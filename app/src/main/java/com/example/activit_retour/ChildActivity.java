package com.example.activit_retour;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ChildActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_child);

        Button buttonYes = findViewById(R.id.button_yes);
        Button buttonNo = findViewById(R.id.button_no);

        // Bouton OUI
        buttonYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Retourner le résultat "OUI"
                Intent returnIntent = new Intent();
                returnIntent.putExtra("choix_key", "OUI");
                setResult(RESULT_OK, returnIntent);
                finish(); // Fermer l'activité enfant
            }
        });

        // Bouton NON
        buttonNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Retourner le résultat "NON"
                Intent returnIntent = new Intent();
                returnIntent.putExtra("choix_key", "NON");
                setResult(RESULT_OK, returnIntent);
                finish(); // Fermer l'activité enfant
            }
        });
    }
}
