package com.avocado.boot.starter.validation.invalid;

import com.avocado.boot.starter.core.utils.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author ：qiaoliang
 */
public class PatternsInvalidImpl implements ConstraintValidator<PatternsInvalid,Object> {
    @Override
    public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {
        return StringUtils.matchDomain(o.toString().trim());
    }
}
