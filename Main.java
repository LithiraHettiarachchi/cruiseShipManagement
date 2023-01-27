package com.company;
import java.io.*;
import java.util.*;


public class Main {
    private static ArrayList<String>read = new ArrayList<String>();
    private static Cabin[] mycabin = new Cabin[12];
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String roomName;
        int roomNum = 0;
        String[] hotel = new String[12];

//initialise
        initialise(hotel); //better to initialise in procedure


        label:
        while (true) {

            optionmenu();
            System.out.println("Enter menu code");
            String menuitem = input.nextLine();
            String upper = menuitem.toUpperCase();
            switch (upper) {
                case "V":
                    viewcabin(hotel);
                    break;
                case "A":
                    while (true) {
                        System.out.println("Enter cabin number (1-12) or 13 to stop:");
                        roomNum = input.nextInt();
                        if ((roomNum >= 0) && (roomNum < 12)) {
                            System.out.println("Enter name for cabin " + roomNum + " :");
                            roomName = input.next();
                            hotel[roomNum] = roomName;
                            read.add(roomName);

                        } else if (roomNum == 13) {
                            break;
                        } else {
                            System.out.println("Enter valid number");
                        }
                    }




                    break;
                case "E":
                    emptycabins(hotel);
                    break;
                case "D": {
                    System.out.println("Please enter customer name");
                    String custname = input.nextLine();
                    List<String> list = Arrays.asList(hotel);
                    if (list.contains(custname)) {
                        list.set(list.indexOf(custname), "e");
                    }

                    break;
                }
                case "F": {
                    System.out.println("Enter customer name");
                    String name = input.nextLine();
                    List<String> list = Arrays.asList(hotel);
                    if (list.contains(name)) {
                        System.out.println(name + " is in " + list.indexOf(name));
                    }
                    break;
                }
                case "S":
                    filewrite(read);
                    break;
                case "L":
                    readfile();
                    break;
                case "O":
                    ordered(hotel);
                    break;
                case "Q":
                    break label;
                case "T":
                    while (true){
                        System.out.println("Enter cabin number (1-12) or 13 to stop:");
                        roomNum = input.nextInt();

                            if ((roomNum >= 0) && (roomNum < 12)) {
                                String firstName;
                                String surName;
                                int expenses=50;
                                int temp;
                                Passenger[] passengersarr = new Passenger[3];
                                for (int i = 1; i <= 3; i++){

                                    System.out.println("Passenger "+ i);
                                    System.out.println("Enter your first name:");
                                    firstName = input.next();
                                    System.out.println("Enter your surname");
                                    surName = input.next();
                                    Passenger passenger = new Passenger(firstName,surName,expenses);
                                    passengersarr[i-1] = passenger;

                                }
                                Cabin cabin = new Cabin(passengersarr[0],passengersarr[1],passengersarr[2]);
                                mycabin[roomNum] = cabin;
                                System.out.println("Expenses for one passenger is $50");
                                for (int i=0; i<=mycabin.length-1; i++) {
                                    if (mycabin[i] != null) {
                                        temp = mycabin.length;
                                        System.out.println("Total expenses: "+ (temp*3*50));
                                    }
                                }
                            }
                            else if (roomNum == 13)
                                break ;
                            else{
                                System.out.println("Enter valid number");
                            }

                    }

            }



        }
    }


    private static void initialise(String[] hotelRef) {
        for (int x = 0; x < 12; x++) hotelRef[x] = "e";
        System.out.println("initilise ");
    }

    //Creating the menu list
    private static void optionmenu() {
        System.out.println("Main Menu");
        System.out.println("----------------------");
        System.out.println("V. View All Cabins ");
        System.out.println("A. Add Customer to Cabin ");
        System.out.println("E. View Empty Cabins");
        System.out.println("D. Delete customer from cabin");
        System.out.println("F. Find cabin from customer name");
        System.out.println("S. Store data into file");
        System.out.println("L. Load program data from file");
        System.out.println("O. Ordered alphabetically by name");
        System.out.println("Q. Quit Program");
        System.out.println("T. show Expenses");
    }

    //View cabin method for option menu "V"
    private static void viewcabin(String[] hotel) {
        for (int x = 0; x < 12; x++) {
            System.out.println("room " + x + " occupied by " + hotel[x]);
        }
    }

    //Empty cabin method for option menu "E"
    private static void emptycabins(String[] hotel) {
        for (int x = 0; x < 12; x++) {
            if (hotel[x].equals("e"))
                System.out.println("room " + x + " is empty");
        }
    }

    //Enter customer details to a text file
    private static void filewrite(ArrayList read) {
        try {
            FileOutputStream fo = new FileOutputStream("data.txt");
            ObjectOutputStream oo = new ObjectOutputStream(fo);
            oo.writeObject(read);
            oo.close();
            fo.close();
        } catch (Exception ex) {
            return;
        }

    }

    //Load data from text file
    private static void readfile() {
        try {
            BufferedReader br =  new BufferedReader(new FileReader("data.txt"));
            String string;
            while ((string = br.readLine()) != null){
                System.out.println(string);
            }



        } catch (Exception ex) {
            return;
        }

    }


    //Create customer names to alphabetical order
    private static void ordered(String[] hotel) {
        String temp;
        String[] temphotel = new String[12];
        for (int i = 0; i < hotel.length;i++){
            if (hotel[i] != null){
                temphotel[i] = hotel[i];
            }
        }

        for (int i = 0; i < temphotel.length; i++) {
            for (int j = i + 1; j < temphotel.length; j++) {
                if (temphotel[i].compareTo(temphotel[j]) > 0) {
                    temp = temphotel[i];
                    temphotel[i] = temphotel[j];
                    temphotel[j] = temp;
                }
            }
        }
        System.out.print("Strings in Sorted Order:");
        for (int i = 0; i <= temphotel.length - 1; i++)
        { if (temphotel[i] != "e"){
            System.out.print(temphotel[i] + ", ");
        }

        }
    }
}



//Reference
//https://howtodoinjava.com/java/collections/arraylist/replace-element-arraylist/
//https://attacomsian.com/blog/java-array-contains-value
//https://beginnersbook.com/2013/12/java-arraylist-indexof-method-example/
//https://www.tutorialspoint.com/How-to-sort-an-array-of-objects-containing-null-elements-in-java
//https://www.geeksforgeeks.org/how-to-create-array-of-objects-in-java/
//https://www.w3schools.com/java/java_constructors.asp
//https://www.geeksforgeeks.org/getter-and-setter-in-java/