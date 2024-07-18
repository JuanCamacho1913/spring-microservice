package com.student.util.mapper;
import com.student.persistence.entities.StudentEntity;
import com.student.presentation.dtos.StudentRequest;
import com.student.presentation.dtos.StudentResponse;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;


import java.util.List;

@Component
public class StudentMapper {

    public StudentEntity getStudent(StudentRequest studentRequest){
        StudentEntity student = new StudentEntity();
        student.setName(studentRequest.name());
        student.setLastName(studentRequest.lastName());
        student.setEmail(studentRequest.email());
        student.setAge(studentRequest.age());

        return student;
    }

    public StudentResponse getStudentResponse(StudentEntity student){
        return new StudentResponse(
                student.getId(),
                student.getName(),
                student.getLastName(),
                student.getEmail(),
                student.getAge()
        );
    }

    public StudentEntity getUpdateStudent(StudentRequest studentRequest, StudentEntity student){
        if (StringUtils.isNotEmpty(studentRequest.name())){
            student.setName(studentRequest.name());
        }

        if (StringUtils.isNotEmpty(studentRequest.lastName())){
            student.setLastName(studentRequest.lastName());
        }

        if (StringUtils.isNotEmpty(studentRequest.email())){
            student.setEmail(studentRequest.email());
        }

        if (studentRequest.age() != null){
            student.setAge(studentRequest.age());
        }

        return student;
    }

    public List<StudentResponse> getStudentResponseList(List<StudentEntity> studentEntityList){
        return studentEntityList.stream()
                .map(student -> new StudentResponse(
                        student.getId(),
                        student.getName(),
                        student.getLastName(),
                        student.getEmail(),
                        student.getAge()
                ))
                .toList();
    }
}





