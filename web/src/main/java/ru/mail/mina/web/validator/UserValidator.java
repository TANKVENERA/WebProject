package ru.mail.mina.web.validator;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import ru.mail.mina.service.model.UserDTO;

/**
 * Created by Администратор on 18.08.2017.
 */
@Component
public class UserValidator implements Validator {

    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    public boolean supports(Class<?> aClass) {
        return UserDTO.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        UserDTO user = (UserDTO) o;
        ValidationUtils.rejectIfEmpty(errors, "username", "error.username.empty");
        if (user.getUsername().length() < 3 ) {
            errors.rejectValue("username", "error.username.length");
        }if (user.getEmail().length() < 5 ) {
            errors.rejectValue("email", "error.useremail.length");
        }
        if (user.getPassword().length() < 8) {
            errors.rejectValue("password", "error.userpassword.length");
        }
        else {
            UserDetails userDetails = userDetailsService.loadUserByUsername(user.getUsername());
            if (userDetails != null) {
                errors.rejectValue("username", "error.username.exist");
            }
        }
    }
}


