package com.example.eCommerceWebsite.dtos.usersDTO;

import com.example.eCommerceWebsite.models.productModel.Product;
import com.example.eCommerceWebsite.models.productModel.Review;
import lombok.Data;

@Data
public class FakeStoreProductDTO {
    private int id;
    private String title;
    private float price;
    private String category;
    private String description;
    private Review rating;
    private String image;

    public Product toproduct(){
//    Product product=new Product();
//    product.setTitle(title);
//    product.setPrice(price);
//    ProductCategory categoryDetailObj =new ProductCategory();
//    categoryDetailObj.setCategoryId("ID1");
//    categoryDetailObj.setCategoryName(category);
//    product.setCategoryDetail(categoryDetailObj);
//    product.setDescription(description);
////    product.setRating(rating);
////    ArrayList<String> images=new ArrayList<>();
////    images.add(image);

    return null;
    }
}
