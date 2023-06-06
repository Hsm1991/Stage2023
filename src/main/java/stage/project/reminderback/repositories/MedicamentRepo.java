package stage.project.reminderback.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import stage.project.reminderback.entities.Medicament;

public interface MedicamentRepo extends JpaRepository<Medicament,Integer> {
}
