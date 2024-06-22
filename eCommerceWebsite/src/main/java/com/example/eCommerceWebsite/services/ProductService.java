package com.example.eCommerceWebsite.services;

import com.example.eCommerceWebsite.models.Product;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;

@Service
public class ProductService {
    private static final String COLLECTION_NAME="Products";
    public String saveProduct(Product product) throws ExecutionException, InterruptedException {

        Firestore firestore= FirestoreClient.getFirestore();
       ApiFuture<WriteResult> collectionAPIFuture= firestore.collection(COLLECTION_NAME).document().set(product);
    return collectionAPIFuture.get().getUpdateTime().toString();
    }
}
