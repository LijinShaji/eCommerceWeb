package com.example.eCommerceWebsite.dtos.productsDTO;
import lombok.Data;

@Data
public class AddProductMediaDTO {
    private long id;
    private String title;
    private String description;
    private String url;
    private String thumbnailUrl;
    private String mediaURL;
    private String extension;
    private String type;
    private long productId;
}
