package com.cts.fasttack.mdes.client.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Anton Leliuk
 */
@XmlRootElement(name = "TokenActivateResponse")
@XmlAccessorType(XmlAccessType.FIELD)
public class TokenActivateResponseDto extends AbstractTokenLifecycleResponseDto {
}
