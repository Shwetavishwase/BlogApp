package com.itp.service;

import java.util.List;

import com.itp.payload.CategoryDto;



public interface CategoryService {

	//create
	public CategoryDto createCategory(CategoryDto categoryDto);
	
	//update
	public CategoryDto updateCategory(CategoryDto categoryDto,Integer categoryId);
	
	//delete
	public void deleteCategory(Integer categoryId);
	
	//getById
	public CategoryDto getCategoryById(Integer categoryId);
	
	//getAll
	public List<CategoryDto> getAllCategory();
}
