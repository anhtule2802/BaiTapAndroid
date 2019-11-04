package com.example.doanandroid;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity {
    ArrayList<DetailTable> listDetail = new ArrayList<DetailTable>();
    CustomListView adapter = null;
    TextView tvDay;
    FloatingActionButton fab;
    ListView lvDetail;
    DBHelper dbHelper;
    ArrayList<DetailTable> dtlist = new ArrayList<>();
    ArrayList<DetailTable> list = new ArrayList<DetailTable>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        getSupportActionBar().setTitle("Chi tiết bảng công việc");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        dbHelper = new DBHelper(this);
        fab = (FloatingActionButton) findViewById(R.id.Fab);
        tvDay = (TextView)findViewById(R.id.tvDay);
        lvDetail = (ListView) findViewById(R.id.listDetail);
        registerForContextMenu(lvDetail);
        showList("Thứ 2");
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_day,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.th2:
                list.clear();
                tvDay.setText("Thứ 2");
                showList("Thứ 2");
                break;
            case R.id.th3:
                list.clear();
                tvDay.setText("Thứ 3");
                showList("Thứ 3");
                break;
            case R.id.th4:
                list.clear();
                tvDay.setText("Thứ 4");
                showList("Thứ 4");
                break;
            case R.id.th5:
                list.clear();
                tvDay.setText("Thứ 5");
                showList("Thứ 5");
                break;
            case R.id.th6:
                list.clear();
                tvDay.setText("Thứ 6");
                showList("Thứ 6");
                break;
            case R.id.th7:
                list.clear();
                tvDay.setText("Thứ 7");
                showList("Thứ 7");
                break;
            case R.id.Cn:
                list.clear();
                tvDay.setText("Chủ Nhật");
                showList("Chủ Nhật");
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    public void showDialog(){
        final Dialog dialog = new Dialog(Main2Activity.this);
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.detail_dialog);
        final EditText editContent = (EditText)dialog.findViewById(R.id.editContent);
        Button btnThem = (Button) dialog.findViewById(R.id.btnThem);
        Button btnHuy = (Button) dialog.findViewById(R.id.btnHuy);
        CheckBox cbDatLich = (CheckBox) dialog.findViewById(R.id.cbDatNhac);
        final Spinner spDay = (Spinner) dialog.findViewById(R.id.spDay);
        final TimePicker tpChiTiet = (TimePicker) dialog.findViewById(R.id.tpChiTiet);
        ArrayList<String> listsp = new ArrayList<>();
        listsp.add("Thứ 2");listsp.add("Thứ 3");listsp.add("Thứ 4");listsp.add("Thứ 5");listsp.add("Thứ 6");listsp.add("Thứ 7");listsp.add("Chủ Nhật");
        ArrayAdapter<String> adaptersp = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,listsp);
        adaptersp.setDropDownViewResource(android.R.layout.simple_list_item_single_choice);
        spDay.setAdapter(adaptersp);
        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DetailTable dt = new DetailTable();
                dtlist = dbHelper.getAllDeTailTable();
                dt.setMaDetail(dtlist.size()+1);
                dt.setMaTable(getIntent().getExtras().getInt("maTable"));
                dt.setTime(tpChiTiet.getCurrentHour().toString()+" : "+tpChiTiet.getCurrentMinute().toString());
                dt.setDay(spDay.getSelectedItem().toString());
                dt.setContentDetail(editContent.getText().toString());
                if(dbHelper.insertDetailTable(dt))
                {
                    list.clear();
                    Toast.makeText(Main2Activity.this,"Thêm Thành Công",Toast.LENGTH_SHORT).show();
                    dialog.cancel();
                    tvDay.setText("Thứ 2");
                    showList("Thứ 2");
                }
                else {
                    Toast.makeText(Main2Activity.this,"Thất bại",Toast.LENGTH_SHORT).show();
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
    public void showList(String th){
        dtlist = dbHelper.getAllDeTailTable();
        for(DetailTable b : dtlist)
        {
            if(b.getMaTable() == getIntent().getExtras().getInt("maTable"))
            {
                if(b.getDay().equalsIgnoreCase(th))
                {
                    list.add(new DetailTable(b.getContentDetail(),b.getTime(),b.getMaDetail()));
                }
            }
        }
        adapter = new CustomListView(Main2Activity.this,R.layout.activity_custom_list_view,list);
        lvDetail.setAdapter(adapter);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        dtlist = dbHelper.getAllDeTailTable();
        final AdapterView.AdapterContextMenuInfo menuInfo = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        switch (item.getItemId()){
            case R.id.sua:
                final Dialog dialog = new Dialog(Main2Activity.this);
                dialog.setCancelable(false);
                dialog.setContentView(R.layout.detail_dialog);
                final EditText editContent = (EditText)dialog.findViewById(R.id.editContent);
                Button btnThem = (Button) dialog.findViewById(R.id.btnThem);
                Button btnHuy = (Button) dialog.findViewById(R.id.btnHuy);
                CheckBox cbDatLich = (CheckBox) dialog.findViewById(R.id.cbDatNhac);
                final Spinner spDay = (Spinner) dialog.findViewById(R.id.spDay);
                final TimePicker tpChiTiet = (TimePicker) dialog.findViewById(R.id.tpChiTiet);
                ArrayList<String> listsp = new ArrayList<>();
                listsp.add("Thứ 2");listsp.add("Thứ 3");listsp.add("Thứ 4");listsp.add("Thứ 5");listsp.add("Thứ 6");listsp.add("Thứ 7");listsp.add("Chủ Nhật");
                ArrayAdapter<String> adaptersp = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,listsp);
                adaptersp.setDropDownViewResource(android.R.layout.simple_list_item_single_choice);
                spDay.setAdapter(adaptersp);
                editContent.setText(adapter.getItem(menuInfo.position).getContentDetail());
                btnThem.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dtlist = dbHelper.getAllDeTailTable();
                        if(dbHelper.updateDetail(adapter.getItem(menuInfo.position).getMaDetail(),getIntent().getExtras().getInt("maTable"),spDay.getSelectedItem().toString(),editContent.getText().toString(),tpChiTiet.getCurrentHour().toString()+" : "+tpChiTiet.getCurrentMinute().toString()))
                        {
                            list.clear();
                            Toast.makeText(Main2Activity.this,"Sửa Thành Công",Toast.LENGTH_SHORT).show();
                            dialog.cancel();
                            tvDay.setText("Thứ 2");
                            showList("Thứ 2");
                        }
                        else {
                            Toast.makeText(Main2Activity.this,"Sửa Thất bại",Toast.LENGTH_SHORT).show();
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
                break;
            case R.id.xoa:
                   if(dbHelper.deleteDetail(adapter.getItem(menuInfo.position).getMaDetail())){
                       list.clear();
                       Toast.makeText(Main2Activity.this,"Xóa Thành Công",Toast.LENGTH_SHORT).show();
                       tvDay.setText("Thứ 2");
                       showList("Thứ 2");
                   }
                   else{
                       Toast.makeText(Main2Activity.this,"Xóa Thất Bại",Toast.LENGTH_SHORT).show();
                   }
                break;
        }
        return super.onContextItemSelected(item);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        if(v.getId() == R.id.listDetail)
        {
            MenuInflater inflater = getMenuInflater();
            inflater.inflate(R.menu.menu_context,menu);
        }
    }
}
