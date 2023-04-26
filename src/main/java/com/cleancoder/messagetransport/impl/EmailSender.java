package com.cleancoder.messagetransport.impl;

import com.cleancoder.messagetransport.MessageSender;

import static java.lang.String.format;

public class EmailSender implements MessageSender
{
    private String text;

    public EmailSender(String text) {
        this.text = text;
    }

    public void sendTo(String message)
    {
        String content = format("Sending an email to %s with text: %s", message, text);
        System.out.println(content);
    }
}
