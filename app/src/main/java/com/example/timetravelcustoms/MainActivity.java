package com.example.timetravelcustoms;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText etNom, etNaissance, etDestination;
    private Spinner spMotif;
    private Button btnInspecter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // hne rbat les elts xml bl java a travers les id mte7om
        etNom = findViewById(R.id.Nom);
        etNaissance = findViewById(R.id.Naiss);
        etDestination = findViewById(R.id.Dest);
        spMotif = findViewById(R.id.spinner);
        btnInspecter = findViewById(R.id.button);

        // kif nenzl 3al button Inspecter , l méthode inspecterProfil() taaml récupération ll données w t3adina ll act2
        btnInspecter.setOnClickListener(v -> inspecterProfil());
    }

    private void inspecterProfil() {
        //récupération des données
        String nom = etNom.getText().toString().trim();
        String naissanceTxt = etNaissance.getText().toString().trim();
        String destinationTxt = etDestination.getText().toString().trim();

        //ken l'utilisateur 5alla champs fere4 nab3thoulou toast fih message
        if (nom.isEmpty() || naissanceTxt.isEmpty() || destinationTxt.isEmpty()) {
            Toast.makeText(this, "Veuillez remplir tous les champs", Toast.LENGTH_SHORT).show();
            return;
        }

        // récupération mtaa l motif
        String motif = spMotif.getSelectedItem().toString();

        // lenna esta3mlt regx kima fl web bsh l'utilisateur yajjm yda5el ken des lettres alphabétiques
        if (!nom.matches("[\\p{L} '-]+")) {
            etNom.setError("Le nom doit contenir uniquement des lettres");
            etNom.requestFocus();
            return;
        }

        // 7awalt les inputs ll int bsh najjm ne7seb bihom
        int anneeNaissance;
        int anneeDestination;
            anneeNaissance = Integer.parseInt(naissanceTxt);
            anneeDestination = Integer.parseInt(destinationTxt);

        // controle de saisie 3al les années
        if (anneeNaissance < 1900 ) {
            etNaissance.setError("Année de naissance inférieur à 1990");
            etNaissance.requestFocus();
            return;
        }

        if (anneeDestination < 1900 ) {
            etDestination.setError("Année de destination inférieur à 1990");
            etDestination.requestFocus();
            return;
        }

        // contrainte bsh najjm ne7seb l'age
        if (anneeNaissance >  anneeDestination  ) {
            Toast.makeText(this, "L'année de destination doit etre supérieur à l'année de naissance ", Toast.LENGTH_SHORT).show();
            return;
        }


        // sna3t Intent explicite vers l’act2,yesta3ml les clés eli sna3thom bl méthode statique bsh yab3eth les données
        Intent intent = new Intent(MainActivity.this, VerificationActivity.class);
        intent.putExtra(CleIntent.cle(CleIntent.MATRICULE, CleIntent.NOM_VOYAGEUR), nom);
        intent.putExtra(CleIntent.cle(CleIntent.MATRICULE, CleIntent.ANNEE_NAISSANCE), anneeNaissance);
        intent.putExtra(CleIntent.cle(CleIntent.MATRICULE, CleIntent.ANNEE_DESTINATION), anneeDestination);
        intent.putExtra(CleIntent.cle(CleIntent.MATRICULE, CleIntent.MOTIF), motif);
        startActivity(intent);
    }

};

