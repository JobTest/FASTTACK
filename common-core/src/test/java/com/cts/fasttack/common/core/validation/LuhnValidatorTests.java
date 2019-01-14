package com.cts.fasttack.common.core.validation;

import com.cts.fasttack.common.core.exception.ValidationFailureException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

@RunWith(BlockJUnit4ClassRunner.class)
public class LuhnValidatorTests {
	
	LuhnValidator validator;
	
	@Before
	public void setup(){
		validator = new LuhnValidator();
	}
	
	@Test(expected=ValidationFailureException.class)
	public void failsValidationWhenNullIsValidated() throws ValidationFailureException{
		validator.validate(null);
	}
	
	@Test(expected=ValidationFailureException.class)
	public void failsValidationWhenCreditCardNumberContainingCharactersIsValidated() throws ValidationFailureException{
		validator.validate("1234X1234");
	}
	
	@Test(expected=ValidationFailureException.class)
	public void failsValidationWhenInvalidCreditCardNumberIsValidated() throws ValidationFailureException{
		validator.validate("99927398716");
	}
	
	@Test
	public void passesValidationWhenValidCreditCardNumberWhichHasEvenNumberOfDigitsIsValidated() throws ValidationFailureException{
		validator.validate("5420113841119649");
	}
	
	@Test
	public void passesValidationWhenValidCreditCardNumberWhichHasOddNumberOfDigitsIsValidated() throws ValidationFailureException{
		validator.validate("49927398716");
	}
	
	@Test
	public void passesValidationWhenValidCreditCardNumberContainingSpacesIsValidated() throws ValidationFailureException{
		validator.validate("4992 7398 716");
	}



	@Test
	public void passesVISAWhenValidCreditCardNumber() throws ValidationFailureException {
		validator.validate("4929754782878948");
		validator.validate("4485873881685221885");
	}

	@Test(expected=ValidationFailureException.class)
	public void failsVISAWhenValidCreditCardNumber() throws ValidationFailureException {
		validator.validate("4929754782878941");
		validator.validate("4485873881685221881");
	}

	@Test
	public void passesMasterCardWhenValidCreditCardNumber() throws ValidationFailureException {
		validator.validate("5392585235254088");
		validator.validate("5174981370196370");
	}

	@Test(expected=ValidationFailureException.class)
	public void failsMasterCardWhenValidCreditCardNumber() throws ValidationFailureException {
		validator.validate("5392585235254081");
		validator.validate("5174981370196371");
	}
}
