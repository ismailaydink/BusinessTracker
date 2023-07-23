package com.example.projectf;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Button checkButton = findViewById(R.id.checkButton);
        checkButton.setOnClickListener(v->{

            Intent i = new Intent(MainActivity2.this,checkIn.class);
            startActivity(i);



        });
        Button foodButton = findViewById(R.id.foodButton);
        foodButton.setOnClickListener(v->{

            Intent i = new Intent(MainActivity2.this,foodCourt.class);
            startActivity(i);


        });

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();


    }
}