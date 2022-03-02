package com.codingdojo.productscategories.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.codingdojo.productscategories.entity.Category;
import com.codingdojo.productscategories.entity.Product;
import com.codingdojo.productscategories.service.CategoryService;
import com.codingdojo.productscategories.service.ProductService;

@Controller
@RequestMapping("/categories")
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private ProductService productService;
	
	@RequestMapping("/new")
	public String newForm(@ModelAttribute("category") Category category, Model model) {
		return "categories/new";
	}
	
	@RequestMapping("/{id}")
	public String addForm(@PathVariable("id") Long id, Model model) {
		Category category = categoryService.find(id);
		List<Product> productsSaved = productService.findAllByCategories(category);
		List<Product> productsNotUsed = productService.findByCategoriesNotContains(category);
		model.addAttribute("category", category);
		model.addAttribute("products_saved", productsSaved);
		model.addAttribute("productsNotUsed", productsNotUsed);

		return "categories/add";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String create(@Valid @ModelAttribute("category") Category category, BindingResult result) {
		if (result.hasErrors()) {
			return "categories/new";
		}
		
		Category saved = categoryService.save(category);
		
		return "redirect:/categories/" +  saved.getId();
	}
	
	@RequestMapping(value = "/{categoryId}/add", method = RequestMethod.POST)
	public String addProduct(@PathVariable("categoryId") Long categoryId, @RequestParam( value="productId" ) Long productId) {
		categoryService.addProduct(categoryId, productId);
		return "redirect:/categories/" +  categoryId;
	}
}
