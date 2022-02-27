package com.boot.springwebapi2.repo;

import com.boot.springwebapi2.model.Product;
import com.boot.springwebapi2.model.ProductDto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface ProductRepo extends CrudRepository<Product, Integer> {
    @Query("select new com.boot.springwebapi2.model.ProductDto (name, price, created, category.id) from Product")
    List<ProductDto> findAll2();

    @Query("select new com.boot.springwebapi2.model.ProductDto ( name,price, created, category.id) from Product where price >= :min and price <= :max")
    List<ProductDto> findByPriceBetweenq(@Param("min") int min, @Param("max") int max);

    //or:
//    List<ProductInfo> findAllByPriceBetween(Integer min , Integer max);

}
