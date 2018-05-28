package com.noelreboulsalze.labellenote;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.noelreboulsalze.labellenote.Objects.History;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by ysiguman on 28/05/18.
 */

public class HistoryActivity extends AppCompatActivity{
    CurrentUser currentUser;
    ConnectionInterface connectionInterface;
    List<History> histories;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        RecyclerView recyclerView = findViewById(R.id.history);
        LinearLayoutManager verticalLayoutMng
                = new LinearLayoutManager(HistoryActivity.this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(verticalLayoutMng);

        histories = new ArrayList<>();

        currentUser = new CurrentUser(this);
        connectionInterface = ApiClient.getClient().create(ConnectionInterface.class);
        HistoryAdapter historyAdapter = new HistoryAdapter(this, histories);
        recyclerView.setAdapter(historyAdapter);

        connectionInterface.getHistory(currentUser.getId()).enqueue(new Callback<List<History>>() {
            @Override
            public void onResponse(Call<List<History>> call, Response<List<History>> response) {
                for (History history : response.body()) {
                    histories.add(new History(
                            history.getTotal_frais(),
                            history.getId_demande(),
                            history.getCreation_note(),
                            history.getState()
                    ));
                }
                historyAdapter.notifyDataSetChanged();
                Log.i("### INFO", String.valueOf(historyAdapter.getItemCount()));
            }

            @Override
            public void onFailure(Call<List<History>> call, Throwable t) {
                Log.e("### ERROR", t.toString());
            }
        });



    }
}
