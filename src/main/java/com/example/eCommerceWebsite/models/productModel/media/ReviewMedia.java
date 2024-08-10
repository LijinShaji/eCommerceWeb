package com.example.eCommerceWebsite.models.productModel.media;

import com.example.eCommerceWebsite.models.productModel.Review;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;

import javax.print.attribute.standard.Media;
@Entity
public class ReviewMedia extends MediaBase {
    ReviewMediaType reviewMediaType;
    @OneToOne
    Review review;
}
