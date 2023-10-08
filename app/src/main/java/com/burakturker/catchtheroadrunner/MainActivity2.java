package com.burakturker.catchtheroadrunner;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Random;

public class MainActivity2 extends AppCompatActivity {
    TextView textViewTime;
    TextView textViewScore;
    int number;
    int score;
    ImageView imageView1;
    ImageView imageView2;
    ImageView imageView3;
    ImageView imageView4;
    ImageView imageView5;
    ImageView imageView6;
    ImageView imageView7;
    ImageView imageView8;
    ImageView imageView9;
    ImageView[] imageArray;
    Runnable runnable;
    Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        number =0;
        textViewTime = findViewById(R.id.textViewTime);
        textViewScore = findViewById(R.id.textViewScore);
        imageView1 = findViewById(R.id.imageView1);
        imageView2 = findViewById(R.id.imageView2);
        imageView3 = findViewById(R.id.imageView3);
        imageView4 = findViewById(R.id.imageView4);
        imageView5 = findViewById(R.id.imageView5);
        imageView6 = findViewById(R.id.imageView6);
        imageView7 = findViewById(R.id.imageView7);
        imageView8 = findViewById(R.id.imageView8);
        imageView9 = findViewById(R.id.imageView9);
        imageArray = new ImageView[] {imageView1,imageView2,imageView3,imageView4,imageView5,imageView6,imageView7,imageView8,imageView9};
        score =0;

        HideRunner();


        new CountDownTimer(15000,1000){

            @Override
            public void onTick(long l) {
                //süre devam ederken
                textViewTime.setText("Time : "+l /1000);
            }

            @Override
            public void onFinish() {
                // süre bitince
                handler.removeCallbacks(runnable);
                textViewTime.setText("time is up!");
                for (ImageView image:imageArray){
                    image.setVisibility(View.INVISIBLE);
                }
                AlertDialog.Builder timeAlert = new AlertDialog.Builder(MainActivity2.this);
                timeAlert.setTitle("Restart");
                timeAlert.setMessage("are you sure to restart game ?");
                timeAlert.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent = getIntent();
                        finish();
                        startActivity(intent);
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

    public  void Score(View view){
        textViewScore.setText("score : "+score);
        score++;
        textViewScore.setText("score : "+score);
    }

    public void HideRunner(){
        handler = new Handler();
        runnable = new Runnable() {
            @Override
            public void run() {
                for (ImageView image:imageArray){
                    image.setVisibility(View.INVISIBLE);
                }
                Random random = new Random();
                int r = random.nextInt(9);
                imageArray[r].setVisibility(View.VISIBLE);
                handler.postDelayed(this,1000);
            }
        };
        handler.post(runnable);

    }





}
