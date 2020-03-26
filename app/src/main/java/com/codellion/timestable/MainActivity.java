package com.codellion.timestable;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView timesOfTable;
    ArrayList<String> timesList;
    ArrayAdapter<String> arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        timesOfTable = (ListView) findViewById(R.id.timesTableListView);
        timesList = new ArrayList<String>();
        arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, timesList);

        SeekBar tableOf = (SeekBar) findViewById(R.id.tableSeekbar);
        tableOf.setMax(20);
        tableOf.setProgress(0);
        tableOf.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                timesList.clear();
                Log.i("Tabel of: ", Integer.toString(progress));
                int ans = 0;
                String result, progressNum, into;

                for (int i = 0; i <= 10; i++){
                    ans = progress * i;
                    Log.i("Tabel of " + progress + " :", Integer.toString(ans));
                    result = Integer.toString(ans);
                    progressNum = Integer.toString(progress);
                    into = Integer.toString(i);
                    timesList.add(progressNum + " x " + into + " = " + result);
                }
                timesOfTable.setAdapter(arrayAdapter);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        timesList.clear();
    }
}
