package com.example.student.tuan22_bai05;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText editMa,editTen;
    Button btnNhap;
    RadioButton rdCT,rdTV;
    ListView list;
    ArrayList<Employee> arrEmployee = new ArrayList<Employee>();
    ArrayAdapter<Employee> arrAdapter = null;
    Employee employee = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editMa = findViewById(R.id.editMa);
        editTen = findViewById(R.id.editTen);
        btnNhap = findViewById(R.id.btnNhap);
        rdCT = findViewById(R.id.rdCT);
        rdTV = findViewById(R.id.rdTV);
        list = findViewById(R.id.lvList);
        arrAdapter = new ArrayAdapter<Employee>(this,android.R.layout.simple_list_item_1,arrEmployee);
        list.setAdapter(arrAdapter);

        btnNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nhap();
            }
        });
    }
    public void nhap(){
        String id = editMa.getText() + "";
        String ten = editTen.getText() + "";
        if(rdCT.isChecked())
        {
            employee = new EmployeeFullTime();
        }
        if(rdTV.isChecked())
        {
            employee = new EmployeeParttime();
        }
        employee.setId(id);
        employee.setName(ten);
        arrEmployee.add(employee);
        arrAdapter.notifyDataSetChanged();
    }
}
