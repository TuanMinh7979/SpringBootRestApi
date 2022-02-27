package com.boot.springwebapi2.service.impl;

import com.boot.springwebapi2.model.Category;
import com.boot.springwebapi2.model.Product;
import com.boot.springwebapi2.model.ProductDto;
import com.boot.springwebapi2.repo.CategoryRepo;
import com.boot.springwebapi2.repo.ProductRepo;
import com.boot.springwebapi2.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepo productRepo;
    @Autowired
    private CategoryRepo categoryRepo;

    @Override
    public Iterable<Product> findAll() {
        return productRepo.findAll();

    }

    @Override
    public Iterable<ProductDto> findAll2() {
        return productRepo.findAll2();
    }

    @Override
    public List<ProductDto> findByPriceBetweenq(int min, int max) {
        return productRepo.findByPriceBetweenq(min, max);
    }

    @Override
    public ProductDto create(ProductDto productDto) {

        Product product = new Product();
        Category category = categoryRepo.findById(productDto.getCategoryId()).get();
        product.setCategory(category);

        product.setCreated(productDto.getCreated());
        product.setName(productDto.getName());
        product.setPrice(productDto.getPrice());
        product = productRepo.save(product);
        return productDto;
    }

    @Override
    public ProductDto update(int id, ProductDto productDto) {
        Product product = productRepo.findById(id).get();
        product.setName(productDto.getName());
        product.setPrice(productDto.getPrice());
        product.setCreated(productDto.getCreated());
        product.setCategory(categoryRepo.findById(productDto.getCategoryId()).get());
        productRepo.save(product);
        return productDto;
    }

    @Override
    public void delete(int id) {
       productRepo.deleteById(id);

    }


}
