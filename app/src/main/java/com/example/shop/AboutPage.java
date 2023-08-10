package com.example.shop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class AboutPage extends AppCompatActivity {

    Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_page);

        TextView aboutText = findViewById(R.id.aboutText);
        aboutText.setMovementMethod(new ScrollingMovementMethod());
        ImageButton cartLButton = findViewById(R.id.cartLButton);
        ImageButton infoButton = findViewById(R.id.infoButton);
        ImageButton profileButton = findViewById(R.id.profileButton);
        ImageButton shippingButton = findViewById(R.id.shippingButton);

        cartLButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, ShoppingCart.class);
                startActivity(intent);
            }
        });

        profileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "Скоро!", Toast.LENGTH_SHORT).show();
            }
        });

        shippingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, Shipping.class);
                startActivity(intent);
            }
        });
    }
}