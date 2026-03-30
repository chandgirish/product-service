package org.chandgirish.product.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "categories")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(unique = true)
    private String title;

    private String description;

    // Self-referencing parent category
    @ManyToOne
    @JoinColumn(name = "parent_id")
    private Category parentCategory;

    // Child categories
    @OneToMany(mappedBy = "parentCategory", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Category> subCategories = new ArrayList<>();


    // Products in this category
    @OneToMany(mappedBy = "category")
    @JsonIgnore // prevent infinite loop in JSON serialization
    private List<Product> products = new ArrayList<>();

    private boolean active = true;

    private LocalDateTime createdAt = LocalDateTime.now();
    private LocalDateTime updatedAt = LocalDateTime.now();
}
