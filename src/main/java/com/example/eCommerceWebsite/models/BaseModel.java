package com.example.eCommerceWebsite.models;

import com.example.eCommerceWebsite.listeners.BaseModelListener;
import com.google.api.client.util.DateTime;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
@EntityListeners(BaseModelListener.class)
public class BaseModel {
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String createdBy;
    private String updatedBy;
}
