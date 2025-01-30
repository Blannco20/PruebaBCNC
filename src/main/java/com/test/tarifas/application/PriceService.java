package com.test.tarifas.application;

import java.time.LocalDateTime;

import com.test.tarifas.domain.PriceDTO;

public interface PriceService {
	
	PriceDTO getPrice(Long brandId, Long productId, LocalDateTime fechaAplicacion);

}
