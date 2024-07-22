package com.student.persistence.repositories;

import com.student.persistence.entities.StudentEntity;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IStudentRepository extends ListCrudRepository<StudentEntity, Integer> {
}
