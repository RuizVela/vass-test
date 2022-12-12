package com.vass.web;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.server.ResponseStatusException;

import com.vass.api.domain.GetPriceResponse;
import com.vass.service.OrderService;

@ExtendWith(MockitoExtension.class)
class OrderControllerTest {

	@Mock
	private OrderService orderService;

	@InjectMocks
	OrderController orderController;

	@Test
	void test_Ok() throws Exception {
		MockHttpServletRequest request = new MockHttpServletRequest();
		RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));

		GetPriceResponse response = new GetPriceResponse();
		response.setBrandId(1);
		response.setProductId(345445);
		response.setPrice(38.5);
		response.setPriceList(1);
		response.setStartDate(null);
		response.setEndDate(null);

		when(orderService.getPrice(any(), any(), any())).thenReturn(response);

		ResponseEntity<GetPriceResponse> responseEntity = orderController.getPrice(null, 1, 3455534);

		assertEquals(response, responseEntity.getBody());

	}

	@Test
	void test_Ko() throws Exception {
		MockHttpServletRequest request = new MockHttpServletRequest();
		RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));

		GetPriceResponse response = new GetPriceResponse();
		response.setBrandId(1);
		response.setProductId(345445);
		response.setPrice(38.5);
		response.setPriceList(1);
		response.setStartDate(null);
		response.setEndDate(null);

		when(orderService.getPrice(any(), any(), any()))
				.thenThrow(new ResponseStatusException(HttpStatus.NOT_FOUND, "productId not found"));

		assertThrows(ResponseStatusException.class, () -> {
			orderController.getPrice(null, 1, 3455534);
		});

	}
}
