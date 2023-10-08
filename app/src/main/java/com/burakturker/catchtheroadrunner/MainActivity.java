package com.burakturker.catchtheroadrunner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    SharedPreferences sharedPreferences;
    TextView textScore;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sharedPreferences = getSharedPreferences("com.burakturker.CatchTheRoadRunner", Context.MODE_PRIVATE);
        textScore = findViewById(R.id.textScore);
        int LastScore = sharedPreferences.getInt("LastScore",0);
        textScore.setText("Last Score: "+LastScore);

    }

    public void start(View view){
        Intent intent =new Intent(MainActivity.this,MainActivity2.class);
        startActivity(intent);
    }
}