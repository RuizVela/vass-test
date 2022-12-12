package com.vass.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDateTime;
import java.time.Month;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.web.server.ResponseStatusException;

import com.vass.api.domain.GetPriceResponse;
import com.vass.repository.OrderRepository;
import com.vass.service.impl.OrderServiceImpl;
import com.vass.service.mapper.PriceMapper;
import com.vass.service.mapper.PriceMapperImpl;

@DataJpaTest
class OrderServiceTest {
	private OrderService orderService;

	@Autowired
	private OrderRepository orderRepository;
	private PriceMapper priceMapper;

	Integer brandId;
	Integer productId;

	@BeforeEach
	void setUp() {
		priceMapper = new PriceMapperImpl();
		orderService = new OrderServiceImpl(orderRepository, priceMapper);

		productId = 35455;
		brandId = 1;
	}

	@Test
	void test1() throws Exception {
		LocalDateTime date = LocalDateTime.of(2020, Month.JUNE, 14, 10, 00);

		GetPriceResponse response = orderService.getPrice(date, productId, brandId);

		Double expected = 35.5;
		assertEquals(response.getPrice(), expected);
	}

	@Test
	void test2() throws Exception {
		LocalDateTime date = LocalDateTime.of(2020, Month.JUNE, 14, 16, 00);

		GetPriceResponse response = orderService.getPrice(date, productId, brandId);

		Double expected = 25.45;
		assertEquals(response.getPrice(), expected);
	}

	@Test
	void test3() throws Exception {
		LocalDateTime date = LocalDateTime.of(2020, Month.JUNE, 14, 21, 00);

		GetPriceResponse response = orderService.getPrice(date, productId, brandId);

		Double expected = 35.5;
		assertEquals(response.getPrice(), expected);
	}

	@Test
	void test4() throws Exception {
		LocalDateTime date = LocalDateTime.of(2020, Month.JUNE, 15, 10, 00);

		GetPriceResponse response = orderService.getPrice(date, productId, brandId);

		Double expected = 30.50;
		assertEquals(response.getPrice(), expected);
	}

	@Test
	void test5() throws Exception {
		LocalDateTime date = LocalDateTime.of(2020, Month.JUNE, 16, 21, 00);

		GetPriceResponse response = orderService.getPrice(date, productId, brandId);

		Double expected = 38.95;
		assertEquals(response.getPrice(), expected);
	}

	@Test
	void test_exception() throws Exception {
		LocalDateTime date = LocalDateTime.of(2020, Month.JUNE, 16, 21, 00);
		int undefinedProductId = 3;

		assertThrows(ResponseStatusException.class, () -> {
			orderService.getPrice(date, undefinedProductId, brandId);
		});
	}

}
