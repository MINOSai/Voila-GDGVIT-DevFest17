package com.minosai.voila;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    SharedPreferences sharedPreferences;
    private String m_Text = "";
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
                Intent intent = new Intent(MainActivity.this, NewTransaction.class);
                startActivity(intent);
//                alertDialogInput();
            }
        });
    }

    public void alertDialogInput(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Title");

        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(LinearLayout.VERTICAL);

        final EditText toPerson = new EditText(this);
        toPerson.setInputType(InputType.TYPE_CLASS_TEXT);
        toPerson.setHint("Person to send");
        toPerson.setBackground(null);

        final EditText toAmount = new EditText(this);
        toAmount.setInputType(InputType.TYPE_CLASS_NUMBER);
        toAmount.setHint("Amount to send");

        linearLayout.addView(toPerson);
        linearLayout.addView(toAmount);

        builder.setView(linearLayout);

        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                m_Text = toPerson.getText().toString();
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        builder.show();
    }
}
