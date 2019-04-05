package com.jkuat.schoolattend.Register;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.jkuat.schoolattend.Login.LoginActivity;
import com.jkuat.schoolattend.R;

public class RegisterStudent extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_student);
        setToolBar();
    }
    public void setToolBar(){

        try{


            getSupportActionBar().setTitle("Register Student");

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
