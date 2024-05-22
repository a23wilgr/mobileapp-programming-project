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
//import java.util.List;

//@SuppressWarnings("FieldCanBeLocal")
public class MainActivity extends AppCompatActivity implements JsonTask.JsonTaskListener {

    //private final String JSON_FILE = "svamp.json";
    private final String JSON_URL = "https://mobprog.webug.se/json-api?login=a23wilgr";

    private ArrayList<Svamp> svamp = new ArrayList<>();

    private RecyclerViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        adapter = new RecyclerViewAdapter(this, svamp, new RecyclerViewAdapter.OnClickListener() {
            @Override
            public void onClick(Svamp svamp) {
                Toast.makeText(MainActivity.this, svamp.getName(), Toast.LENGTH_SHORT).show();
            }
        });

        recyclerView.setAdapter(adapter);

        //new JsonFile(this, this).execute(JSON_FILE);
        new JsonFile(this, this).execute(JSON_URL);
    }

    @Override
    public void onPostExecute(String json) {
        Gson gson = new Gson();
        Type type = new TypeToken<ArrayList<Svamp>>() {}.getType();
        ArrayList<Svamp> listOfSvamp = gson.fromJson(json, type);

        svamp.addAll(listOfSvamp);

        adapter.notifyDataSetChanged();
    }
}