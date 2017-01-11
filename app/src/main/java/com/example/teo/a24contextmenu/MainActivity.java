package com.example.teo.a24contextmenu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    ListView listView1;
    String contacts[] = {"Ajay","Sachin","Sumit","Tarun","Yogesh"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Ánh xạ
        listView1 = (ListView) findViewById(R.id.listView1);

        //Khởi tạo ArraryAdapter truyền dữ liệu mảng contacts vào nó
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, contacts);

    }
}
