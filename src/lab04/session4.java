//Data Entry Program GSLC
package lab04;

import java.util.Scanner;
import java.util.ArrayList;

class Data{
    String name;
    String pass;
    String phone;

    public Data(String name, String pass, String phone){
        this.name = name;
        this.pass = pass;
        this.phone = phone;
    }
}


public class session4 {
    Scanner userInput = new Scanner(System.in);
    ArrayList<Data> items = new ArrayList<Data>();

    int findItem(String name) {
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).name.equalsIgnoreCase(name)) {
                return i;      // found: return its position
            }
        }
        return -1;             // not found
    }

    // reads a whole line and turns it into a number, returns -1 if it is not a number
    int readNumber() {
        try {
            return Integer.parseInt(userInput.nextLine().trim());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    void showData() {
        System.out.println("===========================================");
        System.out.printf("|%-3s|%-10s|%-10s|%-15s|%n", "No", "Name", "Pass", "Phone");
        System.out.println("===========================================");

        if (items.size() == 0) {
            System.out.println("No data exists");
        } else {
            for (int i = 0; i < items.size(); i++) {
                Data d = items.get(i);
                System.out.printf("|%-3d|%-10s|%-10s|%-15s|%n", (i + 1), d.name, d.pass, d.phone);
            }
        }
        System.out.println("===========================================");
    }


    public session4(){
        int choice = 0;

        while(choice != 4){
            System.out.println("1. Input data");
            System.out.println("2. Show data");
            System.out.println("3. Delete data");
            System.out.println("4. Exit");
            System.out.print("Choose: ");

            choice = readNumber();

            switch (choice) {
                case 1:
                    System.out.println("Name: ");
                    String userName = userInput.nextLine().trim(); //stores the input from user
                    System.out.println("Pass: ");
                    String userPass = userInput.nextLine().trim(); //stores the input from user
                    System.out.println("Phone: ");
                    String userPhone= userInput.nextLine().trim(); //stores the input from user

                    if(userName.isEmpty() || userPass.isEmpty() || userPhone.isEmpty()){
                        System.out.println("Data is empty!");
                    }
                    else if(findItem(userName) != -1){
                        System.out.println("Data already exists!");
                    }
                    else{
                        items.add(new Data(userName, userPass, userPhone));
                        System.out.println("New data is added");
                    }
                    break;


                case 2:
                    showData();
                    break;


                case 3:
                    if (items.size() == 0) {
                        System.out.println("No data to remove");
                        break;
                    }

                    showData();
                    System.out.println("Input data number to be removed: ");
                    int number = readNumber();

                    if(number < 1 || number > items.size()){
                        System.out.println("Data not found");
                    }else{
                        Data removed = items.remove(number - 1);   // list starts at 0, table starts at 1
                        System.out.println(removed.name + " data removed");
                    }
                    break;


                case 4:
                    System.out.println("Byebye");
                    break;

                default:
                    System.out.println("Invalid input");
            }
        }
    }


    public static void main(String[] args) {
        new session4();
    }
}
