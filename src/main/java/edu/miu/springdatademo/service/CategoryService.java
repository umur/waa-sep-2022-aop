package edu.miu.springdatademo.service;


import edu.miu.springdatademo.dto.AddressDTO;
import edu.miu.springdatademo.dto.CategoryDTO;
import edu.miu.springdatademo.entity.Category;
import org.springframework.stereotype.Service;
import org.w3c.dom.stylesheets.LinkStyle;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

@Service
public interface CategoryService  {


    //Read
    public List<CategoryDTO> getAllCategory();

    public CategoryDTO getCategoryById(Integer id);


    //Create
    public CategoryDTO SaveCategory(CategoryDTO categoryDTO);

    //Update
    public CategoryDTO updateCategory(CategoryDTO categoryDTO, Integer id);

    //delete
    public CategoryDTO deleteCategory(Integer id);






}
