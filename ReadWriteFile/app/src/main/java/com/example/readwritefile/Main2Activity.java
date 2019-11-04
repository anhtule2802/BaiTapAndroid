package com.example.readwritefile;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {
    Button btnBack;
    TextView tvTenFile;
    EditText editContent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        btnBack = findViewById(R.id.btnBack);
        tvTenFile = findViewById(R.id.tvTenFile);
        editContent = findViewById(R.id.editContent);
        tvTenFile.setText(getIntent().getExtras().getString("name"));
        editContent.setText(getIntent().getExtras().getString("content"));
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
