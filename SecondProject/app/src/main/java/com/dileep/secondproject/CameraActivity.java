package com.dileep.secondproject;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

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

import com.bumptech.glide.Glide;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class CameraActivity extends AppCompatActivity {

    Button capture,saveBtn;
    ImageView imageView;
    Bitmap photo;
    File file;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);
        capture=findViewById(R.id.capture);
        imageView=findViewById(R.id.imageView2);
        saveBtn=findViewById(R.id.save);

        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, android.Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {


            ActivityCompat.requestPermissions(CameraActivity.this, new String[]{android.Manifest.permission.CAMERA, android.Manifest.permission.WRITE_EXTERNAL_STORAGE}, 501);
            return;
        }

        capture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent camera_intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                file = getOutputMediaFile();
                camera_intent.putExtra(MediaStore.EXTRA_OUTPUT, file);
                startActivityForResult(camera_intent, 200);

            }
        });
        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              saveFile(photo);
            }
        });


    }

    public void saveFile(Bitmap bitmap) {

        File file = getOutputMediaFile();
        FileOutputStream out = null;
        try {
            out = new FileOutputStream(file);

                if (out != null) {
                    out.flush();
                    out.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }



    public File getOutputMediaFile() {

        File mediaStorageDir = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES), "AndroidClasses");

//        File mediaStorageDir = new File(this.getFilesDir(), "VishwamFr");
        // Create the storage directory if it does not exist
        if (!mediaStorageDir.exists()) {
            if (!mediaStorageDir.mkdirs()) {
                Log.d("TAG", "failed to create directory");
                return null;
            }
        }
        File file = new File(mediaStorageDir.getPath()  + "androidCalss1.jpg");

        return file;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode==200){
            photo = (Bitmap) data.getExtras().get("data");

            Glide.with(CameraActivity.this)
                    .load(photo)
                    .into(imageView);
        }
    }
}