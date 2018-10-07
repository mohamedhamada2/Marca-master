package com.example.miestro.marca;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        Thread thread = new Thread(){
            @Override
            public void run() {
                try {
                    sleep(5000);
                    if(connected()){
                    startActivity(new Intent(MainActivity.this,Display_List.class));
                        finish();
                    }else{
                        Toast.makeText(getApplicationContext()," no internet connection ",Toast.LENGTH_SHORT).show();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        };

        thread.start();






    }


    public void show_list(){

             //Toast.makeText(this," internet connected ",Toast.LENGTH_SHORT).show();
            startActivity(new Intent(MainActivity.this,Display_List.class));


    }


    private boolean connected(){

        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();

        return activeNetworkInfo != null && activeNetworkInfo.isConnected();

    }

}
