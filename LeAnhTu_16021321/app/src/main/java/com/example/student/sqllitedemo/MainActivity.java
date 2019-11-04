package com.example.student.sqllitedemo;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText et_id, et_name, et_address,et_email;
    Button bt_save, bt_select, bt_exit, bt_update, bt_delete;
    GridView gv_display;
    DBHelper dbHelper;
    private ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mappingView();
    }
    public boolean onCreateOptionsMenu(android.view.Menu menu){
        getMenuInflater().inflate(R.menu.menu_information, menu);
        return true;
    }
    public boolean onOptionsItemSelected(android.view.MenuItem item){
        switch (item.getItemId()){
            case R.id.menu_book:
                showdialog();
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }
 public void showdialog(){
        Dialog dialog = new Dialog(MainActivity.this,android.R.style.Theme_Light_NoTitleBar);
        dialog.setTitle("Thong Tin Tác Giả");
        dialog.setContentView(R.layout.dialog);
        et_id = (EditText) dialog.findViewById(R.id.editTextID);
        et_name = (EditText) dialog.findViewById(R.id.editTextName);
        et_address = (EditText)dialog.findViewById(R.id.editTextAddress);
        et_email = (EditText)dialog.findViewById(R.id.editTextEmail);

        //GridView
        gv_display = (GridView) dialog.findViewById(R.id.gridView_listItem);

       //DBHelper
//        dbHelper = new DBHelper(this);

        //Button
        bt_save = (Button) dialog.findViewById(R.id.buttonSave);
        bt_select = (Button) dialog.findViewById(R.id.buttonSelect);
        bt_exit = (Button) dialog.findViewById(R.id.buttonExit);
        bt_delete = (Button) dialog.findViewById(R.id.buttonDelete);
        bt_update = (Button) dialog.findViewById(R.id.buttonUpdate);
        eventClick();
        dialog.show();
    }
    private void eventClick() {
        bt_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Author author = new Author();
                author.setId(Integer.parseInt(et_id.getText().toString()));
                author.setName(et_name.getText().toString());
                author.setAddress(et_address.getText().toString());
                author.setEmail(et_email.getText().toString());
                if (dbHelper.insertAuthor(author)) {
                    Toast.makeText(getApplicationContext(), "Luu thanh cong", Toast.LENGTH_SHORT).show();
                    clear();
                } else {
                    Toast.makeText(getApplicationContext(), "Luu khong thanh cong", Toast.LENGTH_SHORT).show();
                }
            }
        });

        bt_select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<String> list = new ArrayList<>();
                ArrayList<Author> authorlist = new ArrayList<>();
                String id = et_id.getText().toString();
                if (!id.isEmpty()) {
                    int idkq = Integer.parseInt(id);
                    Author author = dbHelper.getAuthor(idkq);
                    list.add(author.getId() + "");
                    list.add(author.getName());
                    list.add(author.getAddress());
                    list.add(author.getEmail());
                } else {
                    authorlist = dbHelper.getAllAuthor();
                    for (Author b : authorlist) {
                        list.add(b.getId() + "");
                        list.add(b.getName());
                        list.add(b.getAddress());
                        list.add(b.getEmail());
                    }
                }
                adapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, list);
                gv_display.setAdapter(adapter);
            }
        });

        bt_exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        bt_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = et_id.getText().toString();
                if (!id.isEmpty()) {
                    int idkq = Integer.parseInt(id);
                    dbHelper.deleteAuthor(idkq);
                    adapter.notifyDataSetChanged();
                    clear();
                    Toast.makeText(getApplicationContext(), "Xoa thanh cong", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), "Xoa khong thanh cong", Toast.LENGTH_SHORT).show();
                }
            }
        });

        bt_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = et_id.getText().toString();
                String name = et_name.getText().toString();
                String address = et_address.getText().toString();
                String email = et_email.getText().toString();
                if(!id.isEmpty()){
                    int idkq = Integer.parseInt(id);
                    dbHelper.updateAuthor(idkq,name,address,email);
                    adapter.notifyDataSetChanged();
                    clear();
                    Toast.makeText(getApplicationContext(), "Update thanh cong", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(getApplicationContext(), "Update khong thanh cong", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    private void clear() {
        et_id.setText("");
        et_name.setText("");
        et_address.setText("");
        et_email.setText("");
        et_id.requestFocus();
    }
    private void mappingView() {
        //EditText
        et_id = (EditText) findViewById(R.id.editTextID);
        et_name = (EditText) findViewById(R.id.editTextName);
        et_address = (EditText)findViewById(R.id.editTextAddress);
        et_email = (EditText)findViewById(R.id.editTextEmail);
        //GridView
        gv_display = (GridView) findViewById(R.id.gridView_listItem);

        //DBHelper
        dbHelper = new DBHelper(this);

        //Button
        bt_save = (Button) findViewById(R.id.buttonSave);
        bt_select = (Button) findViewById(R.id.buttonSelect);
        bt_exit = (Button) findViewById(R.id.buttonExit);
        bt_delete = (Button) findViewById(R.id.buttonDelete);
        bt_update = (Button) findViewById(R.id.buttonUpdate);
    }
}
