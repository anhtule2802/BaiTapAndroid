package com.example.student.bai01_tuan23;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.RadioGroup;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<NhanVien> arrNhanVien = null;
    MyArrayAdapter adapter = null;
    ListView lvNhanVien = null;
    Button btnNhap;
    Button btnRemoveAll;
    EditText editMa,editTen;
    RadioGroup genderGroup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnNhap = findViewById(R.id.btnNhap);
        btnRemoveAll = findViewById(R.id.btnRemoveAll);
        editMa = findViewById(R.id.editMaNV);
        editTen = findViewById(R.id.editTenNV);
        genderGroup = findViewById(R.id.genderGroup);

        lvNhanVien = findViewById(R.id.listNV);
        arrNhanVien = new ArrayList<NhanVien>();
        adapter = new MyArrayAdapter(this,R.layout.my_item_layout,arrNhanVien);
        lvNhanVien.setAdapter(adapter);
        btnNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                XuLyNhap();
            }
        });
        btnRemoveAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                XuLyXoa();
            }
        });
    }
    public void XuLyNhap(){
        String ma = editMa.getText() + "";
        String ten = editTen.getText() + "";
        boolean gioitinh = false;
        if(genderGroup.getCheckedRadioButtonId() == R.id.rdNu){
            gioitinh = true;
        }
        NhanVien nv = new NhanVien();
        nv.setId(ma);
        nv.setName(ten);
        nv.setGender(gioitinh);
        arrNhanVien.add(nv);
        adapter.notifyDataSetChanged();
        editMa.setText("");
        editTen.setText("");
        editMa.requestFocus();
    }
    public void XuLyXoa(){
        for(int i = lvNhanVien.getChildCount() - 1 ; i>=0 ;i--)
        {
            View v = lvNhanVien.getChildAt(i);
            CheckBox chk = v.findViewById(R.id.chk_item);
            if(chk.isChecked())
            {
                arrNhanVien.remove(i);
            }
        }
        adapter.notifyDataSetChanged();
    }
}
