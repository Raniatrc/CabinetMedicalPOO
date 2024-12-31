package GestionCabinet;

public class rendezvous extends date {

    private String nom, prenom, motif, statut, medcin;
    private long num;
    private double heure;

    public rendezvous(int jour, int mois, int annee, String nom, String prenom, String motif,
                      String statut, String medcin, long num, double heure) {
        super(jour, mois, annee); 
        this.nom = nom;
        this.prenom = prenom;
        this.motif = motif;
        this.statut = statut;
        this.medcin = medcin;
        this.num = num;
        this.heure = heure;
    }

    // Getters et setters
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

    public String getMotif() {
        return motif;
    }

    public void setMotif(String motif) {
        this.motif = motif;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public String getMedcin() {
        return medcin;
    }

    public void setMedcin(String medcin) {
        this.medcin = medcin;
    }

    public long getNum() {
        return num;
    }

    public void setNum(long num) {
        this.num = num;
    }

    public double getHeure() {
        return heure;
    }

    public void setHeure(double heure) {
        this.heure = heure;
    }

    // Affichage du rendez-vous
    void affiche() {
        System.out.println("Date : " + super.toString());  // Utilisation de la méthode toString() de la classe `date`
        System.out.println("L'heure : " + getHeure() + "h");
        System.out.println("Patient : " + getNom() + " " + getPrenom());
        System.out.println("Tel : " + "0" + getNum());
        System.out.println("Médecin : " + getMedcin());
        System.out.println("Motif : " + getMotif());
        System.out.println("Statut : " + getStatut());
    }

    // Annuler le rendez-vous
    void annuler() {
        setStatut("annulé");
    }

    // Modifier un rendez-vous
    void modifierrdv(int jour, int mois, int annee, double heure) {
        setJour(jour);   
        setMois(mois);
        setAnnee(annee);
        setHeure(heure);
    }
}
