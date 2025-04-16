package com.example.lanchefacil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ResumoActivity extends AppCompatActivity {

    TextView txtResumo;
    Button btnNovoPedido;
    ImageView imgPedidoConcluido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resumo);

        txtResumo = findViewById(R.id.txtResumo);
        btnNovoPedido = findViewById(R.id.btnNovoPedido);
        imgPedidoConcluido = findViewById(R.id.imgPedidoConcluido);

        Intent intent = getIntent();
        String nome = intent.getStringExtra("nomeCliente");
        String lanches = intent.getStringExtra("lancheEscolhido");

        String mensagem = "Pedido de: " + nome + "\n\nLanches escolhidos:\n" + lanches;
        txtResumo.setText(mensagem);

        btnNovoPedido.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent voltarInicio = new Intent(ResumoActivity.this, MainActivity.class);
                voltarInicio.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(voltarInicio);
            }
        });
    }
}