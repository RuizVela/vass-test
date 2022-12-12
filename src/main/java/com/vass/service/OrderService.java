package com.vass.service;

import java.time.LocalDateTime;

import com.vass.api.domain.GetPriceResponse;

public interface OrderService {
	GetPriceResponse getPrice(LocalDateTime date, Integer productId, Integer brandId) throws Exception;
}
