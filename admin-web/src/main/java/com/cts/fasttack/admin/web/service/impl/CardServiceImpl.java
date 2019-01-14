package com.cts.fasttack.admin.web.service.impl;

import com.cts.fasttack.admin.web.config.AdminWebApplication;
import com.cts.fasttack.admin.web.converter.CardReplacementFilterToJmsUpdateTokenDtoConverter;
import com.cts.fasttack.admin.web.converter.JmsTokenInfoEventRefToTokenCommentConverter;
import com.cts.fasttack.admin.web.data.dto.TokenInfoListDto;
import com.cts.fasttack.admin.web.data.list.CardReplacementFilter;
import com.cts.fasttack.admin.web.data.list.TokenListFilter;
import com.cts.fasttack.admin.web.rest.TokenInfoRestClient;
import com.cts.fasttack.admin.web.service.CardService;
import com.cts.fasttack.admin.web.service.TokenCommentService;
import com.cts.fasttack.common.core.dto.QueryResultDto;
import com.cts.fasttack.common.core.exception.ServiceException;
import com.cts.fasttack.common.core.util.GenericBuilder;
import com.cts.fasttack.jms.data.HeadersJmsMessage;
import com.cts.fasttack.jms.dto.UpdateTokenJmsResponse;
import com.cts.fasttack.jms.dto.UpdateTokenJmsMessage;
import com.cts.fasttack.jms.support.IntegrationBus;
import com.cts.fasttack.logging.dto.AlertLogDto;
import com.cts.fasttack.logging.service.AlertLogService;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class CardServiceImpl implements CardService {

    private Logger logger = LogManager.getLogger(CardServiceImpl.class);

    @Autowired
    private IntegrationBus integrationBus;

    @Autowired
    private TokenInfoRestClient tokenInfoRestClient;

    @Autowired
    private TokenCommentService tokenCommentService;

    @Autowired
    private AlertLogService alertLogService;

    @Autowired
    private CardReplacementFilterToJmsUpdateTokenDtoConverter cardReplacementFilterToJmsUpdateTokenDtoConverter;

    @Autowired
    private JmsTokenInfoEventRefToTokenCommentConverter jmsTokenInfoEventRefToTokenCommentConverter;

    @Override
    public QueryResultDto<TokenInfoListDto> replacement(CardReplacementFilter filter) throws ServiceException {

        try {
            HeadersJmsMessage jmsMessage = new UpdateTokenJmsMessage()
                    .updateTokenDto(cardReplacementFilterToJmsUpdateTokenDtoConverter.convert(filter))
                    .originator(AdminWebApplication.ORIGINATOR);
            UpdateTokenJmsResponse response = integrationBus.inOut(() -> "CORE", "updateToken", jmsMessage, UpdateTokenJmsResponse.class);

            if (response.getCodeStatus().equals("00") && !response.getTokensInfo().isEmpty()) {
                response.getTokensInfo().forEach(item -> tokenCommentService.save(jmsTokenInfoEventRefToTokenCommentConverter.convert(item, filter.getComment())));
            }
        } catch (ServiceException ex) {
            String alertLogData = "Can't update token because of timeout or no response from server."
                    + " Error code: '" + ex.getErrorCode() + "'.";

            logger.error(alertLogData);
            saveAlertLog(AdminWebApplication.ORIGINATOR, alertLogData, "TOKEN_UPDATE");

            return tokenInfoRestClient.list( getTokenFilter(filter) );
        }
        return tokenInfoRestClient.list( getTokenFilterByPan(filter) );
    }

    private void saveAlertLog(String originator, String data, String event) {
        AlertLogDto alertLogDto = GenericBuilder.of(AlertLogDto::new)
                .with(AlertLogDto::setEvent, event)
                .with(AlertLogDto::setOriginator, originator)
                .with(AlertLogDto::setData, data)
                .with(AlertLogDto::setDate, new Date())
                .build();

        alertLogService.save(alertLogDto);
    }

    private TokenListFilter getTokenFilterByPan(CardReplacementFilter filter) {
        TokenListFilter tokenFilter = getTokenFilter(filter);
        tokenFilter.setPan( StringUtils.isNotBlank(filter.getNewPan()) ? filter.getNewPan() : filter.getOldPan() );
        return tokenFilter;
    }

    private TokenListFilter getTokenFilter(CardReplacementFilter filter) {
        TokenListFilter tokenFilter = new TokenListFilter();
        tokenFilter.setScrollableRowCount( filter.getScrollableRowCount() );
        tokenFilter.setLimit( filter.getLimit() );
        tokenFilter.setPage( filter.getPage() );
        tokenFilter.setSortField(filter.getSortField());
        tokenFilter.setAsc( filter.isAsc() );
        tokenFilter.setSearched( filter.isSearched() );
        return tokenFilter;
    }
}
