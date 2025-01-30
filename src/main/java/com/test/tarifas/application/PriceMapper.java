package com.test.tarifas.application;

import com.test.tarifas.domain.Price;
import com.test.tarifas.domain.PriceDTO;

public class PriceMapper {

    public static PriceDTO toPriceDTO(Price price) {
        return new PriceDTO(
                price.getPriceList(),
                price.getBrandId(),
                price.getStartDate(),
                price.getEndDate(),
                price.getProductId(),
                price.getPrice(),
                price.getCurr()
        );
    }
}
