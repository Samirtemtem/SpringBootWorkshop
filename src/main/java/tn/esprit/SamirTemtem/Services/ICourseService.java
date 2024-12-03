package tn.esprit.SamirTemtem.Services;

import tn.esprit.SamirTemtem.entities.Course;

import java.util.List;

public interface ICourseService {
    Course addCourse(Course course);
    Course updateCourse(Course course);
    void remouveCourse(Long numCourse);
    Course retrieveCourse(Long numCourse);
    List<Course> retriveAll();
}
