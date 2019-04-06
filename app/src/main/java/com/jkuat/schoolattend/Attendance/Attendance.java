package com.jkuat.schoolattend.Attendance;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.zxing.Result;
import com.jkuat.schoolattend.R;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

public class Attendance extends AppCompatActivity  {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attendance);
    }

}
