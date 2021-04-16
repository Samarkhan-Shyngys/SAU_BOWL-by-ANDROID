package com.example.project1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Check extends AppCompatActivity {

    private TextView client;
    private TextView delivery_from;
    private TextView paying_type;
    private TextView shop_contact;
    private TextView purchase_time;
    private TextView price;

    private String priceProtein;
    private String priceCellulose;
    private String priceFats;
    private String priceCarbohydrates;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check);
        client = findViewById(R.id.client);
        delivery_from = findViewById(R.id.delivery_from);
        paying_type = findViewById(R.id.paying_type);
        shop_contact = findViewById(R.id.shop_contact);
        purchase_time = findViewById(R.id.purchase_time);
        price = findViewById(R.id.price);
        Intent intent = getIntent();

        client.setText(intent.getStringExtra("fullName"));
        delivery_from.setText(intent.getStringExtra("city"));
        paying_type.setText(intent.getStringExtra("paymentType"));
        shop_contact.setText(intent.getStringExtra("phoneNumber"));
        purchase_time.setText(intent.getStringExtra("currentTime"));

        // Price of chosen products
        if (intent.hasExtra("priceProtein")){
            priceProtein = intent.getStringExtra("priceProtein");
            price.setText(priceProtein + " tenge");
        }
        if (intent.hasExtra("priceCarbohydrates")){
            priceCarbohydrates = intent.getStringExtra("priceCarbohydrates");
            price.setText(priceCarbohydrates);
        }
        if (intent.hasExtra("priceCellulose")){
            priceCellulose = intent.getStringExtra("priceCellulose");
            price.setText(priceCellulose);
        }
        if (intent.hasExtra("priceFats")){
            priceFats = intent.getStringExtra("priceFats");
            price.setText(priceFats);
        }

    }

    public void GoToMenu(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}