package com.example.project1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Proteins extends AppCompatActivity implements View.OnClickListener {

    private ImageView egg_plus;
    private ImageView egg_minus;
    private TextView  egg_counter;

    private ImageView chicken_plus;
    private ImageView chicken_minus;
    private TextView  chicken_counter;

    private ImageView cheese_plus;
    private ImageView cheese_minus;
    private TextView  cheese_counter;
    private StringBuilder stringBuilder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proteins);
        stringBuilder = new StringBuilder();
        //Count
        egg_plus = findViewById(R.id.egg_plus);
        egg_minus = findViewById(R.id.egg_minus);
        egg_counter = findViewById(R.id.egg_counter);
        egg_plus.setOnClickListener(this);
        egg_minus.setOnClickListener(this);

        chicken_counter = findViewById(R.id.chicken_counter);
        chicken_plus = findViewById(R.id.chicken_plus);
        chicken_minus = findViewById(R.id.chicken_minus);
        chicken_plus.setOnClickListener(this);
        chicken_minus.setOnClickListener(this);

        cheese_counter = findViewById(R.id.cheese_counter);
        cheese_plus = findViewById(R.id.cheese_plus);
        cheese_minus = findViewById(R.id.cheese_minus);
        cheese_plus.setOnClickListener(this);
        cheese_minus.setOnClickListener(this);

    }

    public void onClickGoToMain(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void onClickGoToCarbohydrates(View view) {
        Intent intent = new Intent(this, Carbohydrates.class);
        startActivity(intent);
    }

    public void onClickGoToCellulose(View view) {
        Intent intent = new Intent(this, Cellulose.class);
        startActivity(intent);
    }

    public void onClickGoToFats(View view) {
        Intent intent = new Intent(this, Fats.class);
        startActivity(intent);
    }


    @Override
    public void onClick(View view) {
        int countOfEggs = Integer.parseInt(egg_counter.getText().toString());
        int countOfChicken = Integer.parseInt(chicken_counter.getText().toString());
        int countOfCheese = Integer.parseInt(cheese_counter.getText().toString());
        switch (view.getId()){
            case R.id.egg_plus:
                countOfEggs++;
                egg_counter.setText(String.valueOf(countOfEggs));
                break;
            case R.id.egg_minus:
                countOfEggs--;
                if (countOfEggs < 0)
                    break;
                else{
                    egg_counter.setText(String.valueOf(countOfEggs));
                    break;}
            case R.id.chicken_plus:
                countOfChicken++;
                chicken_counter.setText(String.valueOf(countOfChicken));
                break;
            case R.id.chicken_minus:
                countOfChicken --;
                if (countOfChicken < 0)
                    break;
                else{
                    chicken_counter.setText(String.valueOf(countOfChicken));
                    break;}
            case R.id.cheese_plus:
                countOfCheese++;
                cheese_counter.setText(String.valueOf(countOfCheese));
                break;
            case R.id.cheese_minus:
                countOfCheese --;
                if (countOfCheese < 0)
                    break;
                else{
                    cheese_counter.setText(String.valueOf(countOfCheese));
                    break;}
        }

    }

    public void onClickGoToOrder(View view) {
        Intent intent = new Intent(this, Basket.class);

        int countOfEggs = Integer.parseInt(egg_counter.getText().toString());
        int countOfChicken = Integer.parseInt(chicken_counter.getText().toString());
        int countOfCheese = Integer.parseInt(cheese_counter.getText().toString());

        int priceOfEggs = countOfEggs * 300;
        int priceOfChicken = countOfChicken * 1200;
        int priceOfCheese = countOfCheese * 2000;
        int priceprotein = priceOfEggs + priceOfChicken + priceOfCheese;
        String priceProtein = String.valueOf(priceprotein);
        String orderEggs = "";
        String orderChicken = "";
        String orderCheese = "";
        if(countOfEggs > 0){
            orderEggs =    String.format("\nEggs                          %s            %s tg",countOfEggs,priceOfEggs);
            stringBuilder.append(orderEggs);
        }
        if(countOfChicken > 0){
            orderChicken = String.format("\nChicken                     %s            %s tg",countOfChicken,priceOfChicken);
            stringBuilder.append(orderChicken);
        }
        if(countOfCheese > 0){
            orderCheese =  String.format("\nCheese                      %s            %s tg",countOfCheese,priceOfCheese);
            stringBuilder.append(orderCheese);
        }
        String or = stringBuilder.toString();
        intent.putExtra("protein", or);
        intent.putExtra("priceProtein", priceProtein);
        startActivity(intent);
    }
}