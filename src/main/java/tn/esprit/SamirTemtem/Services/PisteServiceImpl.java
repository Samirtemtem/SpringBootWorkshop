package tn.esprit.SamirTemtem.Services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.SamirTemtem.Repositories.ISkieurRepository;
import tn.esprit.SamirTemtem.entities.Color;
import tn.esprit.SamirTemtem.entities.Piste;
import tn.esprit.SamirTemtem.Repositories.IPisteRepository;
import tn.esprit.SamirTemtem.entities.Skieur;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PisteServiceImpl implements IPisteService {

    private final IPisteRepository pisteRepository;
    private final ISkieurRepository skierRepository;
    @Override
    public Piste addPiste(Piste piste) {
        return pisteRepository.save(piste);
    }

    @Override
    public Piste updatePiste(Piste piste) {
        return pisteRepository.save(piste);
    }

    @Override
    public void removePiste(Long numPiste) {
        pisteRepository.deleteById(numPiste);
    }

    @Override
    public Piste retrievePiste(Long numPiste) {
        return pisteRepository.findById(numPiste).orElse(null);
    }

    @Override
    public List<Piste> getAllPistes() {
        return (List<Piste>) pisteRepository.findAll();
    }

    @Override
    public List<Piste> getPistesByColor(Color color) {
        return pisteRepository.findByColor(color);
    }

    @Override
    public void assignSkierToPiste(Long numSkier, Long numPiste) {
        Skieur skieur = skierRepository.findById(numSkier)
                .orElseThrow(() -> new RuntimeException("Skieur non trouvé"));
        Piste piste = pisteRepository.findById(numPiste)
                .orElseThrow(() -> new RuntimeException("Piste non trouvée"));

        //skieur.getPistes().add(piste);
       piste.getSkieurs().add(skieur);
      //  skierRepository.save(skieur);
        pisteRepository.save(piste);
    }

}
