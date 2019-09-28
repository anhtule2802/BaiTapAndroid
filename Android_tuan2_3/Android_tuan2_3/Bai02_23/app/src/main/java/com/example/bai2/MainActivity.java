package com.example.bai2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Spinner spSP;
    Button btnNhap;
    EditText editMaSP,editTenSP;
    ListView listSP;

    ArrayList<Catalog> listCatalog = new ArrayList<>();
    ArrayAdapter<Catalog> adapterSpinner = null;

    ArrayList<Product> arrayListView = new ArrayList<>();
    ArrayAdapter<Product> adapterListView = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWidgetControl();
        fakeDataCatalog();
        addEventsForFormWidgets();
    }

    private void getWidgetControl(){
        spSP = findViewById(R.id.spSP);
        editMaSP = findViewById(R.id.editMaSP);
        editTenSP = findViewById(R.id.editTenSp);
        btnNhap = findViewById(R.id.btnNhap);
        listSP = findViewById(R.id.listSp);

        adapterSpinner = new ArrayAdapter<Catalog>(this,android.R.layout.simple_spinner_item,listCatalog);
        adapterSpinner.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spSP.setAdapter(adapterSpinner);

        adapterListView = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,arrayListView);
        listSP.setAdapter(adapterListView);
    }
    private void fakeDataCatalog(){
        Catalog ca1 = new Catalog("1","SamSung");
        Catalog ca2 = new Catalog("3","Xiaomi");
        Catalog ca3 = new Catalog("3","Apple");
        listCatalog.add(ca1);
        listCatalog.add(ca2);
        listCatalog.add(ca3);
        adapterSpinner.notifyDataSetChanged();
    }
    private void addProduct(){
        Product pr1 = new Product();
        pr1.setId(editMaSP.getText()+"");
        pr1.setName(editTenSP.getText()+"");
        Catalog c =(Catalog)spSP.getSelectedItem();
        c.addProduct(pr1);
        loadListProductbyCatalog(c);
    }
    private void loadListProductbyCatalog(Catalog c)
    {
        arrayListView.clear();
        arrayListView.addAll(c.getListSp());
        adapterListView.notifyDataSetChanged();
    }
    private void addEventsForFormWidgets(){
        btnNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addProduct();
            }
        });
        spSP.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                loadListProductbyCatalog(listCatalog.get(position));
                editMaSP.setText("");
                editTenSP.setText("");
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        listSP.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Product pr1 = (Product)listSP.getItemAtPosition(position);
                editMaSP.setText(pr1.getId());
                editTenSP.setText(pr1.getName());
            }
        });
    }
}
