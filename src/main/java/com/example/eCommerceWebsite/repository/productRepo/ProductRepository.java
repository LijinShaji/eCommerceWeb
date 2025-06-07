package com.example.eCommerceWebsite.repository.productRepo;

import com.example.eCommerceWebsite.models.productModel.Product;
import com.example.eCommerceWebsite.models.productModel.ProductCategory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;


public interface ProductRepository extends JpaRepository<Product, Long>, PagingAndSortingRepository<Product, Long> {
Page<Product> findAllByTitleContaining(String query, Pageable pageable);
List<Product> findAllByTitleEndingWithIgnoreCase(String productName);
List<Product> findAllByTitleContainingIgnoreCase(String productName);
List<Product> findAllByTitleStartingWithIgnoreCase(String productName);
Set<Product> findProductsByCategories(ProductCategory category);
    @Query("SELECT p FROM Product p JOIN p.categories c WHERE c.categoryId = :categoryId")
    List<Product> findByCategoryId(@Param("categoryId") Long categoryId);

}
