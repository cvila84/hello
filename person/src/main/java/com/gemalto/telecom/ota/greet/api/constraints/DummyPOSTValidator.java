package com.gemalto.telecom.ota.greet.api.constraints;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.gemalto.telecom.ota.greet.api.model.Dummy;

public class DummyPOSTValidator implements ConstraintValidator<ValidDummyPOST, Dummy> {

    @Override
    public void initialize(ValidDummyPOST validDummyPOST) {
        // Nothing to do
    }

    @Override
    public boolean isValid(Dummy dummy, ConstraintValidatorContext constraintValidatorContext) {
        return dummy != null && dummy.getId() != null && dummy.getName() != null;
    }
}
