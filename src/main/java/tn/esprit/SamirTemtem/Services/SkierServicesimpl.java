package tn.esprit.SamirTemtem.Services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.SamirTemtem.Repositories.*;
import tn.esprit.SamirTemtem.entities.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class SkierServicesimpl implements ISkierService {

    private final ISkieurRepository skieurRepository;
    private final IPisteRepository pisteRepository;

    private final IRegistrationRepository registrationRepository;

    private final ISubscriptionRepository subscriptionRepository;

    private final ICourseRepository courseRepository;

    @Override
    public Skieur addSkier(Skieur skieur) {
        return skieurRepository.save(skieur);
    }

    @Override
    public Skieur updateSkier(Skieur skieur) {
        return skieurRepository.save(skieur);
    }

    @Override
    public Skieur retriveSkier(Long numSkier) {
        return skieurRepository.findById(numSkier).orElse(null);
    }

    @Override
    public List<Skieur> retriveAll() {
        return (List<Skieur>) skieurRepository.findAll();
    }

    @Override
    public void remouveSkier(Long numSkier) {
        skieurRepository.deleteById(numSkier);
    }

    @Override
    public List<Skieur> findByBirthDate(LocalDate birthDate) {
        return skieurRepository.findByBirthDate(birthDate);
    }

    @Override
    public List<Skieur> searchByFirstAndOrLastName(String name) {
        return List.of();
    }

    public Skieur addSkierAndAssignToCourse (Skieur skier, Long numCours) {
        Course cours =courseRepository.findById(numCours).orElseThrow (null);
        Set<Registration> inscriptions =skier.getRegistrations();
        for ( Registration inscription :inscriptions){
            inscription.setSkieur (skier);
            inscription.setCourse (cours);
            registrationRepository.save(inscription);
        }
        return skieurRepository.save(skier);
    }

    @Override
    public Skieur assignSkierToPiste(String name, Color color) {
        // Retrieve the Skieur entity by its name from the skieurRepository
        Skieur skieur = skieurRepository.findByName(name);

        // Check if the Skieur entity is null (not found)
        if (skieur == null) {
            // Throw a RuntimeException if the Skieur is not found
            throw new RuntimeException("Skieur not found");
        }

        // Retrieve the list of Piste entities by their color from the pisteRepository
        List<Piste> pistes = pisteRepository.findByColor(color);

        // Check if the list of Piste entities is empty (no pistes found with the specified color)
        if (pistes.isEmpty()) {
            // Throw a RuntimeException if no Piste with the specified color is found
            throw new RuntimeException("Piste with the specified color not found");
        }

        // Iterate over each Piste in the list of pistes
        for (Piste piste : pistes) {
            // Add the Piste to the Skieur's list of pistes
            skieur.getPistes().add(piste);
            // Add the Skieur to the Piste's list of skieurs
            piste.getSkieurs().add(skieur);
            // Save the updated Piste entity to the pisteRepository
            pisteRepository.save(piste);
        }

        // Save the updated Skieur entity to the skieurRepository
        skieurRepository.save(skieur);

        // Return the updated Skieur entity
        return skieur;
    }



   }

