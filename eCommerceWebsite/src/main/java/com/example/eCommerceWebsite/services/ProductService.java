package com.example.eCommerceWebsite.services;

import com.example.eCommerceWebsite.models.Product;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteBatch;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

@Service
public class ProductService {
    private static final String COLLECTION_NAME="Products";

    public String saveProduct(Product product) throws ExecutionException, InterruptedException {
        Firestore firestore= FirestoreClient.getFirestore();
       ApiFuture<WriteResult> collectionAPIFuture= firestore.collection(COLLECTION_NAME).document().set(product);
    return collectionAPIFuture.get().getUpdateTime().toString();
    }
    public String saveMultipleProduct(ArrayList<Product> productList) {
        // using StringBuilder() constructor
        StringBuilder resultDetails = new StringBuilder();

        resultDetails.append("Details:\n");
        Firestore firestore = FirestoreClient.getFirestore();
        productList.forEach((product) -> {
            ApiFuture<DocumentReference> documentReferenceApiFuture = firestore
                    .collection(COLLECTION_NAME)
                    .add(product);
            try {
                resultDetails.append(documentReferenceApiFuture.get().getId());
            } catch (InterruptedException | ExecutionException e) {
                throw new RuntimeException(e);
            }
        });
        return resultDetails.toString();
    }
}
