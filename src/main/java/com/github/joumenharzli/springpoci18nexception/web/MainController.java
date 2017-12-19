package com.github.joumenharzli.springpoci18nexception.web;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.joumenharzli.springpoci18nexception.exception.InternalException;
import com.github.joumenharzli.springpoci18nexception.web.utils.LocaleMessageProvider;

@RestController
public class MainController {

  private final LocaleMessageProvider localeMessageProvider;

  public MainController(LocaleMessageProvider localeMessageProvider) {
    this.localeMessageProvider = localeMessageProvider;
  }

  @GetMapping("/hello")
  public String hello() {
    return localeMessageProvider.getMessage("hello-world","Bob","Alice");
  }

  @GetMapping("/throwerror")
  public String throwError() {
    throw new InternalException();
  }

  @ExceptionHandler(value = InternalException.class)
  public String handleInternalException() {
    return localeMessageProvider.getMessage("error.internal");
  }
}
