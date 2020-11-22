package com.sms.be.configuration.validation.constraint;

import com.sms.be.configuration.validation.validator.ValidDateRangeValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Constraint(validatedBy = ValidDateRangeValidator.class)
@Target( ElementType.METHOD )
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ValidDateRange {

    String message() default "";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
