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

public class foodRepo {

    public void eatMeat(ExecutorService srv, Handler handler,String id){


        srv.execute(()->{

            try {
                URL meatUrl = new URL("http://192.168.1.24:8082/firstservice/eatfood/eat/"+id+"/Meat");
                HttpURLConnection conn = (HttpURLConnection)meatUrl.openConnection();
                BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                StringBuilder builder = new StringBuilder();

                String line ="";

                while((line = reader.readLine())!= null){

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
    public void eatVegetable(ExecutorService srv, Handler handler, String id){

        srv.execute(()->{

            try {
                URL meatUrl = new URL("http://192.168.1.24:8082/firstservice/eatfood/eat/"+id+"/Vegetable");
                HttpURLConnection conn = (HttpURLConnection)meatUrl.openConnection();
                BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                StringBuilder builder = new StringBuilder();

                String line ="";

                while((line = reader.readLine())!= null){

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
    public void eatFish(ExecutorService srv,Handler handler,String id){

        srv.execute(()->{

            try {
                URL meatUrl = new URL("http://192.168.1.24:8082/firstservice/eatfood/eat/"+id+"/Fish");
                HttpURLConnection conn = (HttpURLConnection)meatUrl.openConnection();
                BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                StringBuilder builder = new StringBuilder();

                String line ="";

                while((line = reader.readLine())!= null){

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
