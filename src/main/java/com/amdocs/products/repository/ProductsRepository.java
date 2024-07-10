package com.amdocs.products.repository;

import com.amdocs.products.entities.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface  ProductsRepository extends CrudRepository<Products,Integer> {

//    List<Products> findProductByOrderId
}
