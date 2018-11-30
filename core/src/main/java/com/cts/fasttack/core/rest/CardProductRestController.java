package com.cts.fasttack.core.rest;

import com.cts.fasttack.common.core.converter.QueryResultToDtoConverter;
import com.cts.fasttack.common.core.dto.QueryResultDto;
import com.cts.fasttack.common.core.exception.ServiceException;
import com.cts.fasttack.core.data.list.CardProductListFilter;
import com.cts.fasttack.core.dto.CardProductDto;
import com.cts.fasttack.core.service.CardProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;

import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("/secured/cardProduct")
public class CardProductRestController {

    @Autowired
    private CardProductService cardProductService;

    @Autowired
    protected QueryResultToDtoConverter<CardProductDto> queryResultToDtoConverter;

    @GetMapping("/isExists/{productConfigId}")
    public Boolean isExistsCardProduct(@PathVariable String productConfigId) throws ServiceException {
        return cardProductService.isExists(productConfigId);
    }

    @PostMapping("/list")
    @ResponseBody
    public QueryResultDto<CardProductDto> filterCardProduct(@NotNull @RequestBody CardProductListFilter filter) throws ServiceException {
        return queryResultToDtoConverter.convert(cardProductService.listCardProducts(filter));
    }

    @GetMapping("/{productConfigId}")
    @ResponseBody
    public CardProductDto getCardProduct(@PathVariable String productConfigId) throws ServiceException {
        return cardProductService.getOptional(productConfigId)
                .orElse(new CardProductDto());
    }

    @PutMapping("/")
    @ResponseBody
    public void createCardProduct(@Validated @NotNull @RequestBody CardProductDto cardProductDto) throws ServiceException {
        cardProductService.saveOrUpdate(cardProductDto);
    }

    @PostMapping("/")
    public void updateCardProduct(@Validated @NotNull @RequestBody CardProductDto cardProductDto) throws ServiceException {
        cardProductService.saveOrUpdate(cardProductDto);
    }

    @DeleteMapping("/{productConfigId}")
    public void deleteCardProduct(@PathVariable String productConfigId) throws ServiceException {
        cardProductService.delete(productConfigId);
    }
}
