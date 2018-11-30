package com.cts.fasttack.crypto.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.cts.fasttack.common.core.converter.QueryResultToDtoConverter;
import com.cts.fasttack.common.core.dto.QueryResultDto;
import com.cts.fasttack.crypto.client.dto.EncKeyListFilterDto;
import com.cts.fasttack.crypto.client.dto.EncKeyRequestResponseDto;
import com.cts.fasttack.crypto.server.converter.EncKeyDtoToRequestResponseDtoConverter;
import com.cts.fasttack.crypto.server.converter.EncKeyListFilterDtoToDomainConverter;
import com.cts.fasttack.crypto.server.converter.EncKeyRequestResponseDtoToDtoConverter;
import com.cts.fasttack.crypto.server.service.EncKeyService;

/**
 * @author Dmitry Koval
 */
@RestController
@RequestMapping("/secured/crypto/enckey")
public class EncKeyRestController {

    @Autowired
    private EncKeyService encKeyService;

    @Autowired
    private EncKeyDtoToRequestResponseDtoConverter encKeyDtoToRequestResponseDtoConverter;

    @Autowired
    private EncKeyRequestResponseDtoToDtoConverter encKeyRequestResponseDtoToDtoConverter;

    @Autowired
    private EncKeyListFilterDtoToDomainConverter encKeyListFilterDtoToDomainConverter;

    @Autowired
    private QueryResultToDtoConverter<EncKeyRequestResponseDto> queryResultToDtoConverter;

    @PostMapping("/list")
    public @ResponseBody QueryResultDto<EncKeyRequestResponseDto> listPaged(@RequestBody EncKeyListFilterDto filterDto) {
        return queryResultToDtoConverter.convert(encKeyService.listPaged(encKeyListFilterDtoToDomainConverter.convert(filterDto)));
    }

    @GetMapping("/{id}")
    public @ResponseBody EncKeyRequestResponseDto get(@PathVariable Long id) {
        return encKeyDtoToRequestResponseDtoConverter.convert(encKeyService.get(id));
    }

    @PostMapping("/")
    public @ResponseBody EncKeyRequestResponseDto createNew(@RequestBody EncKeyRequestResponseDto encKeyDto) {
        return encKeyDtoToRequestResponseDtoConverter.convert(encKeyService.createNew(encKeyRequestResponseDtoToDtoConverter.convert(encKeyDto)));
    }

    @PutMapping("/")
    public @ResponseBody EncKeyRequestResponseDto update(@RequestBody EncKeyRequestResponseDto encKeyDto) {
        return encKeyDtoToRequestResponseDtoConverter.convert(encKeyService.update(encKeyRequestResponseDtoToDtoConverter.convert(encKeyDto)));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        encKeyService.delete(id);
    }

}
