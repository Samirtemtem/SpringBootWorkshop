package tn.esprit.SamirTemtem.Services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.SamirTemtem.Repositories.ICourseRepository;
import tn.esprit.SamirTemtem.Repositories.ISkieurRepository;
import tn.esprit.SamirTemtem.entities.Course;
import tn.esprit.SamirTemtem.entities.Registration;
import tn.esprit.SamirTemtem.Repositories.IRegistrationRepository;
import tn.esprit.SamirTemtem.entities.Skieur;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RegistrationServiceImpl implements IRegistrationService {

    private final IRegistrationRepository registrationRepository;
    private  final ISkieurRepository skierRepository;
    private  final ICourseRepository courseRepository;

    @Override
    public Registration addRegistration(Registration registration) {
        return registrationRepository.save(registration);
    }

    @Override
    public Registration updateRegistration(Registration registration) {
        return registrationRepository.save(registration);
    }

    @Override
    public void removeRegistration(Long numRegistration) {
        registrationRepository.deleteById(numRegistration);
    }

    @Override
    public Registration retrieveRegistration(Long numRegistration) {
        return registrationRepository.findById(numRegistration).orElse(null);
    }

    @Override
    public List<Registration> getAllRegistrations() {
        return (List<Registration>) registrationRepository.findAll();
    }

    @Override
    public Registration addRegistrationAndAssignToSkier(Registration registration, Long idSkier) {
        Skieur skieur = skierRepository.findById(idSkier)
                .orElseThrow(() -> new RuntimeException("Skieur not found"));
        registration.setSkieur(skieur);
        return registrationRepository.save(registration);
    }
    @Override
    public Registration RegistrationAndAssignToCourse(Registration registration, Long numCourse) {
        Course course = courseRepository.findById(numCourse)
                .orElseThrow(() -> new RuntimeException("Course not found"));
        registration.setCourse(course);
        return registrationRepository.save(registration);
    }
}
