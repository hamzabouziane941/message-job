package com.cleancoder.validation.technical;

import com.cleancoder.businessvalue.ContactBy;
import java.util.regex.Pattern;

import static java.lang.String.format;

public class TechnicalValidatorImpl implements TechnicalValidator
{
    public boolean isLong(String input) {
        try {
            Long.parseLong(input);
        } catch (NumberFormatException e) {
            System.out.print(format("Input : '%s' is not numeric, ", input));
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    public boolean isBoolean(String input) {
        if(!"true".equals(input) && !"false".equals(input)) {
            System.out.print(format("Input : '%s' is not boolean, ", input));
            return false;
        }
        return true;
    }

    public boolean isRegex(String pattern, String input) {
        boolean isPatternMatched = Pattern
            .compile(pattern)
            .matcher(input)
            .matches();
        if(!isPatternMatched) {
            System.out.print(format("Field with value : '%s' doesn't follow the pattern : '%s', ", input, pattern));
            return false;
        }
        return true;
    }

    public boolean isContactBy(String input) {
        try {
            ContactBy.valueOf(input.toUpperCase());
        } catch (IllegalArgumentException e) {
            System.out.print(format("Input : '%s' is not a contact type, ", input));
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }
}
