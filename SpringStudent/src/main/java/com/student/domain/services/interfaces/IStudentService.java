package com.student.domain.services.interfaces;

import com.student.presentation.dtos.StudentRequest;
import com.student.presentation.dtos.StudentResponse;

import java.util.List;

public interface IStudentService {

    List<StudentResponse> findAllStudent();
    StudentResponse findById(Integer id);
    boolean studentExist(Integer id);
    StudentResponse createStudent(StudentRequest studentRequest);
    StudentResponse updateStudent(StudentRequest studentRequest, Integer id);
    void deleteStudentById(Integer id);
}
