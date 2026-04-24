package com.plurasight;

import java.util.Scanner;

public class OnlineStore {

    public static void main(String[] args) {
        startOnlineStore();
    }

    public static void startOnlineStore(){
        Inventory inventory = new Inventory();
        Cart cart = new Cart();
        StoreUI ui = new StoreUI();
        boolean running = true;
        do {
            ui.mainMenuInit();
            int userInput = getUserInputInt();
            switch (userInput){
                case 1: ui.displayProductMenu(inventory);
                    break;
                case 2:
                    ui.displayCart(cart);

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

    public static String getUserInputString() {
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();
        return userInput;
    }
    public static int getUserInputInt(){
        Scanner scanner = new Scanner(System.in);
        int userInput = scanner.nextInt();
        scanner.nextLine();
        return userInput;
    }
}
