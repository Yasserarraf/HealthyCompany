package com.fstt.healthycompany.Repositories;

import com.fstt.healthycompany.entities.TestResponses;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface TestResponsesRepository extends MongoRepository<TestResponses,String> {
}
