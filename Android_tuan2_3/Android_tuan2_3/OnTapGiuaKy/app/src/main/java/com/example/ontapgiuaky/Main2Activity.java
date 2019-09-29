package com.example.ontapgiuaky;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity {
    EditText editMaNV,editTenNV;
    RadioButton rdNu,rdNam;
    Button btnUpdate;
    TextView tvPosition;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        editMaNV = findViewById(R.id.editMaNV);
        editTenNV = findViewById(R.id.editTenNV);
        rdNam = findViewById(R.id.rdNam);
        rdNu = findViewById(R.id.rdNu);
        btnUpdate = findViewById(R.id.btnUpdate);

        if(!getIntent().hasExtra("nv"))
        {
            btnUpdate.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ShowDiaLog(v);
                }
            });
        }
        else
        {
            NhanVien nv = (NhanVien) getIntent().getSerializableExtra("nv");
            editTenNV.setText(nv.getName());
            editMaNV.setText(nv.getId());
            if(nv.isGender())
            {
                rdNu.setChecked(true);
            }
            else
            {
                rdNam.setChecked(true);
            }
            btnUpdate.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ShowDiaLogUpdate(v);
                }
            });
        }
    }
    public void ShowDiaLog(final View v){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Thêm nhân viên");
        builder.setMessage("Bạn có muốn thêm không ?");
        builder.setCancelable(false);
        builder.setPositiveButton("Có", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent add = new Intent(v.getContext(),MainActivity.class);
                setResult(RESULT_OK,add);
                dialog.dismiss();
                finish();
            }
        });
        builder.setNegativeButton("Không", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    public void ShowDiaLogUpdate(final View v){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Cập nhật nhân viên");
        builder.setMessage("Bạn có muốn cập nhật không ?");
        builder.setCancelable(false);
        builder.setPositiveButton("Có", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                int pos = getIntent().getExtras().getInt("pos");
                boolean gender = false;
                if(rdNu.isChecked())
                {
                    gender = true;
                }
                else
                {
                    gender = false;
                }
                NhanVien nv = new NhanVien(editMaNV.getText().toString(),editTenNV.getText().toString(),gender);
                Intent update1 = new Intent(v.getContext(),MainActivity.class);
                update1.putExtra("pos",pos);
                update1.putExtra("nhanvien",nv);
                setResult(RESULT_OK,update1);
                dialog.dismiss();
                finish();
            }
        });
        builder.setNegativeButton("Không", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
}
