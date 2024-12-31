package GestionCabinet;
import java.util.ArrayList;
import java.util.List;
public class Main {
    public static void main(String[] args) {
       
        ListePatient listePatient = new ListePatient(); 
        List<rendezvous> listeRendezVous = new ArrayList<>();
        listeRendezVous.add(new rendezvous(30, 9, 2025, "Djabri", "Sara", "Consultation", "Confirmé", "Dr. Adimi", 370655999, 12));
        listeRendezVous.add(new rendezvous(28, 1, 2025, "Chekkar", "Meriem", "Intervention", "Confirmé", "Dr. Mazari", 558307655, 18));
        listeRendezVous.add(new rendezvous(16, 7, 2025, "Benali", "Moudjib", "Vaccination", "Confirmé", "Dr. Nadir", 123456789, 10));
       
        ArrayList<MedicalRecord> records = new ArrayList<>();
       
        Menu menu = new Menu(listePatient, listeRendezVous,records); 
        menu.initDossiersFictifs(); 
        // Affichage du menu principal
        menu.afficherMenu();

        // Création d'un tableau de rendez-vous
        rendezvous[] tableauRdv = {
            new rendezvous(30, 9, 2025, "djabri", "sara", "consultation", "confirmé", "adimi", 370655999, 12),
            new rendezvous(28, 1, 2025, "chekkar", "meriem", "intervention", "confirmé", "mazari", 558307655, 18),
            new rendezvous(16, 7, 2025, "benali", "moudjib", "vaccination", "confirmé", "nadir", 123456789, 10)
        };
     // Tableau des dates de recherche
        int[][] datesRecherche = {
            {30, 9, 2025},
            {28, 1, 2025},
            {16, 7, 2025}
        };
        // Date de référence pour la recherche
        for (int[] date : datesRecherche) {
        int jourRecherche = date[0];
        int moisRecherche = date[1];
        int anneeRecherche = date[2];

        // Affichage des rendez-vous ayant la même date
        System.out.println("Prochains Rendez-vous programmés : " + jourRecherche + "/" + moisRecherche + "/" + anneeRecherche);
        boolean trouve = false;
        for (int i = 0; i < tableauRdv.length; i++) {
            rendezvous rdv = tableauRdv[i];
            if (rdv.getJour() == jourRecherche && rdv.getMois() == moisRecherche && rdv.getAnnee() == anneeRecherche) {
                rdv.affiche();
                System.out.println("-----------------");
                trouve = true;
            }
        }
        if (!trouve) {
            System.out.println("Aucun rendez-vous trouvé pour cette date.");
        }

        // Modification d'un rendez-vous
        tableauRdv[1].modifierrdv(3, 8, 2023, 12.4);
        tableauRdv[1].affiche();
    }
}
  }