package com.geekteck.android1lesson4repeat;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<MainViewHolder> {

    List<TitleModel> list;
    Context context;

    public Adapter(List<TitleModel> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public MainViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recyclerview, parent, false);
        return new MainViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MainViewHolder holder, int position) {
        TitleModel titleModel = list.get(position);
        holder.text.setText(titleModel.getText());
        holder.description.setText(titleModel.getDescription());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}

class MainViewHolder extends RecyclerView.ViewHolder {
    static TextView text, description;


    public MainViewHolder(@NonNull View itemView) {
        super(itemView);
        text = itemView.findViewById(R.id.text);
        description = itemView.findViewById(R.id.description);
    }

}

