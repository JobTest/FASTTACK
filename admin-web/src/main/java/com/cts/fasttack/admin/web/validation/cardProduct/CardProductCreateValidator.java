package com.cts.fasttack.admin.web.validation.cardProduct;

import com.cts.fasttack.admin.web.data.dto.CardProductDto;
import com.cts.fasttack.admin.web.service.CardProductService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class CardProductCreateValidator implements ConstraintValidator<ValidateCardProductCreate, CardProductDto> {

    @Autowired
    private CardProductService cardProductService;

    @Override
    public void initialize(ValidateCardProductCreate constraintAnnotation) {

    }

    @Override
    public boolean isValid(CardProductDto value, ConstraintValidatorContext context) {

        List<CardProductDto> cardProductDtoList = cardProductService.listAll();
        boolean notCollisionRange = cardProductService.isNotCollisionRange(cardProductDtoList, value);

        context.disableDefaultConstraintViolation();
        context.buildConstraintViolationWithTemplate( "{cardProduct.validation.create.ranges}" + " " + cardProductService.getMessageError()).addConstraintViolation();

        return cardProductDtoList.isEmpty()
                ? true :
                notCollisionRange;
    }
}
