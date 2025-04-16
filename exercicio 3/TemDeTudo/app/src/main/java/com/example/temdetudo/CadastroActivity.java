package com.example.temdetudo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class CadastroActivity extends AppCompatActivity {

    EditText inputNome;
    Button btnConfirmar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        inputNome = findViewById(R.id.inputNome);
        btnConfirmar = findViewById(R.id.btnEnviar);

        btnConfirmar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nomeCliente = inputNome.getText().toString();

                Intent intent = new Intent(CadastroActivity.this, ConfirmacaoActivity.class);
                intent.putExtra("nomeCliente", nomeCliente);
                startActivity(intent);
            }
        });
    }
}