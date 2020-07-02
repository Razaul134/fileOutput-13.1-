package com.example.exam_xuexiaoguanli;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
Button shuRu_Btn,chaXun_Btn,xiuGai_Btn,shaNChu_Btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        shuRu_Btn =findViewById(R.id.shuRu_Btn);
        chaXun_Btn =findViewById(R.id.chaXun_Btn);
        xiuGai_Btn =findViewById(R.id.xiuGai_Btn);
        shaNChu_Btn =findViewById(R.id.shaNChu_Btn);

        shuRu_Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,LuRUActivity.class);
                startActivity(intent);
            }
        });
    }
}
