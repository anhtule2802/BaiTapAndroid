package com.example.bai01;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText txtCD;
    EditText txtCR;
    Button btnTinh;
    TextView tvDienTich;
    TextView tvChuVi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtCD = findViewById(R.id.txtCD);
        txtCR = findViewById(R.id.txtCR);
        btnTinh = findViewById(R.id.btnTinh);
        tvDienTich = findViewById(R.id.tvDienTich);
        tvChuVi = findViewById(R.id.tvChuVi);
        btnTinh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int CD = Integer.parseInt(txtCD.getText().toString());
                int CR = Integer.parseInt(txtCR.getText().toString());
                int dienTich = CD * CR;
                int chuVi = (CD + CR)*2;
                tvDienTich.setText("Diện Tích Hình Chữ Nhật:"+dienTich+"(cm)");
                tvChuVi.setText("Chu Vi Hình Chữ Nhật:"+chuVi+"(cm)");
            }
        });
    }
}
