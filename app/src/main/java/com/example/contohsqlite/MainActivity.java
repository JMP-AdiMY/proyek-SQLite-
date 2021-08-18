package com.example.contohsqlite;

import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private Button btnStore, butget;
    private EditText etname;
    private DatabaseHelper databaseHelper;
    private TextView tvnames;
    private ArrayList<String>arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        databaseHelper = new DatabaseHelper(this);
        tvnames = (TextView) findViewById(R.id.tvnames);
        btnStore = (Button) findViewById(R.id.btnstore);
        butget = (Button) findViewById(R.id.butget);
        etname = (EditText) findViewById(R.id.etname);

        btnStore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                databaseHelper.addStudentDetail(etname.getText().toString());
                Toast.makeText(MainActivity.this,"Stored Succesfully!", Toast.LENGTH_SHORT).show();
            }
        });

        butget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                arrayList = databaseHelper.getAllStudentList();
                tvnames.setText("");
                for (int i=0;i<arrayList.size();i++){
                    tvnames.setText(tvnames.getText().toString()+","+arrayList.get(i));
                }
            }
        });
    }
}