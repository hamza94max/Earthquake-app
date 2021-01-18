package com.example.hamza.earth;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;

import org.json.JSONException;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // Create a fake list of earthquake locations.
        ArrayList<Model> earthquakess = QueryUtils.extractEarthquakes();



        RecyclerView recyclerView=findViewById(R.id.rec);
        final RecAdapterr adapter=new RecAdapterr(earthquakess,getApplicationContext());
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);


        adapter.setListner(item -> {
            int index= (int) item;

            Uri earthquakeUri = Uri.parse(earthquakess.get(index).getUrl());
            Intent intent =new Intent(Intent.ACTION_VIEW,earthquakeUri);
            startActivity(intent);

        });


    }
}