package com.dileep.secondproject.CameraPackage;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.FileProvider;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.dileep.secondproject.CameraActivity;
import com.dileep.secondproject.R;

import java.io.File;
import java.io.FileOutputStream;

public class SampleCamera extends AppCompatActivity {

    Button captureBtn,saveBtn;
    ImageView imageView;
    Bitmap photo;
    File output;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sample_camera);

        captureBtn=findViewById(R.id.captureBtn);
        imageView=findViewById(R.id.imageView);
        saveBtn=findViewById(R.id.saveBtn);

        //run time permissions
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CAMERA)!=PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this,Manifest.permission.WRITE_EXTERNAL_STORAGE)  !=PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this,Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED ){
            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.CAMERA,Manifest.permission.WRITE_EXTERNAL_STORAGE,Manifest.permission.READ_EXTERNAL_STORAGE},100);
        }



        captureBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent cameraIntent=new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
                startActivityForResult(cameraIntent,101);
            }
        });

        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (photo != null) {

                    // external storage
//                    File file1=new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS),"androidExample2.jpg");
//                    File mediaStorageDir = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS), "dileep.jpg");

                    //internal storage

                    File internal=new File(getApplicationContext().getFilesDir(),"internalStoargeImage.jpg");
//                    File mediaStorageDir = new File(getApplicationContext().getFilesDir(), "VishwamFR");


                    try {
                        FileOutputStream outjhjdf = new FileOutputStream(internal);

                        photo.compress(Bitmap.CompressFormat.JPEG, 100, outjhjdf);


                        outjhjdf.flush();
                        outjhjdf.close();
                        Toast.makeText(SampleCamera.this, "File is saved", Toast.LENGTH_SHORT).show();
                        Log.e("filePath:",internal.getPath());

                    } catch (Exception e) {
                        e.printStackTrace();
                        Toast.makeText(SampleCamera.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }else {
                    Toast.makeText(SampleCamera.this, "Photo is empty", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode==101){

            photo = (Bitmap) data.getExtras().get("data");

//            imageView.setImageBitmap(photo);

            Glide.with(SampleCamera.this)
                    .load(photo)
                    .into(imageView);

        }



    }
}