package com.example.testthuchanh;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button btnQLTacGia;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnQLTacGia = findViewById(R.id.button_QLTacGia);
        btnQLTacGia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Dialog dlg = new Dialog(MainActivity.this);
                dlg.setContentView(R.layout.author_editor);
                dlg.setTitle("Quản Lý Tác Giả");
                final EditText etAuthorID = dlg.findViewById(R.id.editText_AuthorID);
                final EditText etAuthorName = dlg.findViewById(R.id.editText_AuthorName);
                final EditText etAuthorAddress = dlg.findViewById(R.id.editText_AuthorAddress);
                final EditText etAuthorEmail = dlg.findViewById(R.id.editText_AuthorEmail);
                final GridView gvAuthor = dlg.findViewById(R.id.gridView_Author);

                Button btnAuthorSave = dlg.findViewById(R.id.button_AuthorSave);
                btnAuthorSave.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ContentValues author = new ContentValues();
                        try{
                            author.put("id_author",Integer.parseInt(etAuthorID.getText().toString()));
                            author.put("name", etAuthorName.getText().toString());
                            author.put("address", etAuthorAddress.getText().toString());
                            author.put("email", etAuthorEmail.getText().toString());
                            String uri = "content://com.example.testthuchanh.AuthorProvider";
                            Uri aut = Uri.parse(uri);
                            Uri insertUri = getContentResolver().insert(aut, author);
                            if(insertUri!=null)
                            {
                                Toast.makeText(MainActivity.this, "Thêm thành công", Toast.LENGTH_SHORT).show();
                                etAuthorID.setText("");
                                etAuthorName.setText("");
                                etAuthorAddress.setText("");
                                etAuthorEmail.setText("");
                                etAuthorID.requestFocus();
                            }
                            else{
                                Toast.makeText(MainActivity.this, "Thêm thất bại", Toast.LENGTH_SHORT).show();
                            }
                        }catch (NumberFormatException ex)
                        {
                            Toast.makeText(MainActivity.this, "ID Tác giả không hợp lệ", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                Button btnAuthorUpdate = dlg.findViewById(R.id.button_AuthorUpdate);
                btnAuthorUpdate.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ContentValues author = new ContentValues();
                        author.put("id_author", Integer.parseInt(etAuthorID.getText().toString()));
                        author.put("name", etAuthorName.getText().toString());
                        author.put("address", etAuthorAddress.getText().toString());
                        author.put("email", etAuthorEmail.getText().toString());
                        String uri = "content://com.example.testthuchanh.AuthorProvider";
                        Uri aut = Uri.parse(uri);
                        int updateUri = getContentResolver().update(aut,author,"id_author=?",new String[]{etAuthorID.getText().toString()});
                        if(updateUri>0){
                            Toast.makeText(MainActivity.this, "Cập nhật thành công", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(MainActivity.this, "Cập nhật thất bại", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                Button btnAuthorSelect = dlg.findViewById(R.id.button_AuthorSelect);
                btnAuthorSelect.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ArrayList<String> listString = new ArrayList<>();
                        String uri = "content://com.example.testthuchanh.AuthorProvider";
                        Uri aut = Uri.parse(uri);
                        Cursor cursor = getContentResolver().query(aut,null,null,null,"id_author");
                        if(cursor.getCount()>0){
                            cursor.moveToFirst();
                            do{
                                listString.add(cursor.getInt(0)+"");
                                listString.add(cursor.getString(1));
                                listString.add(cursor.getString(2));
                                listString.add(cursor.getString(3));
                                cursor.moveToNext();
                            } while(!cursor.isAfterLast());
                            ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_list_item_1,listString);
                            gvAuthor.setAdapter(adapter);
                        }
                        else
                        {
                            Toast.makeText(MainActivity.this, "Dữ liệu rỗng", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                Button btnAuthorDelete = dlg.findViewById(R.id.button_AuthorDelete);
                btnAuthorDelete.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String uri = "content://com.example.testthuchanh.AuthorProvider";
                        Uri aut = Uri.parse(uri);
                        int row = getContentResolver().delete(aut,"id_author = ?", new String[]{etAuthorID.getText().toString()});
                        if(row > 0) {
                            Toast.makeText(MainActivity.this, "Đã xóa thành công", Toast.LENGTH_SHORT).show();
                        }
                        else {
                            Toast.makeText(MainActivity.this, "Xóa thất bại", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                gvAuthor.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        int rounderPos = (Math.round(position/4)*4);
                        etAuthorID.setText(parent.getItemAtPosition(rounderPos).toString());
                    }
                });
                Button btnAuthorExit = dlg.findViewById(R.id.button_AuthorThoat);
                btnAuthorExit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dlg.dismiss();
                    }
                });

                dlg.show();
                Window window = dlg.getWindow();
                window.setLayout(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
            }
        });
    }
}
