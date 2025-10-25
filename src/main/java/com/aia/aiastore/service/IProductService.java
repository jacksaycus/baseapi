package com.aia.aiastore.service;

import com.aia.aiastore.dto.ProductDto;

import java.util.List;

public interface IProductService {

    List<ProductDto> getProducts();
    List<ProductDto> getProductsRedis();

    void performSetRedis();
}
