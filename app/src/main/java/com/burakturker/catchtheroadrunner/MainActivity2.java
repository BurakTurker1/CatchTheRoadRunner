package com.burakturker.catchtheroadrunner;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity2 extends AppCompatActivity {
    TextView textViewTime;
    TextView textViewScore;
    int number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        number =0;
        textViewTime = findViewById(R.id.textViewTime);
        textViewScore = findViewById(R.id.textViewScore);
        new CountDownTimer(15000,1000){

            @Override
            public void onTick(long l) {
                textViewTime.setText("Time : "+l /1000);
            }

            @Override
            public void onFinish() {
                // süre bitince
                textViewTime.setText("time is up!");
                AlertDialog.Builder timeAlert = new AlertDialog.Builder(MainActivity2.this);
                timeAlert.setTitle("Restart");
                timeAlert.setMessage("are you sure to restart game ?");
                timeAlert.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        // oyunu yeniden başlatma
                    }
                });

                timeAlert.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        //menü ye dönme
                        Intent intent =new Intent(MainActivity2.this,MainActivity.class);
                        startActivity(intent);
                    }
                });
                timeAlert.show();


            }
        }.start();
    }
}
