package com.jkuat.schoolattend.Attendance;

import android.Manifest;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.hardware.Camera;
import android.net.Uri;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.google.zxing.Result;
import com.jkuat.schoolattend.R;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

import static android.Manifest.permission.CAMERA;


public class ScanID extends AppCompatActivity implements ZXingScannerView.ResultHandler{

    private static final int REQUEST_CAMERA= 1;
    private ZXingScannerView scannerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        scannerView= new ZXingScannerView(this);
        setContentView(scannerView);
        if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.M)
        {
            if (checkPermission())
            {
                Toast.makeText(ScanID.this, "Permission is granted", Toast.LENGTH_SHORT).show();
            }
            else
                {
                    requestPermission();
                }
        }
    }
    private boolean checkPermission()
    {
        return (ContextCompat.checkSelfPermission(ScanID.this, CAMERA)== PackageManager.PERMISSION_GRANTED);
    }
    private void requestPermission()
    {
        ActivityCompat.requestPermissions(this, new String[]{CAMERA},REQUEST_CAMERA);
    }

    public void onRequestPermissionResult(int requestCode, String permission[],int grantResult[])
    {
        switch (requestCode)
        {
            case REQUEST_CAMERA :
               if (grantResult.length >0)
               {
                   boolean cameraAccepted = grantResult[0] ==PackageManager.PERMISSION_GRANTED;
                   if (cameraAccepted)
                   {
                       Toast.makeText(ScanID.this, "Permission Granted", Toast.LENGTH_SHORT).show();
                   }
                   else
                       {
                           Toast.makeText(ScanID.this, "Permission Denied", Toast.LENGTH_SHORT).show();
                           if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M)
                           {
                               if (shouldShowRequestPermissionRationale(CAMERA))
                               {
                                   displayAlertMessage("You need to allow access for both permissions",
                                           new DialogInterface.OnClickListener() {
                                               @Override
                                               public void onClick(DialogInterface dialog, int which) {
                                                   requestPermissions(new String[]{CAMERA} , REQUEST_CAMERA);
                                               }
                                           });
                                   return;
                               }
                           }
                       }
               }
               break;

        }
    }

    @Override
    public void onResume()
    {
        super.onResume();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M)
        {
            if (scannerView == null)
            {
                scannerView = new ZXingScannerView(this);
                setContentView(scannerView);
            }
            scannerView.setResultHandler(this);
            scannerView.startCamera();
        }
        else
            {
                requestPermission();
            }
    }

    @Override
    public void onDestroy()
    {
        super.onDestroy();
        scannerView.stopCamera();
    }

     public void displayAlertMessage(String message, DialogInterface.OnClickListener listener)
     {
         new AlertDialog.Builder(ScanID.this)
                 .setMessage(message)
                 .setPositiveButton("OK", listener)
                 .setNegativeButton("Cancel", null)
                 .create()
                 .show();
     }


    @Override
    public void handleResult(Result result) {
        final String scanResult = result.getText();
        AlertDialog.Builder builder= new AlertDialog.Builder(this);
        builder.setTitle("Scan Result");
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                scannerView.resumeCameraPreview(ScanID.this);
            }
        });
        builder.setNeutralButton("Visit", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(scanResult));
                startActivity(intent);
            }
        });
        builder.setMessage(scanResult);
        AlertDialog alert = builder.create();
        alert.show();
    }
}
