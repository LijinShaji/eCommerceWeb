package com.example.eCommerceWebsite.services.productServices;

import com.example.eCommerceWebsite.models.productModel.Product;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;


@Service
@ConditionalOnProperty(name = "product.service",havingValue = "firestore")
public class FirestoreProductService implements ProductService{
    private static final String COLLECTION_NAME="Products";

    public Product addProduct(Product product) throws ExecutionException, InterruptedException {
        Firestore firestore= FirestoreClient.getFirestore();
        ApiFuture<WriteResult> collectionAPIFuture= firestore.collection(COLLECTION_NAME).document().set(product);
         collectionAPIFuture.get().getUpdateTime().toString();
         return null;
    }

    public ArrayList<String> addMultipleProducts(ArrayList<Product> productList) {
        // using StringBuilder() constructor

        ArrayList<String> resultDetailsList = new ArrayList<>();

        Firestore firestore = FirestoreClient.getFirestore();
        productList.forEach((product) -> {
            ApiFuture<DocumentReference> documentReferenceApiFuture = firestore
                    .collection(COLLECTION_NAME)
                    .add(product);
            try {
                resultDetailsList.add(documentReferenceApiFuture.get().getId());
            } catch (InterruptedException | ExecutionException e) {
                throw new RuntimeException(e);
            }
        });
        return resultDetailsList;
    }

    @Override
    public Product getSingleProduct(int id) {
        return null;
    }

    @Override
    public ArrayList<Product> getAllProducts() {
        return null;
    }
}
