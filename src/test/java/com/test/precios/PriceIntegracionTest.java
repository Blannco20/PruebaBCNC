package com.test.precios;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.test.tarifas.PruebaBcncApplication;
import com.test.tarifas.domain.PriceDTO;
import com.test.tarifas.infrastructure.PriceController;

@SpringBootTest(classes = PruebaBcncApplication.class)
@Transactional
 class PriceIntegracionTest {

    @Autowired
    private PriceController priceController;
    
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    @Test
     void test1() {
    	 LocalDateTime fechaAplicacion= LocalDateTime.parse("2020-06-14 10:00:00", formatter);
       
        PriceDTO response = priceController.getPrice(1L, 35455L, fechaAplicacion);
        
        assertThat(response.getPriceList()).isEqualTo(1);
        assertThat(response.getBrandId()).isEqualTo(1);
        assertThat(response.getPrice()).isEqualTo(35.50);
        assertThat(response.getCurr()).isEqualTo("EUR");
    }
    
    @Test
     void test2() {
    	 LocalDateTime fechaAplicacion= LocalDateTime.parse("2020-06-14 16:00:00", formatter);
       
        PriceDTO response = priceController.getPrice(1L, 35455L, fechaAplicacion);
        
        assertThat(response.getPriceList()).isEqualTo(2);
        assertThat(response.getBrandId()).isEqualTo(1);
        assertThat(response.getPrice()).isEqualTo(25.45);
        assertThat(response.getCurr()).isEqualTo("EUR");
    }
    
    @Test
     void test3() {
    	 LocalDateTime fechaAplicacion= LocalDateTime.parse("2020-06-14 21:00:00", formatter);
       
        PriceDTO response = priceController.getPrice(1L, 35455L, fechaAplicacion);
        
        assertThat(response.getPriceList()).isEqualTo(1);
        assertThat(response.getBrandId()).isEqualTo(1);
        assertThat(response.getPrice()).isEqualTo(35.50);
        assertThat(response.getCurr()).isEqualTo("EUR");
    }
    
    @Test
     void test4() {
    	 LocalDateTime fechaAplicacion= LocalDateTime.parse("2020-06-15 10:00:00", formatter);
       
        PriceDTO response = priceController.getPrice(1L, 35455L, fechaAplicacion);
        
        assertThat(response.getPriceList()).isEqualTo(3);
        assertThat(response.getBrandId()).isEqualTo(1);
        assertThat(response.getPrice()).isEqualTo(30.50);
        assertThat(response.getCurr()).isEqualTo("EUR");
    }
    
    @Test
     void test5() {
    	 LocalDateTime fechaAplicacion= LocalDateTime.parse("2020-06-16 21:00:00", formatter);
       
        PriceDTO response = priceController.getPrice(1L, 35455L, fechaAplicacion);
        
        assertThat(response.getPriceList()).isEqualTo(4);
        assertThat(response.getBrandId()).isEqualTo(1);
        assertThat(response.getPrice()).isEqualTo(38.95);
        assertThat(response.getCurr()).isEqualTo("EUR");
    }

   
}