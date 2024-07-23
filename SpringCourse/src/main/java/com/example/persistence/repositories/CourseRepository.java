package com.example.persistence.repositories;

import com.example.persistence.entities.CourseEntity;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends ListCrudRepository<CourseEntity, Integer> {
}
