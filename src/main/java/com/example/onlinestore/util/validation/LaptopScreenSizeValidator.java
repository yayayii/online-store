package com.example.onlinestore.util.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class LaptopScreenSizeValidator implements ConstraintValidator<LaptopScreenSizeConstraint, Integer> {
    @Override
    public void initialize(LaptopScreenSizeConstraint constraint) {
    }

    @Override
    public boolean isValid(Integer contactField, ConstraintValidatorContext cxt) {
        return contactField == 13 || contactField == 14 || contactField == 15 || contactField == 17;
    }
}
