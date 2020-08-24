package com.avocado.boot.starter.core.invalid;

import com.avocado.boot.starter.core.util.RegexUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author ：qiaoliang
 */
public class CharInvalidImpl implements ConstraintValidator<CharInvalid,Object> {
    @Override
    public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {
        return RegexUtils.checkChar(o.toString().trim());
    }
}
