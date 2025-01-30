package com.test.tarifas.infrastructure;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.test.tarifas.domain.Price;

@Repository
public interface PriceRepository extends JpaRepository<Price, Long> {
	
	@Query("SELECT p FROM Price p WHERE :fechaAplicacion BETWEEN p.startDate AND p.endDate " +
	           "AND p.productId = :productId AND p.brandId = :brandId ")
    List<Price> findPrice(
            Long brandId, Long productId, LocalDateTime fechaAplicacion);
    }

