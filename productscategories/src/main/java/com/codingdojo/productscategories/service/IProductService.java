package com.codingdojo.productscategories.service;

import java.util.List;

import com.codingdojo.productscategories.entity.Category;
import com.codingdojo.productscategories.entity.Product;

public interface IProductService {
	public abstract Product find (Long productId);
	public abstract List<Product> getAll();
	public abstract Product save(Product product);
	public abstract Product addCategory (Long productId, Long categoryId);
	public abstract List<Product> findAllByCategories(Category category);
	public abstract List<Product> findByCategoriesNotContains(Category category);
}
