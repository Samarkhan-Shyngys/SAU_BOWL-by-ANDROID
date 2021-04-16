package com.example.project1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Locale;

public class Basket extends AppCompatActivity {

    private ImageView back;
    private TextView product1;
    private String priceProtein;
    private String priceCarbohydrates;
    private String priceCellulose;
    private String priceFats;

    private int seconds = 30;
    private Boolean isRunning = true;
    private Boolean wasRunning = true;
    private TextView timer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basket);
        back = findViewById(R.id.back);
        product1 = findViewById(R.id.product1);
        timer = findViewById(R.id.timer);

        if(savedInstanceState != null){
            savedInstanceState.getInt("seconds");
            isRunning = savedInstanceState.getBoolean("isRunning");
            wasRunning = savedInstanceState.getBoolean("wasRunning");
        }
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Proteins.class);

                startActivity(intent);
            }
        });
        runTimer();
         Intent intent = getIntent();
         if(intent.hasExtra("protein") ){
            String orderProtein = intent.getStringExtra("protein");
            product1.setText(orderProtein);
         }
         if(intent.hasExtra("carbohydrates") ){
            String orderCarbohydrates = intent.getStringExtra("carbohydrates");
            product1.setText(orderCarbohydrates);
         }
         if(intent.hasExtra("cellulose")){
             String orderCellulose = intent.getStringExtra("cellulose");
             product1.setText(orderCellulose);
         }
         if(intent.hasExtra("fats")){
             String orderFats = intent.getStringExtra("fats");
             product1.setText(orderFats);}
         if (intent.hasExtra("priceProtein")){
             priceProtein = intent.getStringExtra("priceProtein");
         }
         if (intent.hasExtra("priceCarbohydrates")){
            priceCarbohydrates = intent.getStringExtra("priceCarbohydrates");
         }
         if (intent.hasExtra("priceCellulose")){
             priceCellulose = intent.getStringExtra("priceCellulose");
         }
         if (intent.hasExtra("priceFats")){
             priceFats = intent.getStringExtra("priceFats");
         }
    }

    @Override
    protected void onResume() {
        super.onResume();
        isRunning = wasRunning;
    }

    @Override
    protected void onPause() {
        super.onPause();
        wasRunning = isRunning;
        isRunning = false;

    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putBoolean("isRunning", isRunning);
        outState.putInt("seconds", seconds);
        outState.putBoolean("wasRunning", wasRunning);
    }

    public void onClickGoToOrder(View view) {
        Intent intent = new Intent(getApplicationContext(), Order.class);
        if (priceProtein != null){
            intent.putExtra("priceProtein", priceProtein);
        }
        if (priceCarbohydrates != null){
            intent.putExtra("priceCarbohydrates", priceCarbohydrates);
        }
        if (priceCellulose != null){
            intent.putExtra("priceCellulose", priceCellulose);
        }
        if (priceFats != null){
            intent.putExtra("priceFats", priceFats);
        }

        startActivity(intent);
    }

    private void runTimer(){
        final Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                String time = String.format(Locale.getDefault(),"%02d", seconds);
                timer.setText(time);

                if(isRunning){
                    seconds--;
                    if (seconds == 0){
                        product1.setText("");
                        isRunning = false;
                    }
                }
                handler.postDelayed(this,1000);
            }
        });

    }

}