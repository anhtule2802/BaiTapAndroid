package com.example.student.tuan22_bai03;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView lvList;
    Button btnNhap;
    EditText editTen;
    TextView tvPV;
    ArrayList<String> myList;
    ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTen = findViewById(R.id.editTen);
        btnNhap = findViewById(R.id.button);
        lvList = findViewById(R.id.lvList);
        tvPV = findViewById(R.id.tvPV);
        myList = new ArrayList<String>();
        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,myList);
        lvList.setAdapter(adapter);
        btnNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myList.add(editTen.getText()+"");
                adapter.notifyDataSetChanged();
            }
        });
        lvList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String msg = "position : " + i;
                msg += "; value :" + adapterView.getItemAtPosition(i).toString();
                tvPV.setText(msg);
            }
        });
    }
}
