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
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@NoArgsConstructor
@Setter
@ToString
@Table
public class Course implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long numCourse ;
    private int level ;
    private Float price ;
    private int timeSlot ;
    @Enumerated(EnumType.STRING)
    private Support support;
    public enum Support {
        SKI, SNOWBOARD
    }

    @Enumerated(EnumType.STRING)
    private TypeCourse typeCourse;
    @JsonIgnore
    @OneToMany(mappedBy = "course",cascade = {CascadeType.ALL})
    Set<Registration> registrations= new HashSet<>();

}
