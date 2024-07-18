package com.example.eCommerceWebsite.models.userModel;

import com.example.eCommerceWebsite.models.BaseModel;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User extends BaseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long user_id;
    private String userName;
    private String name;
    private String emailId;
    private String phoneNo;
    @OneToMany(mappedBy = "user")
    private Set<Address> address=new HashSet<>();


    private String password;
}
