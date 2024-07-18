package com.example.eCommerceWebsite.models.productModel;

import com.example.eCommerceWebsite.models.BaseModel;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Review extends BaseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String title;
    private String comments;
    private int rating;
    @OneToMany(mappedBy = "review")
    private Set<ProductMedia> reviewedMedia = new HashSet<>();
    @ManyToOne
    @JoinColumn()
    @JsonIgnore
    private Product product;

}
