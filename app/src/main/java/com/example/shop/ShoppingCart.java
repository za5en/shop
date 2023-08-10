package com.example.shop;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.shop.adapter.ShoppingCartAdapter;
import com.example.shop.model.Cart;
import com.example.shop.model.Goods;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart extends AppCompatActivity {

    Context context = this;
    RecyclerView shoppingRecycler;
    ShoppingCartAdapter shoppingCartAdapter;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_cart);
        List<Cart> cartList = new ArrayList<>();

        ImageButton infoButton = findViewById(R.id.infoButton);
        ImageButton profileButton = findViewById(R.id.profileButton);
        TextView totalPriceAmount = findViewById(R.id.totalPriceAmount);
        ImageButton acceptOffer = findViewById(R.id.acceptOffer);

        float sum = 0;

        for (Goods c : MainActivity.allGoodsList) {
            if (Cart.items_id.contains(c.getId())) {
                float mult = Integer.parseInt(Cart.realAmount[c.getId()]);
                mult *= c.getMultiplier1();
                sum += mult;
                cartList.add(new Cart(Cart.realAmount[c.getId()], c.getPreviewName(), String.valueOf((int)mult) + " ₽"));
            }
        }
        String sumS = String.valueOf((int)sum) + " ₽";

        totalPriceAmount.setText(sumS);

        setShoppingCartRecycler(cartList);

        infoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, AboutPage.class);
                startActivity(intent);
            }
        });

        profileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "Скоро!", Toast.LENGTH_SHORT).show();
            }
        });

        acceptOffer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "заказ оформлен!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void setShoppingCartRecycler(List<Cart> cartList) {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        shoppingRecycler = findViewById(R.id.shoppingRecycler);
        shoppingRecycler.setLayoutManager(layoutManager);
        shoppingCartAdapter = new ShoppingCartAdapter(this, cartList);
        shoppingRecycler.setAdapter(shoppingCartAdapter);
    }
}