package com.example.project1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Fats extends AppCompatActivity implements View.OnClickListener {

    private ImageView proteins_img;
    private ImageView carbohydrates_img;
    private ImageView cellulose_img;
    private ImageView back;

    private ImageView olive_oil_plus;
    private ImageView olive_oil_minus;
    private TextView  olive_oil_counter;

    private ImageView walnuts_plus;
    private ImageView walnuts_minus;
    private TextView  walnuts_counter;

    private ImageView avocado_plus;
    private ImageView avocado_minus;
    private TextView  avocado_counter;

    private Button order_btn;
    StringBuilder stringBuilder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fats);
        stringBuilder = new StringBuilder();
        proteins_img = findViewById(R.id.proteins_img);
        carbohydrates_img = findViewById(R.id.carbohydrates_img);
        cellulose_img = findViewById(R.id.cellulose_img);
        back = findViewById(R.id.back);
        order_btn = findViewById(R.id.order_btn);

        proteins_img.setOnClickListener(this);
        carbohydrates_img.setOnClickListener(this);
        cellulose_img.setOnClickListener(this);
        back.setOnClickListener(this);
        order_btn.setOnClickListener(this);

        //Count
        olive_oil_plus =    findViewById(R.id.olive_oil_plus);
        olive_oil_minus =   findViewById(R.id.olive_oil_minus);
        olive_oil_counter = findViewById(R.id.olive_oil_counter);
        olive_oil_plus.setOnClickListener(this);
        olive_oil_minus.setOnClickListener(this);

        walnuts_counter = findViewById(R.id.walnuts_counter);
        walnuts_plus =    findViewById(R.id.walnuts_plus);
        walnuts_minus =   findViewById(R.id.walnuts_minus);
        walnuts_plus.setOnClickListener(this);
        walnuts_minus.setOnClickListener(this);

        avocado_counter = findViewById(R.id.avocado_counter);
        avocado_plus =    findViewById(R.id.avocado_plus);
        avocado_minus =   findViewById(R.id.avocado_minus);
        avocado_plus.setOnClickListener(this);
        avocado_minus.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        int countOfolive_oil = Integer.parseInt(olive_oil_counter.getText().toString());
        int countOfwalnuts = Integer.parseInt(walnuts_counter.getText().toString());
        int countOfavocado = Integer.parseInt(avocado_counter.getText().toString());
        switch (view.getId()) {
            case R.id.proteins_img:
                Intent intent = new Intent(getApplicationContext(), Proteins.class);
                startActivity(intent);
                break;
            case R.id.carbohydrates_img:
                Intent intent1 = new Intent(getApplicationContext(), Carbohydrates.class);
                startActivity(intent1);
                break;
            case R.id.cellulose_img:
                Intent intent2 = new Intent(getApplicationContext(), Cellulose.class);
                startActivity(intent2);
                break;
            case R.id.back:
                Intent intent3 = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent3);
                break;

            //Count
            case R.id.olive_oil_plus:
                countOfolive_oil++;
                olive_oil_counter.setText(String.valueOf(countOfolive_oil));
                break;
            case R.id.olive_oil_minus:
                countOfolive_oil--;
                if (countOfolive_oil < 0)
                    break;
                else{
                    olive_oil_counter.setText(String.valueOf(countOfolive_oil));
                    break;}
            case R.id.walnuts_plus:
                countOfwalnuts++;
                walnuts_counter.setText(String.valueOf(countOfwalnuts));
                break;
            case R.id.walnuts_minus:
                countOfwalnuts --;
                if (countOfwalnuts < 0)
                    break;
                else{
                    walnuts_counter.setText(String.valueOf(countOfwalnuts));
                    break;}
            case R.id.avocado_plus:
                countOfavocado++;
                avocado_counter.setText(String.valueOf(countOfavocado));
                break;
            case R.id.avocado_minus:
                countOfavocado --;
                if (countOfavocado < 0)
                    break;
                else{
                    avocado_counter.setText(String.valueOf(countOfavocado));
                    break;}
            case R.id.order_btn:
                Intent intentOrder = new Intent(this, Basket.class);


                int priceOfOlive_oil = countOfolive_oil * 300;
                int priceOfWalnuts = countOfwalnuts * 1200;
                int priceOfAvocado = countOfavocado * 2000;
                int pricefats = priceOfOlive_oil + priceOfWalnuts + priceOfAvocado;
                String priceFats = String.valueOf(pricefats);
                String orderOlive_oil = "";
                String orderWalnuts = "";
                String orderAvocado = "";
                if(countOfolive_oil> 0){
                    orderOlive_oil =    String.format("\nOlive oil                      %s          %s tg",countOfolive_oil,priceOfOlive_oil);
                    stringBuilder.append(orderOlive_oil);
                }
                if(countOfwalnuts > 0){
                    orderWalnuts = String.format("\nWalnuts                      %s          %s tg",countOfwalnuts,priceOfWalnuts);
                    stringBuilder.append(orderWalnuts);
                }
                if(countOfavocado > 0){
                    orderAvocado =  String.format("\nAvocado                     %s          %s tg",countOfavocado,priceOfAvocado);
                    stringBuilder.append(orderAvocado);
                }
                String or = stringBuilder.toString();
                intentOrder.putExtra("fats", or);
                intentOrder.putExtra("priceFats", priceFats);

                startActivity(intentOrder);

                break;
        }
    }
}