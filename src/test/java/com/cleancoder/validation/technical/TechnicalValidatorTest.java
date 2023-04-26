package com.cleancoder.validation.technical;

import com.cleancoder.common.CommonConstants;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TechnicalValidatorTest
{
    private TechnicalValidatorImpl technicalValidator = new TechnicalValidatorImpl();

    @Test
    void should_return_false_when_input_string_is_not_long() {
        assertFalse(technicalValidator.isLong("Not long"));
    }

    @Test
    void should_return_true_when_input_string_is_long() {
        assertTrue(technicalValidator.isLong("2"));
    }

    @Test
    void should_return_true_when_input_string_is_not_boolean() {
        assertFalse(technicalValidator.isBoolean("not boolean"));
    }

    @Test
    void should_return_true_when_input_string_is_boolean() {
        assertTrue(technicalValidator.isBoolean("true"));
    }

    @Test
    void should_return_true_when_input_matches_regex() {
        assertTrue(technicalValidator.isRegex(CommonConstants.EMAIL_REGEX_PATTERN, "test@test.com"));
    }

    @Test
    void should_return_false_when_input_does_not_match_regex() {
        assertFalse(technicalValidator.isRegex(CommonConstants.EMAIL_REGEX_PATTERN, "xxxx"));
    }

    @Test
    void should_return_false_when_input_is_not_contact_type() {
        assertFalse(technicalValidator.isContactBy("xxxx"));
    }

    @Test
    void should_return_true_when_input_is_email() {
        assertTrue(technicalValidator.isContactBy("email"));
    }

    @Test
    void should_return_true_when_input_is_phone() {
        assertTrue(technicalValidator.isContactBy("phone"));
    }

    @Test
    void should_return_true_when_input_is_all() {
        assertTrue(technicalValidator.isContactBy("all"));
    }
}
