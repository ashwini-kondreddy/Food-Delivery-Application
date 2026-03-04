package com.tap.model;

import java.util.*;

public class Cart {

    private Map<Integer, CartItem> items;

    // ✅ FIXED CONSTRUCTOR
    public Cart() {
        items = new HashMap<>();
    }

    public Cart(Map<Integer, CartItem> items) {
        this.items = items;
    }

    public void addItem(CartItem item) {

        int itemId = item.getItemId();

        if(items.containsKey(itemId)) {

            CartItem existingItem = items.get(itemId);

            int newQua = item.getQuantity();
            int oldQua = existingItem.getQuantity();

            existingItem.setQuantity(newQua + oldQua);

        } else {
            items.put(itemId, item);
        }
    }

    public void updateItem(int itemId, int quantity) {

        if(items.containsKey(itemId)) {

            if(quantity <= 0) {
                items.remove(itemId);
            } else {
                CartItem existingCartItem = items.get(itemId);
                existingCartItem.setQuantity(quantity);
            }
        }
    }

    public Map<Integer, CartItem> getItems() {
        return items;
    }

    public void removeItem(int itemId) {
        items.remove(itemId);
    }

    public double getTotalPrice() {

        double totalPrice = 0.0;

        for (CartItem item : items.values()) {
            totalPrice += item.getPrice() * item.getQuantity();
        }

        return totalPrice;
    }

    public void clear() {
        items.clear();
    }
}