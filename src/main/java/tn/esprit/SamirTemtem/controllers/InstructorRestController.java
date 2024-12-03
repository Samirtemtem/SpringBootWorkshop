package tn.esprit.SamirTemtem.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.SamirTemtem.entities.Instructor;
import tn.esprit.SamirTemtem.Services.InstructorServiceImpl;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/instructor")
public class InstructorRestController {

    private final InstructorServiceImpl instructorService;

    @PostMapping("/add")
    public Instructor addInstructor(@RequestBody Instructor instructor) {
        return instructorService.addInstructor(instructor);
    }

    @PutMapping("/update")
    public Instructor updateInstructor(@RequestBody Instructor instructor) {
        return instructorService.updateInstructor(instructor);
    }

    @GetMapping("/get/{numInstructor}")
    public Instructor getInstructor(@PathVariable Long numInstructor) {
        return instructorService.retrieveInstructor(numInstructor);
    }

    @GetMapping("/all")
    public List<Instructor> getAllInstructors() {
        return instructorService.getAllInstructors();
    }

    @DeleteMapping("/delete/{numInstructor}")
    public void deleteInstructor(@PathVariable Long numInstructor) {
        instructorService.removeInstructor(numInstructor);
    }
    @PutMapping("/addAndAssignToCourse/{numCourse}")
    public Instructor addAndAssignToCourse(@RequestBody Instructor instructor, @PathVariable("numCourse")Long numCourse){
        return  instructorService.addInstructorAndAssignToCourse(instructor,numCourse);
    }
    @PutMapping("/addAndAssignToCourses")
    public Instructor addAndAssignToCourses(@RequestBody Instructor instructor){
        return  instructorService.addInstructorAndAssignToCourses(instructor);
    }




}