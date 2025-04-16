package com.example.temdetudo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ConfirmacaoActivity extends AppCompatActivity {

    TextView textBoasVindas;
    Button btnVoltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmacao);

        textBoasVindas = findViewById(R.id.textBoasVindas);
        btnVoltar = findViewById(R.id.btnVoltar);

        String nome = getIntent().getStringExtra("nomeCliente");
        textBoasVindas.setText("Bem-vindo, " + nome + "!");

        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent voltar = new Intent(ConfirmacaoActivity.this, MainActivity.class);
                voltar.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(voltar);
            }
        });
    }
}