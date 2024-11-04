package com.example.eCommerceWebsite.listeners;

import com.example.eCommerceWebsite.models.BaseModel;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class BaseModelListener {
    @PrePersist
    public void prePersist(BaseModel baseModel) {
        LocalDateTime now = LocalDateTime.now();
        baseModel.setCreatedAt(now);
        baseModel.setUpdatedAt(now);
        baseModel.setCreatedBy(getCurrentUser());
        baseModel.setUpdatedBy(getCurrentUser());
    }
    @PreUpdate
    public void preUpdate(BaseModel baseModel) {
        LocalDateTime now = LocalDateTime.now();
        baseModel.setUpdatedAt(now);
        baseModel.setUpdatedBy(getCurrentUser());
    }
    public String getCurrentUser(){
        return "admin";
    }
}
