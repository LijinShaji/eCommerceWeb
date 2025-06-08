package com.example.eCommerceWebsite.services.productServices;

import com.example.eCommerceWebsite.dtos.commonDTO.ResponseDTO;
import com.example.eCommerceWebsite.dtos.productsDTO.MainProductDTO;
import com.example.eCommerceWebsite.dtos.productsDTO.ProductDTO;
import com.example.eCommerceWebsite.models.productModel.Product;
import com.example.eCommerceWebsite.models.productModel.ProductCategory;
import com.example.eCommerceWebsite.repository.productRepo.ProdCategoryRepository;
import com.example.eCommerceWebsite.repository.productRepo.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class SelfProductService implements ProductService {
    private final ProductRepository productRepository;
    private final CategoryService categoryService;
    private final ProdCategoryRepository prodCategoryRepository;

    public SelfProductService(ProductRepository productRepository,CategoryService categoryService,ProdCategoryRepository prodCategoryRepository) {
        this.productRepository = productRepository;
        this.categoryService = categoryService;
        this.prodCategoryRepository = prodCategoryRepository;
    }

    @Override
    public ResponseDTO createProduct(ProductDTO productDTO) {
        Set<ProductCategory> categories=new HashSet<>();
        System.out.println("category"+productDTO.getCategoryID());
        ProductCategory category=categoryService.findCategoryById(productDTO.getCategoryID());
        categories.add(category);
        Product product=new Product();
        product.setTitle(productDTO.getTitle());
        product.setDescription(productDTO.getDescription());
        product.setPrice(productDTO.getPrice());
        System.out.println("Test");
        product.setCategories(categories);
        Product savedProduct= productRepository.save(product);
        categories.forEach(
                category1 -> {
                category1.getProducts().add(savedProduct);
                prodCategoryRepository.save(category1);
                }
        );
        ResponseDTO responseDTO=new ResponseDTO();
        responseDTO.setMessage("Product created successfully");
        return responseDTO;
    }

    @Override
    public ResponseDTO updateProduct(ProductDTO productDTO, long id) {
        return null;
    }

    @Override
    public List<ProductDTO> getAllProducts() {
        return List.of();
    }

    @Override
    public List<Product> searchProducts(String searchText) {
        List<Product> products = new ArrayList<>(productRepository.findAllByTitleContainingIgnoreCase(searchText));
        System.out.println("test");
        products.addAll(productRepository.findAllByTitleEndingWithIgnoreCase(searchText));
        System.out.println("test");
        products.addAll(productRepository.findAllByTitleStartingWithIgnoreCase(searchText));
        System.out.println("test");
     return products;
    }

    @Override
    public List<Product> getProductsByCategory(String category) {
        ProductCategory productCategory=categoryService.findCategoryByName(category);
        return productRepository.findByCategoryId(productCategory.getCategoryId());
    }



    @Override
    public Page<ProductDTO> getPaginatedProducts(int page, int size) {
        Page<Product> products = productRepository.findAll(PageRequest.of(page, size));

        List<ProductDTO> dtoList = products.getContent().stream().map(product -> {
            ProductDTO dto = new ProductDTO();
            dto.setTitle(product.getTitle());
            dto.setPrice(product.getPrice());
            dto.setOverallRating(product.getOverallRating());
            dto.setDescription(product.getDescription());
            return dto;
        }).collect(Collectors.toList());

        return new PageImpl<>(dtoList, products.getPageable(), products.getTotalElements());
    }
    private ProductDTO convertProductToProductDTO(Product product) {
        ProductDTO productDTO=new ProductDTO();
        productDTO.setTitle(product.getTitle());
        productDTO.setDescription(product.getDescription());
        productDTO.setPrice(product.getPrice());
        return productDTO;
    }
}
