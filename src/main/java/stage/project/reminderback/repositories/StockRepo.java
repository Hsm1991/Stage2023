package stage.project.reminderback.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import stage.project.reminderback.entities.Stock;

@Repository
public interface StockRepo extends JpaRepository<Stock,Integer> {
}
