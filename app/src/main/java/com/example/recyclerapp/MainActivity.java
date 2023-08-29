package com.example.recyclerapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements ItemClickListner {

    //1- AdapterView: RecyclerView
    RecyclerView recyclerView;

    //2- Data source:
    VaccineModel[] myListData;

    //3- Adapter
    MyAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        myListData = new VaccineModel[]{
                new VaccineModel(R.drawable.vaccine1,"Vaccine 1"),
                new VaccineModel(R.drawable.vaccine8,"Vaccine 2"),
                new VaccineModel(R.drawable.vaccine9,"Vaccine 3"),
                new VaccineModel(R.drawable.vaccine4,"Vaccine 4"),
                new VaccineModel(R.drawable.vaccine5,"Vaccine 5"),
                new VaccineModel(R.drawable.vaccine6,"Vaccine 6"),
                new VaccineModel(R.drawable.vaccine7,"Vaccine 7"),
        };

        adapter = new MyAdapter(myListData);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        //Handling the click Events
        adapter.setClickListner(this);
    }

    @Override
    public void onClick(View view, int pos) {
        Toast.makeText(this,"Vaccine Name: "+myListData[pos].getVaccineName(),Toast.LENGTH_LONG ).show();
    }
}