package stage.project.reminderback.entities;


import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Stock implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer initialQuantity;
    private Integer currentQuantity;
    public int quantitePrise(){
        return this.initialQuantity - this.currentQuantity;
    }


}
