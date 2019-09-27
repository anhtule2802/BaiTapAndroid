package com.example.student.bai07;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Button btnRut;
    ImageView imgBai;
    ArrayList<LaBai> CacLaBai = new ArrayList<>();
    private void xaoBai()
    {
        CacLaBai.add(new LaBai(1,"Ách Bích",R.drawable.b1));
        CacLaBai.add(new LaBai(1,"Ách Chuồng",R.drawable.c1));
        CacLaBai.add(new LaBai(1,"Ách Rô",R.drawable.r1));
        CacLaBai.add(new LaBai(1,"Ách Cơ",R.drawable.co1));
        CacLaBai.add(new LaBai(2,"2 Bích",R.drawable.b2));
        CacLaBai.add(new LaBai(2,"2 Chuồng",R.drawable.c2));
        CacLaBai.add(new LaBai(2,"2 Rô",R.drawable.r2));
        CacLaBai.add(new LaBai(2,"2 Cơ",R.drawable.co2));
        CacLaBai.add(new LaBai(3,"3 Bích",R.drawable.b3));
        CacLaBai.add(new LaBai(3,"3 Chuồng",R.drawable.c3));
        CacLaBai.add(new LaBai(3,"3 Rô",R.drawable.r3));
        CacLaBai.add(new LaBai(3,"3 Cơ",R.drawable.co3));
        CacLaBai.add(new LaBai(4,"4 Bích",R.drawable.b4));
        CacLaBai.add(new LaBai(4,"4 Chuồng",R.drawable.c4));
        CacLaBai.add(new LaBai(4,"4 Rô",R.drawable.r4));
        CacLaBai.add(new LaBai(4,"4 Cơ",R.drawable.co4));
        CacLaBai.add(new LaBai(5,"5 Bích",R.drawable.b5));
        CacLaBai.add(new LaBai(5,"5 Chuồng",R.drawable.c5));
        CacLaBai.add(new LaBai(5,"5 Rô",R.drawable.r5));
        CacLaBai.add(new LaBai(5,"5 Cơ",R.drawable.co5));
        CacLaBai.add(new LaBai(6,"6 Bích",R.drawable.b6));
        CacLaBai.add(new LaBai(6,"6 Chuồng",R.drawable.c6));
        CacLaBai.add(new LaBai(6,"6 Rô",R.drawable.r6));
        CacLaBai.add(new LaBai(6,"6 Cơ",R.drawable.co6));
        CacLaBai.add(new LaBai(7,"7 Bích",R.drawable.b7));
        CacLaBai.add(new LaBai(7,"7 Chuồng",R.drawable.c7));
        CacLaBai.add(new LaBai(7,"7 Rô",R.drawable.r7));
        CacLaBai.add(new LaBai(7,"7 Cơ",R.drawable.co7));
        CacLaBai.add(new LaBai(8,"8 Bích",R.drawable.b8));
        CacLaBai.add(new LaBai(8,"8 Chuồng",R.drawable.c8));
        CacLaBai.add(new LaBai(8,"8 Rô",R.drawable.r8));
        CacLaBai.add(new LaBai(8,"8 Cơ",R.drawable.co8));
        CacLaBai.add(new LaBai(9,"9 Bích",R.drawable.b9));
        CacLaBai.add(new LaBai(9,"9 Chuồng",R.drawable.c9));
        CacLaBai.add(new LaBai(9,"9 Rô",R.drawable.r9));
        CacLaBai.add(new LaBai(9,"9 Cơ",R.drawable.co9));
        CacLaBai.add(new LaBai(10,"10 Bích",R.drawable.b10));
        CacLaBai.add(new LaBai(10,"10 Chuồng",R.drawable.c10));
        CacLaBai.add(new LaBai(10,"10 Rô",R.drawable.r10));
        CacLaBai.add(new LaBai(10,"10 Cơ",R.drawable.co10));
        CacLaBai.add(new LaBai(11,"Bồi Bích",R.drawable.b11));
        CacLaBai.add(new LaBai(11,"Bồi Chuồng",R.drawable.c11));
        CacLaBai.add(new LaBai(11,"Bồi Rô",R.drawable.r11));
        CacLaBai.add(new LaBai(11,"Bồi Cơ",R.drawable.co11));
        CacLaBai.add(new LaBai(12,"Đầm Bích",R.drawable.b12));
        CacLaBai.add(new LaBai(12,"Đầm Chuồng",R.drawable.c12));
        CacLaBai.add(new LaBai(12,"Đầm Rô",R.drawable.r12));
        CacLaBai.add(new LaBai(12,"Đầm Cơ",R.drawable.co12));
        CacLaBai.add(new LaBai(13,"Già Bích",R.drawable.b13));
        CacLaBai.add(new LaBai(13,"Già Chuồng",R.drawable.c13));
        CacLaBai.add(new LaBai(13,"Già Rô",R.drawable.r13));
        CacLaBai.add(new LaBai(13,"Già Cơ",R.drawable.co13));
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnRut = findViewById(R.id.btnRut);
        imgBai = findViewById(R.id.imgBai);
        xaoBai();
        btnRut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LaBai XetBai;
                Random rand = new Random();
                int labai = rand.nextInt(CacLaBai.size()-1);
                XetBai = CacLaBai.get(labai);
                imgBai.setImageResource(XetBai.Hinh);
            }
        });
    }
}
