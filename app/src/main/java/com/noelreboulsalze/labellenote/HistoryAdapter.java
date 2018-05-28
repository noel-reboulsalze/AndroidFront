package com.noelreboulsalze.labellenote;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.noelreboulsalze.labellenote.Objects.History;

import java.util.List;

/**
 * Created by ysiguman on 28/05/18.
 */

public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.ViewHolder> {
    Context context;
    List<History> histories;
    private LayoutInflater mInflater;

    public HistoryAdapter(Context context, List<History> histories) {
        this.context = context;
        this.histories = histories;
        this.mInflater = LayoutInflater.from(context);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.adapter_history, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public int getItemCount() {
        return histories.size();
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
         History history = histories.get(position);

         holder.creationNote.setText("Date : " + history.getCreation_note());
         holder.price.setText(history.getTotal_frais() + " €");
         holder.state.setText("Etat : " + history.getState());
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView creationNote;
        public TextView price;
        public TextView state;

        ViewHolder(View view) {
            super(view);
            creationNote = view.findViewById(R.id.creation_note);
            price = view.findViewById(R.id.price);
            state = view.findViewById(R.id.state);
        }
    }
}
