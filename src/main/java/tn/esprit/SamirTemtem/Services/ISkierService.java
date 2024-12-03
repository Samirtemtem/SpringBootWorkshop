package tn.esprit.SamirTemtem.Services;

import tn.esprit.SamirTemtem.entities.Color;
import tn.esprit.SamirTemtem.entities.Skieur;

import java.time.LocalDate;
import java.util.List;

public interface ISkierService {
 Skieur addSkier(Skieur skier);
 Skieur updateSkier(Skieur skieur);
 Skieur retriveSkier(Long numSkier);
 List<Skieur> retriveAll();
 void remouveSkier(Long numSkier);
    List<Skieur> findByBirthDate(LocalDate birthDate);
 List<Skieur> searchByFirstAndOrLastName(String Name);
 Skieur assignSkierToPiste(String name, Color color);

}
