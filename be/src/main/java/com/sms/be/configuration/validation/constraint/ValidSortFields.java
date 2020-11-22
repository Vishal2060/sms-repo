package com.sms.be.configuration.validation.constraint;

import com.sms.be.configuration.validation.validator.ValidSortFieldsValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Constraint(validatedBy = ValidSortFieldsValidator.class)
@Target( ElementType.PARAMETER )
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ValidSortFields {

    String message() default "";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
