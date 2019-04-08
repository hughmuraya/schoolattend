package com.jkuat.schoolattend.Welcome;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.jkuat.schoolattend.Login.Login;
import com.jkuat.schoolattend.Login.LoginActivity;
import com.jkuat.schoolattend.R;
import com.jkuat.schoolattend.Register.RegisterLecturer;
import com.jkuat.schoolattend.Register.RegisterStudent;

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
    public void gotoRegister(View u){
        Intent newint= new Intent(getApplicationContext(),RegisterLecturer.class);
        startActivity(newint);
    }
    public void goToLogin(View v){

        try{

            Intent myint=new Intent(getApplicationContext(), Login.class);
            startActivity(myint);

        }
        catch(Exception e){


        }
    }

}
