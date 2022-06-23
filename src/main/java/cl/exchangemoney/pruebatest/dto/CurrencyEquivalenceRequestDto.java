package cl.exchangemoney.pruebatest.dto;

import javax.persistence.Column;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CurrencyEquivalenceRequestDto {

  private String key;
  private String name;
  private String currencyPivotKey;
  private Double currencyPivotEquivalence;
}
