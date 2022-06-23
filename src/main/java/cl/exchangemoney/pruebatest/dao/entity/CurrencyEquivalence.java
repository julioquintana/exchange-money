package cl.exchangemoney.pruebatest.dao.entity;

import java.io.Serial;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "currency_equivalences", schema = "security")
public class CurrencyEquivalence implements Serializable {

  @Serial
  private static final long serialVersionUID = 1L;


  @Id
  @Column(name = "currency_key", nullable = false)
  private String currencyKey;
  @Column(name = "currency_name", nullable = false)
  private String currencyName;
  @Column(name = "currency_pivot_key", nullable = false)
  private String currencyPivotKey;
  @Column(name = "currency_pivot_equivalence", nullable = false)
  private Double currencyPivotEquivalence;
  private Boolean active;
  @UpdateTimestamp
  private java.sql.Timestamp updatedAt;
  @CreationTimestamp
  private java.sql.Timestamp createdAt;
}
