package com.cleancoder.validation;

import com.cleancoder.validation.technical.TechnicalValidator;

import static com.cleancoder.common.CommonConstants.EMAIL_REGEX_PATTERN;
import static com.cleancoder.common.CommonConstants.PHONE_REGEX_PATTERN;

public class UserValidator implements BusinessValidator
{

    private final TechnicalValidator technicalValidator;


    public UserValidator(TechnicalValidator technicalValidator)
    {
        this.technicalValidator = technicalValidator;
    }


    public boolean isValid(String[] userData)
    {
        return technicalValidator.isLong(userData[0])
            && technicalValidator.isBoolean(userData[1])
            && technicalValidator.isContactBy(userData[2])
            && technicalValidator.isRegex(EMAIL_REGEX_PATTERN, userData[3])
            && technicalValidator.isRegex(PHONE_REGEX_PATTERN, userData[4]);
    }
}
