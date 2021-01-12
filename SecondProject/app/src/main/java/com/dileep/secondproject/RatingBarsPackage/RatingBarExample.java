package com.dileep.secondproject.RatingBarsPackage;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.solver.widgets.analyzer.VerticalWidgetRun;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.Toast;

import com.dileep.secondproject.R;

public class RatingBarExample extends AppCompatActivity {

    RatingBar ratingBar;
    Button submit;

    WebView webView;
    SeekBar seekBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rating_bar_example);
        ratingBar=findViewById(R.id.ratingbar);
        submit=findViewById(R.id.submit);
        webView=findViewById(R.id.webview);
        seekBar=findViewById(R.id.seekbar);


seekBar.setProgress(50);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
//                Toast.makeText(RatingBarExample.this, String.valueOf(progress), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(RatingBarExample.this, String.valueOf(ratingBar.getRating()), Toast.LENGTH_SHORT).show();

                webView.loadUrl("https://www.javatpoint.com/android-seekbar-example");
//                webView.getSettings().setJavaScriptEnabled(true);

            }
        });
    }
}