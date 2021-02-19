package com.fstt.healthycompany.Repositories;

import com.fstt.healthycompany.entities.Employee;
import com.fstt.healthycompany.entities.Testpsy;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface EmployeeRepository extends MongoRepository<Employee,String> {
}
