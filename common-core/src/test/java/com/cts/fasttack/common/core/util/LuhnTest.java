package com.cts.fasttack.common.core.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import com.cts.fasttack.common.core.exception.ValidationFailureException;

import org.junit.Before;
import org.junit.Test;


public class LuhnTest {

	Luhn luhn;

	@Before
	public void setup(){
		luhn = new Luhn();
	}
	
	@Test(expected=ValidationFailureException.class)
	public void throwsExceptionWhenNullIsChecked() throws ValidationFailureException{
		luhn.checkForIncorrectEntry(null);
		
	}

	@Test(expected=ValidationFailureException.class)
	public void throwsExceptionWhenStringContainingCharactersIsChecked() throws ValidationFailureException{
		luhn.checkForIncorrectEntry("123X123");
	}
	
	@Test
	public void doesntThrowExceptionWhenNumericsIsChecked() throws ValidationFailureException{
		luhn.checkForIncorrectEntry("123");
	}

	@Test
	public void doesntThrowExceptionWhenNumericsWithSpacesIsChecked() throws ValidationFailureException{
		luhn.checkForIncorrectEntry("123 123");
	}
	
	@Test(expected=ValidationFailureException.class)
	public void throwsExceptionWhenBlankStringIsChecked() throws ValidationFailureException{
		luhn.checkForIncorrectEntry("");
	}
	
	@Test
	public void doesntThrowExceptionForModulo10ResultOfZero() throws ValidationFailureException{
		luhn.validateChecksum(10L);
		luhn.validateChecksum(0L);
		luhn.validateChecksum(20L);
	}
	
	@Test(expected=ValidationFailureException.class)
	public void doesntThrowExceptionForModulo10ResultOfNonZero() throws ValidationFailureException{
		luhn.validateChecksum(11L);
	}
	
	@Test
	public void returnsTrueForEverySecondDigitFromTheRightmostWithinString(){
		String testString = "ABCDE";
		assertTrue(luhn.characterAtIndexShouldBeDoubled(testString,3));
		assertTrue(luhn.characterAtIndexShouldBeDoubled(testString,1));
	}
	
	@Test
	public void returnsFalseForEveryOtherDigitFromTheRightmostWithinString(){
		String testString = "ABCDE";
		assertFalse(luhn.characterAtIndexShouldBeDoubled(testString,4));
		assertFalse(luhn.characterAtIndexShouldBeDoubled(testString,2));
		assertFalse(luhn.characterAtIndexShouldBeDoubled(testString,0));
		
	}
	
	@Test 
	public void calculatesDoubledValueWhereResultIsSingleDigit(){
		assertEquals(2, luhn.calculateDoubledValue("1"));
		assertEquals(4, luhn.calculateDoubledValue("2"));
		assertEquals(6, luhn.calculateDoubledValue("3"));
		assertEquals(8, luhn.calculateDoubledValue("4"));
	}
	
	@Test
	public void calculatesDoubledValueAndAddDigitsWhereResultIsTwoDigits(){
		assertEquals(1, luhn.calculateDoubledValue("5"));
		assertEquals(3, luhn.calculateDoubledValue("6"));
		assertEquals(5, luhn.calculateDoubledValue("7"));
		assertEquals(7, luhn.calculateDoubledValue("8"));
		assertEquals(9, luhn.calculateDoubledValue("9"));
	}
}
