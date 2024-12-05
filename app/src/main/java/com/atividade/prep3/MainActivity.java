package com.atividade.prep3;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText etN;
    private TextView tvRes;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        etN = findViewById(R.id.etN);
        etN.setTextAlignment(TextView.TEXT_ALIGNMENT_CENTER);
        Button btnCalcular = findViewById(R.id.btnCalcular);
        tvRes = findViewById(R.id.tvRes);
        tvRes.setTextAlignment(TextView.TEXT_ALIGNMENT_CENTER);

        btnCalcular.setOnClickListener(teamocolevati -> calc());
    }
    private void calc() {

        int N = Integer.parseInt(etN.getText().toString());
        String res;

        double dividendo, divisor, resultado, soma = 0;
        dividendo = 0;

        if(N < 0 || N > 20){
            res = getString(R.string.txtInvalido);
            tvRes.setText(res);
            etN.setText("");
        }else {
            for (int cta = 0; cta < N; cta++) {
                if (cta == 0) {
                    soma += 1;
                    dividendo = 2;
                }else {
                    if (dividendo % 2 == 0) {
                        divisor = dividendo * dividendo;
                        resultado = (dividendo / divisor);
                        soma -= (dividendo / divisor);
                        dividendo += 1;
                    }else {
                        divisor = dividendo * dividendo;
                        resultado = (dividendo / divisor);
                        soma += (dividendo / divisor);
                        dividendo += 1;
                    }
                }
            }
            res = getString(R.string.txtRes) + " " + soma;
            tvRes.setText(res);
            etN.setText("");
        }
    }
}