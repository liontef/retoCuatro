package com.example.reto3.reto3.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.reto3.reto3.model.Category;
import com.example.reto3.reto3.repository.CategoryRepository;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> getAll(){

        return categoryRepository.getAll();

    }

    public Optional<Category> getCategory(int id){

        return categoryRepository.getCategory(id);
    }

    public Category save(Category cate){

        if(cate.getId()==null){

            return categoryRepository.save(cate);
        }

        else{

            Optional<Category> cateaux=categoryRepository.getCategory(cate.getId());
            if(cateaux.isEmpty()){

                return categoryRepository.save(cate);
            }
            else{

                return cate;
            }
        }


    }

    public Category update(Category cate){
        if(cate.getId()!=null){
            Optional<Category>find= categoryRepository.getCategory(cate.getId());
            if(!find.isEmpty()){
                if(cate.getName()!=null){
                    find.get().setName(cate.getName());
                }
                if(cate.getDescription()!=null){
                    find.get().setDescription(cate.getDescription());
                }
                return categoryRepository.save(find.get());
            }
        }
        return cate;
    }

    public boolean deleteCategory(int id){
        Optional<Category> cate=getCategory(id);
        if(!cate.isEmpty()){
            categoryRepository.delete(cate.get());
            return true;
        }
        return false;
        }
    }
    

