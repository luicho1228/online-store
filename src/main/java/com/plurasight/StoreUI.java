package com.plurasight;
import java.util.ArrayList;

//This class manages the UI of the app
public class StoreUI {
    //-------------------------------------------------
    //Field variables to use globally within the class
    String blueTextColor;
    String yellowTextColor;
    String greenTextColor;
    String resetTextColor;
    String productDetailsTitle;

    //-------------------------------------------------------
    //Constructor to initialize the class and field variables
    public StoreUI(){
        blueTextColor = "\u001B[34m";
        yellowTextColor ="\u001B[33m";
        resetTextColor = "\u001B[0m";
        greenTextColor = "\u001B[32m";
        productDetailsTitle = "\t|" + "\t\tSKU | Product Name | Price | Department " + "|";
        initializeOnlineStore();
    }

    //--------------------------------------------------------------------------
    //These methods initialize the UI and also dislay the Main Menu or Home menu

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
        displayTitle("HOME MENU");
        System.out.println("\t1.Display Products" +
                "\n\t2.Display Cart" +
                "\n\t3.Exit - closes out of the application");
        System.out.print("\n"+yellowTextColor + "Enter command: " + blueTextColor);
    }

    //-------------------------------------------------------------------
    //methods that display menus that ask for user input and sections of the app

    public void displayProductMenu(Inventory inventory){
        displayTitle("PRODUCT MENU");
        ArrayList<Product> productList = inventory.getInventoryArray();
        if (productList.isEmpty()){
            System.err.println("Inventory is Empty!");
            displayDivider(50);
            displayBackToMenuOption();
        }else {
            displayProductsInArray(productList);
            displayDivider(50);
            System.out.println("\t1.Search " +
                    "\n\t2.Add to cart " +
                    "\n\t3.Go back to main menu");
            System.out.print("\n" + yellowTextColor + "Enter Command: " + blueTextColor);
        }
    }

    public void displayCart(Cart cart){
        displayTitle("MY CART");
        ArrayList<Product> cartProductList = cart.getAllProductsInCarts();
        if(cartProductList.isEmpty()){
            System.out.println("\n" + "\t**Cart is Empty!**" + "\n");
            displayBackToMenuOption();
        }else {
            displayProductsInArray(cartProductList);
        }
    }

    public void displaySearchOptions(){
        displayTitle("SEARCH ITEMS");
        System.out.println("Select a Search method: " +
                "\n\t1.Search by Name " +
                "\n\t2.Search by Price " +
                "\n\t3.Search by Department");
        System.out.print("\n" + yellowTextColor + "Enter Command: " + blueTextColor);
    }


    public void displaySearchPrompts(int userInput){
        if (userInput == 1){
            System.out.print("Enter name of product " +
                    yellowTextColor + "\nEnter command: " + blueTextColor);
        } else if (userInput == 2) {
            System.out.print("Enter price of products " +
                    yellowTextColor + "\nEnter command: " + blueTextColor);
        }else if (userInput == 3){
            System.out.print("Enter product Department " +
                    yellowTextColor + "\nEnter command: " + blueTextColor);
        }
    }

    public void displayAddProductUI(){}


    //-------------------------------------------------------------------------------
    //These methods display a product or a list of products from the inventory class
    // (typically used in the display product section and the cart section)

    public void displayProduct(Product product){
        displayProductDetails();
        System.out.println("\t" +"* "+ resetTextColor + product + blueTextColor);
    }

    public void displayProductsInArray(ArrayList<Product> productList){
        displayProductDetails();
        for (Product product: productList) {
            System.out.println("\t"+"* "+resetTextColor +product + blueTextColor);
        }
    }

    //----------------------------------------------------------------------------------------------------------
    //Helper Methods to display functionalities or components that iterate over the ui and to help display decorative features

    public void displayDivider(int length){
        String divider ="";
        for (int i = 0; i < length; i++){
            divider += "--";
        }
        System.out.println(divider);
    }
    public void displayProductDetails(){
        int borderLength = productDetailsTitle.length();
        String border = "\t";
        for(int i = 0; i < borderLength; i++){
            border += "-";
        }
        System.out.println(border);
        System.out.println(productDetailsTitle);
    }
    public void displayTitle(String title){
        String titleDisplay = "\n";
        int numberString = 100 - title.length();
        for(int i = 0; i < numberString; i++){
            titleDisplay += "=";
            if(i == (numberString/2)){
                titleDisplay += title;

            }
        }System.out.println(titleDisplay + "\n");
    }

    public void displayBackToMenuOption(){
        displayDivider(50);
        System.out.print(yellowTextColor + "Enter 0 to go back to Home Menu\n" + blueTextColor);
        System.out.print(yellowTextColor + "Enter Command: " + blueTextColor);
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