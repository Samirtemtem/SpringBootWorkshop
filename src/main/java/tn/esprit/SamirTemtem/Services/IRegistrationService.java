package tn.esprit.SamirTemtem.Services;

import tn.esprit.SamirTemtem.entities.Registration;
import java.util.List;

public interface IRegistrationService {
    Registration addRegistration(Registration registration);
    Registration updateRegistration(Registration registration);
    void removeRegistration(Long numRegistration);
    Registration retrieveRegistration(Long numRegistration);
    List<Registration> getAllRegistrations();
    Registration addRegistrationAndAssignToSkier(Registration registration, Long idSkier);
    Registration RegistrationAndAssignToCourse(Registration registration,Long numCourse);
}
