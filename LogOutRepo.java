package com.example.projectf;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.ExecutorService;
import java.util.logging.Handler;

public class LogOutRepo {

    public void logOutFunc(ExecutorService srv, Handler logOutHandler){


        srv.execute(()->{

            try {
                URL logOutUrl= new URL("http://localhost:8082/firstservice/login/logout");
                HttpURLConnection conn = (HttpURLConnection)logOutUrl.openConnection();



            } catch (MalformedURLException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }


        });

    }
}
