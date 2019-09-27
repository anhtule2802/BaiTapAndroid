package com.example.bai03;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText editA;
    EditText editB;
    Button btnTinh;
    TextView txtKetQua;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editA = findViewById(R.id.editA);
        editB = findViewById(R.id.editB);
        btnTinh = findViewById(R.id.btnTinh);
        txtKetQua = findViewById(R.id.txtKetQua);
        btnTinh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                float a  = Float.parseFloat(editA.getText().toString());
                float b = Float.parseFloat(editB.getText().toString());
                float kq = -b/a;
                if(a!=0)
                {
                    txtKetQua.setText("x = "+kq);
                }
                else
                {
                    txtKetQua.setText("Không phải là pt bậc 1");
                }
            }
        });
    }
}
