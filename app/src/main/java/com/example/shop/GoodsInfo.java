package com.example.shop;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.shop.model.Cart;

import org.w3c.dom.Text;

public class GoodsInfo extends AppCompatActivity {

    final Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goods_info);

        ImageButton cartLButton = findViewById(R.id.cartLButton);
        ImageButton infoButton = findViewById(R.id.infoButton);
        ImageButton profileButton = findViewById(R.id.profileButton);

        ConstraintLayout goodsPreBg = findViewById(R.id.goodsPreBg);
        ImageView goodsPreview = findViewById(R.id.goodsPreview);
        TextView previewName = findViewById(R.id.previewName);
        TextView goodsPreviewDesc = findViewById(R.id.goodsPreviewDesc);
        TextView goodsPrice = findViewById(R.id.goodsPrice);
        ImageButton addToCart = findViewById(R.id.addToCart);
        goodsPreviewDesc.setMovementMethod(new ScrollingMovementMethod());
        goodsPreBg.setBackgroundColor(getIntent().getIntExtra("goodsPreBg", 0));
        goodsPreview.setImageResource(getIntent().getIntExtra("goodsPreview", 0));
        previewName.setText(getIntent().getStringExtra("previewName"));
        goodsPreviewDesc.setText(getIntent().getStringExtra("goodsPreviewDesc"));
        goodsPrice.setText(getIntent().getStringExtra("goodsPrice"));


        cartLButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, ShoppingCart.class);
                startActivity(intent);
            }
        });

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

        addToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                        LayoutInflater layoutInflater = LayoutInflater.from(context);
                        View dialView = layoutInflater.inflate(R.layout.activity_dial_cart, null);

                        AlertDialog.Builder dialBuilder = new AlertDialog.Builder(context);

                        dialBuilder.setView(dialView);
                        final EditText input = (EditText) dialView.findViewById(R.id.amountType);

                        dialBuilder.setCancelable(false)
                            .setPositiveButton("Готово", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    int item_id = getIntent().getIntExtra("goodsId", 0);
                                    Cart.items_id.add(item_id);
                                    Cart.realAmount[item_id] = input.getText().toString();
                                    Toast.makeText(context, "успешно!", Toast.LENGTH_LONG).show();
                                }
                            })
                            .setNegativeButton("Отмена", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    dialogInterface.cancel();
                                }
                            });

                        dialBuilder.create().show();
            }
        });
    }
}