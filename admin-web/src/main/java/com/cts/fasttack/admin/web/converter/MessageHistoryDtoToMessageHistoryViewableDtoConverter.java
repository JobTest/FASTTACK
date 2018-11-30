package com.cts.fasttack.admin.web.converter;

import java.io.IOException;
import java.io.StringWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;

import org.apache.camel.StringSource;
import org.apache.commons.lang3.StringEscapeUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import com.cts.fasttack.admin.web.data.dto.MessageHistoryViewableDto;
import com.cts.fasttack.common.core.converter.AbstractConverter;
import com.cts.fasttack.common.core.util.JsonUtil;
import com.cts.fasttack.logging.dto.MessageHistoryDto;

/**
 * {@link MessageHistoryDto} to {@link MessageHistoryViewableDto} converter.
 *
 * @author v.semerkov
 */
@Component
public class MessageHistoryDtoToMessageHistoryViewableDtoConverter extends AbstractConverter<MessageHistoryDto, MessageHistoryViewableDto> {

    private static final Pattern MSG_RAW_PATTERN = Pattern.compile("^(?<beforePayload>.*Payload: )((?<json>\\{.*\\})|(?<xml><.*>))(?<afterPayload>.*)$", Pattern.DOTALL);

    private static Transformer xmlTransformer;

    @Override
    protected MessageHistoryViewableDto generateTarget() {
        return new MessageHistoryViewableDto();
    }

    @Override
    protected void lightConvert(MessageHistoryDto source, MessageHistoryViewableDto target) {
        target.setId(source.getId());
        target.setParentId(source.getParentId());
        target.setTokenId(source.getTokenId());
        target.setConnectorClient(source.getConnectorClient());
        target.setMsgType(source.getMsgType());
        target.setMsgDateIn(source.getMsgDateIn());
        target.setMsgDateOut(source.getMsgDateOut());
        target.setMsgRawIn(format(source.getMsgRawIn()));
        target.setMsgRawOut(format(source.getMsgRawOut()));
        target.setDecision(source.getDecision());
        target.setErrorCode(source.getErrorCode());
        target.setCvcResp(source.getCvcResp());
        target.setMaskedPan(source.getMaskedPan());
        target.setPanInternalId(source.getPanInternalId());
        target.setPanInternalGuid(source.getPanInternalGuid());
        target.setPanSource(source.getPanSource());
    }

    private String format(String str) {
        StringBuilder sb = new StringBuilder("<pre>");

        if (StringUtils.isNotBlank(str)) {
            Matcher matcher = MSG_RAW_PATTERN.matcher(str);
            if (matcher.matches()) {
                sb.append(replaceSpaces(matcher.group("beforePayload")));
                String jsonPayload = matcher.group("json");
                String xmlPayload = matcher.group("xml");
                String afterPayload = matcher.group("afterPayload");
                if (StringUtils.isNotBlank(jsonPayload)) {
                    sb.append(transformJson(jsonPayload));
                } else if (StringUtils.isNotBlank(xmlPayload)) {
                    sb.append(transformXml(xmlPayload));
                }
                if (StringUtils.isNotBlank(afterPayload)) {
                    sb.append(replaceSpaces(afterPayload));
                }
            } else {
                sb.append(replaceSpaces(str));
            }
        } else {
            sb.append(str);
        }

        sb.append("</pre>");
        return sb.toString();
    }

    private String replaceSpaces(String value) {
        return value.replace("\r\n", "<br/>")
                .replace("\n", "<br/>")
                .replace("\t", "&#9;");
    }

    private String transformJson(String jsonPayload) {
        try {
            return replaceSpaces(JsonUtil.getObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(JsonUtil.getObjectMapper().readTree(jsonPayload)));
        } catch (IOException e) {
            return replaceSpaces(jsonPayload);
        }
    }

    private String transformXml(String xmlPayload) {
        try {
            if (xmlTransformer == null) {
                xmlTransformer = TransformerFactory.newInstance().newTransformer();
                xmlTransformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
                xmlTransformer.setOutputProperty(OutputKeys.INDENT, "yes");
                xmlTransformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
            }

            StringWriter stringWriter = new StringWriter();
            StreamResult streamResult = new StreamResult(stringWriter);

            xmlTransformer.transform(new StringSource(xmlPayload), streamResult);

            return replaceSpaces(StringEscapeUtils.escapeXml10(stringWriter.toString()));
        } catch (Exception e) {
            return replaceSpaces(StringEscapeUtils.escapeXml10(xmlPayload));
        }
    }
}
