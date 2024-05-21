package com.example.project;

import android.os.Bundle;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements JsonTask.JsonTaskListener {

    private ArrayList<Svamp> svampArrayList = new ArrayList<>();
    private RecyclerViewAdapter adapter;
    //private final String JSON_FILE = "svamp.json";
    private final String JSON_URL = "https://mobprog.webug.se/json-api?login=a23wilgr";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        RecyclerView view = findViewById(R.id.recyclerview_item);
        view.setLayoutManager(new LinearLayoutManager(this));

        adapter = new RecyclerViewAdapter(this, svampArrayList, new RecyclerViewAdapter.OnClickListener() {
            @Override
            public void onClick(Svamp item) {
                Toast.makeText(MainActivity.this, item.toString(), Toast.LENGTH_SHORT).show();
            }
        });

        view.setAdapter(adapter);

        //new JsonFile(this, this).execute(JSON_FILE);
        new JsonFile(this, this).execute(JSON_URL);
    }

    @Override
    public void onPostExecute(String json) {
        Gson gson = new Gson();
        Type type = new TypeToken<List<Svamp>>() {}.getType();
        List<Svamp> svampList = gson.fromJson(json, type);

        svampArrayList.clear();
        svampArrayList.addAll(svampList);

        adapter.notifyDataSetChanged();
    }
}
