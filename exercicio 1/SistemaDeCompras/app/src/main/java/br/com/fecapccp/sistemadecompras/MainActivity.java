package br.com.fecapccp.sistemadecompras;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    // Declaração dos CheckBoxes
    CheckBox cbArroz, cbLeite, cbCarne, cbFeijao, cbRefrigerante;
    Button btnCalcular;
    TextView tvTotal;

    // Valores dos produtos
    double precoArroz = 2.69;
    double precoLeite = 2.70;
    double precoCarne = 16.70;
    double precoFeijao = 3.38;
    double precoRefrigerante = 3.00;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inicializando as views
        cbArroz = findViewById(R.id.cb_arroz);
        cbLeite = findViewById(R.id.cb_leite);
        cbCarne = findViewById(R.id.cb_carne);
        cbFeijao = findViewById(R.id.cb_feijao);
        cbRefrigerante = findViewById(R.id.cb_refrigerante);

        btnCalcular = findViewById(R.id.btn_calcular);
        tvTotal = findViewById(R.id.tv_total);

        // Configuração do botão de calcular
        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double total = 0.0;

                // Verificando quais CheckBoxes estão marcados e somando os valores
                if (cbArroz.isChecked()) total += precoArroz;
                if (cbLeite.isChecked()) total += precoLeite;
                if (cbCarne.isChecked()) total += precoCarne;
                if (cbFeijao.isChecked()) total += precoFeijao;
                if (cbRefrigerante.isChecked()) total += precoRefrigerante;

                // Atualizando o TextView com o valor total
                tvTotal.setText(String.format("Total: R$ %.2f", total));
            }
        });
    }
}