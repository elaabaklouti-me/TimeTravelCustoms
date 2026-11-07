package com.example.timetravelcustoms;

public class CleIntent {

        // 7attit les 4 derniers chiffres mtaa ma cin
        public static final String MATRICULE = "3456";

        // méthode statique sna3t beha l clé
        public static String cle(String matricule, String nomDonnee) {
            return matricule + "_" + nomDonnee;
        }

    public static final String NOM_VOYAGEUR = "NOM_VOYAGEUR";
    public static final String ANNEE_NAISSANCE = "ANNEE_NAISSANCE";
    public static final String ANNEE_DESTINATION = "ANNEE_DESTINATION";
    public static final String MOTIF = "MOTIF";
    public static final String VERDICT = "VERDICT";
    }


