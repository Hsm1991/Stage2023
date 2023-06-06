package stage.project.reminderback.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import stage.project.reminderback.entities.Medicament;
import stage.project.reminderback.servicesImplementation.MedicamentsServices;

@RestController
@RequestMapping("/medicaments")

public class MedicamentsController {
    private MedicamentsServices medicamentsServices;

    @PostMapping( "/add")
    public Medicament AjouterMedicament(@RequestBody Medicament medicament,@RequestParam String HeureDePrise){
    return medicamentsServices.AjouterMedicament(medicament,HeureDePrise);}
    @PostMapping( "/MarquerCommePris/{id}")

    public Medicament MarquerCommePris(@PathVariable ("id") Integer id) {
        return medicamentsServices.MarquerCommePris(id);}
    @PostMapping( "/UpdateQuantity/{id}/{quantity}")

    public Medicament UpdateQuantity(@PathVariable ("id") int id,@PathVariable ("quantity") int quantity) {
        return medicamentsServices.UpdateQuantity(id, quantity);
    }
    @GetMapping("/check-alertes")
    public ResponseEntity<String> checkAlertesMedicaments() {
        medicamentsServices.checkAlertesMedicaments();
        return ResponseEntity.ok("Vérification des alertes de prise de médicaments effectuée.");

    }

    }


