package com.example.exam_xuexiaoguanli;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LuRUActivity extends AppCompatActivity {
    EditText xingming_ET, nianLing_ET, xiangguan_ET, youXing_ET;
    Button tiJiao_btn, tuiChu_btn;
    XueShangGunliIdb xueShangGunliIdb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lu_r_u);

        xingming_ET = findViewById(R.id.xingming_ETTV);
        nianLing_ET = findViewById(R.id.nianLing_ETTV);
        xiangguan_ET = findViewById(R.id.xiangguan_ETTV);
        youXing_ET = findViewById(R.id.youXing_ETTV);

        xueShangGunliIdb =new XueShangGunliIdb(LuRUActivity.this,"student.db",null,1);
        tiJiao_btn =findViewById(R.id.tiJiao_btn);


        tiJiao_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String ST_xingming = xingming_ET.getText().toString();
                String ST_nianling = nianLing_ET.getText().toString();
                String ST_xiangguan = xiangguan_ET.getText().toString();
                String ST_youxiang = youXing_ET.getText().toString();

                ContentValues contentValues123 = new ContentValues();
                contentValues123.put("STxingming",ST_xingming);
                contentValues123.put("STnianling",ST_nianling);
                contentValues123.put("STxiangguan",ST_xiangguan);
                contentValues123.put("STyouxiang",ST_youxiang);

                xueShangGunliIdb.getReadableDatabase().insert("Xueshang_Info",null,contentValues123);
                Toast.makeText(LuRUActivity.this, "提交成功！！", Toast.LENGTH_SHORT).show();


            }
        });
        tuiChu_btn = findViewById(R.id.tuiChu_btn);
        tuiChu_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LuRUActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
