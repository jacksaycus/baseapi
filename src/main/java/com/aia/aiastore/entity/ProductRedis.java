package com.aia.aiastore.entity;

import com.redis.om.spring.annotations.Document;
import com.redis.om.spring.annotations.Indexed;
import jakarta.persistence.Column;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.springframework.data.annotation.Id;

import java.math.BigDecimal;
import java.time.Instant;

@RequiredArgsConstructor(staticName = "of")
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Data
@Document
public class ProductRedis {
    @Id
    @Indexed
    private String id;

    @Indexed @NonNull
    private String name;

    @Indexed @NonNull
    private String description;

    @Indexed @NonNull
    private BigDecimal price;

    @Indexed @NonNull
    private Integer popularity;

    @Indexed @NonNull
    private String imageUrl;

    private Instant createdAt;

    private String createdBy;


    private Instant updatedAt;


    private String updatedBy;

}