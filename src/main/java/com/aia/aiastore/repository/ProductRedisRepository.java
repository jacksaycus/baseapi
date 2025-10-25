package com.aia.aiastore.repository;

import com.aia.aiastore.entity.ProductRedis;
import com.redis.om.spring.repository.RedisDocumentRepository;

public interface ProductRedisRepository extends RedisDocumentRepository<ProductRedis,Long> {

}
