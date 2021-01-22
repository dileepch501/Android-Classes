package com.dileep.secondproject.ImageLoaders;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.dileep.secondproject.R;

public class LoadImage extends AppCompatActivity {

    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load_image);
        imageView=findViewById(R.id.imageView);

//        imageView.setImageResource(R.drawable.placeholder);

        RequestOptions requestOptions=new RequestOptions();
        requestOptions.placeholder(R.drawable.placeholder);
//        requestOptions.centerCrop();

        String imageUrl="https://www.google.com/images/branding/googlelogo/1x/googlelogo_color_272x92d.png";

        Glide.with(this)
                .load(imageUrl)
                .apply(requestOptions)
                .into(imageView);

    }
}