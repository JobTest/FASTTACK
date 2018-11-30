package com.cts.fasttack.mdes.client.dto;

import com.fasterxml.jackson.annotation.JsonRootName;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author a.lipavets
 */
@XmlRootElement(name = "TokenDeleteRequest")
@JsonRootName("TokenDeleteRequest")
public class TokenDeleteRequestDto extends AbstractTokenLifecycleRequestDto {
}
