package com.cts.fasttack.admin.web.service;

import com.cts.fasttack.admin.web.data.domain.CardProduct;
import com.cts.fasttack.admin.web.data.dto.CardProductDto;
import com.cts.fasttack.common.core.service.GenericService;

import java.util.List;

public interface CardProductService extends GenericService<String, CardProductDto, CardProduct> {

    List<CardProductDto> listAll();

    boolean isNotCollisionRange(final List<CardProductDto> list, final CardProductDto item);

}
