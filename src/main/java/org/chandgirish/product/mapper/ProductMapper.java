package org.chandgirish.product.mapper;

import org.chandgirish.product.dto.ProductDTO;
import org.chandgirish.product.entity.Product;

public class ProductMapper {

    public static ProductDTO toDTO(Product entity) {
        //can also use mapStruct  which reduces the code
//        ProductDTO dto = new ProductDTO();
//
//        dto.setId(entity.getId());
//        dto.setSku(entity.getSku());
//        dto.setName(entity.getName());
//        dto.setDescription(entity.getDescription());
//        dto.setBrand(entity.getBrand());
//        dto.setPrice(entity.getPrice());
//        dto.setDiscount(entity.getDiscount());
//        dto.setCurrency(entity.getCurrency());
//        dto.setStockQuantity(entity.getStockQuantity());
//        dto.setActive(entity.isActive());
//        dto.setFeatured(entity.isFeatured());
//        dto.setColors(entity.getColors());
//        dto.setSizes(entity.getSizes());
//        dto.setWeight(entity.getWeight());
//        dto.setImages(entity.getImages());
//
//        if (entity.getCategory() != null) {
//            dto.setCategoryId(entity.getCategory().getId());
//        }
//
//        return dto;
        //this line of code does exactly above the commented code, as we have lombok builder
        return ProductDTO.builder()
                .id(entity.getId())
                .sku(entity.getSku())
                .name(entity.getName())
                .description(entity.getDescription())
                .brand(entity.getBrand())
                .price(entity.getPrice())
                .discount(entity.getDiscount())
                .currency(entity.getCurrency())
                .stockQuantity(entity.getStockQuantity())
                .active(entity.isActive())
                .featured(entity.isFeatured())
                .colors(entity.getColors())
                .sizes(entity.getSizes())
                .weight(entity.getWeight())
                .images(entity.getImages())
                .categoryId(entity.getCategory() != null ? entity.getCategory().getId() : null)
                .build();
    }

    public static Product toEntity(ProductDTO dto){
        //this line of code does exactly below the commented code, as we have lombok builder
        return Product.builder()
                .id(dto.getId())
                .sku(dto.getSku())
                .name(dto.getName())
                .description(dto.getDescription())
                .brand(dto.getBrand())
                .price(dto.getPrice())
                .discount(dto.getDiscount())
                .currency(dto.getCurrency())
                .stockQuantity(dto.getStockQuantity())
                .active(dto.isActive())
                .featured(dto.isFeatured())
                .colors(dto.getColors())
                .sizes(dto.getSizes())
                .weight(dto.getWeight())
                .images(dto.getImages())
                .build();

//        Product entity = new Product();
//
//        entity.setId(dto.getId());
//        entity.setSku(dto.getSku());
//        entity.setName(dto.getName());
//        entity.setDescription(dto.getDescription());
//        entity.setBrand(dto.getBrand());
//        entity.setPrice(dto.getPrice());
//        entity.setDiscount(dto.getDiscount());
//        entity.setCurrency(dto.getCurrency());
//        entity.setStockQuantity(dto.getStockQuantity());
//        entity.setActive(dto.isActive());
//        entity.setFeatured(dto.isFeatured());
//        entity.setColors(dto.getColors());
//        entity.setSizes(dto.getSizes());
//        entity.setWeight(dto.getWeight());
//        entity.setImages(dto.getImages());
//
//        return entity;
    }
}
