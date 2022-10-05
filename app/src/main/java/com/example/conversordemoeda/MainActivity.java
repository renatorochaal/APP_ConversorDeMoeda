package com.example.conversordemoeda;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    protected EditText editValor;
    protected EditText valorDolar;
    protected EditText valorEuro;
    protected Button botaoConverter;
    protected Button botaoLimpar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editValor = findViewById(R.id.editValorReal);
        valorDolar = findViewById(R.id.ValorEmDolar);
        valorEuro = findViewById(R.id.valorEmEuro);
        botaoConverter = findViewById(R.id.botaoConverter);
        botaoLimpar = findViewById(R.id.botaoLimpar);

        botaoConverter.setOnClickListener(this);
        botaoLimpar.setOnClickListener(this);
        this.limpaValores();
    }

    private void limpaValores() {
        editValor.setText(R.string.zero);
        valorDolar.setText(R.string.zero);
        valorEuro.setText(R.string.zero);

    }

    @Override
    public void onClick(View view) {
        if(view.getId()== R.id.botaoConverter)
        {
            String valor = editValor.getText().toString();
            if("".equals(valor))
                Toast.makeText(this, R.string.informe_valor, Toast.LENGTH_LONG).show();
            else
            {
                double real = Double.parseDouble(valor);
                valorDolar.setText(String.format("%.2f",real/5.25));
                valorEuro.setText(String.format("%.2f",real/5.19));
            }
        }
        else if (view.getId() == R.id.botaoLimpar)
        {
            this.limpaValores();
        }
    }
}