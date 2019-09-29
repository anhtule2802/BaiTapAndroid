package com.example.ontapgiuaky;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ImageView imgGender;
    TextView tvMaTen;
    CheckBox cbDelete;
    ListView listNV;
    Button btnXoa;
    ArrayList<NhanVien> listNv = new ArrayList<NhanVien>();
    CustomAdapter adapterNV = null;
    private static final int EDIT = 888;
    private static final int ADD = 999;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imgGender = findViewById(R.id.imgGender);
        tvMaTen = findViewById(R.id.tvMaTen);
        listNV = findViewById(R.id.listNV);
        listNv.add(new NhanVien("1","Lê Anh Tú",false));
        listNv.add(new NhanVien("1","Lê Anh Tú2",false));
        listNv.add(new NhanVien("1","Lê Anh Tú3",false));
        listNv.add(new NhanVien("1","Lê Anh Tú4",false));
        listNv.add(new NhanVien("1","Lê Anh Tú5",false));
        listNv.add(new NhanVien("1","Lê Anh Tú6",false));
        listNv.add(new NhanVien("1","Lê Anh Tú7",false));
        listNv.add(new NhanVien("1","Lê Anh Tú8",false));
        listNv.add(new NhanVien("1","Lê Anh Tú9",false));
        listNv.add(new NhanVien("1","Lê Anh Tú10",false));
        listNv.add(new NhanVien("1","Lê Anh Tú11",false));

        adapterNV = new CustomAdapter(MainActivity.this,R.layout.customlistview,listNv);
        listNV.setAdapter(adapterNV);
        btnXoa = (Button) findViewById(R.id.btnXoa);
        btnXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //XuLyXoa();
                Intent add = new Intent(v.getContext(),Main2Activity.class);
                startActivityForResult(add,ADD);
            }
        });

        listNV.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent update = new Intent(view.getContext(),Main2Activity.class);
                NhanVien nv = listNv.get(position);
                update.putExtra("nv", nv);
                update.putExtra("pos",position);
                startActivityForResult(update,EDIT);
            }
        });
    }
    public void XuLyXoa(){
        for(int i = listNV.getChildCount() - 1;i>=0;i--)
        {
            View v = listNV.getChildAt(i);
            cbDelete = v.findViewById(R.id.cbDelete);
            if(cbDelete.isChecked())
            {
                listNv.remove(i);
            }
            cbDelete.setChecked(false);
            adapterNV.notifyDataSetChanged();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
            if(requestCode == EDIT)
            {
                if(resultCode == RESULT_OK)
                {
                    NhanVien nv = (NhanVien) data.getSerializableExtra("nhanvien");
                    NhanVien update = listNv.get(data.getExtras().getInt("pos"));
                    update.setName(nv.getName());
                    update.setId(nv.getId());
                    update.setGender(nv.isGender());
                    adapterNV.notifyDataSetChanged();
                }
            }
            else if(requestCode == ADD)
            {
                if (resultCode == RESULT_OK)
                {
                    Toast.makeText(MainActivity.this,"Add Nhân Viên",Toast.LENGTH_LONG).show();
                }
            }
    }
}
