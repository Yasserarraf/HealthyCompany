package com.fstt.healthycompany.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.Collection;

@Document
@Data @AllArgsConstructor @NoArgsConstructor @ToString
public class Employee {
    @Id
    private String id;
    private String name;
    private String prenom;
    private String email;

    private Collection<TestResponses> testsCompleted = new ArrayList<>();
}
