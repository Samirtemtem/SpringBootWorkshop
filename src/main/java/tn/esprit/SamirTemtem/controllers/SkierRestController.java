package tn.esprit.SamirTemtem.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.SamirTemtem.Services.SkierServicesimpl;
import tn.esprit.SamirTemtem.entities.Skieur;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("skier")
public class SkierRestController {
private final SkierServicesimpl skierServices;

    @PostMapping("/add")
    public Skieur saveSkier(@RequestBody Skieur skier){
        return skierServices.addSkier(skier);
    }
    @PutMapping("/update")
    public Skieur updateSkieur(@RequestBody Skieur skieur) {
        return skierServices.updateSkier(skieur);
    }
    @GetMapping("/get/{numSkier}")
    public Skieur getSkier(@PathVariable Long numSkier){
            return skierServices.retriveSkier(numSkier);
    }
    @GetMapping("/all")
    public List<Skieur> getAllSkieurs() {
        return skierServices.retriveAll();
    }

    @DeleteMapping("/delete/{numSkier}")
    public void deleteSkieur(@PathVariable Long numSkier) {
        skierServices.remouveSkier(numSkier);
    }
    @GetMapping("/getByBirthDate/{birthDate}")
    public List<Skieur> getByBirthDate(@PathVariable LocalDate birthDate){
        return skierServices.findByBirthDate(birthDate);
    }


    @PostMapping("/addSkierAndAssignToCourse/{numCourse}")
    Skieur addSkierAndAssignToCourse(@RequestBody Skieur skier,@RequestParam Long numCours){
        return skierServices.addSkierAndAssignToCourse(skier,numCours);
    }
   /* @GetMapping("/retrieveSkiersBySubscriptionType/{type_abonnement}")
    List<Skieur> retrieveSkiersBySubscriptionType(@RequestParam TypeAbonnement typeAbonnement){
        return skierServices.retrieveSkiersBySubscriptionType (typeAbonnement);
    }*/
}