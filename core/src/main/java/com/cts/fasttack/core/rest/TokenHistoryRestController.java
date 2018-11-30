package com.cts.fasttack.core.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.cts.fasttack.common.core.converter.QueryResultToDtoConverter;
import com.cts.fasttack.common.core.dto.QueryResultDto;
import com.cts.fasttack.core.dto.TokenHistoryList;
import com.cts.fasttack.core.filter.TokenHistoryFilter;
import com.cts.fasttack.core.service.TokenHistoryService;

/**
 * @author Dmitry Koval
 */
@RestController
@RequestMapping("/secured/tokenHistory")
public class TokenHistoryRestController {

    @Autowired
    private TokenHistoryService tokenHistoryService;

    @Autowired
    private QueryResultToDtoConverter<TokenHistoryList> queryResultToDtoConverter;

    @PostMapping("/list")
    @ResponseBody
    public QueryResultDto<TokenHistoryList> listTokenHistory(@RequestBody TokenHistoryFilter filter) {
        return queryResultToDtoConverter.convert(tokenHistoryService.listTokenHistory(filter));
    }
}
