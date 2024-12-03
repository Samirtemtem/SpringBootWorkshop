package tn.esprit.SamirTemtem.Repositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.SamirTemtem.entities.Course;
@Repository
public interface ICourseRepository extends CrudRepository<Course, Long> {

}
