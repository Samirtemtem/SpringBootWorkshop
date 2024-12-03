package tn.esprit.SamirTemtem.Repositories;

import org.springframework.data.repository.CrudRepository;
import tn.esprit.SamirTemtem.entities.Registration;

public interface IRegistrationRepository extends CrudRepository<Registration, Long> {
}
