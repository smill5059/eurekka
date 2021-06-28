package com.ssafy.eurekka.handler;

import com.ssafy.eurekka.util.NotificationManager;
import java.util.Enumeration;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

  @Autowired
  private NotificationManager notificationManager;

  @ExceptionHandler(Exception.class)
  public ResponseEntity globalException(Exception e, HttpServletRequest req) {
    e.printStackTrace();
    notificationManager.sendMattermost(e, req.getRequestURI(), getParmas(req));
    return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
  }

  @ExceptionHandler(HttpMessageNotReadableException.class)
  public ResponseEntity wrongParamException(Exception e, HttpServletRequest req) {
    e.printStackTrace();
    notificationManager.sendMattermost(e, req.getRequestURI(), getParmas(req));
    return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
  }

  private String getParmas(HttpServletRequest req) {
    StringBuilder sb = new StringBuilder();
    Enumeration<String> keys = req.getParameterNames();
    while (keys.hasMoreElements()) {
      String key = keys.nextElement();
      sb.append("- ").append(key).append(": ").append(req.getParameter(key)).append("\n");
    }
    return sb.toString();
  }

}
