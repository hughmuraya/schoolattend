package com.jkuat.schoolattend.Welcome;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.jkuat.schoolattend.Login.LoginActivity;
import com.jkuat.schoolattend.R;
import com.jkuat.schoolattend.Register.RegisterLecturer;

public class WelcomePage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_page);
        setToolBar();
    }
    public void setToolBar(){

        try{


            getSupportActionBar().setTitle("Welcome to SchoolAttend");

        }
        catch(Exception e){


        }
    }
    public void goToRegister(View v){

        try{

            Intent myint=new Intent(getApplicationContext(), RegisterLecturer.class);
            startActivity(myint);

        }
        catch(Exception e){


        }
    }
    public void goToLogin(View v){

        try{

            Intent myint=new Intent(getApplicationContext(), LoginActivity.class);
            startActivity(myint);

        }
        catch(Exception e){


        }
    }

}
