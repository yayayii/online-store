package com.example.onlinestore.util.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Set;

public class LaptopScreenSizeValidator implements ConstraintValidator<LaptopScreenSizeConstraint, Integer> {
    private final static Set<Integer> SCREEN_SIZE_VALUES = Set.of(13, 14, 15, 17);


    @Override
    public void initialize(LaptopScreenSizeConstraint constraint) {
    }

    @Override
    public boolean isValid(Integer contactField, ConstraintValidatorContext cxt) {
        return SCREEN_SIZE_VALUES.contains(contactField);
    }
}
