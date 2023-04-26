package com.cleancoder.messagetransport.impl;

import com.cleancoder.messagetransport.MessageSender;

import static java.lang.String.format;

public class SMSSender implements MessageSender
{
    private String text;

    public SMSSender(String text) {
        this.text = text;
    }

    @Override
    public void sendTo(String message)
    {
        String content = format("Sending an sms to %s with text: %s", message, text);
        System.out.println(content);
    }
}
