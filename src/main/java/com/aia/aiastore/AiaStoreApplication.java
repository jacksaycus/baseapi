package com.aia.aiastore;

import com.aia.aiastore.entity.Product;
import com.aia.aiastore.entity.ProductRedis;
import com.aia.aiastore.repository.ProductRedisRepository;
import com.aia.aiastore.repository.ProductRepository;
import com.redis.om.spring.annotations.EnableRedisDocumentRepositories;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;

import java.util.List;

@EnableRedisDocumentRepositories
@SpringBootApplication
public class AiaStoreApplication {
    private static Logger log = LoggerFactory.getLogger(AiaStoreApplication.class);

//    @Autowired
//    ProductRepository productRepository;
//    @Autowired
//    ProductRedisRepository productRedisRepository;

//    @Bean
//    @Order(1)
//    CommandLineRunner findAll() {
//        return args -> {
//            List<Product> products = productRepository.findAll();
//            products.forEach(product -> log.info("Find all Product: {}", product.getName()));
//        };
//    }
//    @Bean
//    @Order(2)
//    CommandLineRunner loadTestData() {
//        return args -> {
//            productRedisRepository.deleteAll();
//            List<Product> products = productRepository.findAll();
//            System.err.println(products.size());
//            for(int i = 0;i <products.size();i++){
//                Product product = products.get(i);
//                ProductRedis temp = ProductRedis.of(product.getName(),product.getDescription(),product.getPrice(),product.getPopularity(), product.getImageUrl());
//                temp.setId(product.getId().toString());
//                productRedisRepository.save(temp);
//            }
//
//        };
//        }
//
//    @Bean
//    @Order(3)
//    CommandLineRunner findAllProduct() {
//        return args -> {
//            List<ProductRedis> productRedis = productRedisRepository.findAll();
//            System.err.println("product redis size " + productRedis.size());
//            productRedis.forEach(productredis -> log.info("Find all ProductRedis: {}", productredis));
//        };
//    }

	public static void main(String[] args) {
		SpringApplication.run(AiaStoreApplication.class, args);
	}

}
