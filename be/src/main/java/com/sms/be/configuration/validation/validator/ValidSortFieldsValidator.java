package com.sms.be.configuration.validation.validator;

import com.sms.be.configuration.validation.constraint.ValidSortFields;
import com.sms.be.model.Data;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ValidSortFieldsValidator implements ConstraintValidator<ValidSortFields, String> {
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {

        if(value == null){
            return true;
        }

        String[] values = value.split(",");

        List<String> fields = Arrays.stream(values)
                .map(x-> x.replace("-", "").trim())
                .collect(Collectors.toList());

        try {
            for (String field : fields) {
                Data.class.getDeclaredField(field);
            }
        }catch (NoSuchFieldException e) {
            return false;
        }

        return true;
    }
}
