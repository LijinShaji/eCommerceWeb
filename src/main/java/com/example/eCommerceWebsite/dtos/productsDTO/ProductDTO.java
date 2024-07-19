package com.example.eCommerceWebsite.dtos.productsDTO;

import com.example.eCommerceWebsite.models.BaseModel;
import com.example.eCommerceWebsite.models.productModel.ProductCategory;
import com.example.eCommerceWebsite.models.productModel.ProductMedia;
import com.example.eCommerceWebsite.models.productModel.Review;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Data
public class ProductDTO {
        private String title;
        private float price;
        private long categoryID;
        private int overallRating;
        private String description;
        private long productMediaDTO;
}
