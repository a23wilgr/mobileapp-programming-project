package com.example.project;

import android.content.Intent;
import android.os.Bundle;

import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;


@SuppressWarnings("FieldCanBeLocal")
public class MainActivity extends AppCompatActivity implements JsonTask.JsonTaskListener {

    private ArrayList<Svamp> svamp = new ArrayList<>();
    private RecyclerViewAdapter adapter;

    //private final String JSON_FILE = "svamp.json";
    private final String JSON_URL = "https://mobprog.webug.se/json-api?login=a23wilgr";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
        new JsonTask(this).execute(JSON_URL);
    }

    @Override
    public void onPostExecute(String json) {
        Log.d("MainActivity", json);
        Gson gson = new Gson();
        Type type = new TypeToken<ArrayList<Svamp>>() {}.getType();
        ArrayList<Svamp> listWithSvamp = gson.fromJson(json, type);

        svamp.addAll(listWithSvamp);
        adapter.notifyDataSetChanged();
    }
}