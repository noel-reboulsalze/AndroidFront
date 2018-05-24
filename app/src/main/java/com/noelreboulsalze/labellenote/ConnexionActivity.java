package com.noelreboulsalze.labellenote;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

import com.noelreboulsalze.labellenote.Objects.User;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by ysiguman on 24/05/18.
 */

public class ConnexionActivity extends AppCompatActivity{
    private EditText login;
    private EditText pass;
    private Button logBtn;

    User user;
    CurrentUser currentUser;
    ConnectionInterface connectionInterface;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connexion);

        user = new User();

        connectionInterface = ApiClient.getClient().create(ConnectionInterface.class);
        currentUser = new CurrentUser(this);

        login = findViewById(R.id.login);
        pass = findViewById(R.id.pass);

        logBtn = findViewById(R.id.logBtn);
        logBtn.setOnClickListener(view -> connection());
    }

    private void connection() {
        user.setLogin(this.login.getText().toString());
        user.setPass(this.pass.getText().toString());

        connectionInterface.connect(user).enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if (response.code() == 200) {
                    Log.i("### RESULT ", "ok");
                    user = response.body();

                    if (currentUser.isExist()) {
                        currentUser.clear();
                    }

                    currentUser.setLogin(user.getLogin());
                    currentUser.setType(user.getType());
                    currentUser.logs();


                    Intent intent = new Intent(ConnexionActivity.this, MenuActivity.class);
                    startActivity(intent);

                } else if (response.code() == 404){
                    Log.i("### RESULT ", "Not Found");
                } else {
                    Log.e("### ERROR", String.valueOf(response.code()));
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Log.e("### ERROR", t.toString());
            }
        });
    }
}
