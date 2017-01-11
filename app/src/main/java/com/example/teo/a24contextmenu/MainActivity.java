package com.example.teo.a24contextmenu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

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
        //Truyền dữ liệu từ Adapter vào listview với phương thức setAdapter()
        listView1.setAdapter(adapter);

        //Dùng để gọi trình đơn ngữ cảnh
        registerForContextMenu(listView1);
    }

    //Gọi menu context
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        //Đặt tiêu đề cho ContextMenu
        menu.setHeaderTitle("Select The Action");
        menu.add(0, v.getId(), 0, "Call");//groupId, itemId, order, title
        menu.add(0, v.getId(), 0, "SMS");
    }


    //Bắt sự kiện nêu title
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        if (item.getTitle() == "Call"){
            Toast.makeText(getApplicationContext(), "Calling code", Toast.LENGTH_LONG).show();
        } else if (item.getTitle() == "SMS"){
            Toast.makeText(getApplicationContext(), "Sending sms code", Toast.LENGTH_LONG).show();
        } else {
            return false;
        }
        return true;
    }
}
