package com.developers.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.developers.pojos.Category;
import com.developers.pojos.Products;

@Repository
public interface ProductRepository extends JpaRepository<Products, Integer>{
	 
	List<Products> findByCategoryId(Category cat);
}