package com.example.eCommerceWebsite.models.productModel.media;

import com.example.eCommerceWebsite.models.MediaBase;
import com.example.eCommerceWebsite.models.productModel.ProductCategory;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;


@Entity
public class CategoryMedia extends MediaBase {
    private MediaType categoryMediaType;
    @OneToOne
    private ProductCategory productCategory;
}
