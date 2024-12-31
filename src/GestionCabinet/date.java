package GestionCabinet;

public class date {

    // Attributs
    private int jour;
    private int mois;
    private int annee;

    // Constructeur
    public date(int jour, int mois, int annee) {
        if (estDateValide(jour, mois, annee)) {
            this.jour = jour;
            this.mois = mois;
            this.annee = annee;
        } else {
            throw new IllegalArgumentException("Date invalide !");
        }
    }

    // Getters
    public int getJour() {
        return jour;
    }

    public int getMois() {
        return mois;
    }

    public int getAnnee() {
        return annee;
    }

    // Setters avec vérification
    public void setJour(int jour) {
        if (estDateValide(jour, this.mois, this.annee)) {
            this.jour = jour;
        } else {
            throw new IllegalArgumentException("Jour invalide !");
        }
    }

    public void setMois(int mois) {
        if (estDateValide(this.jour, mois, this.annee)) {
            this.mois = mois;
        } else {
            throw new IllegalArgumentException("Mois invalide !");
        }
    }

    public void setAnnee(int annee) {
        if (estDateValide(this.jour, this.mois, annee)) {
            this.annee = annee;
        } else {
            throw new IllegalArgumentException("Année invalide !");
        }
    }

    // Méthode pour vérifier si une date est valide
    private boolean estDateValide(int jour, int mois, int annee) {
        if (mois < 1 || mois > 12) return false;

        // Nombre de jours dans chaque mois
        int[] joursParMois = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        // Vérification pour une année bissextile
        if (mois == 2 && ((annee % 4 == 0 && annee % 100 != 0) || (annee % 400 == 0))) {
            joursParMois[1] = 29;
        }

        return jour >= 1 && jour <= joursParMois[mois - 1];
    }

    // Méthode pour afficher la date au format "jj/mm/aaaa"
    @Override
    public String toString() {
        return String.format("%02d/%02d/%04d", jour, mois, annee);
    }

    void affiche() {
        System.out.println(String.format("date: %02d/%02d/%04d", jour, mois, annee));
    }
}
