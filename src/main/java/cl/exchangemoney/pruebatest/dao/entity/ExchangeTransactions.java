package cl.exchangemoney.pruebatest.dao.entity;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "exchange_transactions", schema = "security")
public class ExchangeTransactions {

  @Id
  private Long id;
  private String currencyOrigin;
  private String currencyDestiny;
  private Double amountOrigin;
  private Double amountDestiny;
  private Double amountPivotEquivalence;
  private Double priceEquivalence;
  private java.sql.Timestamp createdAt;

}
