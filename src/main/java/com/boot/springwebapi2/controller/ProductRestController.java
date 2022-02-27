package com.boot.springwebapi2.controller;

import com.boot.springwebapi2.model.ProductDto;
import com.boot.springwebapi2.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/product")
public class ProductRestController {
    @Autowired
    private ProductService productService;

    @GetMapping("")
    public ResponseEntity<Iterable<ProductDto>> findAll() {
        try {
            Iterable<ProductDto> products = productService.findAll2();
            return new ResponseEntity<Iterable<ProductDto>>(products, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/search/{min}/{max}")
    public ResponseEntity<Iterable<ProductDto>> searchByPriceMinMax(@PathVariable("min") int min, @PathVariable("max") int max) {
        try {
            Iterable<ProductDto> products = productService.findByPriceBetweenq(min, max);
            return new ResponseEntity<Iterable<ProductDto>>(products, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/create")
    public ResponseEntity<ProductDto> create(@RequestBody ProductDto productInfo) {
        System.out.println(productInfo);
        try {
            ProductDto productSaved = productService.create(productInfo);
            return new ResponseEntity<ProductDto>(productSaved, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ProductDto> update(@PathVariable("id") int id, @RequestBody ProductDto productInfo) {
        System.out.println(productInfo);
        try {
            ProductDto productSaved = productService.update(id, productInfo);
            return new ResponseEntity<ProductDto>(productSaved, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") int id) {
        try {
            productService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

}
