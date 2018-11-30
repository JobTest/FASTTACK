package com.cts.fasttack.ih_sv.client.ws.service;

import com.cts.fasttack.common.core.exception.ServiceException;
import com.cts.fasttack.ih_sv.client.ws.client.Avs1Request;
import com.cts.fasttack.ih_sv.client.ws.client.Avs1Response;

/**
 * @author d.ishchenko
 */
public interface Avs1Service {

	Avs1Response avs1(Avs1Request request, String maskedPan) throws ServiceException;

}
