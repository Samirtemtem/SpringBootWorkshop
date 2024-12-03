package tn.esprit.SamirTemtem.Services;

import tn.esprit.SamirTemtem.entities.Instructor;
import java.util.List;

public interface IInstructorService {
    Instructor addInstructor(Instructor instructor);
    Instructor updateInstructor(Instructor instructor);
    void removeInstructor(Long numInstructor);
    Instructor retrieveInstructor(Long numInstructor);
    List<Instructor> getAllInstructors();

}
