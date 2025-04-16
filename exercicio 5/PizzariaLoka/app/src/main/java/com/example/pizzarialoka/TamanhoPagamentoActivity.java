package com.example.pizzarialoka;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class TamanhoPagamentoActivity extends AppCompatActivity {

    RadioGroup radioGroupTamanho, radioGroupPagamento;
    Button btnConfirmar;

    String tipoPizzaSelecionada;
    double valorSabores;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tamanho_pagamento);

        radioGroupTamanho = findViewById(R.id.radioGroupTamanho);
        radioGroupPagamento = findViewById(R.id.radioGroupPagamento);
        btnConfirmar = findViewById(R.id.btnConfirmar);

        tipoPizzaSelecionada = getIntent().getStringExtra("saboresSelecionados");
        valorSabores = getIntent().getDoubleExtra("valorSabores", 0.0);

        btnConfirmar.setOnClickListener(v -> {
            int tamanhoSelecionadoId = radioGroupTamanho.getCheckedRadioButtonId();
            int pagamentoSelecionadoId = radioGroupPagamento.getCheckedRadioButtonId();

            if (tamanhoSelecionadoId == -1 || pagamentoSelecionadoId == -1) {
                Toast.makeText(TamanhoPagamentoActivity.this, "Selecione o tamanho e o pagamento!", Toast.LENGTH_SHORT).show();
                return;
            }

            RadioButton rbTamanho = findViewById(tamanhoSelecionadoId);
            RadioButton rbPagamento = findViewById(pagamentoSelecionadoId);

            String tamanho = rbTamanho.getText().toString();
            String pagamento = rbPagamento.getText().toString();
            double valorTamanho = calcularPreco(tamanho);

            double valorTotal = valorSabores + valorTamanho;

            Intent intent = new Intent(TamanhoPagamentoActivity.this, ResumoPedidoActivity.class);
            intent.putExtra("saboresSelecionados", tipoPizzaSelecionada);
            intent.putExtra("tamanho", tamanho);
            intent.putExtra("pagamento", pagamento);
            intent.putExtra("valor", valorTotal);
            startActivity(intent);
        });
    }

    private double calcularPreco(String tamanho) {
        if (tamanho.contains("Pequena")) return 20.0;
        if (tamanho.contains("Média")) return 30.0;
        if (tamanho.contains("Grande")) return 40.0;
        return 0.0;
    }
}