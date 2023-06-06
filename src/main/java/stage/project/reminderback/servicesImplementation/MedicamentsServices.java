package stage.project.reminderback.servicesImplementation;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import stage.project.reminderback.entities.Medicament;
import stage.project.reminderback.repositories.MedicamentRepo;
import stage.project.reminderback.services.IMedicamentsServices;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
@AllArgsConstructor
@NoArgsConstructor

public class MedicamentsServices implements IMedicamentsServices {
    MedicamentRepo medicamentRepo;

    @Override
    public Medicament AjouterMedicament(Medicament medicament, String HeureDePrise) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        LocalTime heure = LocalTime.parse(HeureDePrise, formatter);
        medicament.setHeureDePrise(heure);
        medicament.getStock().setInitialQuantity(medicament.getQuantité());
        medicament.getStock().setCurrentQuantity(medicament.getQuantité());

        return medicamentRepo.save(medicament);
    }

    @Override
    public Medicament MarquerCommePris(Integer id) {
        Medicament m = medicamentRepo.findById(id).get();
        m.getStock().setCurrentQuantity(m.getStock().getCurrentQuantity()-m.getDose());
        return m;
    }

    @Override
    public Medicament UpdateQuantity(int id, int quantity) {
        Medicament m = medicamentRepo.findById(id).get();
        m.getStock().setInitialQuantity(m.getStock().getCurrentQuantity()+ quantity);
        m.getStock().setCurrentQuantity(m.getStock().getInitialQuantity());
        return m;
    }

    @Scheduled(fixedRate = 60000) // Exécute la tâche toutes les 60 secondes
    public void checkAlertesMedicaments() {
        List<Medicament> medicaments = medicamentRepo.findAll();

        LocalTime currentTime = LocalTime.now();
        for (Medicament medicament : medicaments) {
            if (medicament.getHeureDePrise().equals(currentTime)) {
                System.err.println("Alerte : Heure de prise pour le médicament " + medicament.getNom() + " !");
            }
        }
    }
}
