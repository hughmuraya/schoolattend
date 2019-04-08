package com.jkuat.schoolattend.Attendance;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.google.zxing.Result;
import com.jkuat.schoolattend.Login.LoginActivity;
import com.jkuat.schoolattend.R;
import com.jkuat.schoolattend.Register.RegisterLecturer;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

public class Attendance extends AppCompatActivity  {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attendance);
        setToolBar();
    }
    public void setToolBar(){

        try{


            getSupportActionBar().setTitle("Attendance");

        }
        catch(Exception e){


        }
    }
    public void goToScan(View v){

        try{

            Intent myint=new Intent(getApplicationContext(), ScanID.class);
            startActivity(myint);

        }
        catch(Exception e){


        }
    }
    public void goToHome(View v){

        try{

            Intent myint1=new Intent(getApplicationContext(), LoginActivity.class);
            startActivity(myint1);

        }
        catch(Exception e){


        }
    }
}
