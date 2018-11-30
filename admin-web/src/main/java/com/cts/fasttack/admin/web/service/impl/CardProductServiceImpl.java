package com.cts.fasttack.admin.web.service.impl;

import com.cts.fasttack.admin.web.converter.CardProductDtoToDomainConverter;
import com.cts.fasttack.admin.web.converter.CardProductToDtoConverter;
import com.cts.fasttack.admin.web.dao.CardProductDao;
import com.cts.fasttack.admin.web.data.domain.CardProduct;
import com.cts.fasttack.admin.web.data.dto.CardProductDto;

import com.cts.fasttack.admin.web.security.service.CurrentUserService;
import com.cts.fasttack.admin.web.service.CardProductService;
import com.cts.fasttack.common.core.service.GenericServiceImpl;
import com.cts.fasttack.common.core.util.GenericBuilder;
import com.cts.fasttack.logging.dto.AlertLogDto;
import com.cts.fasttack.logging.service.AlertLogService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service("cardProductService")
public class CardProductServiceImpl extends GenericServiceImpl<Long, CardProductDto, CardProduct, CardProductDao> implements CardProductService {

    private Logger logger = LogManager.getLogger(CardProductServiceImpl.class);

    private String messageError = "";

    @Autowired
    private AlertLogService alertLogService;

    @Autowired
    private CurrentUserService currentUserService;

    @Autowired
    public CardProductServiceImpl(CardProductDao dao, CardProductToDtoConverter domainToDtoConverter, CardProductDtoToDomainConverter dtoToDomainConverter) {
        super(dao, domainToDtoConverter, dtoToDomainConverter);
    }

    @Override
    public String getMessageError() {
        return messageError;
    }

    @Override
    public void setMessageError(String messageError) {
        this.messageError = messageError;
    }

    @Override
    @Transactional(readOnly = true)
    public List<CardProductDto> listAll() {
        return super.listAll()
                .stream()
                .collect(Collectors.toList());
    }

    @Override
    public boolean isNotCollisionRange(final List<CardProductDto> list, final CardProductDto item) {
        if (item.getBeginRange().equals(item.getEndRange())) {
            saveLog("A Begin Range can't equals a End Range", item, null);
            return false;
        }
        if (item.getBeginRange().length() != item.getEndRange().length()) {
            saveLog("Ranges can't have different length", item, null);
            return false;
        }
        if (!isNotDouble(list, item)) {
            Optional<CardProductDto> cardProductDto = list.parallelStream()
                    .filter(cpd -> cpd.equals(item))
                    .findAny();
            saveLog("Ranges can't occur again", item, cardProductDto.get());
            return false;
        }

        long itemBegin = Long.valueOf(item.getBeginRange());
        long itemEnd = Long.valueOf(item.getEndRange());

        if (itemEnd < itemBegin) {
            saveLog("A End Range could not be less a Begin Range", item, null);
            return false;
        }

        for (CardProductDto cardProductDto: list) {
            long cardProductBegin = Long.valueOf(cardProductDto.getBeginRange());
            long cardProductEnd = Long.valueOf(cardProductDto.getEndRange());

            final boolean insideEnd = cardProductBegin <= itemEnd && itemEnd <= cardProductEnd;
            final boolean insideBegin = cardProductBegin <= itemBegin && itemBegin <= cardProductEnd;
            final boolean outsideEnd = itemEnd < cardProductBegin || cardProductEnd < itemEnd;
            final boolean outsideBegin = itemBegin < cardProductBegin || cardProductEnd < itemBegin;
            final boolean onlyInsideEnd = itemEnd == cardProductEnd;
            final boolean onlyInsideBegin = itemBegin == cardProductBegin;

            boolean collisionRange = (outsideBegin && insideEnd && !onlyInsideEnd)
                    || (outsideEnd && insideBegin && !onlyInsideBegin);

            if (collisionRange) {
                saveLog("Ranges can't intersect", item, cardProductDto);
                return false;
            }
        }
        return true;
    }

    private boolean isNotDouble(final List<CardProductDto> list, final CardProductDto item) {
        return list!=null && !list.isEmpty() && item!=null
                ? !list.contains(item)
                : false;
    }

    private void saveLog(String event, CardProductDto data1, CardProductDto data2) {
        String logData = event + " " + data1 + " " + data2;
        logger.warn(logData);
        saveAlertLog(currentUserService.getCurrentUser().getUsername(), logData, "PRODUCT_VALID_ERROR");
        if (data2!=null) setMessageError("\n\r" + data2.toString());
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
}
