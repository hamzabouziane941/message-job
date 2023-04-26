package com.cleancoder;

import com.cleancoder.messagetransport.impl.EmailSender;
import com.cleancoder.messagetransport.impl.SMSSender;
import com.cleancoder.validation.BusinessValidator;
import com.cleancoder.validation.UserValidator;
import com.cleancoder.validation.technical.TechnicalValidator;
import com.cleancoder.validation.technical.TechnicalValidatorImpl;
import java.io.File;

public class App {

    public static void main(String[] args) {
        String userFilePath = args[0];
        String emailText = args[1];
        String smsText = args[2];

        TechnicalValidator technicalValidator = new TechnicalValidatorImpl();
        BusinessValidator userValidator = new UserValidator(technicalValidator);
        new Runner(userValidator, new EmailSender(emailText), new SMSSender(smsText)).run(new File(userFilePath));
    }
}
