package org.infotutorial.rest.service;

import java.util.Objects;

import org.infotutorial.rest.domain.Product;
import org.infotutorial.rest.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class ProductService {

    private ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Iterable<Product> findAll() {
        return productRepository.findAll();
    }

    public Product findById(Long id) {
        return productRepository.getById(id);
    }

    public Product saveOrUpdate(Product product) {
        if (StringUtils.isEmpty(product.getStatus())) {
            product.setStatus("Draft");
        }
        return productRepository.save(product);
    }

    public void delete(Long id) {
        Product product = productRepository.getById(id);
        productRepository.delete(product);
    }
}
