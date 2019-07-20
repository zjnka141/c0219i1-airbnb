package codegym.airbnb.common.validation;


import codegym.airbnb.dao.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueValidator implements ConstraintValidator<Unique,String> {
    @Autowired
    private AccountRepository accountRepository;

    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        return accountRepository.countByUsernameOrEmail(value,value)<=0;
    }

    @Override
    public void initialize(Unique constraintAnnotation) {

    }
}
