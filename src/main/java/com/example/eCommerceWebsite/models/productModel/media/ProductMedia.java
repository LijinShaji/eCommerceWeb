package com.example.eCommerceWebsite.models.productModel.media;

import com.example.eCommerceWebsite.models.MediaBase;
import com.example.eCommerceWebsite.models.productModel.Product;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;

@Entity
public class ProductMedia extends MediaBase {
    private MediaType productMediaType;
    @OneToOne
    private Product product;
}
