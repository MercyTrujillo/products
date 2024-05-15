package com.amdocs.products.repository;

import com.amdocs.products.entities.Products;
import org.springframework.data.repository.CrudRepository;

public interface  ProductsRepository extends CrudRepository<Products,Integer> {
}
