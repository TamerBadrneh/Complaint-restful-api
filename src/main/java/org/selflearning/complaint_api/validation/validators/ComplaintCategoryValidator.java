package org.selflearning.complaint_api.validation.validators;

import java.util.EnumSet;

import org.selflearning.complaint_api.constants.ComplaintCategory;
import org.selflearning.complaint_api.validation.annotations.IsComplaintCategory;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ComplaintCategoryValidator implements ConstraintValidator<IsComplaintCategory, ComplaintCategory> {

    @Override
    public boolean isValid(ComplaintCategory value, ConstraintValidatorContext context) {
        return EnumSet.allOf(ComplaintCategory.class)
                .contains(Enum.valueOf(ComplaintCategory.class, value.toString().toUpperCase()));
    }

}
