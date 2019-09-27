package com.example.bai04;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText editNum;
    Button btnBCC;
    TextView txtBCC;
    private String tinhBCC(int num)
    {
        String bcc = "";
        for(int i = 1;i<=10;i++)
        {
            int kq = num*i;
            bcc += num+" x "+i+"="+kq+"\n";
        }
        return bcc;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editNum = findViewById(R.id.editNum);
        btnBCC = findViewById(R.id.btnBCC);
        txtBCC = findViewById(R.id.txtBCC);
        btnBCC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtBCC.setText(tinhBCC(Integer.parseInt(editNum.getText().toString())));
            }
        });
    }
}
