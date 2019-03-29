package Krzysztof.SpringProject.validators;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class ProduktValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return false;
    }

    @Override
    public void validate(Object o, Errors errors) {

        ValidationUtils.rejectIfEmpty(errors,"pName","produkt.empty");
        ValidationUtils.rejectIfEmpty(errors,"pDescription","produkt.empty");
        ValidationUtils.rejectIfEmpty(errors,"price","produkt.empty");
        ValidationUtils.rejectIfEmpty(errors,"amount","produkt.empty");
        ValidationUtils.rejectIfEmpty(errors,"category","produkt.empty");
    }
}
