package com.test.tarifas.application;

import com.test.tarifas.domain.Price;
import com.test.tarifas.domain.PriceDTO;

public class PriceMapper {
	
	private PriceMapper() {
        throw new UnsupportedOperationException("No puedes instanciar el mapper");
    }


    public static PriceDTO toPriceDTO(Price price) {
        return new PriceDTO(
                price.getPriceList(),
                price.getBrandId(),
                price.getStartDate(),
                price.getEndDate(),
                price.getProductId(),
                price.getAmount(),
                price.getCurr()
        );
    }
}
