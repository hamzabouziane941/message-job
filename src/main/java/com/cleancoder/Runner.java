package com.cleancoder;

import com.cleancoder.common.CommonConstants;
import com.cleancoder.fileprocessing.FileProcessor;
import com.cleancoder.messagetransport.MessageSender;
import com.cleancoder.validation.BusinessValidator;
import java.io.File;

import static java.lang.String.format;

public class Runner
{
    private static final String LINE_SEPARATOR = ",";

    private final BusinessValidator userValidator;
    private final MessageSender emailSender;
    private final MessageSender smsSender;

    public Runner(BusinessValidator userValidator, MessageSender emailSender, MessageSender smsSender) {
        this.userValidator = userValidator;
        this.emailSender = emailSender;
        this.smsSender = smsSender;
    }

    public void run(File userFile) {
        FileProcessor.processLines(userFile, this::sendMessage);
    }


    private void sendMessage(String line)
    {
        String[] userData = loadUserData(line);
        if(!userValidator.isValid(userData)) {
            System.out.println(format("Line with id : '%s' is not valid", userData[0]));
            return;
        }
        sendMessageIfUserActive(userData);
    }

    private void sendMessageIfUserActive(String[] userData)
    {
        String isActive = userData[1];
        if("true".equals(isActive)) {
            sendMessage(userData);
        }
    }


    private void sendMessage(String[] userData)
    {
        String contactBy = userData[2];
        String email = userData[3];
        String phone = userData[4];

        if(CommonConstants.EMAIL.equals(contactBy)) {
            emailSender.sendTo(email);
        }
        else if(CommonConstants.PHONE.equals(contactBy)) {
            smsSender.sendTo(phone);
        }
        else {
            emailSender.sendTo(email);
            smsSender.sendTo(phone);
        }
    }

    private String[] loadUserData(String line)
    {
        return line.split(LINE_SEPARATOR);
    }

}
