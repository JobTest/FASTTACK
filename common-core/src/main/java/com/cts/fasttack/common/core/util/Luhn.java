package com.cts.fasttack.common.core.util;

import com.cts.fasttack.common.core.exception.ValidationFailureException;
import com.cts.fasttack.common.core.util.support.CharacterIdentifier;
import com.cts.fasttack.common.core.util.support.StringSpaceRemover;

/**
 * Checks whether a string of digits is a valid credit card number according
 * to the Luhn algorithm.
 */
public class Luhn {

	public void validateChecksum(long result) throws ValidationFailureException {
		if (result % 10 != 0){
			throw new ValidationFailureException();
		}
	} 

	public long evaluateChecksum(String creditCardNumber) {
		long luhnValue = 0;
		creditCardNumber = StringSpaceRemover.removeSpaces(creditCardNumber);
		int i = creditCardNumber.length() - 1;
		
		while(i>=0){
			String singleDigit = Character.toString(creditCardNumber.charAt(i));
			if (characterAtIndexShouldBeDoubled(creditCardNumber, i)){
				luhnValue += calculateDoubledValue(singleDigit);
			} else {
				luhnValue += Integer.parseInt(singleDigit);
			}
			i--;
		}
		return luhnValue;
	}

	public int calculateDoubledValue(String input) {
		int value = Integer.parseInt(input);
		int result = value * 2;
		if (result > 9){
			result = 1 + result % 10;
		} 
		return result;
	}

	public boolean characterAtIndexShouldBeDoubled(String creditCardNumber, int index) {
		if ((creditCardNumber.length() - index) % 2 == 1){
			return false;
		}
		return true;
	}

	public void checkForIncorrectEntry(String creditCardNumber) throws ValidationFailureException {
		if (creditCardNumber == null  ||
			creditCardNumber.equals("") ||
		    CharacterIdentifier.containsCharacters(creditCardNumber)){
			throw new ValidationFailureException();
		}
		
	}
}
