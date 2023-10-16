package com.example.timestable;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView tableListView;
    public void generateTimesTable(int timesTableNumber) {
        ArrayList<String> timesTable = new ArrayList<String>();
        for(int i = 1; i <= 10; i++) {
            timesTable.add(Integer.toString(i * timesTableNumber));
        }
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, timesTable);
        tableListView.setAdapter(arrayAdapter);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tableListView = (ListView) findViewById(R.id.tableListView);
        SeekBar numberSeekBar =findViewById(R.id.numberSeekBar);
        tableListView = findViewById(R.id.tableListView);

        int max = 20;
        int startingPosition = 10;

        numberSeekBar.setMax(max);
        numberSeekBar.setProgress(startingPosition);

        generateTimesTable(startingPosition);

        numberSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                int min = 1;
                int timesTableNumber;
                if (progress < min) {
                    timesTableNumber = min;
                    numberSeekBar.setProgress(min);
                } else {
                    timesTableNumber = progress;
                }
                Log.i("test", Integer.toString(timesTableNumber));
                generateTimesTable(timesTableNumber);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}