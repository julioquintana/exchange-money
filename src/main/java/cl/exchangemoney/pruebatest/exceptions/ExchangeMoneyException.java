package cl.exchangemoney.pruebatest.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class ExchangeMoneyException extends Exception {

  private final String codError;
  private final String severity;
  private final HttpStatus status;

  public ExchangeMoneyException(
      String severity, String message, String codError, HttpStatus status) {
    super(message);
    this.codError = codError;
    this.severity = severity;
    this.status = status;
  }
}
