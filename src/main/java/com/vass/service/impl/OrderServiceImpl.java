package com.vass.service.impl;

import java.time.LocalDateTime;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.vass.api.domain.GetPriceResponse;
import com.vass.entity.PriceEntity;
import com.vass.repository.OrderRepository;
import com.vass.service.OrderService;
import com.vass.service.mapper.PriceMapper;

@Service
@ComponentScan("com")
public class OrderServiceImpl implements OrderService {

	private OrderRepository orderRepository;
	private PriceMapper priceMapper;

	public OrderServiceImpl(OrderRepository orderRepository, PriceMapper priceMapper) {
		super();
		this.orderRepository = orderRepository;
		this.priceMapper = priceMapper;
	}

	@Override
	public GetPriceResponse getPrice(LocalDateTime date, Integer productId, Integer brandId) throws Exception {
		GetPriceResponse getPriceResponse = null;

		PriceEntity response = orderRepository.getPrice(date, productId, brandId);

		if (response == null) {
			throw new ResponseStatusException(
					  HttpStatus.NOT_FOUND, "productId not found"
					);
		}
		getPriceResponse = priceMapper.priceEntityToGetPriceResponse(response);

		return getPriceResponse;
	}

}
