package com.example.projectf;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;

import java.util.concurrent.ExecutorService;

public class MainActivity extends AppCompatActivity {


    TextView txt;
    Handler handler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(@NonNull Message message) {

            if (message.obj.toString().equals("Wrong password") || message.obj.toString().equals("User doesn't exists")){

                txt.setText(message.obj.toString());
                txt.setVisibility(View.VISIBLE);


            }
            else{

                Intent intent = new Intent(MainActivity.this,MainActivity2.class);
                startActivity(intent);


            }

            return false;
        }
    });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txt = findViewById(R.id.textView3);

        txt.setVisibility(View.INVISIBLE);



        EditText username = findViewById(R.id.editTextTextPersonName2);
        EditText password = findViewById(R.id.editTextTextPassword);

        Button button = findViewById(R.id.button);


        button.setOnClickListener(v->{

            String usernameStr = username.getText().toString();
            String passwordStr = password.getText().toString();

            ExecutorService srv = ((LogIn)getApplication()).srv;
            LogInRepo repo = new LogInRepo();

            repo.logInFunc(srv,handler,usernameStr,passwordStr);

        });
    }
}