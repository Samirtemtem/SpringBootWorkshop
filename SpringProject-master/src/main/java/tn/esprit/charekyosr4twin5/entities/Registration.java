package tn.esprit.charekyosr4twin5.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@Table
public class Registration implements Serializable {
    public Long getNumRegistraion() {
        return numRegistraion;
    }

    public void setNumRegistraion(Long numRegistraion) {
        this.numRegistraion = numRegistraion;
    }

    public int getNumWeek() {
        return numWeek;
    }

    public void setNumWeek(int numWeek) {
        this.numWeek = numWeek;
    }

    public Skieur getSkieur() {
        return skieur;
    }

    public void setSkieur(Skieur skieur) {
        this.skieur = skieur;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long numRegistraion ;
    private int numWeek ;

    @ManyToOne
    Skieur skieur;
    @ManyToOne
    Course course;

}
