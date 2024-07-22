package com.student.domain.services.implementation;

import com.student.domain.exceptions.StudentNotFoundException;
import com.student.domain.services.interfaces.IStudentService;
import com.student.persistence.entities.StudentEntity;
import com.student.persistence.repositories.IStudentRepository;
import com.student.presentation.dtos.StudentRequest;
import com.student.presentation.dtos.StudentResponse;
import com.student.util.mapper.StudentMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements IStudentService {

    private final IStudentRepository studentRepository;
    private final StudentMapper studentMapper;

    public List<StudentResponse> findAllStudent() {
        List<StudentEntity> studentList = this.studentRepository.findAll();
        return this.studentMapper.getStudentResponseList(studentList);
    }

    public StudentResponse findById(Integer id) {
        StudentEntity student = this.studentRepository.findById(id)
                .orElseThrow(() -> new StudentNotFoundException(String.format("Student with %s does not exist", id)));
        return this.studentMapper.getStudentResponse(student);
    }

    public boolean studentExist(Integer id) {
        return this.studentRepository.findById(id).isPresent();
    }

    public StudentResponse createStudent(StudentRequest studentRequest) {
        StudentEntity student = this.studentMapper.getStudent(studentRequest);
        StudentEntity studentCreate = this.studentRepository.save(student);

        return this.studentMapper.getStudentResponse(studentCreate);
    }

    public StudentResponse updateStudent(StudentRequest studentRequest, Integer id) {
        StudentEntity student = this.studentRepository.findById(id)
                                    .orElseThrow(() -> new StudentNotFoundException(String.format("Student with %s does not exist", id)));

        StudentEntity studentForUpdate = this.studentMapper.getUpdateStudent(studentRequest,student);
        StudentEntity studentUpdate = this.studentRepository.save(studentForUpdate);

        return this.studentMapper.getStudentResponse(studentUpdate);
    }

    public void deleteStudentById(Integer id) {
        this.studentRepository.deleteById(id);
    }


}
