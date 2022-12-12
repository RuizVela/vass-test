package com.vass.web;

import java.time.LocalDateTime;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.vass.api.OrderApi;
import com.vass.api.domain.GetPriceResponse;
import com.vass.service.OrderService;

@RestController
public class OrderController implements OrderApi {

	private OrderService orderService;

	public OrderController(OrderService orderService) {
		this.orderService = orderService;
	}

	@Override
	public ResponseEntity<GetPriceResponse> getPrice(LocalDateTime date, Integer productId, Integer brandId)
			throws Exception {
		
		GetPriceResponse getPriceResponse = null;
		try {
			getPriceResponse = orderService.getPrice(date, productId, brandId);

		} catch (Exception e) {
			throw e;
		}
		return ResponseEntity.ok(getPriceResponse);
	}

}
