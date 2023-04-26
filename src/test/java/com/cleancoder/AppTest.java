package com.cleancoder;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import com.cleancoder.messagetransport.MessageSender;
import com.cleancoder.messagetransport.impl.EmailSender;
import com.cleancoder.messagetransport.impl.SMSSender;
import com.cleancoder.validation.UserValidator;
import com.cleancoder.validation.technical.TechnicalValidatorImpl;
import java.io.File;
import java.nio.file.Paths;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class AppTest {

  private final MessageSender emailSender = mock(EmailSender.class);
  private final MessageSender smsSender = mock(SMSSender.class);
  private final UserValidator userValidator = new UserValidator(new TechnicalValidatorImpl());
  private final Runner runner = new Runner(userValidator, emailSender, smsSender);


  @Test
  void should_send_message_to_active_users_only() {
    runner.run(initUserFile("test_user_data.txt"));
    verify(emailSender, times(1)).sendTo("test1@mail.com");
    verify(smsSender, times(1)).sendTo("+999999999998");
    verify(emailSender, times(1)).sendTo("test4@mail.com");
    verify(emailSender, times(1)).sendTo("test5@mail.com");
    verify(smsSender, times(1)).sendTo("+999999999995");
    verify(emailSender, never()).sendTo("test3@mail.com");
  }


  @Test
  void should_not_send_message_to_invalid_users() {
    runner.run(initUserFile("invalid_users_data.txt"));
    verify(emailSender, never()).sendTo("test1@mail.com");
    verify(emailSender, never()).sendTo("test2@mail.com");
    verify(emailSender, never()).sendTo("test3@mail.com");
    verify(smsSender, never()).sendTo("+999999999996");
    verify(emailSender, never()).sendTo("test5@mail.com");
  }


  private File initUserFile(String fileName) {
    return Paths.get("src", "test", "resources", fileName).toFile();
  }
}
