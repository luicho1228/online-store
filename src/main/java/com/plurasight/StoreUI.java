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
        System.out.print("Enter command: ");
    }
    public void displayProductMenu(Inventory inventory){
        System.out.println("==================================PRODUCT MENU===================================");
        ArrayList<Product> productList = inventory.getInventoryArray();
        if (productList.isEmpty()){
            System.err.println("Inventory is Empty!");
            System.out.print(yellowTextColor + "Enter 0 to go back to Home Menu\n" + blueTextColor);
            System.out.print("Enter Command: ");
        }else {
            displayProductsInArray(productList);
            System.out.println("1.Search " +
                    "\n2.Add to cart " +
                    "\n3.Go back to main menu");
            System.out.print("Enter Command: ");

        }

    }
    public void displayCart(Cart cart){
        System.out.println("\n=====MY CART=====");
        ArrayList<Product> cartProductList = cart.getAllProductsInCarts();
        if(cartProductList.isEmpty()){
            System.err.println("Cart is Empty!");
            System.out.print(yellowTextColor + "Enter 0 to go back to Home Menu\n" + blueTextColor);
            System.out.print("Enter Command: ");
        }else {
            displayProductsInArray(cartProductList);
        }
    }

    public void displaySearchOptions(){
       System.out.println("===================================SEARCH ITEMs=================================");
        System.out.println("Select a Search method: " +
                "\n1.Search by Name " +
                "\n2.Search by Price " +
                "\n3. Search by Department");
        System.out.print("Enter Command: ");
    }

    public void displayProduct(Product product){
        System.out.println(product);
    }

    public void displayProductsInArray(ArrayList<Product> productList){
        int itemIndex = 0;
        for (Product product: productList) {
            System.out.println(itemIndex +"."+product);
            itemIndex++;
        }
        System.out.println("-----------------------------------------------------------------------------------------");
    }

    public void displaySearchPrompts(int userInput){
        if (userInput == 1){
            System.out.println("Enter name of product " +
                    "\nEnter command: ");
        } else if (userInput == 2) {
            System.out.println("Enter price of products " +
                    "\nEnter command: ");
        }else if (userInput == 3){
            System.out.println("Enter product Department " +
                    "\nEnter command: ");
        }
    }

    public void displaySelectionErrorPrompt(){
        System.err.println("Please select from the options available in the menu");
    }
    public void displayGoodByes(){
        System.out.println("Thank you, I'll see you soon!");
    }

    public void displayLoadFileError(String fileName){
        System.err.println("ERROR: could not load the data from the file: " + fileName);
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
