package cl.exchangemoney.pruebatest.controller;

import cl.exchangemoney.pruebatest.dto.CurrencyEquivalenceRequestDto;
import cl.exchangemoney.pruebatest.dto.CurrencyEquivalenceResponseDto;
import cl.exchangemoney.pruebatest.service.ICurrencyEquivalenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.SortDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/v1/currency-equivalence/", produces = MediaType.APPLICATION_JSON_VALUE)
public class CurrencyEquivalenceController {

  private final ICurrencyEquivalenceService service;

  @Autowired
  public CurrencyEquivalenceController(ICurrencyEquivalenceService service) {
    this.service = service;
  }

  @PostMapping(path = "/")
  public ResponseEntity<CurrencyEquivalenceResponseDto> create(
      @RequestBody CurrencyEquivalenceRequestDto requestDto) {
    return new ResponseEntity<>(service.newCurrencyEquivalence(requestDto), HttpStatus.OK);
  }

  @GetMapping(path = "/")
  public ResponseEntity<Page<CurrencyEquivalenceResponseDto>> getByParameters(
      @RequestParam(value = "key", required = false) String key,
      @SortDefault.SortDefaults({
          @SortDefault(sort = "currency_name", direction = Sort.Direction.ASC)})
          Pageable pageable) {
    return new ResponseEntity<>(
        service.getAll(key, pageable), HttpStatus.OK);
  }
}
