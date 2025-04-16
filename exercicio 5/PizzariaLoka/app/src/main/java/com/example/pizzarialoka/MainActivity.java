package com.example.pizzarialoka;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    CheckBox checkCalabresa, checkMarguerita, checkPortuguesa;
    Button btnAvancar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        checkCalabresa = findViewById(R.id.checkCalabresa);
        checkMarguerita = findViewById(R.id.checkMarguerita);
        checkPortuguesa = findViewById(R.id.checkPortuguesa);
        btnAvancar = findViewById(R.id.btnAvancar);

        btnAvancar.setOnClickListener(v -> {
            StringBuilder sabores = new StringBuilder();
            double valorSabores = 0.0;

            if (checkCalabresa.isChecked()) {
                sabores.append("Calabresa, ");
                valorSabores += 10.0;
            }
            if (checkMarguerita.isChecked()) {
                sabores.append("Marguerita, ");
                valorSabores += 14.0;
            }
            if (checkPortuguesa.isChecked()) {
                sabores.append("Portuguesa, ");
                valorSabores += 16.0;
            }

            // Remove a última vírgula e espaço
            if (sabores.length() > 0) sabores.setLength(sabores.length() - 2);

            Intent intent = new Intent(MainActivity.this, TamanhoPagamentoActivity.class);
            intent.putExtra("saboresSelecionados", sabores.toString());
            intent.putExtra("valorSabores", valorSabores);
            startActivity(intent);
        });
    }
}