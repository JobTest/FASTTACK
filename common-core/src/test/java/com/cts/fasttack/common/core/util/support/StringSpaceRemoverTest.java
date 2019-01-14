package com.cts.fasttack.common.core.util.support;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class StringSpaceRemoverTest {
	@Test
	public void removesSpacesFromAString(){
		assertEquals("ABC123", StringSpaceRemover.removeSpaces(" ABC 123 "));
	}
	@Test
	public void doesntRemoveCharactersAndDigitsFromAString(){
		assertEquals("ABC123", StringSpaceRemover.removeSpaces("ABC123"));
	}
}
