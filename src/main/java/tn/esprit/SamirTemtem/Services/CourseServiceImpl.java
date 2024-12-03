package tn.esprit.SamirTemtem.Services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.SamirTemtem.entities.Course;
import tn.esprit.SamirTemtem.Repositories.ICourseRepository;

import java.util.List;

@Service
@RequiredArgsConstructor

public class CourseServiceImpl implements  ICourseService{

    private final ICourseRepository courseRepository;


    @Override
    public Course addCourse(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public Course updateCourse(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public List<Course> retriveAll() {
        return (List<Course>) courseRepository.findAll();

    }
    @Override
    public Course retrieveCourse(Long numCourse) {
        return courseRepository.findById(numCourse).orElse(null);
    }
    @Override
    public void remouveCourse(Long numCourse) {
        courseRepository.deleteById(numCourse);
    }




}