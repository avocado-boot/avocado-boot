package com.avocado.boot.starter.core.invalid;

import com.avocado.boot.starter.core.util.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author ：qiaoliang
 */
public class IPInvalidImpl implements ConstraintValidator<IPInvalid,Object> {
    @Override
    public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {
        return StringUtils.matchIp(o.toString().trim());
    }
}
