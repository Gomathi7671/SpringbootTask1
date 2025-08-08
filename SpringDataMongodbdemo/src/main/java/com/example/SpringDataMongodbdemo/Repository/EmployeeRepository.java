package com.example.SpringDataMongodbdemo.Repository;

import com.example.SpringDataMongodbdemo.model.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EmployeeRepository extends MongoRepository<Employee, String> {
}
