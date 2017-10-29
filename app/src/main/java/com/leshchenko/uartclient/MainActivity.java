package com.leshchenko.uartclient;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.leshchenko.uard.CallbackUard;
import com.leshchenko.uard.Uard;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Uard uard = new Uard(new CallbackUard() {
            @Override
            public void result(String s) {
                Log.d("Result~",s);
            }
        });

        Button startBtn = findViewById(R.id.btnStart);
        Button stopBtn = findViewById(R.id.btnStop);

        startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                uard.openDevice(getApplicationContext());
            }
        });
        stopBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                uard.closeDevice();
            }
        });

    }
}
