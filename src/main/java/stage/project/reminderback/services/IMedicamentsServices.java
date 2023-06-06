package stage.project.reminderback.services;

import stage.project.reminderback.entities.Medicament;

public interface IMedicamentsServices {
    Medicament AjouterMedicament(Medicament medicament,String HeureDePrise);
    Medicament MarquerCommePris(Integer id);
    Medicament UpdateQuantity(int id, int quantity);
}
