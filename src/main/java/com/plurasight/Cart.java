package com.plurasight;

import java.util.ArrayList;

//This class represents the user's cart object
public class Cart {
    private Inventory cartInventory;
    private boolean isEmpty = true;
    public Cart(){
        cartInventory = new Inventory();
    }
    public Cart(Inventory cartInventory){
        this.cartInventory = cartInventory;
    }
    public void addToCart(Product product){
        cartInventory.addProduct(product);
        if (!cartInventory.getInventoryArray().isEmpty()){
            isEmpty = false;
        }
    }
    public void removeFromCart(Product product){
        cartInventory.removeProduct(product);
        if (cartInventory.getInventoryArray().isEmpty()){
            isEmpty = true;
        }
    }
    public boolean isEmpty(){
        return isEmpty;
    }
    public ArrayList getAllProductsInCarts(){
        return cartInventory.getInventoryArray();
    }

}
