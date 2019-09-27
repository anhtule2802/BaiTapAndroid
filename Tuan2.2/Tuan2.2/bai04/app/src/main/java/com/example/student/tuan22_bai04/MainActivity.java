package com.example.student.tuan22_bai04;

import android.app.ListActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends ListActivity {
    ArrayList<String> lvlist;
    ArrayAdapter<String> adapter;
    Button btnNhap;
    EditText editTen;
    TextView tvPV;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTen = findViewById(R.id.editTen);
        tvPV = findViewById(R.id.tvPV);
        lvlist = new ArrayList<>();
        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,lvlist);
        setListAdapter(adapter);
        btnNhap = findViewById(R.id.btnNhap);
        btnNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lvlist.add(editTen.getText() + "");
                adapter.notifyDataSetChanged();
            }
        });
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        String item = (String)getListAdapter().getItem(position);
        tvPV.setText("position : " + position + "; value : " + item +"");
    }
}
