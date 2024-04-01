package org.example.models;

import java.util.*;

public class Grocery {

    public static List groceryList = new ArrayList();

    public void startGrocery() {
        Scanner input = new Scanner(System.in);

        System.out.print("Please enter a number(0: stop, 1: add, 2: delete): ");
        String num = input.nextLine();

        if (!num.equals("0") && !num.equals("1") && !num.equals("2")) {
            System.out.println("Please enter a valid number!");
            startGrocery();
        } else if (num.equals("0")) {
            System.out.println("Grocery List : " + groceryList);
            System.out.println("Shopping is over :(");
            return;

        } else if (num.equals("1")) {
            System.out.println("Please enter the products you want to be added : ");
            String item = input.nextLine();
            addItems(item);

        } else {  //if (num.equals("2"))
            System.out.println("Please enter the products you want to delete : ");

            String item = input.nextLine();
            removeItems(item);
        }

        startGrocery();
    }

    public static void addItems(String input) {
        String[] items = input.split(",");

        for (String item : items) {
            if (!item.isBlank() && !checkItemIsInList(item)) {
                groceryList.add(item.trim());
            }
        }
        printSorted();
    }

    public static void removeItems(String input) {
        String[] items = input.split(",");

        for (String item : items) {
            if (!item.isBlank() && checkItemIsInList(item)) {
                groceryList.remove(item);
            }
        }
        printSorted();
    }

    public static boolean checkItemIsInList(String product) {
        return groceryList.contains(product.trim());
    }

    public static void printSorted() {
        Collections.sort(groceryList);
        System.out.println("Grocery List : " + groceryList);
        //groceryList.forEach(g-> System.out.println(g));
    }

}
