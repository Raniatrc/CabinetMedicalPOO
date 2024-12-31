package GestionCabinet;

public class MedicalRecord {
    private String prenom;
    private String nom;
    private int age;
    private String sexe;
    private String contactInfo;  
    private String contactUrgence;  
    private String allergies;  
    private String historiqueMedical;  
    private String notesMedecin;  
    
    public MedicalRecord(String prenom, String nom, int age, String sexe, String contactInfo, 
                          String contactUrgence, String allergies, String historiqueMedical, String notesMedecin) {
        this.prenom = prenom;
        this.nom = nom;
        this.age = age;
        this.sexe = sexe;
        this.contactInfo = contactInfo;
        this.contactUrgence = contactUrgence;
        this.allergies = allergies;
        this.historiqueMedical = historiqueMedical;
        this.notesMedecin = notesMedecin;
    }

    public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getSexe() {
		return sexe;
	}

	public void setSexe(String sexe) {
		this.sexe = sexe;
	}

	public String getPrenom() {
        return prenom;
    }

    public String getNom() {
        return nom;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public String getContactUrgence() {
        return contactUrgence;
    }

    public String getAllergies() {
        return allergies;
    }

    public String getHistoriqueMedical() {
        return historiqueMedical;
    }

    public String getNotesMedecin() {
        return notesMedecin;
    }

    // Affichage du dossier médical
    public void afficher() {
        System.out.println("Nom du patient : " + prenom + " " + nom);
        System.out.println("Âge : " + age);
        System.out.println("Sexe : " + sexe);
        System.out.println("Contact : " + contactInfo);
        System.out.println("Contact d'urgence : " + contactUrgence);
        System.out.println("Allergies : " + allergies);
        System.out.println("Antécédents médicaux : " + historiqueMedical);
        System.out.println("Notes du médecin : " + notesMedecin);
    }
}

