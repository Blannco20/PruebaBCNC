package com.test.precios;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.test.tarifas.application.PriceService;
import com.test.tarifas.domain.PriceDTO;
import com.test.tarifas.infrastructure.PriceController;


@ExtendWith(MockitoExtension.class)
public class PriceControllerMockTest {
	
	@InjectMocks
	private PriceController priceController;
	

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private PriceService priceService;

    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    
    @BeforeEach
    void setup() {
        // Inicializa MockMvc manualmente con el controlador a probar
        mockMvc = MockMvcBuilders.standaloneSetup(priceController).build();
    }


    // Test 1: petición a las 10:00 del día 14 del producto 35455 para la brand 1 (ZARA)
    @Test
    void test1() throws Exception {
        LocalDateTime fechaInicio = LocalDateTime.parse("2020-06-14 00:00:00", formatter);
        LocalDateTime fechaFin = LocalDateTime.parse("2020-12-31 23:59:59", formatter);
        
        LocalDateTime fechaAplicacion= LocalDateTime.parse("2020-06-14 10:00:00", formatter);
        
        PriceDTO expectedPrice = new PriceDTO(1L, 1L, fechaInicio, fechaFin, 35455L, 35.50, "EUR");

        when(priceService.getPrice(1L, 35455L, fechaAplicacion)).thenReturn(expectedPrice);

        mockMvc.perform(get("/api/price")
                .param("brandId", "1")
                .param("productId", "35455")
                .param("fechaAplicacion", "2020-06-14 10:00:00"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.priceList").value(1))
                .andExpect(jsonPath("$.brandId").value(1))
                .andExpect(jsonPath("$.price").value(35.50))
                .andExpect(jsonPath("$.curr").value("EUR"));
    }
    
   

    // Test 2: petición a las 16:00 del día 14 del producto 35455 para la brand 1 (ZARA)
    @Test
    void test2() throws Exception {
    	 LocalDateTime fechaInicio = LocalDateTime.parse("2020-06-14 15:00:00", formatter);
         LocalDateTime fechaFin = LocalDateTime.parse("2020-06-14 18:30:00", formatter);
         
         LocalDateTime fechaAplicacion= LocalDateTime.parse("2020-06-14 16:00:00", formatter);
         
         PriceDTO expectedPrice = new PriceDTO(2L, 1L, fechaInicio, fechaFin, 35455L, 25.45, "EUR");

        when(priceService.getPrice(1L, 35455L, fechaAplicacion)).thenReturn(expectedPrice);

        mockMvc.perform(get("/api/price")
                .param("brandId", "1")
                .param("productId", "35455")
                .param("fechaAplicacion", "2020-06-14 16:00:00"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.priceList").value(2))
                .andExpect(jsonPath("$.brandId").value(1))
                .andExpect(jsonPath("$.price").value(25.45))
                .andExpect(jsonPath("$.curr").value("EUR"));
    }

    // Test 3: petición a las 21:00 del día 14 del producto 35455 para la brand 1 (ZARA)
    @Test
    void test3() throws Exception {
    	 LocalDateTime fechaInicio = LocalDateTime.parse("2020-06-14 00:00:00", formatter);
         LocalDateTime fechaFin = LocalDateTime.parse("2020-12-31 23:59:59", formatter);
         
         LocalDateTime fechaAplicacion= LocalDateTime.parse("2020-06-14 21:00:00", formatter);
         
         PriceDTO expectedPrice = new PriceDTO(1L, 1L, fechaInicio, fechaFin, 35455L, 35.50, "EUR");

        when(priceService.getPrice(1L, 35455L, fechaAplicacion)).thenReturn(expectedPrice);

        mockMvc.perform(get("/api/price")
                .param("brandId", "1")
                .param("productId", "35455")
                .param("fechaAplicacion", "2020-06-14 21:00:00"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.priceList").value(1))
                .andExpect(jsonPath("$.brandId").value(1))
                .andExpect(jsonPath("$.price").value(35.50))
                .andExpect(jsonPath("$.curr").value("EUR"));
    }

    // Test 4: petición a las 10:00 del día 15 del producto 35455 para la brand 1 (ZARA)
    @Test
    void test4() throws Exception {
    	LocalDateTime fechaInicio = LocalDateTime.parse("2020-06-15 00:00:00", formatter);
        LocalDateTime fechaFin = LocalDateTime.parse("2020-06-15 11:00:00", formatter);
        
        LocalDateTime fechaAplicacion= LocalDateTime.parse("2020-06-15 10:00:00", formatter);
        
        PriceDTO expectedPrice = new PriceDTO(3L, 1L, fechaInicio, fechaFin, 35455L, 30.50, "EUR");

        when(priceService.getPrice(1L, 35455L, fechaAplicacion)).thenReturn(expectedPrice);

        mockMvc.perform(get("/api/price")
                .param("brandId", "1")
                .param("productId", "35455")
                .param("fechaAplicacion", "2020-06-15 10:00:00"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.priceList").value(3))
                .andExpect(jsonPath("$.brandId").value(1))
                .andExpect(jsonPath("$.price").value(30.50))
                .andExpect(jsonPath("$.curr").value("EUR"));
    }

    // Test 5: petición a las 21:00 del día 16 del producto 35455 para la brand 1 (ZARA)
    @Test
    void test5() throws Exception {
    	LocalDateTime fechaInicio = LocalDateTime.parse("2020-06-15 16:00:00", formatter);
        LocalDateTime fechaFin = LocalDateTime.parse("2020-12-31 23:59:59", formatter);
        
        LocalDateTime fechaAplicacion= LocalDateTime.parse("2020-06-16 21:00:00", formatter);
        
        PriceDTO expectedPrice = new PriceDTO(4L, 1L, fechaInicio, fechaFin, 35455L, 38.95, "EUR");

        when(priceService.getPrice(1L, 35455L, fechaAplicacion)).thenReturn(expectedPrice);

        mockMvc.perform(get("/api/price")
                .param("brandId", "1")
                .param("productId", "35455")
                .param("fechaAplicacion", "2020-06-16 21:00:00"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.priceList").value(4))
                .andExpect(jsonPath("$.brandId").value(1))
                .andExpect(jsonPath("$.price").value(38.95))
                .andExpect(jsonPath("$.curr").value("EUR"));
    }
}
