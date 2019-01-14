package com.cts.fasttack.common.core.util.support;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class CharacterIdentifierTest {
	@Test
	public void returnsFalseForNumericString(){
		assertFalse(CharacterIdentifier.containsCharacters("123"));
	}

	@Test
	public void returnsFalseForNumericStringContainingSpaces(){
		assertFalse(CharacterIdentifier.containsCharacters("123 123"));
	}

	@Test
	public void returnsTrueForCharacterString(){
		assertTrue(CharacterIdentifier.containsCharacters("A"));
	}
}
