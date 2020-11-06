package com.geekteck.android1lesson4repeat;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<TitleModel> list;
    private Adapter adapter;
    private EditText text;
    private Button button;
    private TitleModel model;
    private String name;
    public static final String Key = "key";
    public static final int REQUEST_CODE = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupUI();
    }

    private void setupUI() {
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        list = new ArrayList<>();
        adapter = new Adapter(list, this);
        recyclerView.setAdapter(adapter);

        button = findViewById(R.id.button);
        text = findViewById(R.id.editText);


        button.setOnClickListener(v -> {
            String string = text.getText().toString();
            list.add(new TitleModel(string, "dankinson"));
            text.setText("");
            adapter.notifyDataSetChanged();
        });

    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelableArrayList("key", (ArrayList<? extends Parcelable>) list);
        Log.d(Key,"onSaveInstanceState: "+list.toString());
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
       list.addAll(savedInstanceState.getParcelableArrayList("key"));
    }
}