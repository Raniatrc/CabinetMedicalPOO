package GestionCabinet;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ListePatient {
    private List<FichePatient> patients;

    public ListePatient() {
        this.patients = new ArrayList<>();
        initialiserPatients();
    }

    // Initialisation des patients fictifs
    private void initialiserPatients() {
        patients.add(new FichePatient(1, "Bensalem", "Ahmed", 40, "15 Rue Didouche Mourad", "16000", "Alger", 
                "0550123456", "ahmed.bensalem@gmail.com", 175, 80, "123456789123456", 
                "A+", "Hypertension", "Pollen", "Bêta-bloquants", 
                "Dr. Haddad", "2024-01-10", "2024-02-15", "RAS"));
        patients.add(new FichePatient(2, "Khelifa", "Yasmine", 28, "10 Avenue de l'Indépendance", "31000", "Oran", 
                "0669876543", "yasmine.khelifa@yahoo.com", 160, 55, "789456123789456", 
                "O-", "Asthme", "Poussière", "Ventoline", 
                "Dr. Belkacem", "2023-12-20", "2024-01-30", "RAS"));
        patients.add(new FichePatient(1, "Bensalem", "Ahmed", 40, "15 Rue Didouche Mourad", "16000", "Alger", 
    	        "0550123456", "ahmed.bensalem@gmail.com", 175, 80, "123456789123456", 
    	        "A+", "Hypertension", "Pollen", "Bêta-bloquants", 
    	        "Dr. Haddad", "2024-01-10", "2024-02-15", "RAS"));

    	patients.add(new FichePatient(2, "Khelifa", "Yasmine", 28, "10 Avenue de l'Indépendance", "31000", "Oran", 
    	        "0669876543", "yasmine.khelifa@yahoo.com", 160, 55, "789456123789456", 
    	        "O-", "Asthme", "Poussière", "Ventoline", 
    	        "Dr. Belkacem", "2023-12-20", "2024-01-30", "RAS"));

    	patients.add(new FichePatient(3, "Bousaid", "Ali", 35, "23 Rue de la Liberté", "20000", "Blida", 
    	        "0771122334", "ali.bousaid@hotmail.com", 172, 70, "456123789456123", 
    	        "B+", "Diabète", "Aucune", "Insuline", 
    	        "Dr. Gacem", "2023-11-15", "2024-02-10", "Surveillance régulière"));

    	patients.add(new FichePatient(4, "Cherif", "Fatima", 50, "5 Rue Emir Abdelkader", "40000", "Tlemcen", 
    	        "0543221100", "fatima.cherif@gmail.com", 158, 65, "321654987321654", 
    	        "AB-", "Cholestérol", "Noix", "Statines", 
    	        "Dr. Bendjaballah", "2023-12-01", "2024-03-01", "Régime conseillé"));

    	patients.add(new FichePatient(5, "Saadi", "Mohamed", 45, "18 Rue des Martyrs", "30000", "Constantine", 
    	        "0555566778", "mohamed.saadi@gmail.com", 180, 85, "654987321654987", 
    	        "O+", "Hypertension", "Aucune", "Inhibiteurs de l'ECA", 
    	        "Dr. Ouaret", "2023-10-10", "2024-01-15", "RAS"));

    	patients.add(new FichePatient(6, "Belaid", "Salima", 32, "12 Rue Ait Ahmed", "15000", "Tizi Ouzou", 
    	        "0567890123", "salima.belaid@gmail.com", 165, 60, "789123456789123", 
    	        "A-", "Anémie", "Aucune", "Compléments en fer", 
    	        "Dr. Taleb", "2024-01-05", "2024-04-01", "Traitement en cours"));

    	patients.add(new FichePatient(7, "Haddad", "Rachid", 60, "20 Rue des Frères Abane", "8000", "Béjaïa", 
    	        "0549988776", "rachid.haddad@yahoo.com", 170, 75, "321789654321789", 
    	        "B-", "Cardiopathie", "Poisson", "Anticoagulants", 
    	        "Dr. Meziane", "2023-09-25", "2024-02-20", "Surveillance étroite"));

    	patients.add(new FichePatient(8, "Zitouni", "Imane", 25, "8 Rue de l'Unité Africaine", "16000", "Alger", 
    	        "0553456789", "imane.zitouni@gmail.com", 162, 52, "987654321987654", 
    	        "O+", "Aucune", "Poussière", "Aucune", 
    	        "Dr. Sebti", "2024-01-10", "2024-03-15", "RAS"));

    	patients.add(new FichePatient(9, "Boualem", "Hana", 38, "10 Rue des Jasmins", "20000", "Blida", 
    	        "0778877665", "hana.boualem@yahoo.com", 168, 65, "654123987654123", 
    	        "AB+", "Hypothyroïdie", "Gluten", "Lévothyrox", 
    	        "Dr. Saadi", "2023-12-05", "2024-02-25", "Dosage ajusté"));

    	patients.add(new FichePatient(10, "Rezzoug", "Samir", 55, "25 Rue de l'Amitié", "19000", "Annaba", 
    	        "0667788990", "samir.rezzoug@hotmail.com", 175, 78, "123987456123987", 
    	        "B+", "Arthrite", "Aucune", "Anti-inflammatoires", 
    	        "Dr. Amrane", "2023-11-01", "2024-01-20", "Kinésithérapie conseillée"));


    }

    // Méthode pour récupérer la liste des patients
    public List<FichePatient> getListePatients() {
        return patients;
    }

    // Méthode pour afficher la liste des patients
    public void afficherPatients() {
        if (patients == null || patients.isEmpty()) {
            System.out.println("Aucun patient dans la liste.");
            return;
        }

        // Affichage de l'en-tête du tableau
        System.out.printf(
            "%-5s %-15s %-15s %-5s %-20s %-10s %-15s %-15s %-25s %-10s %-10s %-20s %-15s %-20s\n", 
            "ID", "Nom", "Prénom", "Âge", "Adresse", "CP", "Ville", "Téléphone", "Email", 
            "Taille", "Poids", "N° Séc. Soc.", "Groupe", "Dernière Visite"
        );
        System.out.println("=".repeat(175)); 

        // Affichage des patients
        for (FichePatient patient : patients) {
            System.out.printf(
                "%-5d %-15s %-15s %-5d %-20s %-10s %-15s %-15s %-25s %-10.1f %-10.1f %-20s %-15s %-20s\n", 
                patient.getId(),                    
                patient.getNom(),                    
                patient.getPrenom(),                 
                patient.getAge(),                   
                patient.getAdresse(),                
                patient.getCodePostal(),          
                patient.getVille(),                  
                patient.getTelephone(),             
                patient.getEmail(),                  
                patient.getTaille(),                 
                patient.getPoids(),                  
                patient.getNumeroSecuriteSociale(),  
                patient.getGroupeSanguin(),          
                patient.getDerniereVisite()          
            );
        }
    }


    // Rechercher un patient par son ID
    public FichePatient rechercherPatientParId(int id) {
        return patients.stream().filter(patient -> patient.getId() == id).findFirst().orElse(null);
    }

    // Ajouter un nouveau patient
    public void ajouterPatient(FichePatient patient) {
        if (validation.estValidePatient(patient)) {
            patients.add(patient);
        } else {
            throw new IllegalArgumentException("Données invalides pour le patient.");
        }
    }

    // Supprimer un patient par son ID
    public boolean supprimerPatient(int id) {
        FichePatient patient = rechercherPatientParId(id);
        if (patient != null) {
            patients.remove(patient);
            return true;
        }
        return false;
    }

    // Mettre à jour les informations d'un patient
    public boolean mettreAJourPatient(int id, FichePatient nouvellesInfos) {
        if (validation.estValidePatient(nouvellesInfos)) {
            FichePatient patient = rechercherPatientParId(id);
            if (patient != null) {
                int index = patients.indexOf(patient);
                patients.set(index, nouvellesInfos);
                return true;
            }
        }
        return false;
    }

    // Gérer la liste des patients via un menu 
    public void gererListePatient() {
        Scanner scanner = new Scanner(System.in);
        boolean continuer = true;

        while (continuer) {
            System.out.println("===== Gestion des Fiches Patients =====");
            System.out.println("1. Afficher les patients");
            System.out.println("2. Ajouter un patient");
            System.out.println("3. Modifier un patient");
            System.out.println("4. Supprimer un patient");
            System.out.println("5. Retour au menu principal");
            System.out.print("Choisissez une option (1-5): ");

            int choix = scanner.nextInt();
            scanner.nextLine(); 

            switch (choix) {
                case 1:
                    afficherPatients(scanner);
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
                    continuer = false;
                    break;
                default:
                    System.out.println("Choix invalide, veuillez réessayer.");
                    break;
            }
        }
    }

   
	// Ajouter un patient via le menu
        private void ajouterPatientMenu(Scanner scanner) {
        System.out.println("Ajouter un patient : ");
        FichePatient nouveauPatient = saisirInformationsPatient(scanner);
        try {
            ajouterPatient(nouveauPatient);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        }
   

    // Saisir les informations d'un patient
            public FichePatient saisirInformationsPatient(Scanner scanner) {
            String nom, prenom, adresse, codePostal, ville, telephone, email, groupeSanguin, antecedents, allergies, traitements, medecin, derniereVisite, prochainRdv, remarques;
            int age, taille, poids, numeroSecuriteSociale;

            // Demander le nom
            System.out.print("Entrez le nom : ");
            nom = scanner.nextLine();
            while (!validation.estValideNomPrenomVille(nom)) {
                System.out.print("Nom invalide. Veuillez entrer un nom valide : ");
                nom = scanner.nextLine();
            }

            // Demander le prénom
            System.out.print("Entrez le prénom : ");
            prenom = scanner.nextLine();
            while (!validation.estValideNomPrenomVille(prenom)) {
                System.out.print("Prénom invalide. Veuillez entrer un prénom valide : ");
                prenom = scanner.nextLine();
            }

            // Demander l'âge avec gestion 
            System.out.print("Entrez l'âge : ");
            while (!scanner.hasNextInt()) {
                System.out.print("Âge invalide. Veuillez entrer un nombre valide pour l'âge : ");
                scanner.next(); 
            }
            age = scanner.nextInt();
            scanner.nextLine(); 

            // Demander l'adresse
            System.out.print("Entrez l'adresse : ");
            adresse = scanner.nextLine();

            // Demander le code postal
            System.out.print("Entrez le code postal : ");
            codePostal = scanner.nextLine();

            // Demander la ville
            System.out.print("Entrez la ville : ");
            ville = scanner.nextLine();
            while (!validation.estValideNomPrenomVille(ville)) {
                System.out.print("Ville invalide. Veuillez entrer une ville valide : ");
                ville = scanner.nextLine();
            }

            // Demander le téléphone
            System.out.print("Entrez le téléphone : ");
            telephone = scanner.nextLine();
            while (!validation.estValideNumerique(telephone)) {
                System.out.print("Numéro de téléphone invalide. Veuillez entrer un numéro valide : ");
                telephone = scanner.nextLine();
            }

            // Demander l'email
            System.out.print("Entrez l'email : ");
            email = scanner.nextLine();

            // Demander la taille
            System.out.print("Entrez la taille (en cm) : ");
            while (!scanner.hasNextInt()) {
                System.out.print("Taille invalide. Veuillez entrer un nombre valide pour la taille : ");
                scanner.next(); 
            }
            taille = scanner.nextInt();
            scanner.nextLine();
            
            // Demander le poids
            System.out.print("Entrez le poids (en kg) : ");
            while (!scanner.hasNextInt()) {
                System.out.print("Poids invalide. Veuillez entrer un nombre valide pour le poids : ");
                scanner.next();
            }
            poids = scanner.nextInt();
            scanner.nextLine(); 

            // Demander le numéro de sécurité sociale
            System.out.print("Entrez le numéro de sécurité sociale : ");
            while (!scanner.hasNextInt()) {
                System.out.print("Numéro de sécurité sociale invalide. Veuillez entrer un numéro valide : ");
                scanner.next(); 
            }
            numeroSecuriteSociale = scanner.nextInt();
            scanner.nextLine(); 

            // Demander le groupe sanguin
            System.out.print("Entrez le groupe sanguin : ");
            groupeSanguin = scanner.nextLine();

            // Demander les antécédents
            System.out.print("Entrez les antécédents médicaux : ");
            antecedents = scanner.nextLine();

            // Demander les allergies
            System.out.print("Entrez les allergies : ");
            allergies = scanner.nextLine();

            // Demander les traitements
            System.out.print("Entrez les traitements en cours : ");
            traitements = scanner.nextLine();

            // Demander le médecin
            System.out.print("Entrez le médecin traitant : ");
            medecin = scanner.nextLine();

            // Demander la date de la dernière visite
            System.out.print("Entrez la date de la dernière visite : ");
            derniereVisite = scanner.nextLine();

            // Demander la date du prochain rendez-vous
            System.out.print("Entrez la date du prochain rendez-vous : ");
            prochainRdv = scanner.nextLine();

            // Demander des remarques
            System.out.print("Entrez des remarques : ");
            remarques = scanner.nextLine();

            return new FichePatient(nom, prenom, age, adresse, codePostal, ville, telephone, email, taille, poids, numeroSecuriteSociale, groupeSanguin, antecedents, allergies, traitements, medecin, derniereVisite, prochainRdv, remarques);
        }

    // Modifier un patient via le menu  
    public void modifierPatientMenu(Scanner scanner, FichePatient patient2) {
    System.out.println("===== Modifier un Patient =====");
    System.out.print("Entrez l'ID du patient à modifier : ");
    int id = scanner.nextInt();
    scanner.nextLine(); 

    // Recherche du patient
    FichePatient patient = new FichePatient(0, null, null, 0, null, null, null, null, null, 0, 0, null, null, null, null, null,
			null, null, null, null);

    boolean continuer = true;
	while (continuer) {
	    // Afficher la liste complète des champs modifiables
	    System.out.println("=== Champs Modifiables ===");
	    System.out.println("1. Nom : " + patient.getNom());
	    System.out.println("2. Prénom : " + patient.getPrenom());
	    System.out.println("3. Âge : " + patient.getAge());
	    System.out.println("4. Adresse : " + patient.getAdresse());
	    System.out.println("5. Code postal : " + patient.getCodePostal());
	    System.out.println("6. Ville : " + patient.getVille());
	    System.out.println("7. Téléphone : " + patient.getTelephone());
	    System.out.println("8. Email : " + patient.getEmail());
	    System.out.println("9. Taille : " + patient.getTaille());
	    System.out.println("10. Poids : " + patient.getPoids());
	    System.out.println("11. Numéro de sécurité sociale : " + patient.getNumeroSecuriteSociale());
	    System.out.println("12. Groupe sanguin : " + patient.getGroupeSanguin());
	    System.out.println("13. Antécédents : " + patient.getAntecedents());
	    System.out.println("14. Allergies : " + patient.getAllergies());
	    System.out.println("15. Traitements : " + patient.getTraitements());
	    System.out.println("16. Médecin référent : " + patient.getMedecin());
	    System.out.println("17. Dernière visite : " + patient.getDerniereVisite());
	    System.out.println("18. Prochain rendez-vous : " + patient.getProchainRdv());
	    System.out.println("19. Remarques : " + patient.getRemarques());
	    System.out.println("20. Retour au menu principal");
	    System.out.print("Choisissez le numéro du champ à modifier : ");

	    int choix = scanner.nextInt();
	    scanner.nextLine(); 

	    switch (choix) {
	        case 1:
	            System.out.print("Entrez le nouveau nom : ");
	            String nouveauNom = scanner.nextLine();
	            if (validationNomOuPrenom(nouveauNom)) {
	                patient.setNom(nouveauNom);
	                System.out.println("Nom modifié avec succès !");
	            } else {
	                System.out.println("Erreur : Nom invalide.");
	            }
	            break;

	        case 2:
	            System.out.print("Entrez le nouveau prénom : ");
	            String nouveauPrenom = scanner.nextLine();
	            if (validationNomOuPrenom(nouveauPrenom)) {
	                patient.setPrenom(nouveauPrenom);
	                System.out.println("Prénom modifié avec succès !");
	            } else {
	                System.out.println("Erreur : Prénom invalide.");
	            }
	            break;

	        case 3:
	            System.out.print("Entrez le nouvel âge : ");
	            int nouvelAge = scanner.nextInt();
	            scanner.nextLine();
	            if (nouvelAge > 0) {
	                patient.setAge(nouvelAge);
	                System.out.println("Âge modifié avec succès !");
	            } else {
	                System.out.println("Erreur : Âge invalide.");
	            }
	            break;

	        case 4:
	            System.out.print("Entrez la nouvelle adresse : ");
	            String nouvelleAdresse = scanner.nextLine();
	            patient.setAdresse(nouvelleAdresse);
	            System.out.println("Adresse modifiée avec succès !");
	            break;

	        case 5:
	            System.out.print("Entrez le nouveau code postal : ");
	            String nouveauCodePostal = scanner.nextLine();
	            if (validationCodePostal(nouveauCodePostal)) {
	                patient.setCodePostal(nouveauCodePostal);
	                System.out.println("Code postal modifié avec succès !");
	            } else {
	                System.out.println("Erreur : Code postal invalide.");
	            }
	            break;

	        case 6:
	            System.out.print("Entrez la nouvelle ville : ");
	            String nouvelleVille = scanner.nextLine();
	            patient.setVille(nouvelleVille);
	            System.out.println("Ville modifiée avec succès !");
	            break;

	        case 7:
	            System.out.print("Entrez le nouveau numéro de téléphone : ");
	            String nouveauTelephone = scanner.nextLine();
	            if (validationTelephone(nouveauTelephone)) {
	                patient.setTelephone(nouveauTelephone);
	                System.out.println("Téléphone modifié avec succès !");
	            } else {
	                System.out.println("Erreur : Téléphone invalide.");
	            }
	            break;

	        case 8:
	            System.out.print("Entrez le nouvel email : ");
	            String nouvelEmail = scanner.nextLine();
	            if (validationEmail(nouvelEmail)) {
	                patient.setEmail(nouvelEmail);
	                System.out.println("Email modifié avec succès !");
	            } else {
	                System.out.println("Erreur : Email invalide.");
	            }
	            break;

	        case 9:
	            System.out.print("Entrez la nouvelle taille (en cm) : ");
	            double nouvelleTaille = scanner.nextDouble();
	            scanner.nextLine();
	            patient.setTaille(nouvelleTaille);
	            System.out.println("Taille modifiée avec succès !");
	            break;

	        case 10:
	            System.out.print("Entrez le nouveau poids (en kg) : ");
	            double nouveauPoids = scanner.nextDouble();
	            scanner.nextLine();
	            patient.setPoids(nouveauPoids);
	            System.out.println("Poids modifié avec succès !");
	            break;

	        case 11:
	            System.out.print("Entrez le nouveau numéro de sécurité sociale : ");
	            String nouveauNumSecu = scanner.nextLine();
	            patient.setNumeroSecuriteSociale(nouveauNumSecu);
	            System.out.println("Numéro de sécurité sociale modifié avec succès !");
	            break;

	        case 12:
	            System.out.print("Entrez le nouveau groupe sanguin : ");
	            String nouveauGroupeSanguin = scanner.nextLine();
	            patient.setGroupeSanguin(nouveauGroupeSanguin);
	            System.out.println("Groupe sanguin modifié avec succès !");
	            break;

	        case 13:
	            System.out.print("Entrez les nouveaux antécédents : ");
	            String nouveauxAntecedents = scanner.nextLine();
	            patient.setAntecedents(nouveauxAntecedents);
	            System.out.println("Antécédents modifiés avec succès !");
	            break;

	        case 14:
	            System.out.print("Entrez les nouvelles allergies : ");
	            String nouvellesAllergies = scanner.nextLine();
	            patient.setAllergies(nouvellesAllergies);
	            System.out.println("Allergies modifiées avec succès !");
	            break;

	        case 15:
	            System.out.print("Entrez les nouveaux traitements : ");
	            String nouveauxTraitements = scanner.nextLine();
	            patient.setTraitements(nouveauxTraitements);
	            System.out.println("Traitements modifiés avec succès !");
	            break;

	        case 16:
	            System.out.print("Entrez le nouveau médecin référent : ");
	            String nouveauMedecin = scanner.nextLine();
	            patient.setMedecin(nouveauMedecin);
	            System.out.println("Médecin référent modifié avec succès !");
	            break;

	        case 17:
	            System.out.print("Entrez la nouvelle date de dernière visite : ");
	            String nouvelleDerniereVisite = scanner.nextLine();
	            patient.setDerniereVisite(nouvelleDerniereVisite);
	            System.out.println("Dernière visite modifiée avec succès !");
	            break;

	        case 18:
	            System.out.print("Entrez la nouvelle date de prochain rendez-vous : ");
	            String nouveauProchainRdv = scanner.nextLine();
	            patient.setProchainRdv(nouveauProchainRdv);
	            System.out.println("Prochain rendez-vous modifié avec succès !");
	            break;

	        case 19:
	            System.out.print("Entrez les nouvelles remarques : ");
	            String nouvellesRemarques = scanner.nextLine();
	            patient.setRemarques(nouvellesRemarques);
	            System.out.println("Remarques modifiées avec succès !");
	            break;

	        case 20:
	            continuer = false;
	            break;

	        default:
	            System.out.println("Choix invalide, veuillez réessayer.");
	            break;
	    }
	}
}


     	public void modifierPatient(Scanner scanner, FichePatient patient) {
	
      	}
	    void afficherPatients(Scanner scanner) {

		}

		private void modifierPatientMenu(Scanner scanner) {

			
		}

		private void supprimerPatientMenu(Scanner scanner) {
			
		}
		private boolean validationEmail(String nouvelEmail) {
			return false;
		}

		private boolean validationTelephone(String nouveauTelephone) {
			return false;
		}

		private boolean validationCodePostal(String nouveauCodePostal) {
			return false;
		}

		private boolean validationNomOuPrenom(String nouveauNom) {
			return false;
		}

}


    
    
    
    
    
    
    
    
    
 