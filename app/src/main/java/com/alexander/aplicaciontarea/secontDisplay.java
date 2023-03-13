package com.alexander.aplicaciontarea;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class secontDisplay extends AppCompatActivity {

    public float numberOneG;
    EditText ladoUno, ladoDos, ladoTres;
    TextView result;
    Button calculate;
    String TAG = "DepuraciónP2";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secont_display);

        ladoUno = findViewById(R.id.ladoUno);
        ladoDos = findViewById(R.id.ladoDos);
        ladoTres = findViewById(R.id.ladoTres);
        result = findViewById(R.id.result);
        ladoUno.setText(String.valueOf(getIntent().getFloatExtra("numberOne",0)));
        ladoDos.setText(String.valueOf(getIntent().getFloatExtra("numberTwo",0)));
        ladoTres.setText(String.valueOf(getIntent().getFloatExtra("numberThree",0)));
        result.setText(String.valueOf(getIntent().getFloatExtra("result",0)));
    }
}