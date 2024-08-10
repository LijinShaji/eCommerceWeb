package com.example.eCommerceWebsite.services.productServices;

import com.example.eCommerceWebsite.dtos.productsDTO.AddProductMediaDTO;
import com.example.eCommerceWebsite.models.productModel.ProductMediaMain;

import java.util.ArrayList;
import java.util.List;

public interface ProductMediaService {
    ProductMediaMain addProductMedia(AddProductMediaDTO productMediaDTO);
    List<Long> addProductMedia(List<AddProductMediaDTO> productMediaDTOList);
    ArrayList<AddProductMediaDTO> getAllProductMedia();
    AddProductMediaDTO getProductMediaById(int id);
}
