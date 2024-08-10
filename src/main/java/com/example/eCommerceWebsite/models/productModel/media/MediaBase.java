package com.example.eCommerceWebsite.models.productModel.media;

import com.example.eCommerceWebsite.models.BaseModel;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;

@MappedSuperclass
public class MediaBase extends BaseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private String description;
    private String url;
    private String thumbnailUrl;
    private String mediaURL;
    private String extension;
    private String type;
}
