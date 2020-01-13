package com.gemalto.telecom.ota.greet.api.constraints;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.gemalto.telecom.ota.greet.api.model.Dummy;

public class DummyPATCHValidator implements ConstraintValidator<ValidDummyPATCH, Dummy> {

    @Override
    public void initialize(ValidDummyPATCH validDummyPATCH) {
        // Nothing to do
    }

    @Override
    public boolean isValid(Dummy dummy, ConstraintValidatorContext constraintValidatorContext) {
        return dummy != null && dummy.getState() != null;
    }
}
