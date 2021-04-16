package com.example.project1;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button go_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        go_btn = findViewById(R.id.go_btn);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null){
            actionBar.hide();
        }
    }

    public void onClickGoToMenu(View view) {
        Intent intent = new Intent(this, Proteins.class);
        startActivity(intent);

    }



    public void onClickGoToInfo(View view) {
        Intent intent = new Intent(this, Info.class);
        startActivity(intent);
    }

    public void goToBasket(View view) {
        Intent intent = new Intent(this, Basket.class);
        startActivity(intent);
    }
}