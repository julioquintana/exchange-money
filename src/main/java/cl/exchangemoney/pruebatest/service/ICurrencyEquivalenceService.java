package cl.exchangemoney.pruebatest.service;

import cl.exchangemoney.pruebatest.dto.CurrencyEquivalenceRequestDto;
import cl.exchangemoney.pruebatest.dto.CurrencyEquivalenceResponseDto;
import cl.exchangemoney.pruebatest.exceptions.ExchangeMoneyException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ICurrencyEquivalenceService {

  CurrencyEquivalenceResponseDto newCurrencyEquivalence(CurrencyEquivalenceRequestDto requestDto);

  Page<CurrencyEquivalenceResponseDto> getAll(String key, Pageable pageable)
      throws ExchangeMoneyException;
}
