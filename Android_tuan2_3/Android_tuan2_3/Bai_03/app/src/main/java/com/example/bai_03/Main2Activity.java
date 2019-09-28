package com.example.bai_03;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity {
    TextView tvA,tvB;
    Spinner spA;
    ArrayAdapter<String> adapterSpinner = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        tvA = findViewById(R.id.tvA);
        tvB = findViewById(R.id.textView2);
        spA = findViewById(R.id.spA);
        ArrayList<String> arrayList2 = getIntent().getExtras().getStringArrayList("giatri1");
        adapterSpinner = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,arrayList2);
        adapterSpinner.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spA.setAdapter(adapterSpinner);
        tvB.setText(getIntent().getExtras().getString("giatri2"));
    }

}
