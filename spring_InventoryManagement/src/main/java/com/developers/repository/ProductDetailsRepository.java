package com.developers.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.developers.pojos.ProductDetails;

import com.developers.pojos.Users;

@Repository
public interface ProductDetailsRepository extends JpaRepository<ProductDetails,Integer> {
	
	List<ProductDetails> findBySupplier(Users userId);

}
