package com.gemalto.telecom.ota.greet.api.constraints;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.gemalto.telecom.ota.greet.api.model.Greet;

public class DummyPATCHValidator implements ConstraintValidator<ValidDummyPATCH, Greet> {

    @Override
    public void initialize(ValidDummyPATCH validDummyPATCH) {
        // Nothing to do
    }

    @Override
    public boolean isValid(Greet greet, ConstraintValidatorContext constraintValidatorContext) {
        return greet != null && greet.getState() != null;
    }
}
