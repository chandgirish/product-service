package org.chandgirish.product.service.implementation;

import lombok.RequiredArgsConstructor;
import org.chandgirish.product.dto.ProductDTO;
import org.chandgirish.product.entity.Product;
import org.chandgirish.product.exception.ProductNotFoundException;
import org.chandgirish.product.mapper.ProductMapper;
import org.chandgirish.product.repository.ProductRepository;
import org.chandgirish.product.service.ProductService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductServiceImplementation implements ProductService {
    //with lombok
    private final ProductRepository productRepository;

    /*
        without lombok
        //constructor initializer and there is no @RequiredArgsConstructor annotation
        @Autowired
        public ProductService(ProductRepository repository) {
        this.repository = repository;
    }
    * */

    @Override
    public ProductDTO create(ProductDTO dto) {
        Product product = ProductMapper.toEntity(dto);
        product.setCreatedAt(LocalDateTime.now());
        product.setUpdatedAt(LocalDateTime.now());

        return ProductMapper.toDTO(productRepository.save(product));
    }

    @Override
    public ProductDTO getById(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Product not found: "+id));
        return ProductMapper.toDTO(product);
    }

    @Override
    public List<ProductDTO> getAll() {
        return productRepository.findAll()
                .stream()
                .map(ProductMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ProductDTO update(Long id, ProductDTO dto) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Product not found with id: " +id));

        product.setName(dto.getName());
        product.setDescription(dto.getDescription());
        product.setBrand(dto.getBrand());
        product.setPrice(dto.getPrice());
        product.setDiscount(dto.getDiscount());
        product.setStockQuantity(dto.getStockQuantity());
        product.setActive(dto.isActive());
        product.setFeatured(dto.isFeatured());
        product.setColors(dto.getColors());
        product.setSizes(dto.getSizes());
        product.setWeight(dto.getWeight());
        product.setImages(dto.getImages());
        product.setUpdatedAt(LocalDateTime.now());

        return ProductMapper.toDTO(productRepository.save(product));

    }

    @Override
    public void delete(Long id){
        if (!productRepository.existsById(id)) {
            throw new ProductNotFoundException("Product not found with id: " +id);
        }
        productRepository.deleteById(id);
    }
}
