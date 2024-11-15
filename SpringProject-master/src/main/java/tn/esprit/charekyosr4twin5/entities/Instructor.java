package tn.esprit.charekyosr4twin5.entities;

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
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@Table
public class Instructor implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long numInstructor;
    private LocalDate dateOfHire;
    private String name;
    @OneToMany
    Set<Course> courses = new HashSet<>();

    public Instructor(String dateOfHire, String name) {
        this.dateOfHire = LocalDate.parse(dateOfHire, DateTimeFormatter.ISO_DATE);
        this.name = name;
    }
}