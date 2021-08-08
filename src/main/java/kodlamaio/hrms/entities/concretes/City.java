package kodlamaio.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "cities")

public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "city_id")
    private int id;

    @NotNull(message = "Şehir ismi boş olamaz")
    @Min(value = 2,message = "Şehir ismi en az 2 karakter olmalı")
    private String cityName;

    @JsonIgnore
    @OneToMany(mappedBy = "city")
    private Set<JobPosting> jobPostings;

}
