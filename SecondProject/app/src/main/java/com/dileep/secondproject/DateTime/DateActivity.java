package com.dileep.secondproject.DateTime;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import com.dileep.secondproject.R;

public class DateActivity extends AppCompatActivity {

    Button submit;
    TextView dateTv;
    DatePicker datePicker;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date);
        submit=findViewById(R.id.submit);
        dateTv=findViewById(R.id.dateTv);
        datePicker=findViewById(R.id.datePicker);


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            datePicker.setOnDateChangedListener(new DatePicker.OnDateChangedListener() {
                @Override
                public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                    dateTv.setText("Selected date is:  "+String.valueOf(dayOfMonth)+"-"+String.valueOf(monthOfYear+1)+"-"+String.valueOf(year));

                }
            });
        }


        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int date=datePicker.getDayOfMonth();
                int month= datePicker.getMonth()+1;
                int year= datePicker.getYear();


                dateTv.setText("Selected date is:"+String.valueOf(date)+"-"+String.valueOf(month)+"-"+String.valueOf(year));
            }
        });
    }
}