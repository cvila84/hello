package com.gemalto.telecom.ota.greet.api.constraints;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Target({ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {DummyPATCHValidator.class})
public @interface ValidDummyPATCH {
    String message() default "{dummy.patch}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
