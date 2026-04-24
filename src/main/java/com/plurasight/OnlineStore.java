package com.plurasight;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class OnlineStore {

    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        startOnlineStore();
    }

    public static void startOnlineStore(){
        Inventory inventory = loadInventory();
        Cart cart = new Cart();
        StoreUI ui = new StoreUI();
        boolean running = true;
        do {
            ui.mainMenuInit();
            int userInput = scanner.nextInt();
            scanner.nextLine();
            switch (userInput){
                case 1:
                    ui.displayProductMenu(inventory);
                    userInput = scanner.nextInt();
                    scanner.nextLine();

                    break;
                case 2:
                    ui.displayCart(cart);
                    userInput = scanner.nextInt();
                    scanner.nextLine();
                    break;
                case 3:
                    System.out.println("Thank you, I'll see you soon!");
                    running = false;
                        break;
                default:
                    System.err.println("Please select from the options available in the menu");
                    break;
            }

        }while (running);
    }

    private static Inventory loadInventory(){
        Inventory inventory = new Inventory();
        String fileName ="products.csv";
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
            String fileInput = "";
            int i = 0;
            while ((fileInput = bufferedReader.readLine()) != null){
               try {
                   if (i > 0) {
                       String[] fileStringPart = fileInput.split("\\|");
                       String sku = fileStringPart[0];
                       String name = fileStringPart[1];
                       double price = Double.parseDouble(fileStringPart[2]);
                       String department = fileStringPart[3];
                       inventory.addProduct(new Product(sku, name, price, department));
                   }
                   i++;
               }catch (IndexOutOfBoundsException iob){
                   System.err.println("ERROR: could not load the data from the file: " + fileName);
               }
            }bufferedReader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return inventory;
    }

}
