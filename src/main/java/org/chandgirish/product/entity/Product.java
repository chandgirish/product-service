package org.chandgirish.product.entity;

import jakarta.persistence.*;
import lombok.*;
//import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String sku; // Stock Keeping Unit

    //Basic info
    @Column(nullable = false)
    private String name;

    @Column(length = 2000)
    private String description;

    private String brand;
    @Column(nullable = false)
    private Double price;

    private Double discount;
    private String currency = "USD";

    private Integer stockQuantity;
    private boolean active = true;
    private boolean featured = false;

    //variants
    @ElementCollection
    @CollectionTable(name = "product_colors", joinColumns = @JoinColumn(name = "product_id"))
    @Column(name = "color")
    private List<String> colors;

    @ElementCollection
    @CollectionTable(name = "product_sizes", joinColumns = @JoinColumn(name = "product_id"))
    @Column(name = "size")
    private List<String> sizes;

    private Double weight;

    // Media
    @ElementCollection
    @CollectionTable(name = "product_images", joinColumns = @JoinColumn(name = "product_id"))
    @Column(name = "image_url")
    private List<String> images;

    // Relations
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    // Timestamps
    private LocalDateTime createdAt = LocalDateTime.now();

    private LocalDateTime updatedAt = LocalDateTime.now();
}
