package com.avocado.boot.starter.validation.invalid;

import com.avocado.boot.starter.core.utils.RegexUtils;
import com.avocado.boot.starter.core.utils.StringUtils;

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
