package com.cts.fasttack.bank.client.ws.service;

import com.cts.fasttack.bank.client.converter.JmsSearchContragent2DtoToWsDtoConverter;
import com.cts.fasttack.bank.client.converter.SearchContragent2ResponseToDtoConverter;
import com.cts.fasttack.bank.client.exception.WebServiceExceptionHandler;
import com.cts.fasttack.bank.client.ws.contragent.SearchContragent2Response;
import com.cts.fasttack.common.core.exception.ServiceException;
import com.cts.fasttack.jms.dto.JmsSearchContragent2Dto;
import com.cts.fasttack.jms.dto.JmsSearchContragent2ResponseDto;
import com.cts.fasttack.logging.interceptor.MessageHistoryOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import javax.xml.bind.JAXBElement;

/**
 * @author a.lipavets
 */
@Service("searchContragent2WebService")
public class SearchContragent2WebServiceImpl extends WebServiceClient implements SearchContragent2WebService {

    public SearchContragent2WebServiceImpl(@Qualifier("webServiceTemplateContragent") WebServiceTemplate webServiceTemplate) {
        super(webServiceTemplate);
    }

    @Autowired
    private JmsSearchContragent2DtoToWsDtoConverter jmsSearchContragent2DtoToWsDtoConverter;

    @Autowired
    private SearchContragent2ResponseToDtoConverter searchContragent2ResponseToDtoConverter;

    @Override
    @MessageHistoryOperation(connectorClient = "BANK", rawIn = "#request", responseMediaType = MediaType.APPLICATION_XML_VALUE)
    public JmsSearchContragent2ResponseDto searchContragent2(JmsSearchContragent2Dto request) throws ServiceException {
        return executeWithResponse(() -> { 
        	@SuppressWarnings("unchecked")
			JmsSearchContragent2ResponseDto response = searchContragent2ResponseToDtoConverter.convert(
                ((JAXBElement<SearchContragent2Response>)
                        webServiceTemplate.marshalSendAndReceive(
                                webServiceTemplate.getDefaultUri() + "/ContragentPT",
                                jmsSearchContragent2DtoToWsDtoConverter.convert(request),
                                new SoapActionCallback("urn:searchContragent2"))).getValue());
        	return response;
        }, WebServiceExceptionHandler.INSTANCE);
    }
}
