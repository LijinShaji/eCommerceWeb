package com.example.eCommerceWebsite.services.productServices;

import com.example.eCommerceWebsite.dtos.FakeStoreProductDTO;
import com.example.eCommerceWebsite.models.productModel.ProductCategory;
import com.example.eCommerceWebsite.models.productModel.Product;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.ExecutionException;
@Service
@ConditionalOnProperty(name = "product.service",havingValue = "fake store")
public class FakeStoreAPIProductService implements ProductService {

    private final RestTemplate restTemplate;


    public FakeStoreAPIProductService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
    @Override
    public Product addProduct(Product product) throws ExecutionException, InterruptedException {
        FakeStoreProductDTO fakeStoreProductDTO=new FakeStoreProductDTO();
        fakeStoreProductDTO.setTitle(product.getTitle());
        fakeStoreProductDTO.setDescription(product.getDescription());
        ProductCategory categoryDetail=product.getCategoryDetail();
//        String catTitle=categoryDetail.getCategoryId();
        fakeStoreProductDTO.setCategory(null);
        FakeStoreProductDTO responseObj=restTemplate.postForObject("https://fakestoreapi.com/products", fakeStoreProductDTO, FakeStoreProductDTO.class);
        return responseObj.toproduct();
    }

    @Override
    public ArrayList<String> addMultipleProducts(ArrayList<Product> products) {
        return null;
    }

    @Override
    public Product getSingleProduct(int id) {
        System.out.println("FAKE STORE triggered "+id);
       FakeStoreProductDTO fakeStoreProductDTO= restTemplate.getForObject("https://fakestoreapi.com/products/" + id, FakeStoreProductDTO.class);
        assert fakeStoreProductDTO != null;

       return fakeStoreProductDTO.toproduct();
    }

    @Override
    public ArrayList<Product> getAllProducts() {
       Product[] products=
               restTemplate.getForObject(
                       "https://fakestoreapi.com/products", Product[].class);
        assert products != null;
        return new ArrayList<>(Arrays.asList(products));
    }
}
