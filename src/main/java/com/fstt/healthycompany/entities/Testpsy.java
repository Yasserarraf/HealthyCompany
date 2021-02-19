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
public class Testpsy {
    @Id
    private String id;
    private String topic;
    @DBRef
    private Collection<Question> questions = new ArrayList<>();



    @Override
    public String toString() {
        return "Testpsy{" +
                "id='" + id + '\'' +
                ", topic='" + topic + '\'' +
                '}';
    }
}
