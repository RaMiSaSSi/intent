package com.example.activit_retour;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView textViewResult;

    // Déclarer l'ActivityResultLauncher
    private final ActivityResultLauncher<Intent> resultLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            result -> {
                if (result.getResultCode() == RESULT_OK && result.getData() != null) {
                    // Récupérer le choix de l'activité enfant
                    String choix = result.getData().getStringExtra("choix_key");
                    textViewResult.setText("Résultat : " + choix);
                }
            }
    );

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewResult = findViewById(R.id.textView_result);
        Button buttonStartActivity = findViewById(R.id.button_start_activity);

        buttonStartActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Démarrer l'activité enfant
                Intent intent = new Intent(MainActivity.this, ChildActivity.class);
                resultLauncher.launch(intent);
            }
        });
    }
}
