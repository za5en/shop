package com.example.shop.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shop.R;
import com.example.shop.ShoppingCart;
import com.example.shop.model.Cart;

import org.w3c.dom.Text;

import java.util.List;

public class ShoppingCartAdapter extends RecyclerView.Adapter<ShoppingCartAdapter.ShoppingCartViewHolder> {

    Context context;
    List<Cart> cartList;

    public ShoppingCartAdapter(Context context, List<Cart> cartList) {
        this.context = context;
        this.cartList = cartList;
    }

    @NonNull
    @Override
    public ShoppingCartViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View cartItems = LayoutInflater.from(context).inflate(R.layout.shop_cart_item, parent, false);
        return new ShoppingCartAdapter.ShoppingCartViewHolder(cartItems);
    }

    @Override
    public void onBindViewHolder(@NonNull ShoppingCartAdapter.ShoppingCartViewHolder holder, int position) {
        holder.goodsName.setText(cartList.get(position).getGoodsName());
        holder.amountText.setText(cartList.get(position).getAmount());
        holder.goodsPrice.setText(cartList.get(position).getGoodsPrice());
    }

    @Override
    public int getItemCount() {
        return cartList.size();
    }

    public static final class ShoppingCartViewHolder extends RecyclerView.ViewHolder {

        TextView goodsName, amountText, goodsPrice;

        public ShoppingCartViewHolder(@NonNull View itemView) {
            super(itemView);
            goodsName = itemView.findViewById(R.id.goodsName);
            amountText = itemView.findViewById(R.id.amountText);
            goodsPrice = itemView.findViewById(R.id.goodsPrice);
        }
    }
}
