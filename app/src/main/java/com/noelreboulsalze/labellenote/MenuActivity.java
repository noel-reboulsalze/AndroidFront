package com.noelreboulsalze.labellenote;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by ysiguman on 24/05/18.
 */

public class MenuActivity extends AppCompatActivity {
    Button logout;
    Button btn1;
    Button btn2;
    Button btn3;
    Button btn4;

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

        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);

        setBtnVisibility();
        setBtnAction();
    }

    private void setBtnAction() {
        btn1.setOnClickListener(view -> {
            Intent intent = new Intent(MenuActivity.this, NewBillActivity.class);
            startActivity(intent);
        });
        btn2.setOnClickListener(view -> {

        });
        btn3.setOnClickListener(view -> {

        });
        btn4.setOnClickListener(view -> {

        });
    }

    private void setBtnVisibility() {
        if (currentUser.getType().equals("admin")) {
            btn1.setVisibility(View.VISIBLE);
            btn2.setVisibility(View.VISIBLE);
            btn3.setVisibility(View.VISIBLE);
        }

        if (currentUser.getType().equals("salarie")) {
            btn1.setVisibility(View.VISIBLE);
            btn2.setVisibility(View.VISIBLE);
        }

        if (currentUser.getType().equals("comptable")) {
            btn1.setVisibility(View.VISIBLE);
            btn2.setVisibility(View.VISIBLE);
            btn4.setVisibility(View.VISIBLE);
        }
    }
}
