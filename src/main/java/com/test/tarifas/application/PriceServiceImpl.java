package com.test.tarifas.application;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.test.tarifas.domain.Price;
import com.test.tarifas.domain.PriceDTO;
import com.test.tarifas.infrastructure.PriceRepository;

@Service
public class PriceServiceImpl implements PriceService {
	
	private final PriceRepository priceRepository;

	public PriceServiceImpl(PriceRepository priceRepository) {
		this.priceRepository = priceRepository;
	}

	@Override
	public PriceDTO getPrice(Long brandId, Long productId, LocalDateTime fechaAplicacion) {
		
		 List<Price> prices = priceRepository.findPrice(brandId, productId, fechaAplicacion);

		 Price tarifa  = prices.stream()
		                     .max((p1, p2) -> Integer.compare(p1.getPriority(), p2.getPriority()))
		                     .orElseThrow(() -> new RuntimeException("Price not found"));
		 
		 return PriceMapper.toPriceDTO(tarifa);
		        
		        
	}

}
