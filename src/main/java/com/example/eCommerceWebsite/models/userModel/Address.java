package com.example.eCommerceWebsite.models.userModel;

import com.example.eCommerceWebsite.models.BaseModel;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Address extends BaseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long address_id;
    private String street;
    private String locality;
    private String district;
    private String state;
    private int pinCode;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="user_id",referencedColumnName = "user_id")
    @JsonIgnore
    private User user;
}
