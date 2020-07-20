package com.avocado.boot.starter.validation.invalid;

import com.avocado.boot.starter.core.utils.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author ：qiaoliang
 * @date ：2020-06-18
 */
public class PhoneInvalidImpl implements ConstraintValidator<PhoneInvalid,Object> {
    @Override
    public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {
        return StringUtils.matchMobile(o.toString().trim());
    }
}
