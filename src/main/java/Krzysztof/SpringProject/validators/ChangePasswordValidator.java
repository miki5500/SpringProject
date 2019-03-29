package Krzysztof.SpringProject.validators;

import Krzysztof.SpringProject.constants.SpringProjectConstants;
import Krzysztof.SpringProject.user.User;
import Krzysztof.SpringProject.utilities.SpringProjectUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class ChangePasswordValidator implements Validator {


    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {

        @SuppressWarnings("unused")
        User u = (User) o;

        ValidationUtils.rejectIfEmpty(errors,"newPassword","error.userPassword.empty");
    }

    public void checkPasswords(String password, Errors errors) {
        if(!password.equals(null)) {
            boolean isMatch = SpringProjectUtils.checkEmailOrPassword(SpringProjectConstants.PASSWORD_PATTERN, password);
            if(!isMatch)
            {
                errors.rejectValue("newPassword", "error.userPasswordIsNotMatch");
            }
        }
    }
}
