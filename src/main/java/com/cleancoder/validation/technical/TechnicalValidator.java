package com.cleancoder.validation.technical;

public interface TechnicalValidator
{
    boolean isLong(String input);

    boolean isBoolean(String input);

    boolean isRegex(String pattern, String input);

    boolean isContactBy(String input);
}
