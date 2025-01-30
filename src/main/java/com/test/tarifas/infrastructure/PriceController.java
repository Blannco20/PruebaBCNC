package com.test.tarifas.infrastructure;

import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.test.tarifas.application.PriceService;
import com.test.tarifas.domain.PriceDTO;

@RestController
@RequestMapping("/api/price")
public class PriceController {

	private final PriceService priceService;

	public PriceController(PriceService priceService) {
		this.priceService = priceService;
	}

	@GetMapping()
	public PriceDTO getPrice(@RequestParam Long brandId, @RequestParam Long productId,
			@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime fechaAplicacion) {

		return priceService.getPrice(brandId, productId, fechaAplicacion);
	}

}
