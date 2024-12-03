package tn.esprit.SamirTemtem.Repositories;

import org.springframework.data.repository.CrudRepository;
import tn.esprit.SamirTemtem.entities.Instructor;

public interface IInstructorRepository extends CrudRepository<Instructor, Long> {
}
