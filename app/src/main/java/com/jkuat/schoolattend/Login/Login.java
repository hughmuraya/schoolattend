package com.jkuat.schoolattend.Login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.jkuat.schoolattend.Attendance.Attendance;
import com.jkuat.schoolattend.Attendance.ScanID;
import com.jkuat.schoolattend.R;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);
        setToolBar();
    }
    public void setToolBar(){

        try{


            getSupportActionBar().setTitle("Sign In");

        }
        catch(Exception e){


        }
    }
    public void goToAttend(View v){

        try{

            Intent Button=new Intent(getApplicationContext(), Attendance.class);
            startActivity(Button);

        }
        catch(Exception e){


        }
    }
}
