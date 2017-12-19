package com.github.joumenharzli.springpoci18nexception.web.utils;

import java.time.format.DateTimeFormatter;
import java.util.Collections;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

@Component
public class LocaleMessageProvider {

  private final MessageSource messageSource;

  public LocaleMessageProvider(MessageSource messageSource) {
    this.messageSource = messageSource;
  }

  public String getMessage(String messageCode) {
    return getMessage(messageCode, Collections.emptyList());
  }

  public String getMessage(String messageCode, Object... args) {
    return this.messageSource.getMessage(messageCode, args, LocaleContextHolder.getLocale());
  }

}
