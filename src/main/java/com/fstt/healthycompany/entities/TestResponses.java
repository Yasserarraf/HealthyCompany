package com.fstt.healthycompany.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.Collection;
@Document
@Data @AllArgsConstructor @NoArgsConstructor
public class TestResponses {
    @Id
    private String id;
    @DBRef
    private Employee employee;
    @DBRef
    private Testpsy testpsy;
    @DBRef
    private Collection<Reponse> reponses = new ArrayList<>();


    @Override
    public String toString() {
        return "TestResponses{" +
                "id='" + id + '\'' +
                ", employee=" + employee +
                '}';
    }
}
