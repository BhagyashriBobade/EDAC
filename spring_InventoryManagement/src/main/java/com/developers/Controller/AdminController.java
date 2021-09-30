package com.developers.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.developers.pojos.ProductDetails;
import com.developers.pojos.Products;
import com.developers.pojos.Users;
import com.developers.repository.ProductDetailsRepository;
import com.developers.repository.ProductRepository;
import com.developers.pojos.Category;

@RestController
@RequestMapping("/api")
@CrossOrigin("http://localhost:3000")
public class AdminController  {
	
	@Autowired 
	ProductDetailsRepository productdetailrepo;
	
	@Autowired
    ProductRepository productrepo;
    
	@GetMapping("/suppliedProductDetails/{supplierId}")
    public ResponseEntity<List<ProductDetails>> getProductDetailsbySuppliers(@PathVariable int supplierId){
   	  List<ProductDetails> psuser= productdetailrepo.findBySupplier(new Users(supplierId));
   	  System.out.println(psuser);
   	  return new ResponseEntity<List<ProductDetails>>(psuser,HttpStatus.OK);
   	 }
	
	@GetMapping("/products")
	public ResponseEntity<List<Products>> getAllProduct(){
		List<Products> productlist =productrepo.findAll();
		System.out.println(productlist);
		return new ResponseEntity<List<Products>>(productlist,HttpStatus.OK);
	}
	
	@GetMapping("/products/{categoryId}")
	public ResponseEntity<List<Products>> getProductByCategory(@PathVariable int categoryId){
		List<Products> prlist = productrepo.findByCategoryId(new Category(categoryId));
		System.out.println(prlist);
		return new ResponseEntity<List<Products>> (prlist,HttpStatus.OK);
	}
	
	
    
}
