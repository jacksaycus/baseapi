package com.aia.aiastore.controller;

import com.aia.aiastore.dto.ProductDto;
import com.aia.aiastore.service.IProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("api/v1/products")
@RequiredArgsConstructor
// @CrossOrigin(origins = "http://localhost:5173")
public class ProductController {

    private final IProductService iProductService;

    @GetMapping("/")
    public String getroot() { // DTO Pattern
        return "hello world";
    }

    @GetMapping("/table")
    public List<ProductDto> getProducts() { // DTO Pattern
        List<ProductDto> productList = iProductService.getProducts();
        return productList;
    }

    @GetMapping("/redis")
    public List<ProductDto> getProductsRedis() { // DTO Pattern
        List<ProductDto> productList = iProductService.getProductsRedis();
        return productList;
    }

    @GetMapping("/performsetredis")
    ResponseEntity<String> performSetRedis() {
        iProductService.performSetRedis();
        return ResponseEntity.ok().body("clean redis success");
    }

}
