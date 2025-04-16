package com.example.pizzarialoka;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ResumoPedidoActivity extends AppCompatActivity {

    TextView txtResumoFinal;
    Button btnVoltarInicio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resumo_pedido);

        txtResumoFinal = findViewById(R.id.txtResumoFinal);
        btnVoltarInicio = findViewById(R.id.btnVoltarInicio);

        Intent intent = getIntent();
        String sabores = intent.getStringExtra("saboresSelecionados");
        String tamanho = intent.getStringExtra("tamanho");
        String pagamento = intent.getStringExtra("pagamento");
        double valor = intent.getDoubleExtra("valor", 0.0);

        String resumo = "Sabores: " + sabores +
                "\nTamanho: " + tamanho +
                "\nPagamento: " + pagamento +
                "\n\nValor Total: R$" + String.format("%.2f", valor);

        txtResumoFinal.setText(resumo);

        btnVoltarInicio.setOnClickListener(v -> {
            Intent voltar = new Intent(this, MainActivity.class);
            voltar.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(voltar);
        });
    }
}

