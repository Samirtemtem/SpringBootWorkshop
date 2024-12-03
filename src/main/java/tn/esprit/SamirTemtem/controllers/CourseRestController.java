package tn.esprit.SamirTemtem.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.SamirTemtem.entities.Course;
import tn.esprit.SamirTemtem.Services.CourseServiceImpl;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("course")
public class CourseRestController {

    private final CourseServiceImpl courseService;

    @PostMapping("/add")
    public Course addCourse(@RequestBody Course course) {
        return courseService.addCourse(course);
    }
    @PutMapping("/update")
    public Course updateCourse(@RequestBody Course course) {
        return courseService.updateCourse(course);
    }
    @GetMapping("/get/{numCourse}")
    public Course getCourse(@PathVariable Long numCourse) {
        return courseService.retrieveCourse(numCourse);
    }

    @GetMapping("/all")
    public List<Course> getAllCourses() {
        return courseService.retriveAll();
    }

    @DeleteMapping("/delete/{numCourse}")
    public void deleteCourse(@PathVariable Long numCourse) {
        courseService.remouveCourse(numCourse);
    }
}
