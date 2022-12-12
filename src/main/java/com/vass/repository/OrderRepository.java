package com.vass.repository;

import java.time.LocalDateTime;
import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.vass.entity.PriceEntity;

public interface OrderRepository extends JpaRepository<PriceEntity, Date> {

	@Query("SELECT p FROM PriceEntity p WHERE (?1 BETWEEN p.startDate AND p.endDate) AND p.productId = ?2 AND brand = ?3 ORDER BY p.priority DESC LIMIT 1")
	PriceEntity getPrice(LocalDateTime date, Integer productId, Integer brandId);
}
