/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nsh.service.impl;

import com.nsh.service.ProductService;

/**
 *
 * @author admin
 */
public class ProductServiceImpl implements ProductService{
    
    @Autowired
    private  cateRepo;
    
    @Override
    public List<Category> getCates() {
        return this.cateRepo.getCates();
    }
}
