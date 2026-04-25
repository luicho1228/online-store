package com.plurasight;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

//This class manages the logic and user input of the app
public class OnlineStore {

    private static Scanner scanner = new Scanner(System.in);
    private static Inventory inventory;
    private static Cart cart = new Cart();
    private static StoreUI ui = new StoreUI();
    public static void main(String[] args) {
        startOnlineStore();
    }

    //This method initialize the app and manages the main menu logic and UI;
    public static void startOnlineStore(){
        inventory = loadInventory();
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
                    if(userInput == 1){
                        ui.displaySearchOptions();
                        Product retreavedProduct = searchProduct(userInput);
                        ui.displayProduct(retreavedProduct);
                        ui.displayBackToMenuOption();
                        userInput = scanner.nextInt();
                        scanner.nextLine();
                    }
                    else if (userInput == 2) {

                    }
                    else if (userInput == 3) {}
                    else{ui.displaySelectionErrorPrompt();}
                    break;
                case 2:
                    ui.displayCart(cart);
                    userInput = scanner.nextInt();
                    scanner.nextLine();
                    break;
                case 3:
                    ui.displayGoodByes();
                    running = false;
                        break;
                default:
                    ui.displaySelectionErrorPrompt();
                    break;
            }
        }while (running);
    }

    //This method implements the ui and logic of the search feature in the app. Returning the desired product to be searched
    private static Product searchProduct(int userInput){
        Product retreavedProduct = null;
        userInput = scanner.nextInt();
        scanner.nextLine();
        if (userInput == 1){
            ui.displaySearchPrompts(userInput);
            String inputName = scanner.nextLine();
            retreavedProduct = inventory.getProductByName(inputName);
        } else if (userInput == 2) {
            ui.displaySearchPrompts(userInput);
            Double userInputDouble = scanner.nextDouble();
            scanner.nextLine();
            retreavedProduct = inventory.getProductByPrice(userInputDouble);
        }else if (userInput == 3){
            ui.displaySearchPrompts(userInput);
            String inputDepartment = scanner.nextLine();
            retreavedProduct = inventory.getProductByDepartment(inputDepartment);
        }
        return retreavedProduct;
    }

    //This method loads the inventory class and fill it up with products data retrieved from the product.csv file
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
                   ui.displayLoadFileError(fileName);
               }
            }bufferedReader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return inventory;
    }
}
