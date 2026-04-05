package org.chandgirish.product.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ProductDTO {

    private Long id;
    private String sku;
    private String name;
    private String description;
    private String brand;
    private Double price;
    private Double discount;
    private String currency;
    private Integer stockQuantity;
    private boolean active;
    private boolean featured;
    private List<String> colors;
    private List<String> sizes;
    private Double weight;
    private List<String> images;
    private Long categoryId;
}
