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
@Table(name = "configurations", schema = "security")
public class Configurations {

  @Id
  private Integer id;
  private String pivotKey;
  private double percentage;
}
