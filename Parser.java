package com.example.jisungkim.app;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class Parser extends AppCompatActivity {
    TextView name = (TextView) findViewById(R.id.name);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parser);

//        TextView name = (TextView)findViewById(R.id.name);
//        TextView price = (TextView)findViewById(R.id.price);
//        TextView explanation = (TextView)findViewById(R.id.explanation);
//        TextView type = (TextView)findViewById(R.id.type);

        ResConnection resConnection = new ResConnection();

        AsyncTask<String, String, String> result = resConnection.execute("","");

        System.out.println("RESULT");

        try {
            String msg = result.get();
            System.out.println(msg);

            name.setText(msg.toString());

        } catch (Exception e){
        }
    }

    public class ResConnection extends AsyncTask<String, String, String> {
        @Override
        protected String doInBackground(String... strings) {
            try {
                URL url = new URL("https://store.naver.com/restaurants/list?filterId=s11556056&query=성신여대%20맛집");
                System.out.println("Call target URL try....");
                try {
                    InputStream inputStream = url.openStream();
                    Scanner scanner = new Scanner(inputStream, "UTF-8");
                    System.out.println(scanner.nextLine());
                }
                catch (IOException ioe) {
                    System.out.println("IOException occured.");
                }
                while (true) {
                    try {}
                    catch (Exception e) {
                        e.printStackTrace();
                        break;
                    }
                }
            }catch(MalformedURLException me) { }
            return null;
        }
    }
}
