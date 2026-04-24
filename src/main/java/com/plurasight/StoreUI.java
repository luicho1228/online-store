package com.plurasight;
import java.util.ArrayList;
public class StoreUI {
    String blueTextColor;
    String yellowTextColor;
    public StoreUI(){
        blueTextColor = "\u001B[34m";
        yellowTextColor ="\u001B[33m";
        initializeOnlineStore();
    }
    private void initializeOnlineStore(){
        int initCount = 0;
        System.out.print(blueTextColor + "Initializing interface!");
        do {
            System.out.print(".");
            initCount++;
            pauseThread(1);
        }while (initCount < 3);
        System.out.println("\nWelcome to Luis Online Store!");
    }
    public void mainMenuInit(){
        System.out.println("=====HOME MENU=====");
        System.out.println("1.Display Products" +
                "\n2.Display Cart" +
                "\n3.Exit - closes out of the application");
    }
    public void displayProductMenu(Inventory inventory){
        System.out.println("=====PRODUCT MENU=====");
        ArrayList<Product> productList = inventory.getInventoryArray();
        displayProductsInArray(productList);

    }
    public void displayCart(Cart cart){
        System.out.println("=====MY CART=====");
        ArrayList<Product> cartProductList = cart.getAllProductsInCarts();
        displayProductsInArray(cartProductList);
    }
    public void displayProductsInArray(ArrayList<Product> productList){
        int itemIndex = 0;
        for (Product product: productList) {
            System.out.println(itemIndex +"."+product);
            itemIndex++;
        }
        displayExitOptions();
    }
    public void displayExitOptions(){
        System.out.print(yellowTextColor + "Enter 0 to go back to Home Menu\n" + blueTextColor);
    }
    public static void pauseThread(int seconds){
        seconds *= 1000;
        try {
            Thread.sleep(seconds);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
