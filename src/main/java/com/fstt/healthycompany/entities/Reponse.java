package com.fstt.healthycompany.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data @AllArgsConstructor @NoArgsConstructor
public class Reponse {
    @Id
    private String id;

    private String content;
    @DBRef
    private Question question;



    @Override
    public String toString() {
        return "Reponse{" +
                "id='" + id + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
