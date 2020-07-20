package com.avocado.boot.starter.validation.invalid;

import com.avocado.boot.starter.core.utils.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author ：qiaoliang
 * @date ：2020-06-18
 */
public class EmailInvalidImpl implements ConstraintValidator<EmailInvalid,Object> {
    @Override
    public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {
        return StringUtils.matchEmail(o.toString().trim());
    }
}
