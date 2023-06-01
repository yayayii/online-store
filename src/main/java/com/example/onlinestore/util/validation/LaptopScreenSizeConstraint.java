package com.example.onlinestore.util.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = LaptopScreenSizeValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface LaptopScreenSizeConstraint {
    String message() default "Invalid laptop screen size";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
