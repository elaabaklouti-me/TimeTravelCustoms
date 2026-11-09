package com.example.timetravelcustoms;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ResultActivity extends AppCompatActivity {

    private View layoutResult;
    private TextView tvMessage;
    private Button btnNouveau;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);


        layoutResult = findViewById(R.id.layout_result_xx);
        tvMessage = findViewById(R.id.message);
        btnNouveau = findViewById(R.id.btn_voyageur);

        // récupération du résultat booléenne elli ba3thetha la fonction envoyerVerdict ml act2
        Intent intent = getIntent();
        boolean approuve = intent.getBooleanExtra(
                CleIntent.cle(CleIntent.MATRICULE, CleIntent.VERDICT), false);
        String nom = intent.getStringExtra(
                CleIntent.cle(CleIntent.MATRICULE, CleIntent.NOM_VOYAGEUR));

        // hne badalt loun l background wl message selon le resultat de approve
        if (approuve) {
            layoutResult.setBackgroundColor(Color.parseColor("#2E7D32"));
            tvMessage.setText("Bon voyage " + nom);
        } else {
            layoutResult.setBackgroundColor(Color.parseColor("#C62828"));
            tvMessage.setText(nom + " est en état d'arrestation temporelle");
        }

        // Intent explicite yhezna men ResultActivity lil MainActivity
        btnNouveau.setOnClickListener(v -> {
            Intent retour = new Intent(ResultActivity.this, MainActivity.class);

            //lenna sta3mlt flags bsh android yfassa5 les activitées eli mawjoudin w il lance task jdida elli hia act1 fer4a mn jdid
            retour.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(retour);
            finish();
        });
    }
}