package com.example.eCommerceWebsite.models.productModel.media;

import com.example.eCommerceWebsite.models.productModel.Product;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;

@Entity
public class ProductMedia extends MediaBase{
    ProductMediaType productMediaType;
    @OneToOne
    Product product;
}
