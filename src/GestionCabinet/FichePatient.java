package GestionCabinet;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FichePatient {

    // Attributs de base
    private int id;
    private String nom;
    private String prenom;
    private int age;
    private String adresse;
    private String codePostal;
    private String ville;
    private String telephone;
    private String email;
    private double taille; // en cm
    private double poids; // en kg
    private String numeroSecuriteSociale;

    // Attributs médicaux
    private String groupeSanguin;
    private String antecedents;
    private String allergies;
    private String traitements;

    // Suivi médical
    private String medecin;
    private String derniereVisite;
    private String prochainRdv;
    private String remarques;

    // Constructeur
    public FichePatient(int id, String nom, String prenom, int age, String adresse, String codePostal, String ville,
                        String telephone, String email, double taille, double poids, String numeroSecuriteSociale,
                        String groupeSanguin, String antecedents, String allergies, String traitements, String medecin,
                        String derniereVisite, String prochainRdv, String remarques) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
        this.adresse = adresse;
        this.codePostal = codePostal;
        this.ville = ville;
        this.telephone = telephone;
        this.email = email;
        this.taille = taille;
        this.poids = poids;
        this.numeroSecuriteSociale = numeroSecuriteSociale;
        this.groupeSanguin = groupeSanguin;
        this.antecedents = antecedents;
        this.allergies = allergies;
        this.traitements = traitements;
        this.medecin = medecin;
        this.derniereVisite = derniereVisite;
        this.prochainRdv = prochainRdv;
        this.remarques = remarques;
    }

	//getters and setters
 	
	public FichePatient(String nom2, String prenom2, int age2, String adresse2, String codePostal2, String ville2,
			String telephone2, String email2, int taille2, int poids2, int numeroSecuriteSociale2,
			String groupeSanguin2, String antecedents2, String allergies2, String traitements2, String medecin2,
			String derniereVisite2, String prochainRdv2, String remarques2) {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public double getTaille() {
		return taille;
	}

	public void setTaille(double taille) {
		this.taille = taille;
	}

	public double getPoids() {
		return poids;
	}

	public void setPoids(double poids) {
		this.poids = poids;
	}

	public String getNumeroSecuriteSociale() {
		return numeroSecuriteSociale;
	}

	public void setNumeroSecuriteSociale(String numeroSecuriteSociale) {
		this.numeroSecuriteSociale = numeroSecuriteSociale;
	}

	public String getGroupeSanguin() {
		return groupeSanguin;
	}

	public void setGroupeSanguin(String groupeSanguin) {
		this.groupeSanguin = groupeSanguin;
	}

	public String getAntecedents() {
		return antecedents;
	}

	public void setAntecedents(String antecedents) {
		this.antecedents = antecedents;
	}

	public String getAllergies() {
		return allergies;
	}

	public void setAllergies(String allergies) {
		this.allergies = allergies;
	}

	public String getTraitements() {
		return traitements;
	}

	public void setTraitements(String traitements) {
		this.traitements = traitements;
	}

	public String getMedecin() {
		return medecin;
	}

	public void setMedecin(String medecin) {
		this.medecin = medecin;
	}

	public String getDerniereVisite() {
		return derniereVisite;
	}

	public void setDerniereVisite(String derniereVisite) {
		this.derniereVisite = derniereVisite;
	}

	public String getProchainRdv() {
		return prochainRdv;
	}

	public void setProchainRdv(String prochainRdv) {
		this.prochainRdv = prochainRdv;
	}

	public String getRemarques() {
		return remarques;
	}

	public void setRemarques(String remarques) {
		this.remarques = remarques;
	}


    // Méthode pour valider si une chaîne contient uniquement des lettres
    public boolean isValidName(String input) {
        return input != null && input.matches("[A-Za-z]+");
    }

    // Méthode pour valider si une chaîne contient uniquement des chiffres
    public boolean isValidPhoneNumber(String input) {
        return input != null && input.matches("[0-9]+");
    }

    // Méthode pour valider un email
    public boolean isValidEmail(String input) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(input);
        return matcher.matches();
    }

    // Méthode pour valider un numéro de sécurité sociale
    public boolean isValidNumeroSecuriteSociale(String input) {
        return input != null && input.matches("[0-9]{15}");
    }

    // Méthode toString (inchangée)
    public String toString() {
        return "FichePatient [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", age=" + age + ", adresse=" + adresse
                + ", codePostal=" + codePostal + ", ville=" + ville + ", telephone=" + telephone + ", email=" + email
                + ", taille=" + taille + ", poids=" + poids + ", numeroSecuriteSociale=" + numeroSecuriteSociale
                + ", groupeSanguin=" + groupeSanguin + ", antecedents=" + antecedents + ", allergies=" + allergies
                + ", traitements=" + traitements + ", medecin=" + medecin + ", derniereVisite=" + derniereVisite
                + ", prochainRdv=" + prochainRdv + ", remarques=" + remarques + "]";
    }

    // Ajout de méthodes pour la validation des champs lors de l'ajout et la modification
    public boolean isValidFiche() {
        return isValidName(nom) && isValidName(prenom) && isValidPhoneNumber(telephone) && isValidEmail(email)
                && isValidNumeroSecuriteSociale(numeroSecuriteSociale);
    }

    // Méthode de modification d'un champ spécifique
    public void modifierChamps(String champ, String valeur) {
        switch (champ.toLowerCase()) {
            case "nom":
                if (isValidName(valeur)) {
                    this.nom = valeur;
                } else {
                    System.out.println("Erreur : le nom ne doit contenir que des lettres.");
                }
                break;
            case "prenom":
                if (isValidName(valeur)) {
                    this.prenom = valeur;
                } else {
                    System.out.println("Erreur : le prénom ne doit contenir que des lettres.");
                }
                break;
            case "telephone":
                if (isValidPhoneNumber(valeur)) {
                    this.telephone = valeur;
                } else {
                    System.out.println("Erreur : le numéro de téléphone ne doit contenir que des chiffres.");
                }
                break;
            case "email":
                if (isValidEmail(valeur)) {
                    this.email = valeur;
                } else {
                    System.out.println("Erreur : l'email n'est pas valide.");
                }
                break;
            case "numero securite sociale":
                if (isValidNumeroSecuriteSociale(valeur)) {
                    this.numeroSecuriteSociale = valeur;
                } else {
                    System.out.println("Erreur : le numéro de sécurité sociale n'est pas valide.");
                }
                break;
            default:
                System.out.println("Erreur : champ non reconnu.");
                break;
        }
    }
}
