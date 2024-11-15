package tn.esprit.charekyosr4twin5.Repositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.charekyosr4twin5.entities.Course;
@Repository
public interface ICourseRepository extends CrudRepository<Course, Long> {

}
