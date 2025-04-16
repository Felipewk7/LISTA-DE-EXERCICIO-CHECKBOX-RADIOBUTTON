package com.example.calculodesalario;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText salaryInput;
    private RadioGroup radioGroup;
    private TextView resultText;
    private Button calculateButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        salaryInput = findViewById(R.id.salaryInput);
        radioGroup = findViewById(R.id.radioGroup);
        resultText = findViewById(R.id.resultText);
        calculateButton = findViewById(R.id.calculateButton);

        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String salaryStr = salaryInput.getText().toString();

                if (salaryStr.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Digite o salário", Toast.LENGTH_SHORT).show();
                    return;
                }

                double salary = Double.parseDouble(salaryStr);
                int selectedId = radioGroup.getCheckedRadioButtonId();

                double percent;
                if (selectedId == R.id.radio40) {
                    percent = 0.40;
                } else if (selectedId == R.id.radio45) {
                    percent = 0.45;
                } else if (selectedId == R.id.radio50) {
                    percent = 0.50;
                } else {
                    Toast.makeText(MainActivity.this, "Selecione um percentual de aumento", Toast.LENGTH_SHORT).show();
                    return;
                }

                double newSalary = salary + (salary * percent);
                String result = String.format("Salário reajustado: R$ %.2f", newSalary);
                resultText.setText(result);
            }
        });
    }
}