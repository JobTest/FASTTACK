package com.cts.fasttack.mdes.client.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.fasterxml.jackson.annotation.JsonRootName;

/**
 * @author Dmitry Koval
 */
@XmlRootElement(name = "TokenActivateRequest")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
@JsonRootName("TokenActivateRequest")
public class TokenActivateRequestDto extends AbstractTokenLifecycleRequestDto {
}
