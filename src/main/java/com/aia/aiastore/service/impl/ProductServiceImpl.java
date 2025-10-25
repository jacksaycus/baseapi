package com.aia.aiastore.service.impl;

import com.aia.aiastore.dto.ProductDto;
import com.aia.aiastore.entity.Product;
import com.aia.aiastore.entity.ProductRedis;
import com.aia.aiastore.repository.ProductRedisRepository;
import com.aia.aiastore.repository.ProductRepository;
import com.aia.aiastore.service.IProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements IProductService {

    private final ProductRepository productRepository;
    private final ProductRedisRepository productRedisRepository;

    @Override
    public List<ProductDto> getProducts() {
        return productRepository.findAll()
                .stream().map(this::transformToDTO).collect(Collectors.toList());
    }
    @Override
    public List<ProductDto> getProductsRedis() {
        return productRedisRepository.findAll()
                .stream().map(this::transformToDTO1).collect(Collectors.toList());
    }

   @Override
   public void performSetRedis() {
       productRedisRepository.deleteAll();
       List<Product> products = productRepository.findAll();
       System.err.println(products.size());
       for(int i = 0;i <products.size();i++){
           Product product = products.get(i);
           ProductRedis temp = ProductRedis.of(product.getName(),product.getDescription(),product.getPrice(),product.getPopularity(), product.getImageUrl());
           temp.setId(product.getId().toString());
           productRedisRepository.save(temp);
       }
   }

    private ProductDto transformToDTO(Product product) {
        ProductDto productDto = new ProductDto();
        BeanUtils.copyProperties(product, productDto);
        productDto.setProductId(product.getId());
        return productDto;
    }

    private ProductDto transformToDTO1(ProductRedis product) {
        ProductDto productDto = new ProductDto();
        BeanUtils.copyProperties(product, productDto);
        productDto.setProductId(Long.parseLong(product.getId()));
        return productDto;
    }
}
