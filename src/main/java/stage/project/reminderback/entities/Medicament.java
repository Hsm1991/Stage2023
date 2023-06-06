package stage.project.reminderback.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table( name = "Medicament")
public class Medicament implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idMedicament")
    private Integer id;
    private String nom;
    private Integer quantité;
    private LocalTime heureDePrise;
    private int dose;
    @ManyToOne
    private Stock stock;

}
