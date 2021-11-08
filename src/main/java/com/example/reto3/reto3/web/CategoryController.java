package com.example.reto3.reto3.web;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.reto3.reto3.model.Category;
import com.example.reto3.reto3.service.CategoryService;

@RestController
@RequestMapping("/api/Category")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class CategoryController {
    
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/all")
    public List<Category> getCategories(){

        return categoryService.getAll();

    }

    @GetMapping("/{id}")

    public Optional<Category> getCategory(@PathVariable("id") int id){

        return categoryService.getCategory(id);

    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Category save(@RequestBody Category cate){

        return categoryService.save(cate);

    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Category update(@RequestBody Category cate){

        return categoryService.update(cate);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean deleteCategory(@PathVariable("id") int id){

        return categoryService.deleteCategory(id);
    }

}
