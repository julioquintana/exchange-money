package cl.exchangemoney.pruebatest.util;

import cl.exchangemoney.pruebatest.dao.entity.CurrencyEquivalence;
import cl.exchangemoney.pruebatest.dto.CurrencyEquivalenceRequestDto;
import cl.exchangemoney.pruebatest.dto.CurrencyEquivalenceResponseDto;
import java.util.stream.Collectors;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

public class CurrencyEquivalenceMapper {

  public static CurrencyEquivalence build(
      CurrencyEquivalenceRequestDto currencyEquivalenceRequestDto) {
    return CurrencyEquivalence.builder()
        .currencyKey(currencyEquivalenceRequestDto.getKey())
        .currencyName(currencyEquivalenceRequestDto.getName())
        .currencyPivotKey(currencyEquivalenceRequestDto.getCurrencyPivotKey())
        .currencyPivotEquivalence(currencyEquivalenceRequestDto.getCurrencyPivotEquivalence())
        .active(true)
        .build();
  }

  public static CurrencyEquivalenceResponseDto build(
      CurrencyEquivalence currencyEquivalenceSalved) {
    return CurrencyEquivalenceResponseDto.builder()
        .currencyKey(currencyEquivalenceSalved.getCurrencyKey())
        .currencyName(currencyEquivalenceSalved.getCurrencyName())
        .currencyPivotKey(currencyEquivalenceSalved.getCurrencyPivotKey())
        .currencyPivotEquivalence(currencyEquivalenceSalved.getCurrencyPivotEquivalence())
        .active(currencyEquivalenceSalved.getActive())
        .updatedAt(currencyEquivalenceSalved.getUpdatedAt())
        .createdAt(currencyEquivalenceSalved.getCreatedAt())
        .build();
  }

  public static Page<CurrencyEquivalenceResponseDto> build(Page<CurrencyEquivalence> response) {
    return new PageImpl<>(
        response.stream().map(CurrencyEquivalenceMapper::build).collect(Collectors.toList()),
        response.getPageable(),
        response.getTotalElements());
  }
}
