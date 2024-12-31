package GestionCabinet;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Menu {
    private Scanner scanner;
    private ListePatient listePatient;
    private List<rendezvous> listeRendezVous;
    private List<MedicalRecord> listeDossierMedical;

    public Menu() {
        this.listePatient = new ListePatient();
        this.listeRendezVous = new ArrayList<>();
        this.listeDossierMedical = new ArrayList<>();
        this.scanner = new Scanner(System.in);
    }
    
   // Constructeur avec arguments
    public Menu(ListePatient listePatient, List<rendezvous> listeRendezVous,List<MedicalRecord> listeDossierMedical) {
        this.listePatient = listePatient;
        this.listeRendezVous = listeRendezVous;
        this.listeDossierMedical = listeDossierMedical;
        this.scanner = new Scanner(System.in);
    }
    public void afficherMenu() {
        boolean continuer = true;
        while (continuer) {
            System.out.println("===== Menu Principal =====");
            System.out.println("1. Gérer la fiche patient");
            System.out.println("2. Gérer les rendez-vous");
            System.out.println("3. Gérer le dossier médical");
            System.out.println("4. Quitter");
            System.out.print("Choisissez une option (1-4): ");

            int choix = scanner.nextInt();
            scanner.nextLine(); 

            switch (choix) {
                case 1:
                    gererFichePatient();
                    break;
                case 2:
                    gererRendezVous();
                    break;
                case 3:
                    gererDossierMedical();
                    break;
                case 4:
                    System.out.println("Au revoir !");
                    continuer = false;
                    break;
                default:
                    System.out.println("Choix invalide, veuillez réessayer.");
                    break;
            }
        }
    }

    private void gererDossierMedical() {
        while (true) {
        	 // Affichage du menu des choix
            System.out.println("1. Ajouter un patient");
            System.out.println("2. Consulter un dossier médical");
            System.out.println("3. Afficher tous les dossiers médicaux");
            System.out.println("4. Retour au menu principal");
            System.out.print("Choisissez une option : ");
            int choix = scanner.nextInt();
            scanner.nextLine();  

            if (choix == 1) {
                ajouterPatient();
            } else if (choix == 2) {
                consulterDossier();
            } else if (choix == 3) {
                afficherTousLesDossiers();  
            } else if (choix == 4) {
                break;
            } else {
                System.out.println("Option invalide. Veuillez choisir une option valide.");
            }
        }
    }
    private void ajouterPatient() {
        System.out.println("Ajout d'un patient :");
        // Demander les informations de base du patient
        System.out.print("Entrez le prénom du patient : ");
        String firstName = scanner.nextLine();

        System.out.print("Entrez le nom du patient : ");
        String lastName = scanner.nextLine();

        System.out.print("Entrez l'âge du patient : ");
        int age = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Entrez le sexe du patient : ");
        String gender = scanner.nextLine();

        // Demander des informations supplémentaires sur le patient
        System.out.print("Entrez les informations de contact du patient (téléphone/email) : ");
        String contactInfo = scanner.nextLine();

        System.out.print("Entrez le nom et le téléphone du contact d'urgence : ");
        String emergencyContact = scanner.nextLine();

        System.out.print("Entrez les allergies du patient (si aucune, tapez 'Aucune') : ");
        String allergies = scanner.nextLine();

        System.out.print("Entrez l'historique médical du patient (si aucun, tapez 'Aucun') : ");
        String pastMedicalHistory = scanner.nextLine();

        System.out.print("Entrez les notes du médecin pour ce patient (si aucune, tapez 'Aucune') : ");
        String doctorNotes = scanner.nextLine();

        // Créer et ajouter le dossier médical du patient
        MedicalRecord record = new MedicalRecord(firstName, lastName, age, gender, contactInfo,
                                                 emergencyContact, allergies, pastMedicalHistory, doctorNotes);
        listeDossierMedical.add(record); 

        System.out.print("Voulez-vous entrer un autre patient ? (oui/non) : ");
        String response = scanner.nextLine();
        if (response.equalsIgnoreCase("non")) {
        	 return;
        }
    }

    private void consulterDossier() {
        System.out.print("Entrez le nom du patient pour consulter son dossier : ");
        String searchName = scanner.nextLine();

        boolean found = false;
        for (MedicalRecord record : listeDossierMedical) {
            if (record.getPrenom().equalsIgnoreCase(searchName) || record.getNom().equalsIgnoreCase(searchName)) {
                record.afficher(); 
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Aucun dossier trouvé pour ce patient.");
        }
    }

    // Méthode pour initialiser les dossiers fictifs
    public void initDossiersFictifs() {
        listeDossierMedical.add(new MedicalRecord("John", "Doe", 30, "Homme", "0123456789", "Mère: 0123456789", "Aucune", "Aucun", "Suivi général"));
        listeDossierMedical.add(new MedicalRecord("Jane", "Smith", 28, "Femme", "0987654321", "Père: 0987654321", "Aucune", "Antécédents de grippe", "Consultation annuelle"));
        listeDossierMedical.add(new MedicalRecord("Alice", "Johnson", 35, "Femme", "0234567890", "Mari: 0234567890", "Pollen", "Antécédents de diabète", "Suivi endocrinologique"));
    }

   
    private void afficherTousLesDossiers() {
       
        if (listeDossierMedical.isEmpty()) {
            System.out.println("Aucun dossier médical disponible.");
            return;
        }

        // Affichage de l'entête du tableau
        System.out.println("-----------------------------------------------------------");
        System.out.printf("| %-15s | %-15s | %-3s | %-10s | %-20s |\n", "Prénom", "Nom", "Âge", "Sexe", "Contact");
        System.out.println("-----------------------------------------------------------");

        // Affichage de chaque dossier médical sous forme de tableau
        for (MedicalRecord record : listeDossierMedical) {
            System.out.printf("| %-15s | %-15s | %-3d | %-10s | %-20s |\n",
                              record.getPrenom(), record.getNom(), record.getAge(),
                              record.getSexe(), record.getContactInfo());
        }

        System.out.println("-----------------------------------------------------------");
    }

	private void gererFichePatient() {
        Scanner scanner = new Scanner(System.in);
        boolean continuer = true;

        while (continuer) {
            System.out.println("===== Gestion des Fiches Patients =====");
            System.out.println("1. Afficher la liste des patients");
            System.out.println("2. Ajouter un nouveau patient");
            System.out.println("3. Modifier un patient existant");
            System.out.println("4. Supprimer un patient");
            System.out.println("5. Retour au menu principal");
            System.out.print("Choisissez une option (1-5) : ");

            int choix = scanner.nextInt();
            scanner.nextLine(); 

            switch (choix) {
                case 1:
                    listePatient.afficherPatients();
                    break;
                case 2:
                    ajouterPatientMenu(scanner);
                    break;
                case 3:
                    modifierPatientMenu(scanner);
                    break;
                case 4:
                    supprimerPatientMenu(scanner);
                    break;
                case 5:
                    System.out.println("Retour au menu principal.");
                    continuer = false;
                    break;
                default:
                    System.out.println("Choix invalide, veuillez réessayer.");
                    break;
            }
        }
    }

    private void ajouterPatientMenu(Scanner scanner) {
        boolean ajoutRéussi = false; 
        while (!ajoutRéussi) {
            try {
                System.out.println("===== Ajouter un Patient =====");
                FichePatient nouveauPatient = listePatient.saisirInformationsPatient(scanner);

                // Vérification des informations du patient avant de les ajouter
                if (validation.estValidePatient(nouveauPatient)) {
                    listePatient.ajouterPatient(nouveauPatient);
                    System.out.println("Patient ajouté avec succès !");
                    ajoutRéussi = true; 
                    System.out.println("Les informations fournies sont invalides. Veuillez réessayer.");
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Erreur : " + e.getMessage());
            }
        }
    }


    private void modifierPatientMenu(Scanner scanner) {
        System.out.println("===== Modifier un Patient =====");
        System.out.print("Entrez l'ID du patient à modifier : ");

        int id = -1;
        while (true) {
            try {
                id = scanner.nextInt();
                scanner.nextLine(); 
                break;
            } catch (InputMismatchException e) {
                System.out.println("Erreur : Veuillez entrer un ID valide (nombre).");
                scanner.nextLine(); 
            }
        }

        FichePatient patient = listePatient.rechercherPatientParId(id);

        if (patient != null) {
            boolean continuer = true;

            while (continuer) {
                System.out.println("=== Modifier un Patient ===");
                System.out.println("1. Nom");
                System.out.println("2. Prénom");
                System.out.println("3. Âge");
                System.out.println("4. Adresse");
                System.out.println("5. Code postal");
                System.out.println("6. Ville");
                System.out.println("7. Téléphone");
                System.out.println("8. Email");
                System.out.println("9. Taille");
                System.out.println("10. Poids");
                System.out.println("11. Numéro de sécurité sociale");
                System.out.println("12. Groupe sanguin");
                System.out.println("13. Antécédents");
                System.out.println("14. Allergies");
                System.out.println("15. Traitements");
                System.out.println("16. Médecin référent");
                System.out.println("17. Dernière visite");
                System.out.println("18. Prochain rendez-vous");
                System.out.println("19. Remarques");
                System.out.println("20. Retour au menu principal");
                System.out.print("Choisissez le champ à modifier (1-20) : ");

                int choix = -1;
                while (true) {
                    try {
                        choix = scanner.nextInt();
                        scanner.nextLine(); 
                        if (choix >= 1 && choix <= 20) break; 
                        System.out.println("Erreur : Veuillez choisir un nombre entre 1 et 20.");
                    } catch (InputMismatchException e) {
                        System.out.println("Erreur : Veuillez entrer un nombre valide.");
                        scanner.nextLine(); 
                    }
                }

                if (choix == 20) {
                    continuer = false;
                    break;
                }

                System.out.print("Entrez la nouvelle valeur : ");
                String nouvelleValeur = scanner.nextLine();

                    switch (choix) {
                    case 1:
                        while (true) {
                            System.out.print("Entrez un nouveau nom : ");
                            nouvelleValeur = scanner.nextLine();
                            if (validationNomOuPrenom(nouvelleValeur)) {
                                patient.setNom(nouvelleValeur);
                                System.out.println("Nom modifié avec succès !");
                                break;
                            } else {
                                System.out.println("Erreur : Nom invalide. Réessayez.");
                            }
                        }
                        break;
                    case 2:
                        while (true) {
                            System.out.print("Entrez un nouveau prénom : ");
                            nouvelleValeur = scanner.nextLine();
                            if (validationNomOuPrenom(nouvelleValeur)) {
                                patient.setPrenom(nouvelleValeur);
                                System.out.println("Prénom modifié avec succès !");
                                break;
                            } else {
                                System.out.println("Erreur : Prénom invalide. Réessayez.");
                            }
                        }
                        break;
                    case 3:
                        while (true) {
                            System.out.print("Entrez un nouvel âge : ");
                            nouvelleValeur = scanner.nextLine();
                            try {
                                int nouvelAge = Integer.parseInt(nouvelleValeur);
                                if (nouvelAge > 0) {
                                    patient.setAge(nouvelAge);
                                    System.out.println("Âge modifié avec succès !");
                                    break;
                                } else {
                                    System.out.println("Erreur : L'âge doit être un entier positif. Réessayez.");
                                }
                            } catch (NumberFormatException e) {
                                System.out.println("Erreur : Veuillez entrer un nombre valide pour l'âge.");
                            }
                        }
                        break;
                    case 4:
                        while (true) {
                            System.out.print("Entrez une nouvelle adresse : ");
                            nouvelleValeur = scanner.nextLine();
                            if (!nouvelleValeur.isEmpty()) {
                                patient.setAdresse(nouvelleValeur);
                                System.out.println("Adresse modifiée avec succès !");
                                break;
                            } else {
                                System.out.println("Erreur : L'adresse ne peut pas être vide. Réessayez.");
                            }
                        }
                        break;
                    case 5:
                        while (true) {
                            System.out.print("Entrez un nouveau code postal : ");
                            nouvelleValeur = scanner.nextLine();
                            if (nouvelleValeur.matches("\\d+")) {
                                patient.setCodePostal(nouvelleValeur);
                                System.out.println("Code postal modifié avec succès !");
                                break;
                            } else {
                                System.out.println("Erreur : Le code postal doit contenir uniquement des chiffres. Réessayez.");
                            }
                        }
                        break;
                    case 6:
                        while (true) {
                            System.out.print("Entrez une nouvelle ville : ");
                            nouvelleValeur = scanner.nextLine();
                            if (!nouvelleValeur.isEmpty()) {
                                patient.setVille(nouvelleValeur);
                                System.out.println("Ville modifiée avec succès !");
                                break;
                            } else {
                                System.out.println("Erreur : La ville ne peut pas être vide. Réessayez.");
                            }
                        }
                        break;
                    case 7:
                        while (true) {
                            System.out.print("Entrez un nouveau numéro de téléphone : ");
                            nouvelleValeur = scanner.nextLine();
                            if (nouvelleValeur.matches("\\d+")) {
                                patient.setTelephone(nouvelleValeur);
                                System.out.println("Téléphone modifié avec succès !");
                                break;
                            } else {
                                System.out.println("Erreur : Le numéro de téléphone doit contenir uniquement des chiffres. Réessayez.");
                            }
                        }
                        break;
                    case 8:
                        while (true) {
                            System.out.print("Entrez une nouvelle adresse email : ");
                            nouvelleValeur = scanner.nextLine();
                            if (nouvelleValeur.contains("@")) {
                                patient.setEmail(nouvelleValeur);
                                System.out.println("Email modifié avec succès !");
                                break;
                            } else {
                                System.out.println("Erreur : Adresse email invalide. Réessayez.");
                            }
                        }
                        break;
                    case 9:
                        while (true) {
                            System.out.print("Entrez une nouvelle taille (en cm) : ");
                            nouvelleValeur = scanner.nextLine();
                            try {
                                int nouvelleTaille = Integer.parseInt(nouvelleValeur);
                                if (nouvelleTaille > 0) {
                                    patient.setTaille(nouvelleTaille);
                                    System.out.println("Taille modifiée avec succès !");
                                    break;
                                } else {
                                    System.out.println("Erreur : La taille doit être un entier positif. Réessayez.");
                                }
                            } catch (NumberFormatException e) {
                                System.out.println("Erreur : Veuillez entrer un nombre valide pour la taille.");
                            }
                        }
                        break;
                    case 10:
                        while (true) {
                            System.out.print("Entrez un nouveau poids (en kg) : ");
                            nouvelleValeur = scanner.nextLine();
                            try {
                                double nouveauPoids = Double.parseDouble(nouvelleValeur);
                                if (nouveauPoids > 0) {
                                    patient.setPoids(nouveauPoids);
                                    System.out.println("Poids modifié avec succès !");
                                    break;
                                } else {
                                    System.out.println("Erreur : Le poids doit être un nombre positif. Réessayez.");
                                }
                            } catch (NumberFormatException e) {
                                System.out.println("Erreur : Veuillez entrer un nombre valide pour le poids.");
                            }
                        }
                        break;
                    case 11:
                        while (true) {
                            System.out.print("Entrez un nouveau numéro de sécurité sociale : ");
                            nouvelleValeur = scanner.nextLine();
                            if (!nouvelleValeur.isEmpty()) {
                                patient.setNumeroSecuriteSociale(nouvelleValeur);
                                System.out.println("Numéro de sécurité sociale modifié avec succès !");
                                break;
                            } else {
                                System.out.println("Erreur : Le numéro de sécurité sociale ne peut pas être vide. Réessayez.");
                            }
                        }
                        break;
                    case 12:
                        while (true) {
                            System.out.print("Entrez un nouveau groupe sanguin : ");
                            nouvelleValeur = scanner.nextLine();
                            if (!nouvelleValeur.isEmpty()) {
                                patient.setGroupeSanguin(nouvelleValeur);
                                System.out.println("Groupe sanguin modifié avec succès !");
                                break;
                            } else {
                                System.out.println("Erreur : Le groupe sanguin ne peut pas être vide. Réessayez.");
                            }
                        }
                        break;
                    case 13:
                        while (true) {
                            System.out.print("Entrez de nouveaux antécédents : ");
                            nouvelleValeur = scanner.nextLine();
                            if (!nouvelleValeur.isEmpty()) {
                                patient.setAntecedents(nouvelleValeur);
                                System.out.println("Antécédents modifiés avec succès !");
                                break;
                            } else {
                                System.out.println("Erreur : Les antécédents ne peuvent pas être vides. Réessayez.");
                            }
                        }
                        break;
                    case 14:
                        while (true) {
                            System.out.print("Entrez de nouvelles allergies : ");
                            nouvelleValeur = scanner.nextLine();
                            if (!nouvelleValeur.isEmpty()) {
                                patient.setAllergies(nouvelleValeur);
                                System.out.println("Allergies modifiées avec succès !");
                                break;
                            } else {
                                System.out.println("Erreur : Les allergies ne peuvent pas être vides. Réessayez.");
                            }
                        }
                        break;
                    case 15:
                        while (true) {
                            System.out.print("Entrez de nouveaux traitements : ");
                            nouvelleValeur = scanner.nextLine();
                            if (!nouvelleValeur.isEmpty()) {
                                patient.setTraitements(nouvelleValeur);
                                System.out.println("Traitements modifiés avec succès !");
                                break;
                            } else {
                                System.out.println("Erreur : Les traitements ne peuvent pas être vides. Réessayez.");
                            }
                        }
                        break;
                    case 16:
                        while (true) {
                            System.out.print("Entrez un nouveau médecin référent : ");
                            nouvelleValeur = scanner.nextLine();
                            if (!nouvelleValeur.isEmpty()) {
                                patient.setMedecin(nouvelleValeur);
                                System.out.println("Médecin référent modifié avec succès !");
                                break;
                            } else {
                                System.out.println("Erreur : Le médecin référent ne peut pas être vide. Réessayez.");
                            }
                        }
                        break;
                    case 17:
                        while (true) {
                            System.out.print("Entrez une nouvelle date de dernière visite : ");
                            nouvelleValeur = scanner.nextLine();
                            if (!nouvelleValeur.isEmpty()) {
                                patient.setDerniereVisite(nouvelleValeur);
                                System.out.println("Dernière visite modifiée avec succès !");
                                break;
                            } else {
                                System.out.println("Erreur : La date de dernière visite ne peut pas être vide. Réessayez.");
                            }
                        }
                        break;
                    case 18:
                        while (true) {
                            System.out.print("Entrez une nouvelle date pour le prochain rendez-vous : ");
                            nouvelleValeur = scanner.nextLine();
                            if (!nouvelleValeur.isEmpty()) {
                                patient.setProchainRdv(nouvelleValeur);
                                System.out.println("Prochain rendez-vous modifié avec succès !");
                                break;
                            } else {
                                System.out.println("Erreur : La date du prochain rendez-vous ne peut pas être vide. Réessayez.");
                            }
                        }
                        break;
                    case 19:
                        while (true) {
                            System.out.print("Entrez de nouvelles remarques : ");
                            nouvelleValeur = scanner.nextLine();
                            if (!nouvelleValeur.isEmpty()) {
                                patient.setRemarques(nouvelleValeur);
                                System.out.println("Remarques modifiées avec succès !");
                                break;
                            } else {
                                System.out.println("Erreur : Les remarques ne peuvent pas être vides. Réessayez.");
                            }
                        }
                        break;
                    case 20:
                    	while(true) {

                        continuer = false;
                        break;}
                    default:
                        System.out.println("Choix invalide. Veuillez réessayer.");
                        break;
                }
            }

            System.out.println("Patient modifié avec succès !");
        } else {
            System.out.println("Aucun patient trouvé avec cet ID.");
        }
    }


    private boolean validationNomOuPrenom(String nouveauPrenom) {
		return false;
	}

	private boolean validationAge(int nouvelAge) {
		return false;
	}

	private boolean validationEmail(String nouvelEmail) {
		return false;
	}

	private boolean validationTelephone(String nouveauTelephone) {
		return false;
	}

	private void supprimerPatientMenu(Scanner scanner) {
        System.out.println("===== Supprimer un Patient =====");
        System.out.print("Entrez l'ID du patient à supprimer : ");
        int id = scanner.nextInt();
        scanner.nextLine();

        if (listePatient.supprimerPatient(id)) {
            System.out.println("Patient supprimé avec succès !");
        } else {
            System.out.println("Aucun patient trouvé avec cet ID.");
        }
    }

	private void gererRendezVous() {
	    boolean continuer = true;
	    rendezvous[] tableauRdv = {
	        new rendezvous(30, 9, 2025, "djabri", "sara", "consultation", "confirmé", "adimi", 370655999, 12),
	        new rendezvous(28, 1, 2025, "chekkar", "meriem", "intervention", "confirmé", "mazari", 558307655, 18),
	        new rendezvous(16, 7, 2025, "benali", "moudjib", "vaccination", "confirmé", "nadir", 123456789, 10)
	    };

	    while (continuer) {
	        System.out.println("\n===== Gestion des Rendez-Vous =====");
	        System.out.println("1. Afficher tous les rendez-vous");
	        System.out.println("2. Rechercher un rendez-vous par date");
	        System.out.println("3. Modifier un rendez-vous");
	        System.out.println("4. Annuler un rendez-vous");
	        System.out.println("5. Retour au menu principal");
	        System.out.print("Choisissez une option (1-5) : ");
	        
			int choix = scanner.nextInt();
	        scanner.nextLine(); // Consomme la ligne restante

	        switch (choix) {
	            case 1:
	                afficherTousLesRendezVous(tableauRdv);
	                break;
	            case 2:
	                rechercherRendezVousParDate(tableauRdv);
	                break;
	            case 3:
	                modifierRendezVous(tableauRdv);
	                break;
	            case 4:
	                annulerRendezVous(tableauRdv);
	                break;
	            case 5:
	                System.out.println("Retour au menu principal.");
	                continuer = false;
	                break;
	            default:
	                System.out.println("Choix invalide. Veuillez réessayer.");
	                break;
	        } 
	    }
	}
	private void afficherTousLesRendezVous(rendezvous[] tableauRdv) {
	    System.out.println("\n===== Liste des Rendez-Vous =====");
	    for (rendezvous rdv : tableauRdv) {
	        rdv.affiche();
	        System.out.println("-----------------");
	    }
	}
	private void rechercherRendezVousParDate(rendezvous[] tableauRdv) {
		if (scanner == null) { 
	        scanner = new Scanner(System.in);
	    }
	
	    System.out.print("Entrez le jour : ");
		int jour = scanner.nextInt();
	    System.out.print("Entrez le mois : ");
	    int mois = scanner.nextInt();
	    System.out.print("Entrez l'année : ");
	    int annee = scanner.nextInt();

	    System.out.println("\nRendez-vous pour la date : " + jour + "/" + mois + "/" + annee);
	    boolean trouve = false;
	    for (rendezvous rdv : tableauRdv) {
	        if (rdv.getJour() == jour && rdv.getMois() == mois && rdv.getAnnee() == annee) {
	            rdv.affiche();
	            System.out.println("-----------------");
	            trouve = true;
	        }
	    }
	    if (!trouve) {
	        System.out.println("Aucun rendez-vous trouvé pour cette date.");
	    }
	}
	private void modifierRendezVous(rendezvous[] tableauRdv) {
		if (scanner == null) { 
	        scanner = new Scanner(System.in);
	    }
	    System.out.print("Entrez l'ID du rendez-vous à modifier (0 à " + (tableauRdv.length - 1) + ") : ");
		int id = scanner.nextInt();

	    if (id >= 0 && id < tableauRdv.length) {
	        System.out.print("Nouvelle date (jour) : ");
	        int jour = scanner.nextInt();
	        System.out.print("Nouvelle date (mois) : ");
	        int mois = scanner.nextInt();
	        System.out.print("Nouvelle date (année) : ");
	        int annee = scanner.nextInt();
	        System.out.print("Nouvelle heure : ");
	        double heure = scanner.nextDouble();

	        tableauRdv[id].modifierrdv(jour, mois, annee, heure);
	        System.out.println("Le rendez-vous a été modifié avec succès !");
	        tableauRdv[id].affiche();
	    } else {
	        System.out.println("ID invalide. Aucune modification effectuée.");
	    }
	}
	private void annulerRendezVous(rendezvous[] tableauRdv) {
		if (scanner == null) {
	        scanner = new Scanner(System.in);
	    }
	    System.out.print("Entrez l'ID du rendez-vous à annuler (0 à " + (tableauRdv.length - 1) + ") : ");
		int id = scanner.nextInt();

	    if (id >= 0 && id < tableauRdv.length) {
	        tableauRdv[id].annuler();
	        System.out.println("Le rendez-vous a été annulé avec succès !");
	        tableauRdv[id].affiche();
	    } else {
	        System.out.println("ID invalide. Aucune annulation effectuée.");
	    }}}
	  


                  





















