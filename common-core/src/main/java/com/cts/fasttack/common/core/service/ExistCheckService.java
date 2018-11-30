package com.cts.fasttack.common.core.service;

import java.io.Serializable;

import com.cts.fasttack.common.core.exception.ServiceException;

public interface ExistCheckService<T extends Serializable> {

    boolean isExists(T id) throws ServiceException;
}
