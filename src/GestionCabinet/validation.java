

package GestionCabinet;

public class validation {

    // Vérifie si une chaîne contient uniquement des lettres ou des caractères spéciaux autorisés
    public static boolean estValideNomPrenomVille(String str) {
        return str != null && str.matches("[a-zA-ZÀ-ÿéèêôùï\\s'-]+");
    }

    // Vérifie si une chaîne contient uniquement des chiffres
    public static boolean estValideNumerique(String str) {
        return str != null && str.matches("\\d+");
    }

    // Vérifie si un ID est valide 
    public static boolean estValideId(String id) {
        return estValideNumerique(id) && Integer.parseInt(id) > 0;
    }

    // Vérifie la validité complète d'un patient
    public static boolean estValidePatient(FichePatient patient) {
        if (patient == null) {
            return false;
        }
        
        return estValideNomPrenomVille(patient.getNom()) &&
                estValideNomPrenomVille(patient.getPrenom()) &&
                estValideId(String.valueOf(patient.getId())) &&
                estValideNumerique(String.valueOf(patient.getAge()));
    }
}
