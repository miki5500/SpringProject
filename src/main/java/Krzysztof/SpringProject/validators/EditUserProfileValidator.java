package Krzysztof.SpringProject.validators;


import Krzysztof.SpringProject.constants.SpringProjectConstants;
import Krzysztof.SpringProject.user.User;
import Krzysztof.SpringProject.utilities.SpringProjectUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class EditUserProfileValidator implements Validator {


    @Override
    public boolean supports(Class<?> aClass) {
        return false;
    }

    @Override
    public void validate(Object o, Errors errors) {

        User u = (User) o;

        ValidationUtils.rejectIfEmpty(errors, "name", "error.userName.empty");
        ValidationUtils.rejectIfEmpty(errors, "lastName", "error.userLastName.empty");
        ValidationUtils.rejectIfEmpty(errors, "email", "error.userEmail.empty");

        if (!u.getEmail().equals(null)) {
            boolean isMatch = SpringProjectUtils.checkEmailOrPassword(SpringProjectConstants.EMAIL_PATTERN, u.getEmail());
            if (!isMatch) {
                errors.rejectValue("email", "error.userEmailIsNotMatch");
            }
        }
    }
}
