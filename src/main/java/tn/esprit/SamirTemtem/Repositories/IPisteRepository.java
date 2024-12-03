package tn.esprit.SamirTemtem.Repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import tn.esprit.SamirTemtem.entities.Color;
import tn.esprit.SamirTemtem.entities.Piste;

import java.util.List;

public interface IPisteRepository extends CrudRepository<Piste, Long> {
    @Query("SELECT p FROM Piste p WHERE p.color = :color")
    List<Piste> findByColor(Color color);


}
