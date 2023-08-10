package com.example.shop.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shop.GoodsInfo;
import com.example.shop.R;
import com.example.shop.model.Goods;

import java.util.List;

public class GoodsAdapter extends RecyclerView.Adapter<GoodsAdapter.GoodsViewHolder> {

    Context context;
    List<Goods> goodsList;

    public GoodsAdapter(Context context, List<Goods> goodsList) {
        this.context = context;
        this.goodsList = goodsList;
    }

    @NonNull
    @Override
    public GoodsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View goodsItems = LayoutInflater.from(context).inflate(R.layout.goods_item, parent, false);
        return new GoodsAdapter.GoodsViewHolder(goodsItems);
    }

    @Override
    public void onBindViewHolder(@NonNull GoodsAdapter.GoodsViewHolder holder, int position) {
        holder.goodsBg.setBackgroundColor(Color.parseColor(goodsList.get(position).getColor()));

        int imageId = context.getResources().getIdentifier(goodsList.get(position).getImg(), "drawable", context.getPackageName());
        holder.goodsImage.setImageResource(imageId);

        holder.goodsName.setText(goodsList.get(position).getName());
        holder.goodsDesc.setText(goodsList.get(position).getDescription());
        holder.goodsPrice.setText(goodsList.get(position).getPrice());
        int previewId = context.getResources().getIdentifier(goodsList.get(position).getGoodsPreview(), "drawable", context.getPackageName());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, GoodsInfo.class);

                intent.putExtra("goodsPreBg", Color.parseColor(goodsList.get(position).getGoodsPreBg()));
                intent.putExtra("goodsPreview", previewId);
                intent.putExtra("previewName", goodsList.get(position).getPreviewName());
                intent.putExtra("goodsPreviewDesc", goodsList.get(position).getPreviewDesc());
                intent.putExtra("goodsPrice", goodsList.get(position).getPrice());
                intent.putExtra("goodsId", goodsList.get(position).getId());

                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return goodsList.size();
    }

    public static final class GoodsViewHolder extends RecyclerView.ViewHolder {

        LinearLayout goodsBg;
        ImageView goodsImage;
        TextView goodsName, goodsDesc, goodsPrice;

        public GoodsViewHolder(@NonNull View itemView) {
            super(itemView);

            goodsBg = itemView.findViewById(R.id.goodsBg);
            goodsImage = itemView.findViewById(R.id.goodsImage);
            goodsName = itemView.findViewById(R.id.goodsName);
            goodsDesc = itemView.findViewById(R.id.goodsDesc);
            goodsPrice = itemView.findViewById(R.id.goodsPrice);
        }
    }

}
