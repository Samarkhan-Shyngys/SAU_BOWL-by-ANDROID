package com.example.project1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Carbohydrates extends AppCompatActivity implements View.OnClickListener {

    private ImageView proteins_img;
    private ImageView cellulose_img;
    private ImageView fat_img;
    private ImageView back;

    private ImageView oats_plus;
    private ImageView oats_minus;
    private TextView  oats_counter;

    private ImageView buckwheat_plus;
    private ImageView buckwheat_minus;
    private TextView  buckwheat_counter;

    private ImageView banana_plus;
    private ImageView banana_minus;
    private TextView  banana_counter;

    private Button order_btn;

    private StringBuilder stringBuilder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carbohydrates);
        stringBuilder = new StringBuilder();
        proteins_img = findViewById(R.id.proteins_img);
        cellulose_img = findViewById(R.id.cellulose_img);
        fat_img = findViewById(R.id.fat_img);
        back = findViewById(R.id.back);
        order_btn = findViewById(R.id.order_btn);

        proteins_img.setOnClickListener(this);
        cellulose_img.setOnClickListener(this);
        fat_img.setOnClickListener(this);
        back.setOnClickListener(this);
        order_btn.setOnClickListener(this);

        //Count
        oats_plus = findViewById(R.id.oats_plus);
        oats_minus = findViewById(R.id.oats_minus);
        oats_counter = findViewById(R.id.oats_counter);
        oats_plus.setOnClickListener(this);
        oats_minus.setOnClickListener(this);

        buckwheat_counter = findViewById(R.id.buckwheat_counter);
        buckwheat_plus = findViewById(R.id.buckwheat_plus);
        buckwheat_minus = findViewById(R.id.buckwheat_minus);
        buckwheat_plus.setOnClickListener(this);
        buckwheat_minus.setOnClickListener(this);

        banana_counter = findViewById(R.id.banana_counter);
        banana_plus = findViewById(R.id.banana_plus);
        banana_minus = findViewById(R.id.banana_minus);
        banana_plus.setOnClickListener(this);
        banana_minus.setOnClickListener(this);

    }
    @Override
    public void onClick(View view) {
        int countOfOats = Integer.parseInt(oats_counter.getText().toString());
        int countOfBuckwheat = Integer.parseInt(buckwheat_counter.getText().toString());
        int countOfBanana = Integer.parseInt(banana_counter.getText().toString());
        switch (view.getId()){
            case R.id.proteins_img:
                Intent intent = new Intent(getApplicationContext(), Proteins.class);
                startActivity(intent);
                break;
            case R.id.cellulose_img:
                Intent intent1 = new Intent(getApplicationContext(), Cellulose.class);
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
            case R.id.oats_plus:
                countOfOats++;
                oats_counter.setText(String.valueOf(countOfOats));
                break;
            case R.id.oats_minus:
                countOfOats--;
                if (countOfOats < 0)
                    break;
                else{
                    oats_counter.setText(String.valueOf(countOfOats));
                    break;}
            case R.id.buckwheat_plus:
                countOfBuckwheat++;
                buckwheat_counter.setText(String.valueOf(countOfBuckwheat));
                break;
            case R.id.buckwheat_minus:
                countOfBuckwheat --;
                if (countOfBuckwheat < 0)
                    break;
                else{
                    buckwheat_counter.setText(String.valueOf(countOfBuckwheat));
                    break;}
            case R.id.banana_plus:
                countOfBanana++;
                banana_counter.setText(String.valueOf(countOfBanana));
                break;
            case R.id.banana_minus:
                countOfBanana --;
                if (countOfBanana < 0)
                    break;
                else{
                    banana_counter.setText(String.valueOf(countOfBanana));
                    break;}
            case R.id.order_btn:
                Intent intentOrder = new Intent(this, Basket.class);


                int priceOfOats = countOfOats * 300;
                int priceOfBuckwheat = countOfBuckwheat * 1200;
                int priceOfBanana = countOfBanana * 2000;
                int pricecarbohydrates = priceOfOats + priceOfBuckwheat + priceOfBanana;
                String priceCarbohydrates = String.valueOf(pricecarbohydrates);
                String orderOats = "";
                String orderBuckwheat = "";
                String orderBanana = "";
                if(countOfOats> 0){
                    orderOats =    String.format("\nOats                           %s          %s tg",countOfOats,priceOfOats);
                    stringBuilder.append(orderOats);
                }
                if(countOfBuckwheat > 0){
                    orderBuckwheat = String.format("\nBuckwheat                %s          %s tg",countOfBuckwheat,priceOfBuckwheat);
                    stringBuilder.append(orderBuckwheat);
                }
                if(countOfBanana > 0){
                    orderBanana =  String.format("\nBanana                      %s          %s tg",countOfBanana,priceOfBanana);
                    stringBuilder.append(orderBanana);
                }
                String or = stringBuilder.toString();
                intentOrder.putExtra("carbohydrates", or);
                intentOrder.putExtra("priceCarbohydrates", priceCarbohydrates);
                startActivity(intentOrder);
                break;
        }
    }
}