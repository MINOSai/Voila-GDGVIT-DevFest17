package com.minosai.voila;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    SharedPreferences sharedPreferences;

    FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sharedPreferences = getSharedPreferences("LoginStatus",MODE_PRIVATE);
        Intent intent = new Intent(MainActivity.this, LoginActivity.class);
        if(sharedPreferences.contains("isLoggedIn")){
            if(!sharedPreferences.getBoolean("isLoggedIn",false)){
                startActivity(intent);
            }
        }else {
            startActivity(intent);
        }

        fab = (FloatingActionButton)findViewById(R.id.addTransactionFab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                
            }
        });
    }
}
