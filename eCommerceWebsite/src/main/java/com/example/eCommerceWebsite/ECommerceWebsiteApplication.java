package com.example.eCommerceWebsite;

import com.example.eCommerceWebsite.models.Product;
import com.example.eCommerceWebsite.services.ProductService;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

@SpringBootApplication
public class ECommerceWebsiteApplication {

	public static void main(String[] args) throws IOException {
		SpringApplication.run(ECommerceWebsiteApplication.class, args);

	}

}
