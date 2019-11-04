package com.example.testthuchanhuser;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button btngetAll;
    GridView gridAll;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btngetAll = findViewById(R.id.btnGetAll);
        gridAll = findViewById(R.id.gridDS);
        btngetAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<String> list = new ArrayList<>();
                Uri uri = Uri.parse("content://com.example.testthuchanh.AuthorProvider");
                Cursor cursor = getContentResolver().query(uri,null,null,null,"id_author");
                if(cursor.getCount()>0){
                    cursor.moveToFirst();
                    do{
                        list.add(cursor.getInt(0)+"");
                        list.add(cursor.getString(1));
                        list.add(cursor.getString(2));
                        list.add(cursor.getString(3));
                        cursor.moveToNext();
                    } while(!cursor.isAfterLast());
                    ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_list_item_1,list);
                    gridAll.setAdapter(adapter);
                }
                else
                {
                    Toast.makeText(MainActivity.this, "Dữ liệu rỗng", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
