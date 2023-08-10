package com.example.shop.model;

public class Goods {

    int id, category;
    String img, name, description, color, price, previewDesc, goodsPreview, goodsPreBg, previewName;
    float multiplier1;

    public Goods(int id, String img, String name, String description, String color, String price, String previewDesc, String goodsPreview, String goodsPreBg, String previewName, int category, float multiplier1) {
        this.id = id;
        this.img = img;
        this.name = name;
        this.description = description;
        this.color = color;
        this.price = price;
        this.previewDesc = previewDesc;
        this.goodsPreview = goodsPreview;
        this.goodsPreBg = goodsPreBg;
        this.previewName = previewName;
        this.category = category;
        this.multiplier1 = multiplier1;
    }

    public float getMultiplier1() {
        return multiplier1;
    }

    public void setMultiplier1(float multiplier1) {
        this.multiplier1 = multiplier1;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public String getPreviewName() {
        return previewName;
    }

    public void setPreviewName(String previewName) {
        this.previewName = previewName;
    }

    public String getGoodsPreview() {
        return goodsPreview;
    }

    public void setGoodsPreview(String goodsPreview) {
        this.goodsPreview = goodsPreview;
    }

    public String getGoodsPreBg() {
        return goodsPreBg;
    }

    public void setGoodsPreBg(String goodsPreBg) {
        this.goodsPreBg = goodsPreBg;
    }

    public String getPreviewDesc() {
        return previewDesc;
    }

    public void setPreviewDesc(String previewDesc) {
        this.previewDesc = previewDesc;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
