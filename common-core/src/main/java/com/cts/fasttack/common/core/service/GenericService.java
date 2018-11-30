package com.cts.fasttack.common.core.service;

import java.io.Serializable;
import java.util.Collection;
import java.util.Optional;

import com.cts.fasttack.common.core.data.Identifiable;
import com.cts.fasttack.common.core.dto.IdentifierDto;
import com.cts.fasttack.common.core.list.ListFilter;
import com.cts.fasttack.common.core.list.QueryResult;

public interface GenericService<KEY extends Serializable, DTO extends IdentifierDto<?>, DOMAIN extends Identifiable<?>> extends ExistCheckService<KEY> {

	DTO get(KEY id);

	Optional<DTO> getOptional(KEY id);

	DTO save(DTO item);

	void delete(DTO item);

	void delete(KEY id);

	DTO update(DTO item);

	Collection<DTO> listAll();

	QueryResult<DTO> list(ListFilter<DOMAIN> filter);

}