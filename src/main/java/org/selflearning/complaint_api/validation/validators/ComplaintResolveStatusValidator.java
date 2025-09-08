package org.selflearning.complaint_api.validation.validators;

import java.util.EnumSet;

import org.selflearning.complaint_api.constants.ComplaintResolveStatus;
import org.selflearning.complaint_api.validation.annotations.IsComplaintResolveStatus;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ComplaintResolveStatusValidator
        implements ConstraintValidator<IsComplaintResolveStatus, ComplaintResolveStatus> {

    @Override
    public boolean isValid(ComplaintResolveStatus value, ConstraintValidatorContext context) {
        return EnumSet.allOf(ComplaintResolveStatus.class)
                .contains(Enum.valueOf(ComplaintResolveStatus.class, value.toString().toUpperCase()));
    }

}
