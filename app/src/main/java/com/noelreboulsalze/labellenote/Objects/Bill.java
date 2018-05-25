package com.noelreboulsalze.labellenote.Objects;

import com.google.gson.annotations.SerializedName;

/**
 * Created by ysiguman on 24/05/18.
 */

public class Bill {
    @SerializedName("id")
    private String id;
    @SerializedName("type")
    private String type;
    @SerializedName("prix")
    private int price;
    @SerializedName("quantite")
    private int quantity;
    @SerializedName("userID")
    private String  userId;

    public Bill() {
    }

    public Bill(String id, String type, int price, int quantity, String userId) {
        this.id = id;
        this.type = type;
        this.price = price;
        this.quantity = quantity;
        this.userId = userId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
