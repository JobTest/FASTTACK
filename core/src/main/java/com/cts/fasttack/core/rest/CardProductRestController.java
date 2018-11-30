package com.cts.fasttack.core.rest;

import com.cts.fasttack.common.core.converter.QueryResultToDtoConverter;
import com.cts.fasttack.common.core.dto.QueryResultDto;
import com.cts.fasttack.common.core.exception.ServiceException;
import com.cts.fasttack.core.data.list.CardProductListFilter;
import com.cts.fasttack.core.dto.CardProductDto;
import com.cts.fasttack.core.service.CardProductService;
import com.cts.fasttack.core.util.TokenHelper;
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
    private TokenHelper tokenHelper;

    @Autowired
    protected QueryResultToDtoConverter<CardProductDto> queryResultToDtoConverter;

    @GetMapping("/isExists/{id}")
    public Boolean isExistsCardProduct(@PathVariable Long id) throws ServiceException {
        return cardProductService.isExists(id);
    }

    @PostMapping("/list")
    @ResponseBody
    public QueryResultDto<CardProductDto> filterCardProduct(@NotNull @RequestBody CardProductListFilter filter) throws ServiceException {
        return queryResultToDtoConverter.convert(cardProductService.listCardProducts(filter));
    }

    @GetMapping("/{id}")
    @ResponseBody
    public CardProductDto getCardProduct(@PathVariable Long id) throws ServiceException {
        return cardProductService.getOptional(id)
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

    @DeleteMapping("/{id}")
    public void deleteCardProduct(@PathVariable Long id) throws ServiceException {
        cardProductService.delete(id);
    }

    @GetMapping("/productConfigId/{pan}")
    @ResponseBody
    public CardProductDto getProductConfigId(@PathVariable Long pan) throws ServiceException {
        return tokenHelper.getProductConfigId(pan);
    }
}
