package com.alexander.aplicaciontarea;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.net.Uri;


public class MainActivity extends AppCompatActivity {

    String TAG = "Depuración";
    EditText ladoUno, ladoDos, LadoTres;
    TextView result;
    Button calculate;
    Button btnGoogle;
    Button btnAlarm;
    Button btnCall;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        android.util.Log.i(TAG, "Estoy en OnCreate");
        ladoUno = findViewById(R.id.ladoUno);
        ladoDos = findViewById(R.id.ladoDos);
        LadoTres = findViewById(R.id.ladoTres);
        result = findViewById(R.id.result);
        calculate = findViewById(R.id.btnCalculate);
        btnGoogle = findViewById(R.id.btnGoogle);
        btnAlarm = findViewById(R.id.btnAlarm);
        btnCall = findViewById((R.id.btnCall));

        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoActivity2(view);
            }
        });

        btnGoogle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToGoogle();
            }
        });

        btnAlarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String message = "Alarma desde Java";
                int hour = 19;
                int minutes = 30;
                createAlarm(message,hour,minutes);
            }
        });

        btnCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String numberPhone = "3004280212";
                dialPhoneNumber(numberPhone );
            }
        });
    }

    public void goToGoogle(){
        String url = "https://www.google.com";
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        startActivity(intent);
    }

    public void createAlarm(String message, int hour, int minutes) {
        Intent intent = new Intent(AlarmClock.ACTION_SET_ALARM)
                .putExtra(AlarmClock.EXTRA_MESSAGE, message)
                .putExtra(AlarmClock.EXTRA_HOUR, hour)
                .putExtra(AlarmClock.EXTRA_MINUTES, minutes);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }


    public void dialPhoneNumber(String phoneNumber) {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:" + phoneNumber));
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    @Override
    protected void onStart() {
        super.onStart();

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(TAG, "Estoy en onRestart: ");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "Estoy en onResume: ");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, " Estoy en onPause: ");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "Estoy en onDestroy: ");
    }

    //Creo una funcion, con nombre gotoActivity2, es publica y no espera nada de respuesta
    //Vire es el tipo de dato(en este caso,  un objeto que es la vista View)
    //view es el nombre del objeto que recibe la función

    public void gotoActivity2(View view) {

        float sideOne = Float.parseFloat(ladoUno.getText().toString());
        float sideTwo = Float.parseFloat(ladoDos.getText().toString());
        float sideThree = Float.parseFloat(LadoTres.getText().toString());
        float result = sideOne*sideTwo*sideThree;
        Log.i(TAG, String.valueOf(sideOne));
        Intent sendData = new Intent(this, secontDisplay.class);
        sendData.putExtra("numberOne", sideOne);
        sendData.putExtra("numberTwo", sideTwo);
        sendData.putExtra("numberThree", sideThree);
        sendData.putExtra("result", result);
        startActivity(sendData);
    }
}