package cl.exchangemoney.pruebatest.specification;


import cl.exchangemoney.pruebatest.dao.entity.CurrencyEquivalence;
import cl.exchangemoney.pruebatest.dao.entity.CurrencyEquivalence_;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

public class CurrencyEquivalenceSpecification {

  public static Specification<CurrencyEquivalence> currencyEquivalenceEquals(final String key) {
    return (root, query, criteriaBuilder) -> {
      if (StringUtils.hasText(key)) {
        return criteriaBuilder.equal(root.get(CurrencyEquivalence_.currencyKey), key);
      }
      return criteriaBuilder.conjunction();
    };
  }
}
