package com.example.languageopinion;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.QuickContactBadge;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private EditText enter_mob,enter_pass;
    private Button login,change_lan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        enter_mob = findViewById(R.id.enter_mob);
        enter_pass = findViewById(R.id.enter_pass);
        login = findViewById(R.id.login);
        change_lan = findViewById(R.id.change_lan);

        change_lan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                changeLanguage();
            }
        });

    }

    private void changeLanguage() {

     final String language[] = {"Hindi","Marathi","Urdu"};
        AlertDialog.Builder mBuild = new AlertDialog.Builder(this);
        mBuild.setTitle("Chose Language");
        mBuild.setSingleChoiceItems(language, -1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                if (which==0){

                    setLocale("hi");
                    recreate();
                }
                else  if (which==1){

                    setLocale("mr");
                    recreate();
                }
                else  if (which==2){

                    setLocale("ur");
                    recreate();
                }
            }
        });
        mBuild.create();
        mBuild.show();
    }

    private void setLocale(String language){

        Locale locale = new Locale(language);
        Locale.setDefault(locale);

        Configuration configuration = new Configuration();
        configuration.setLocale(locale); //= locale;
        getBaseContext().getResources().updateConfiguration(configuration, getBaseContext().getResources().getDisplayMetrics());
    }
}