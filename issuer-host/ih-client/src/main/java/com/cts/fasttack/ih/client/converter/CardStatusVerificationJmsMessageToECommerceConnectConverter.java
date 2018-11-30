package com.cts.fasttack.ih.client.converter;

import java.util.Date;

import org.springframework.stereotype.Component;
import com.cts.fasttack.common.core.converter.AbstractConverter;
import com.cts.fasttack.common.core.dict.DateFormatEnum;
import com.cts.fasttack.common.core.util.DateFormatUtil;
import com.cts.fasttack.ih.client.dto.Authorization;
import com.cts.fasttack.ih.client.dto.Card;
import com.cts.fasttack.ih.client.dto.ECommerceConnect;
import com.cts.fasttack.ih.client.dto.Invoice;
import com.cts.fasttack.ih.client.dto.Message;
import com.cts.fasttack.ih.client.dto.ObjectFactory;
import com.cts.fasttack.ih.client.dto.PayData;
import com.cts.fasttack.ih.client.dto.RequestData;
import com.cts.fasttack.ih.client.dto.Transaction;
import com.cts.fasttack.ih.client.dto.Transactions;
import com.cts.fasttack.ih.client.dto.XMLPayRequest;
import com.cts.fasttack.jms.dto.CardStatusVerificationJmsMessage;
import com.cts.fasttack.jms.dto.JmsCardStatusVerificationDto;

/**
 * {@link CardStatusVerificationJmsMessage} to {@link ECommerceConnect} converter.
 *
 * @author v.semerkov
 */
@Component
public class CardStatusVerificationJmsMessageToECommerceConnectConverter extends AbstractConverter<CardStatusVerificationJmsMessage, ECommerceConnect> {

    private static final ObjectFactory FACTORY = new ObjectFactory();


    @Override
    protected ECommerceConnect generateTarget() {
        return FACTORY.createECommerceConnect();
    }

    @Override
    protected void lightConvert(CardStatusVerificationJmsMessage source, ECommerceConnect target) {
        JmsCardStatusVerificationDto jmsCardStatusVerificationDto = source.getCardStatusVerificationDto();

        Message message = FACTORY.createMessage();
        message.setId("1");
        message.setVersion("1.0");

        XMLPayRequest xmlPayRequest = FACTORY.createXMLPayRequest();

        RequestData requestData = FACTORY.createRequestData();
        requestData.setMerchantID(jmsCardStatusVerificationDto.getMerchantId());
        requestData.setTerminalID(jmsCardStatusVerificationDto.getTerminalId());

        Transactions transactions = FACTORY.createTransactions();

        Transaction transaction = FACTORY.createTransaction();
        transaction.setId("2");

        Authorization authorization = FACTORY.createAuthorization();

        PayData payData = FACTORY.createPayData();

        Invoice invoice = FACTORY.createInvoice();
        invoice.setDate(DateFormatUtil.dateToString(DateFormatEnum.DATETIME_WITHOUT_SEPARATION, new Date()));
        invoice.setTotalAmount(0L);
        invoice.setCurrency("980");
        invoice.setDescription("Account verification");
        // ID value from message history
        invoice.setOrderID(String.valueOf(source.getMessageHistoryId()));

        payData.setInvoice(invoice);

        Card card = FACTORY.createCard();
        Long pan = jmsCardStatusVerificationDto.getCardNum();
        //FIXME remove in production mode
        if (pan == 5355571259999092L || pan == 5355571259999068L || pan == 5355571259999126L) {
            card.setCardNum(5559490000000007L);
            card.setExpMonth("01");
            card.setExpYear("2020");
            card.setCVNum("123");
        } else {
            card.setCardNum(jmsCardStatusVerificationDto.getCardNum());
            card.setExpMonth(jmsCardStatusVerificationDto.getExpMonth());
            card.setExpYear(jmsCardStatusVerificationDto.getExpYear());
            card.setCVNum(jmsCardStatusVerificationDto.getCvNum());
        }
        payData.setCard(card);

        authorization.setPayData(payData);

        transaction.setAuthorization(authorization);

        transactions.getTransaction().add(transaction);

        requestData.setTransactions(transactions);

        xmlPayRequest.setRequestData(requestData);

        message.setXMLPayRequest(xmlPayRequest);

        target.setMessage(message);
    }
}
