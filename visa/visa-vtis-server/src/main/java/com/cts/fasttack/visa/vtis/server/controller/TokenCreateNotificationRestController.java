package com.cts.fasttack.visa.vtis.server.controller;

import com.cts.fasttack.common.core.exception.ServiceException;
import com.cts.fasttack.visa.vtis.server.service.VisaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

/**
 * @author Dmitry Koval
 */
@RestController
public class TokenCreateNotificationRestController {

    @Autowired
    private VisaService visaService;

    @PostMapping(value = "/tokenRequestors/{tokenRequestorID}/tokens/{tokenReferenceID}/tokenChanged", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<?> tokenCreateNotification(HttpEntity<String> requestDto,
                                                  @PathVariable String tokenRequestorID,
                                                  @PathVariable String tokenReferenceID,
                                                  @RequestParam("eventType") String eventType,
                                                  @RequestParam("eventID") String eventID) throws ServiceException {

        return visaService.tokenNotification(requestDto, tokenRequestorID, tokenReferenceID, eventType, eventID);
    }
}
