/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nsh.service.impl;

import com.nsh.pojo.Category;
import com.nsh.repositories.CategoryRepository;
import com.nsh.service.CategoryService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author admin
 */
@Service

public class CategoryServiceImpl implements CategoryService{

    @Autowired
    private CategoryRepository cateRepo;
    
    @Override
    public List<Category> getCates() {
        return this.cateRepo.getCates();
    }
}
