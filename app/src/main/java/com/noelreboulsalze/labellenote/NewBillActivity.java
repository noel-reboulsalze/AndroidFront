package com.noelreboulsalze.labellenote;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

import com.noelreboulsalze.labellenote.Objects.Bill;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by ysiguman on 24/05/18.
 */

public class NewBillActivity extends AppCompatActivity {
    Bill bill;
    Button createBtn;
    EditText type;
    EditText price;
    EditText quantity;

    CurrentUser currentUser;
    ConnectionInterface connectionInterface;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_bill);

        currentUser = new CurrentUser(this);

        bill = new Bill();
        createBtn = findViewById(R.id.createBtn);
        type = findViewById(R.id.type);
        price = findViewById(R.id.price);
        quantity = findViewById(R.id.quantity);

        createBtn.setOnClickListener(view -> createBill());
        connectionInterface = ApiClient.getClient().create(ConnectionInterface.class);
    }

    private void createBill() {
        bill.setType(type.getText().toString());
        bill.setPrice(Integer.parseInt(price.getText().toString()));
        bill.setQuantity(Integer.parseInt(quantity.getText().toString()));
        bill.setUserId(currentUser.getId());


        connectionInterface.createBIll(bill).enqueue(new Callback<ResponseBody>() {
            @Override
                public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                Log.i("### RESPONSE", "ok");
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Log.e("### ERROR", t.toString());
            }
        });
    }
}
