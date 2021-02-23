package com.dileep.secondproject.MaterialUI;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.PopupMenu;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


import com.dileep.secondproject.R;
import com.google.firebase.auth.FirebaseAuth;

public class HomeActivity extends AppCompatActivity {


    Toolbar toolbar;
    Button popBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        toolbar = findViewById(R.id.toolbar);
        popBtn=findViewById(R.id.popBtn);


        setSupportActionBar(toolbar);

        /*Overflow menu */
        //1. menu create  ========= done
        //2. setting menu to the toolbar
        //3. actions for the options


        /* PopUp menu */

        //1. Create menu item
        //2. setting the menu to the required View (Buttons, TetViews, Layouts, etc...)


        popBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PopupMenu popupMenu=new PopupMenu(HomeActivity.this,popBtn);
                popupMenu.getMenuInflater().inflate(R.menu.popup_menu,popupMenu.getMenu());
                popupMenu.show();

                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {

                        switch (item.getItemId()){
                            case R.id.popSettings:
                                Toast.makeText(HomeActivity.this, "This is pop setting", Toast.LENGTH_SHORT).show();
                                return true;
                            case R.id.popLogout:
                                Toast.makeText(HomeActivity.this, "This is pop logout", Toast.LENGTH_SHORT).show();
                                return true;
                            case R.id.popAbout:
                                Toast.makeText(HomeActivity.this, "This is About page", Toast.LENGTH_SHORT).show();
                                return true;
                            default:
                                return true;
                        }
                    }
                });


            }
        });







    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.overflow_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.settings:
                Toast.makeText(this, "This is settings.", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.logout:
                makeLogout();
                Toast.makeText(this, "This is logout", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.search:
                Toast.makeText(this, "This is search", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }

    private void makeLogout() {
        FirebaseAuth.getInstance().signOut();

        Intent signupIntent = new Intent(HomeActivity.this, MaterialUIExample.class);
        startActivity(signupIntent);
        finish();
    }
}