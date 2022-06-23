package cl.exchangemoney.pruebatest.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CurrencyEquivalenceResponseDto {

  private String currencyKey;
  private String currencyName;
  private String currencyPivotKey;
  private Double currencyPivotEquivalence;
  private Boolean active;
  private java.sql.Timestamp updatedAt;
  private java.sql.Timestamp createdAt;
}
