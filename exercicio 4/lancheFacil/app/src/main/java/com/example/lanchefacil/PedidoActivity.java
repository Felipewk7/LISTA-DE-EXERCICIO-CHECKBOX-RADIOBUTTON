package com.example.lanchefacil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class PedidoActivity extends AppCompatActivity {

    EditText inputNome;
    CheckBox checkHamburguer, checkPizza, checkHotdog;
    Button btnConfirmar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pedido);

        inputNome = findViewById(R.id.inputNome);
        checkHamburguer = findViewById(R.id.checkHamburguer);
        checkPizza = findViewById(R.id.checkPizza);
        checkHotdog = findViewById(R.id.checkHotdog);
        btnConfirmar = findViewById(R.id.btnConfirmar);

        btnConfirmar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nome = inputNome.getText().toString();
                StringBuilder pedido = new StringBuilder();

                if (checkHamburguer.isChecked()) pedido.append("Hambúrguer\n");
                if (checkPizza.isChecked()) pedido.append("Pizza\n");
                if (checkHotdog.isChecked()) pedido.append("Hot Dog\n");

                Intent intent = new Intent(PedidoActivity.this, ResumoActivity.class);
                intent.putExtra("nomeCliente", nome);
                intent.putExtra("lancheEscolhido", pedido.toString());
                startActivity(intent);
            }
        });
    }
}