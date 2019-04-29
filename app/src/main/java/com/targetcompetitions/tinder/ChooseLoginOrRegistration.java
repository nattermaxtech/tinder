package com.targetcompetitions.tinder;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.support.v7.widget.Toolbar;
import android.content.Intent;

public class ChooseLoginOrRegistration extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_login_or_registration);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }


    public void onLoginButtonClick(View view){
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }

    public void onRegistrationButtonClick(View view){
        Intent intent = new Intent(this, RegistrationActivity.class);
        startActivity(intent);
    }
}
