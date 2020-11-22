package com.sms.be.configuration.validation.validator;

import com.sms.be.configuration.validation.constraint.ValidDateRange;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.constraintvalidation.SupportedValidationTarget;
import javax.validation.constraintvalidation.ValidationTarget;
import java.time.LocalDate;

@Component
@SupportedValidationTarget(ValidationTarget.PARAMETERS)
public class ValidDateRangeValidator implements
        ConstraintValidator<ValidDateRange, Object[]> {

    @Override
    public boolean isValid(Object[] value, ConstraintValidatorContext context) {

        LocalDate fromStartDate = (LocalDate) value[4];
        LocalDate toStartDate = (LocalDate) value[5];
        LocalDate fromEndDate = (LocalDate) value[6];
        LocalDate toEndDate = (LocalDate) value[7];

        if (fromStartDate != null && toStartDate != null) {
            if ( fromStartDate.isBefore(toStartDate) || fromStartDate.isEqual(toStartDate)) {
                return true;
            } else {
                context.buildConstraintViolationWithTemplate("Invalid Date Range");
                return false;
            }
        }

        if (fromEndDate != null && toEndDate != null) {
            if (fromEndDate.isBefore(toEndDate) || fromEndDate.isEqual(toEndDate) ){
                return true;
            } else {
                context.buildConstraintViolationWithTemplate("Invalid Date Range");
                return false;
            }
        }


        return true;
    }

}
