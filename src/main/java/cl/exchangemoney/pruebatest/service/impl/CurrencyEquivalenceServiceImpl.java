package cl.exchangemoney.pruebatest.service.impl;

import static org.springframework.data.jpa.domain.Specification.where;

import cl.exchangemoney.pruebatest.dao.repository.CurrencyEquivalenceRepository;
import cl.exchangemoney.pruebatest.dto.CurrencyEquivalenceRequestDto;
import cl.exchangemoney.pruebatest.dto.CurrencyEquivalenceResponseDto;
import cl.exchangemoney.pruebatest.exceptions.ExchangeMoneyException;
import cl.exchangemoney.pruebatest.service.ICurrencyEquivalenceService;
import cl.exchangemoney.pruebatest.specification.CurrencyEquivalenceSpecification;
import cl.exchangemoney.pruebatest.util.Constant;
import cl.exchangemoney.pruebatest.util.CurrencyEquivalenceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class CurrencyEquivalenceServiceImpl implements ICurrencyEquivalenceService {

  private final CurrencyEquivalenceRepository repository;

  @Autowired
  public CurrencyEquivalenceServiceImpl(CurrencyEquivalenceRepository repository) {
    this.repository = repository;
  }

  @Override
  public CurrencyEquivalenceResponseDto newCurrencyEquivalence(
      CurrencyEquivalenceRequestDto currencyEquivalenceRequestDto) {
    var currencyEquivalence = CurrencyEquivalenceMapper.build(currencyEquivalenceRequestDto);
    var currencyEquivalenceSalved = repository.save(currencyEquivalence);
    return CurrencyEquivalenceMapper.build(currencyEquivalenceSalved);
  }

  @Override
  public Page<CurrencyEquivalenceResponseDto> getAll(String key, Pageable pageable)
      throws ExchangeMoneyException {
    var response =
        repository.findAll(where(CurrencyEquivalenceSpecification.currencyEquivalenceEquals(key)),
            pageable);

    if (response.isEmpty()) {
      throw new ExchangeMoneyException(
          Constant.ERROR, Constant.EMPTY_LIST, Constant.GENERIC_ERROR, HttpStatus.NOT_FOUND);
    }
    return CurrencyEquivalenceMapper.build(response);
  }
}
