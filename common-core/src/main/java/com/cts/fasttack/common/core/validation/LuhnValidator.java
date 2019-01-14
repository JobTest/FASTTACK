package com.cts.fasttack.common.core.validation;

import com.cts.fasttack.common.core.exception.ValidationFailureException;
import com.cts.fasttack.common.core.util.Luhn;

/**
 * Test harness for an implementation of the Luhn algorithm that checks the
 * validity of a credit card number.
 */
public class LuhnValidator {
	
	private Luhn validator = new Luhn();

	public void validate(String creditCardNumber) throws ValidationFailureException {
		validator.checkForIncorrectEntry(creditCardNumber);
		long result = validator.evaluateChecksum(creditCardNumber);
		validator.validateChecksum(result);
	}

}
