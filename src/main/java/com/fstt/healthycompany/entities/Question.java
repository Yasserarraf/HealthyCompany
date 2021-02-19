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
public class Question {
    @Id
    private String id;
    private String content;
    @DBRef
    private Collection<Reponse> reponses = new ArrayList<>();

    @DBRef
    private Testpsy test;

    @Override
    public String toString() {
        return "Question{" +
                "id='" + id + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
