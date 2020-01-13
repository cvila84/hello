package com.gemalto.telecom.ota.greet.api.constraints;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.gemalto.telecom.ota.greet.api.model.Greet;

public class DummyPOSTValidator implements ConstraintValidator<ValidDummyPOST, Greet> {

    @Override
    public void initialize(ValidDummyPOST validDummyPOST) {
        // Nothing to do
    }

    @Override
    public boolean isValid(Greet greet, ConstraintValidatorContext constraintValidatorContext) {
        return greet != null && greet.getId() != null && greet.getName() != null;
    }
}
