package com.example.project1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import static android.widget.AdapterView.*;

public class Info extends AppCompatActivity {

    private ListView listView;
    private TextView  textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        textView = findViewById(R.id.textView);
        listView = findViewById(R.id.listView);
        listView.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                if(position == 0){
                    textView.setText(R.string.info_number);
                }else if(position == 1){
                    textView.setText(R.string.shop_info);}
                else if(position == 2){
                    textView.setText(R.string.address_info);}
            }
        });
    }

    public void GoToMain(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}