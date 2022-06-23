package cl.exchangemoney.pruebatest.dao.repository;

import cl.exchangemoney.pruebatest.dao.entity.CurrencyEquivalence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface CurrencyEquivalenceRepository
    extends JpaRepository<CurrencyEquivalence, String>,
    JpaSpecificationExecutor<CurrencyEquivalence> {

}
