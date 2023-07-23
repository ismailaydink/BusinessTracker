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

import com.google.android.material.snackbar.Snackbar;

import java.util.concurrent.ExecutorService;

public class checkIn extends AppCompatActivity {

    TextView txt;
    Handler handler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(@NonNull Message message) {

            txt.setText(message.obj.toString());
            txt.setVisibility(View.VISIBLE);


            return true;

        }
    });


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_in);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        EditText idText = findViewById(R.id.idCheck);
        txt = findViewById(R.id.infotxt);
        txt.setVisibility(View.INVISIBLE);
        CheckRepo repo = new CheckRepo();
        ExecutorService srv = ((LogIn)getApplication()).srv;

        Button checkInBtn = findViewById(R.id.checkInBtn);
        checkInBtn.setOnClickListener(v->{

            if(idText.getText().toString().equals("")){

                txt.setText("Please enter id");
                txt.setVisibility(View.VISIBLE);



            }
            else{

                repo.checkInFunc(srv,handler,idText.getText().toString());


            }


        });

        Button checkOutBtn = findViewById(R.id.checkOutBtn);

        checkOutBtn.setOnClickListener(v->{

            if(idText.getText().toString().equals("")){

                txt.setText("Please enter id");
                txt.setVisibility(View.VISIBLE);
            }
            else{

                repo.checkOutFunc(srv,handler,idText.getText().toString());

            }


        });

    }




}