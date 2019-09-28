package com.example.bai_03;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText editA,editB;
    Button btnChuyenl;
    ArrayList<String> arrayList = new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editA = findViewById(R.id.editA);
        editB = findViewById(R.id.editB);
        btnChuyenl = findViewById(R.id.btnChuyen);
        btnChuyenl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(v.getContext(),Main2Activity.class);
                arrayList.add("ABC");
                arrayList.add("ABC132");
                arrayList.add("ABC223");
                myIntent.putExtra("giatri1",arrayList);
                myIntent.putExtra("giatri2",editB.getText()+"");
                startActivity(myIntent);
            }
        });
    }
}
