package com.example.timetravelcustoms;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class VerificationActivity extends AppCompatActivity {
    private TextView tvNom, tvAge, tvMotif;
    private Button btnApprouver, btnRefuser;

    // hetheya nom bsh nab3thou ll act3
    private String nom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verification);

        tvNom = findViewById(R.id.textView2);
        tvAge = findViewById(R.id.textView3);
        tvMotif = findViewById(R.id.textView4);
        btnApprouver = findViewById(R.id.button2);
        btnRefuser = findViewById(R.id.button3);

        // lenna l'act2 va récupérer les données saisies fl act1 bel les clés eli déja sna3thom fl act1
        Intent intent = getIntent();
        nom = intent.getStringExtra(CleIntent.cle(CleIntent.MATRICULE, CleIntent.NOM_VOYAGEUR));
        int anneeNaissance = intent.getIntExtra(CleIntent.cle(CleIntent.MATRICULE, CleIntent.ANNEE_NAISSANCE), 0);
        int anneeDestination = intent.getIntExtra(CleIntent.cle(CleIntent.MATRICULE, CleIntent.ANNEE_DESTINATION), 0);
        String motif = intent.getStringExtra(CleIntent.cle(CleIntent.MATRICULE, CleIntent.MOTIF));

        // calcul d'age temporel
        int ecart = anneeDestination - anneeNaissance;

        // affichage des données 3al act2
        tvNom.setText("Nom : " + nom);
        tvAge.setText("Age Temporel : " + ecart + " ans");
        tvMotif.setText("Motif : " + motif);

        // désactivation du btn approuver itha ken l motif "Modification du passé" w l'écart nbre premier
        if ("Modification du passé".equals(motif) && estPremier(ecart)) {
            btnApprouver.setEnabled(false);
        }

        // envoyerverdict tab3eth true ll act3 itha kn nzelna 3al btn approuver
        btnApprouver.setOnClickListener(v -> envoyerVerdict(true));

        // envoyerverdict tab3eth false ll act3 itha kn nzelna 3al btn refuser
        btnRefuser.setOnClickListener(v -> envoyerVerdict(false));


        };

    // vérification de l'ecart premier
    private boolean estPremier(int n) {
        if (n < 2) return false;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    // fonction elli bsh tab3th ll act3 esm l voyageur w itha kenou approuvé wela le
    private void envoyerVerdict(boolean approuve) {
        Intent intent = new Intent(VerificationActivity.this, ResultActivity.class);
        intent.putExtra(CleIntent.cle(CleIntent.MATRICULE, CleIntent.VERDICT), approuve);
        intent.putExtra(CleIntent.cle(CleIntent.MATRICULE, CleIntent.NOM_VOYAGEUR), nom);
        startActivity(intent);
    }
}