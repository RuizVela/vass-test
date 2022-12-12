package com.vass.api;

import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.vass.api.domain.GetPriceResponse;

@Validated
public interface OrderApi {

	@GetMapping(value = "/getPrice")
	ResponseEntity<GetPriceResponse> getPrice(
			@RequestParam("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDateTime date,
			@RequestParam("productId") Integer productId, @RequestParam("brandId") Integer brandId) throws Exception;
}
