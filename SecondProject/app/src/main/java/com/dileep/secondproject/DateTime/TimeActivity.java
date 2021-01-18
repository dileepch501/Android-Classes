package com.dileep.secondproject.DateTime;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

import com.dileep.secondproject.R;

public class TimeActivity extends AppCompatActivity {

    Button submit;
    TimePicker timePicker;
    TextView timeTv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time);

        submit=findViewById(R.id.submit);
        timeTv=findViewById(R.id.TimeTv);
        timePicker=findViewById(R.id.timePicker);


        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
                    int hour= timePicker.getHour();
                    int minute= timePicker.getMinute();

                    timeTv.setText("Selected time: "+hour+":"+ minute);
                }
            }
        });

    }
}