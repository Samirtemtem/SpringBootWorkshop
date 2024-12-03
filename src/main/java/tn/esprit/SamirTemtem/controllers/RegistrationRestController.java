package tn.esprit.SamirTemtem.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.SamirTemtem.entities.Registration;
import tn.esprit.SamirTemtem.Services.RegistrationServiceImpl;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/registration")
public class RegistrationRestController {

    private final RegistrationServiceImpl registrationService;

    @PostMapping("/add")
    public Registration addRegistration(@RequestBody Registration registration) {
        return registrationService.addRegistration(registration);
    }

    @PutMapping("/update")
    public Registration updateRegistration(@RequestBody Registration registration) {
        return registrationService.updateRegistration(registration);
    }

    @GetMapping("/get/{numRegistration}")
    public Registration getRegistration(@PathVariable Long numRegistration) {
        return registrationService.retrieveRegistration(numRegistration);
    }

    @GetMapping("/all")
    public List<Registration> getAllRegistrations() {
        return registrationService.getAllRegistrations();
    }

    @DeleteMapping("/delete/{numRegistration}")
    public void deleteRegistration(@PathVariable Long numRegistration) {
        registrationService.removeRegistration(numRegistration);
    }
    @PostMapping("/assign/{idSkier}")
    public Registration assignRegistrationToSkier(
            @RequestBody Registration registration,
            @PathVariable Long idSkier) {
        return registrationService.addRegistrationAndAssignToSkier(registration, idSkier);
    }
    @PostMapping("/assignCourse/{numCourse}")
    public Registration assignRegistrationToCourse(
            @RequestBody Registration registration,
            @PathVariable Long numCourse) {
        return registrationService.RegistrationAndAssignToCourse(registration, numCourse);
    }
}
