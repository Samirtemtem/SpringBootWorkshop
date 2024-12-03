package tn.esprit.SamirTemtem.Repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import tn.esprit.SamirTemtem.entities.Skieur;

import java.time.LocalDate;
import java.util.List;

public interface ISkieurRepository extends CrudRepository <Skieur, Long> {
    @Query("SELECT s FROM Skieur s WHERE s.birthDate = :birthDate")
    List<Skieur> findByBirthDate(@Param("birthDate") LocalDate birthDate);
    Skieur findByName(String name);

}