package com.example.springmvc.controller;

import com.example.springmvc.jdbc.ProductServiceImp;
import com.example.springmvc.model.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProductController {

	private ProductServiceImp productRepository;

	@Autowired
	public void setProductRepository(ProductServiceImp productRepository) {
		this.productRepository = productRepository;
	}

	@RequestMapping(path = "/")
	public String index() {
		return "index";
	}

	@RequestMapping(path = "/products/add", method = RequestMethod.GET)
	public String createProduct(Model model) {
		model.addAttribute("product", new Product());
		return "edit";
	}
	
	@RequestMapping(path = "/products/searchbrand", method = RequestMethod.GET)
	public String serachProductBrand(Model model) {
		model.addAttribute("product", new Product());
		return "search";
	}
	
	  //search brand
	@RequestMapping(path = "/products/searchbrandname", method = RequestMethod.GET)
	public String saveProductSearch(@RequestParam("keyword") String keyword, ModelMap model) {
		System.out.println("inside search"+keyword);
		model.addAttribute("products", productRepository.findByBrand(keyword));
		return "search";
	}
	

	@RequestMapping(path = "/products", method = RequestMethod.POST)
	public String saveProduct(Product product) {
		productRepository.addProduct(product);
		return "redirect:/";
	}

	@RequestMapping(path = "/products", method = RequestMethod.GET)
	public String getAllProducts(Model model) {
		model.addAttribute("products", productRepository.getAllProducts());
		return "products";
	}

	@GetMapping("/products/edit/{id}")
	public String getEmployer(@PathVariable("id") int id, ModelMap model) {
		Product product = productRepository.getProdcutById(id);
		model.addAttribute("product", productRepository.getProdcutById(id));
		return "edit";

	}
	
	  @RequestMapping(path = "/products/delete/{id}", method = RequestMethod.GET)
	    public String deleteProduct(@PathVariable(name = "id") long id) {
	        productRepository.deleteById(id);
	        return "redirect:/products";
	    }

}
