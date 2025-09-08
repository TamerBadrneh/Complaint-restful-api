package org.selflearning.complaint_api.validation.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.selflearning.complaint_api.validation.validators.ComplaintResolveStatusValidator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ComplaintResolveStatusValidator.class)
public @interface IsComplaintResolveStatus {
    String message() default "Invalid Value";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
