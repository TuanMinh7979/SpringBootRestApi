package com.boot.springwebapi2.service.impl;

import com.boot.springwebapi2.model.Category;
import com.boot.springwebapi2.repo.CategoryRepo;
import com.boot.springwebapi2.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;

public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepo categoryRepo;

    @Override
    public Category findById(int id) {
        return categoryRepo.findById(id).get();
    }
}
