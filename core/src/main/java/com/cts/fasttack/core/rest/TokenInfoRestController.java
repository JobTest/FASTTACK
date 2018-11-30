package com.cts.fasttack.core.rest;

import java.util.ArrayList;
import java.util.List;

import com.cts.fasttack.common.core.list.QueryResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.cts.fasttack.common.core.converter.QueryResultToDtoConverter;
import com.cts.fasttack.common.core.dto.QueryResultDto;
import com.cts.fasttack.common.core.exception.ServiceException;
import com.cts.fasttack.core.data.TokenInfoId;
import com.cts.fasttack.core.data.TokenInfoList;
import com.cts.fasttack.core.data.list.TokenInfoViewListFilter;
import com.cts.fasttack.core.dto.TokenInfoRestDto;
import com.cts.fasttack.core.service.TokenInfoService;

/**
 * Controller that process requests about token information
 *
 * @author Dmitry Koval
 */
@RestController
@RequestMapping("/secured/tokenInfo")
public class TokenInfoRestController {

    @Autowired
    private TokenInfoService tokenInfoService;

    @Autowired
    private QueryResultToDtoConverter<TokenInfoList> queryResultToDtoConverter;

    @GetMapping("/{tokenRefId}/{tokenRequestorId}")
    @ResponseBody
    public TokenInfoRestDto getTokenInfo(@PathVariable String tokenRefId, @PathVariable String tokenRequestorId) throws ServiceException {
        return tokenInfoService.getWithDeviceInfo(new TokenInfoId(tokenRefId, tokenRequestorId));
    }

    @PostMapping("/list")
    @ResponseBody
    public QueryResultDto<TokenInfoList> list(@RequestBody TokenInfoViewListFilter filter) throws ServiceException {
//        return queryResultToDtoConverter.convert(tokenInfoService.listTokens(filter)); //todo deprecate
        QueryResult<TokenInfoList> tokenInfoListQueryResult = isNotEmptyFilter(filter)
                ? tokenInfoService.listTokens(filter)
                : listTokens(filter);
        return queryResultToDtoConverter.convert(tokenInfoListQueryResult);
    }

    //todo
    private QueryResult<TokenInfoList> listTokens(TokenInfoViewListFilter filter) {
        QueryResult<TokenInfoList> tokenInfoList = new QueryResult<>();
        tokenInfoList.setFilter(filter);
        tokenInfoList.setObjects(new ArrayList<>());
        return tokenInfoList;
    }

    //todo
    private boolean isNotEmptyFilter(TokenInfoViewListFilter filter) {
        return filter.getPan()==null
                    && filter.getPanInternalId()==null
                    && filter.getPanInternalGuid()==null
                    && filter.getTaxId()==null
                    && filter.getContragentId()==null
                    && filter.getDocSr()==null
                    && filter.getDocNo()==null
                    && filter.getsName()==null
                    && filter.getName()==null
                    && filter.getTokenRefId()==null
                    && filter.getPaymentAppId()==null
                    && filter.getDateFrom()==null
                    && filter.getDateTill()==null
                    && filter.getStatuses().isEmpty()
                ? false
                : true;
    }

    @PostMapping("/listTokenInfoId")
    @ResponseBody
    public List<TokenInfoList> listTokenInfoId(@RequestBody List<TokenInfoId> tokenInfoIds){
        return tokenInfoService.listTokenInfoId(tokenInfoIds);
    }
}
