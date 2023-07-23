package com.example.projectf;

import android.os.Handler;
import android.os.Message;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.ExecutorService;


public class CheckRepo {

    public void checkInFunc(ExecutorService srv, Handler handler, String id){

        srv.execute(()->{

            try {
                URL checkUrl = new URL("http://192.168.1.24:8082/firstservice/check/checkIn/" + id);
                HttpURLConnection conn = (HttpURLConnection)checkUrl.openConnection();

                BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));

                StringBuilder builder = new StringBuilder();
                String line ="";

                while ((line = reader.readLine()) != null){

                    builder.append(line);

                }

                Message msg = new Message();
                msg.obj = builder.toString();
                handler.sendMessage(msg);

                conn.disconnect();

            } catch (MalformedURLException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }


        });


    }
    public void checkOutFunc(ExecutorService srv, Handler handler, String id){

        srv.execute(()->{

            URL checkOutUrl = null;
            try {
                checkOutUrl = new URL("http://192.168.1.24:8082/firstservice/check/checkOut/" + id);
                HttpURLConnection conn = (HttpURLConnection) checkOutUrl.openConnection();

                BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));

                StringBuilder builder = new StringBuilder();
                String line = "";

                while((line= reader.readLine())!= null){

                    builder.append(line);

                }


                Message msg = new Message();

                msg.obj = builder.toString();

                handler.sendMessage(msg);

                conn.disconnect();



            } catch (MalformedURLException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }


        });


    }
}
