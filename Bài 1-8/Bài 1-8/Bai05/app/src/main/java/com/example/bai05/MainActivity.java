package com.example.bai05;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText editHoTen;
    Button btnTach;
    TextView txtHoTen;
    private String tachHoTen(String hoTen)
    {
        String[] tach = hoTen.split("\\s");
        hoTen = "Họ là "+tach[0]+"\nTên là "+tach[tach.length-1];
        return hoTen;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editHoTen = findViewById(R.id.editHoTen);
        btnTach = findViewById(R.id.btnTach);
        txtHoTen = findViewById(R.id.txtHoTen);
        btnTach.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               txtHoTen.setText(tachHoTen(editHoTen.getText().toString()));
            }
        });
    }
}
