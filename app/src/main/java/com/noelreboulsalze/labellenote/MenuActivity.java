package com.noelreboulsalze.labellenote;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

/**
 * Created by ysiguman on 24/05/18.
 */

public class MenuActivity extends AppCompatActivity {
    Button logout;
    CurrentUser currentUser;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        currentUser = new CurrentUser(this);

        logout = findViewById(R.id.logout);
        logout.setOnClickListener(view -> {
            currentUser.clear();

            Intent intent = new Intent(MenuActivity.this, MainActivity.class);
            startActivity(intent);
        });
    }
}
