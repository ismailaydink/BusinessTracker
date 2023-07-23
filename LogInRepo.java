package com.example.projectf;

import android.os.Handler;
import android.os.Message;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.concurrent.ExecutorService;


public class LogInRepo {


    public void logInFunc(ExecutorService srv, Handler logInHandler, String username, String password){


        srv.execute(()-> {

            try {
                URL url = new URL("http://192.168.1.24:8082/firstservice/login/login/" + username + "/" + password);
                HttpURLConnection conn =
                        (HttpURLConnection)url.openConnection();


                BufferedReader reader =
                        new BufferedReader(new InputStreamReader(conn.getInputStream()));
                StringBuilder buffer = new StringBuilder();

                String line ="";

                while ((line = reader.readLine()) != null){

                    buffer.append(line);
                }

                Message msg = new Message();
                msg.obj = buffer.toString();
                logInHandler.sendMessage(msg);

                conn.disconnect();

            } catch (MalformedURLException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }


        });

    }
}
