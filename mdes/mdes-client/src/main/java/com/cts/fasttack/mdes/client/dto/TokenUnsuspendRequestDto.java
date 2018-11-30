package com.cts.fasttack.mdes.client.dto;

import com.fasterxml.jackson.annotation.JsonRootName;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Anton Leliuk
 */
@XmlRootElement(name = "TokenUnsuspendRequest")
@JsonRootName("TokenUnsuspendRequest")
public class TokenUnsuspendRequestDto extends AbstractTokenLifecycleRequestDto {
}
