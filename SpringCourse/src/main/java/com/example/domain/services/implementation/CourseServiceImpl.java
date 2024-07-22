package com.example.domain.services.implementation;

import com.example.domain.exceptions.CourseNotFoundException;
import com.example.domain.services.interfaces.ICourseService;
import com.example.persistence.entities.CourseEntity;
import com.example.persistence.repositories.CourseRepository;
import com.example.presentation.dtos.CourseRequest;
import com.example.presentation.dtos.CourseResponse;
import com.example.util.mapper.CourseMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements ICourseService {

    private final CourseRepository courseRepository;
    private final CourseMapper courseMapper;

    @Override
    public List<CourseResponse> findAllCourse() {
        List<CourseEntity> courseEntityList = this.courseRepository.findAll();
        return this.courseMapper.getCourseResponseList(courseEntityList);
    }

    @Override
    public CourseResponse findById(Integer id) {
       CourseEntity course = this.courseRepository.findById(id).orElse(new CourseEntity());
        return this.courseMapper.getCourseResponse(course);
    }

    @Override
    public boolean courseExist(Integer id) {
        return this.courseRepository.findById(id).isPresent();
    }

    @Override
    public CourseResponse createCourse(CourseRequest courseRequest) {
        CourseEntity course = this.courseMapper.getCourse(courseRequest);
        CourseEntity courseCreate = this.courseRepository.save(course);

        return this.courseMapper.getCourseResponse(courseCreate);
    }

    @Override
    public CourseResponse updateCourse(CourseRequest courseRequest, Integer id) {
        CourseEntity course = this.courseRepository.findById(id)
                                  .orElseThrow(
                                          () -> new CourseNotFoundException(String.format("The course with id %s does not exist", id)));

        CourseEntity courseForUpdate = this.courseMapper.getUpdateCourse(courseRequest, course);
        CourseEntity courseUpdate = this.courseRepository.save(courseForUpdate);

        return this.courseMapper.getCourseResponse(courseUpdate);
    }

    @Override
    public void deleteCourseById(Integer id) {
        this.courseRepository.findById(id)
                             .orElseThrow(() -> new CourseNotFoundException(String.format("The course with id %s does not exist", id)));

        this.courseRepository.deleteById(id);
    }
}
