package com.example.doanandroid;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    FloatingActionButton fab;
    ArrayAdapter<String> adapter;
    ListView listTable;
    DBHelper dbHelper;
    ArrayList<TableCongViec> cvlist = new ArrayList<>();
    ArrayList<String> list = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setTitle("Bảng Công Việc");
        setContentView(R.layout.activity_main);
        fab = (FloatingActionButton) findViewById(R.id.Fab);
        listTable = (ListView) findViewById(R.id.listTable);
        dbHelper = new DBHelper(this);
        showTable();
        registerForContextMenu(listTable);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog();
            }
        });
        listTable.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                cvlist = dbHelper.getAllTable();
                Intent detail = new Intent(view.getContext(),Main2Activity.class);
                for(TableCongViec b : cvlist){
                    if(b.getNameTable().equalsIgnoreCase(adapter.getItem(position))){
                        detail.putExtra("maTable",b.getMaTable());
                        startActivity(detail);
                    }
                }
            }
        });
    }
    public void showDialog()
    {
        final Dialog dialog = new Dialog(MainActivity.this);
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.custom_dialog);
        final EditText editName = (EditText)dialog.findViewById(R.id.editName);
        Button btnThem = (Button) dialog.findViewById(R.id.btnThem);
        Button btnHuy = (Button) dialog.findViewById(R.id.btnHuy);
        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TableCongViec cv = new TableCongViec();
                cvlist = dbHelper.getAllTable();
                cv.setMaTable(cvlist.size() + 1);
                cv.setNameTable(editName.getText().toString());
                if (dbHelper.insertCongViec(cv)) {
                    list.clear();
                    Toast.makeText(MainActivity.this, "Thêm Thành Công", Toast.LENGTH_SHORT).show();
                    showTable();
                    dialog.cancel();
                } else {
                    Toast.makeText(MainActivity.this, "Không Thể Thêm", Toast.LENGTH_LONG).show();
                }
            }
        });
        btnHuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.cancel();
            }
        });
        dialog.show();
    }
    public void showTable(){
        cvlist = dbHelper.getAllTable();
        for(TableCongViec b : cvlist)
        {
            list.add(b.getNameTable().toUpperCase());
        }
        adapter = new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_list_item_1,list);
        listTable.setAdapter(adapter);
    }
    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        cvlist = dbHelper.getAllTable();
        AdapterView.AdapterContextMenuInfo menuInfo = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        final String pos = adapter.getItem(menuInfo.position);
        switch (item.getItemId()){
            case R.id.sua:
                final Dialog dialog = new Dialog(MainActivity.this);
                dialog.setCancelable(false);
                dialog.setContentView(R.layout.custom_dialog);
                TextView tvDialog = (TextView) dialog.findViewById(R.id.tvDialog);
                final EditText editName = (EditText)dialog.findViewById(R.id.editName);
                Button btnThem = (Button) dialog.findViewById(R.id.btnThem);
                Button btnHuy = (Button) dialog.findViewById(R.id.btnHuy);
                for(final TableCongViec b : cvlist)
                {
                    if(b.getNameTable().equalsIgnoreCase(pos)){
                    tvDialog.setText("Sửa Công Việc");
                    editName.setText(b.getNameTable());
                    btnThem.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                                    if(dbHelper.updateTable(b.getMaTable(),editName.getText().toString())){
                                        Toast.makeText(MainActivity.this,"Sửa Thành Công",Toast.LENGTH_SHORT).show();
                                        list.clear();
                                        showTable();
                                        dialog.cancel();
                                    }else{
                                        Toast.makeText(MainActivity.this,"Sửa Thất Bại",Toast.LENGTH_SHORT).show();
                                    }

                            }
                    });
                    }
                }
                btnHuy.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.cancel();
                    }
                });
                dialog.show();
                break;
            case R.id.xoa:
                for(TableCongViec b : cvlist)
                {
                    if(b.getNameTable().equalsIgnoreCase(pos)){
                        if(dbHelper.deleteTable(b.getMaTable())){
                            Toast.makeText(MainActivity.this,"Xóa Thành Công",Toast.LENGTH_SHORT).show();
                            list.clear();
                            showTable();
                        }else{
                            Toast.makeText(MainActivity.this,"Xóa Thất Bại",Toast.LENGTH_SHORT).show();
                        }
                    }
                }
            break;
        }
        return super.onContextItemSelected(item);
    }
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        if(v.getId() == R.id.listTable)
        {
            MenuInflater inflater = getMenuInflater();
            inflater.inflate(R.menu.menu_context,menu);
        }
    }
}
