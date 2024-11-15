package tn.esprit.charekyosr4twin5.Services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.charekyosr4twin5.Repositories.ICourseRepository;
import tn.esprit.charekyosr4twin5.entities.Course;
import tn.esprit.charekyosr4twin5.entities.Instructor;
import tn.esprit.charekyosr4twin5.Repositories.IInstructorRepository;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class InstructorServiceImpl implements IInstructorService {

    private final IInstructorRepository instructorRepository;

    private final ICourseRepository courseRepository;

    @Override
    public Instructor addInstructor(Instructor instructor) {
        return instructorRepository.save(instructor);
    }

    @Override
    public Instructor updateInstructor(Instructor instructor) {
        return instructorRepository.save(instructor);
    }

    @Override
    public void removeInstructor(Long numInstructor) {
        instructorRepository.deleteById(numInstructor);
    }

    @Override
    public Instructor retrieveInstructor(Long numInstructor) {
        return instructorRepository.findById(numInstructor).orElse(null);
    }

    @Override
    public List<Instructor> getAllInstructors() {
        return (List<Instructor>) instructorRepository.findAll();
    }
    public Instructor addInstructorAndAssignToCourse(Instructor instructor, Long numCourse) {
        Course course = courseRepository.findById(numCourse).orElse(null);
        Set<Course> courseSet = new HashSet<>();

        courseSet.add(course);
        instructor.setCourses(courseSet);
        return instructorRepository.save(instructor);
    }

    public Instructor addInstructorAndAssignToCourses(Instructor instructor) {
        Set<Course> courseSet = new HashSet<>();
        if(instructor.getCourses().isEmpty()){
            System.out.println("course not found");

            return instructorRepository.save(instructor);
        }
        for(Course c : instructor.getCourses()){
            Course course = courseRepository.findById(c.getNumCourse()).orElse(null);
            System.out.println("course found");
            courseSet.add(course);
        }
        instructor.setCourses(courseSet);
        return instructorRepository.save(instructor);
    }

}
