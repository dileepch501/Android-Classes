package com.dileep.secondproject.CameraPackage;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.dileep.secondproject.CameraActivity;
import com.dileep.secondproject.R;

public class SampleCamera extends AppCompatActivity {

    Button captureBtn;
    ImageView imageView;
    Bitmap photo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sample_camera);

        captureBtn=findViewById(R.id.captureBtn);
        imageView=findViewById(R.id.imageView);

        //run time permissions
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CAMERA)  !=PackageManager.PERMISSION_GRANTED ){
            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.CAMERA},100);
        }



        captureBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent cameraIntent=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(cameraIntent,101);
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