package com.example.outputfile13;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    EditText open_ETTV;
    Button btn_OpAC;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialization();
        btn_OpAC();
    }

    private void btn_OpAC() {
        btn_OpAC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    FileOutputStream fos = openFileOutput("WallCometoNiceWorld.txt",MODE_PRIVATE);
                    fos.write(open_ETTV.getText().toString().getBytes());
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
    private void initialization() {
        open_ETTV =findViewById(R.id.open_ETTV);
        btn_OpAC =findViewById(R.id.btn_OpAC);
    }
}


