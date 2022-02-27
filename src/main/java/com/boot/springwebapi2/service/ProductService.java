package com.boot.springwebapi2.service;

import com.boot.springwebapi2.model.Product;
import com.boot.springwebapi2.model.ProductDto;

import java.util.List;

public interface ProductService {
    Iterable<Product> findAll();

    Iterable<ProductDto> findAll2();

    List<ProductDto> findByPriceBetweenq(int min, int max);

    ProductDto create(ProductDto productDto);
    ProductDto update(int id, ProductDto productDto);
    void delete(int id);
}
