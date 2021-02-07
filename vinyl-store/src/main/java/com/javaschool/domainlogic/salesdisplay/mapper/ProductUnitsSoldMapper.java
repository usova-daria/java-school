package com.javaschool.domainlogic.salesdisplay.mapper;

import com.javaschool.domainlogic.admin.stats.dto.ProductData;
import com.javaschool.domainlogic.salesdisplay.dto.ProductUnitsSold;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface ProductUnitsSoldMapper {

    ProductUnitsSold toDto(ProductData productData);

    List<ProductUnitsSold> toDtoList(List<ProductData> productData);

}
