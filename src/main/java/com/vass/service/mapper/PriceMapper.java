package com.vass.service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.springframework.stereotype.Component;

import com.vass.api.domain.GetPriceResponse;
import com.vass.entity.PriceEntity;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.WARN)
@Component
public interface PriceMapper {

	@Mapping(source = "brand", target = "brandId")
	GetPriceResponse priceEntityToGetPriceResponse(PriceEntity priceEntity);
}
