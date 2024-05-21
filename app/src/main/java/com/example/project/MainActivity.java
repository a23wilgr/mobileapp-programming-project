package com.example.project;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;
import android.widget.Toolbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("FieldCanBeLocal")
public class MainActivity extends AppCompatActivity implements JsonTask.JsonTaskListener {

    private ArrayList<Svamp> svampArrayList=new ArrayList<>();
    private RecyclerViewAdapter adapter;
    private final String JSON_URL = "https://mobprog.webug.se/json-api?login=a23wilgr";
    //private final String JSON_FILE = "svamp.json";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        RecyclerView view = findViewById(R.id.recyclerview_item);
        view.setLayoutManager(new LinearLayoutManager(this));


        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this, svampArrayList, new RecyclerViewAdapter.OnClickListener() {
            @Override
            public void onClick(Svamp item) {
                Toast.makeText(MainActivity.this, item.toString(), Toast.LENGTH_SHORT).show();
            }
        });

        view.setAdapter(adapter);

        new JsonFile(this, this).execute(JSON_URL);

    }

    private void setSupportActionBar(Toolbar toolbar) {
    }

    @Override
    public void onPostExecute(String json) {
        Gson gson = new Gson();
        Type type = new TypeToken<List<Svamp>>() {}.getType();
        //svampArrayList = gson.fromJson(json, type);
        List<Svamp> svampList = gson.fromJson(json, type);

        svampArrayList.addAll(svampList);

        adapter.notifyDataSetChanged();
    }

}