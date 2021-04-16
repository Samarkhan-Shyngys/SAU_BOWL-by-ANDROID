package com.example.project1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Cellulose<countOfBeans> extends AppCompatActivity implements View.OnClickListener {

    private ImageView proteins_img;
    private ImageView carbohydrates_img;
    private ImageView fat_img;
    private ImageView back;

    private ImageView beens_plus;
    private ImageView beens_minus;
    private TextView  beens_counter;

    private ImageView nuts_plus;
    private ImageView nuts_minus;
    private TextView  nuts_counter;

    private ImageView lentils_plus;
    private ImageView lentils_minus;
    private TextView  lentils_counter;

    private Button order_btn;

    private StringBuilder stringBuilder;

    private TextView beens_text;
    private TextView nuts_text;
    private TextView lentils_text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cellulose);
        stringBuilder = new StringBuilder();

        beens_text = findViewById(R.id.beens_text);
        nuts_text = findViewById(R.id.nuts_text);
        lentils_text = findViewById(R.id.lentils_text);

        proteins_img = findViewById(R.id.proteins_img);
        carbohydrates_img = findViewById(R.id.carbohydrates_img);
        fat_img = findViewById(R.id.fat_img);
        back = findViewById(R.id.back);
        order_btn = findViewById(R.id.order_btn);

        proteins_img.setOnClickListener(this);
        carbohydrates_img.setOnClickListener(this);
        fat_img.setOnClickListener(this);
        back.setOnClickListener(this);
        order_btn.setOnClickListener(this);

        //Count
        beens_plus =    findViewById(R.id.beens_plus);
        beens_minus =   findViewById(R.id.beens_minus);
        beens_counter = findViewById(R.id.beens_counter);
        beens_plus.setOnClickListener(this);
        beens_minus.setOnClickListener(this);


        nuts_counter = findViewById(R.id.nuts_counter);
        nuts_plus =    findViewById(R.id.nuts_plus);
        nuts_minus =   findViewById(R.id.nuts_minus);
        nuts_plus.setOnClickListener(this);
        nuts_minus.setOnClickListener(this);

        lentils_counter = findViewById(R.id.lentils_counter);
        lentils_plus =    findViewById(R.id.lentils_plus);
        lentils_minus =   findViewById(R.id.lentils_minus);
        lentils_plus.setOnClickListener(this);
        lentils_minus.setOnClickListener(this);

    }




    @Override
    public void onClick(View view) {
        int countOfBeens = Integer.parseInt(beens_counter.getText().toString());
        int countOfNuts = Integer.parseInt(nuts_counter.getText().toString());
        int countOfLentils = Integer.parseInt(lentils_counter.getText().toString());
        switch (view.getId()) {
            case R.id.proteins_img:
                Intent intent = new Intent(getApplicationContext(), Proteins.class);
                startActivity(intent);
                break;
            case R.id.carbohydrates_img:
                Intent intent1 = new Intent(getApplicationContext(), Carbohydrates.class);
                startActivity(intent1);
                break;
            case R.id.fat_img:
                Intent intent2 = new Intent(getApplicationContext(), Fats.class);
                startActivity(intent2);
                break;
            case R.id.back:
                Intent intent3 = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent3);
                break;

            //Count
           case R.id.beens_plus:
               countOfBeens++;
               beens_counter.setText(String.valueOf(countOfBeens));
               break;
           case R.id.beens_minus:
               countOfBeens--;
               if (countOfBeens < 0)
                   break;
               else{
                   beens_counter.setText(String.valueOf(countOfBeens));
                   break;}
            case R.id.nuts_plus:
                countOfNuts++;
                nuts_counter.setText(String.valueOf(countOfNuts));
                break;
            case R.id.nuts_minus:
                countOfNuts --;
                if (countOfNuts < 0)
                    break;
                else{
                    nuts_counter.setText(String.valueOf(countOfNuts));
                    break;}
            case R.id.lentils_plus:
                countOfLentils++;
                lentils_counter.setText(String.valueOf(countOfLentils));
                break;
            case R.id.lentils_minus:
                countOfLentils --;
                if (countOfLentils < 0)
                    break;
                else{
                    lentils_counter.setText(String.valueOf(countOfLentils));
                    break;}

            case R.id.order_btn:
                Intent intentOrder = new Intent(this, Basket.class);


                int priceOfBeens = countOfBeens * 300;
                int priceOfNuts = countOfNuts * 1200;
                int priceOfLentils = countOfLentils * 2000;
                int pricecellulose = priceOfBeens + priceOfNuts + priceOfLentils;
                String priceCellulose = String.valueOf(pricecellulose);
                String orderBeens = "";
                String orderNuts = "";
                String orderLentils = "";
                if(countOfBeens> 0){
                    orderBeens =    String.format("\nBeens                        %s            %s tg",countOfBeens,priceOfBeens);
                    stringBuilder.append(orderBeens);
                }
                if(countOfNuts > 0){
                    orderNuts = String.format("\nNuts                           %s            %s tg",countOfNuts,priceOfNuts);
                    stringBuilder.append(orderNuts);
                }
                if(countOfLentils > 0){
                    orderLentils =  String.format("\nLentils                        %s            %s tg",countOfLentils,priceOfLentils);
                    stringBuilder.append(orderLentils);
                }
                String or = stringBuilder.toString();
                intentOrder.putExtra("cellulose", or);
                intentOrder.putExtra("priceCellulose", priceCellulose);
                startActivity(intentOrder);
                break;
        }


    }
}