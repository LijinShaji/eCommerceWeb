package com.example.eCommerceWebsite.models.productModel.media;

import com.example.eCommerceWebsite.models.MediaBase;
import com.example.eCommerceWebsite.models.productModel.Review;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;

@Entity
public class ReviewMedia extends MediaBase {
    private MediaType reviewMediaType;
    @OneToOne
    private Review review;
}
