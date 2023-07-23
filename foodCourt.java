package com.example.projectf;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.concurrent.ExecutorService;


public class foodCourt extends AppCompatActivity {

    Handler handler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(@NonNull Message message) {
            txt.setText(message.obj.toString());
            txt.setVisibility(View.VISIBLE);

            return true;
        }
    });
    TextView txt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_court);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }


        txt = findViewById(R.id.textWow);
        txt.setVisibility(View.INVISIBLE);
        EditText idView = findViewById(R.id.idText);

        Button meatButt = findViewById(R.id.meatButton);
        meatButt.setOnClickListener(v->{

            if (idView.getText().toString().equals("")){

                txt.setText("Please enter ID");
                txt.setVisibility(View.VISIBLE);
            }
            else{
                ExecutorService srv = ((LogIn)getApplication()).srv;
                foodRepo repo = new foodRepo();
                repo.eatMeat(srv,handler, idView.getText().toString());
            }


        });
        Button foodBtn = findViewById(R.id.vegetableButton);
        foodBtn.setOnClickListener(v->{

            if (idView.getText().toString().equals("")){

                txt.setText("Please enter ID");
                txt.setVisibility(View.VISIBLE);
            }
            else  {

                ExecutorService srv = ((LogIn)getApplication()).srv;
                foodRepo repo = new foodRepo();
                repo.eatVegetable(srv,handler,idView.getText().toString());
            }

        });

        Button fishBtn = findViewById(R.id.fishButton);
        fishBtn.setOnClickListener(v->{

            if (idView.getText().toString().equals("")){

                txt.setText("Please enter ID");
                txt.setVisibility(View.VISIBLE);
            }
            else  {

                ExecutorService srv = ((LogIn)getApplication()).srv;
                foodRepo repo = new foodRepo();
                repo.eatFish(srv,handler,idView.getText().toString());
            }

        });
    }
}