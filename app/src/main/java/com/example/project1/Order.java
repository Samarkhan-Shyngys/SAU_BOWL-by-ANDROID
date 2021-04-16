package com.example.project1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Order extends AppCompatActivity {

    private EditText name;
    private EditText phone;
    private Spinner location;

    private String paymentType;
    private String fullName;
    private String phoneNumber;
    private String city;

    private String priceProtein;
    private String priceCellulose;
    private String priceFats;
    private String priceCarbohydrates;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        Spinner spinner = (Spinner) findViewById(R.id.location);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.cities, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        name = findViewById(R.id.name);
        phone = findViewById(R.id.phone);
        location = findViewById(R.id.location);

        Intent intent = getIntent();
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
    protected void onStart() {
        super.onStart();

    }

    public void onClickChangePayingType(View view) {
        RadioButton radioButton = (RadioButton) view;
        int id = radioButton.getId();
        if(id == R.id.cash){
            paymentType = getString(R.string.cash);
        }
        else if(id == R.id.creditcard){
            paymentType = getString(R.string.credit_card);
        }
    }

    public void onClickGoToCheck(View view) {
        fullName = name.getText().toString();
        phoneNumber = phone.getText().toString();
        city = (String) location.getSelectedItem();




        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
        String time = format.format(calendar.getTime());
        Intent intent = new Intent(this, Check.class);
        intent.putExtra("fullName", fullName);
        intent.putExtra("phoneNumber", phoneNumber);
        intent.putExtra("city", city);
        intent.putExtra("paymentType", paymentType);
        intent.putExtra("currentTime", time);

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

    public void onClickGoToBasket(View view) {
        Intent intent = new Intent(this,Proteins.class);
        startActivity(intent);
    }
}