
//EMPLOYEE MANAGEMENT MENU
package lab02;  

import java.util.Scanner; //import scanner class
import java.util.ArrayList;

public class session1 {
    Scanner userInput = new Scanner(System.in); //create a scanner object
        ArrayList<String> emails = new ArrayList<String>();
        ArrayList<String> names = new ArrayList<String>();




    public session1(){
        int choice = 0;

        while(choice != 3){
        System.out.println("EMPLOYEE MANAGEMENT MENU");
        System.out.println("1. Insert Employee Data");
        System.out.println("2. View All");
        System.out.println("3. Exit");            
        

        choice = userInput.nextInt();
        userInput.nextLine(); //consume leftover enter

        switch (choice) {
            case 1:
                 System.out.println("Insert Employee Data...");
                 System.out.println("Enter employee (name;email): "); 
                 String empInput = userInput.nextLine();
                 String[] empData = empInput.split(";");//Split employee input into two

                 if(empData.length != 2){
                    System.out.println("Data is invalid.");
                    break;
                 } 

                String empName = empData[0].trim(); 
                String empEmail = empData[1].trim();

                if(empEmail.contains("@")){
                    emails.add(empEmail); //save into array
                    names.add(empName); //saves name into array
                    System.out.println("Data saved.");
                }
                else{
                    System.out.println("Email is not valid.");
                }
                break;

        
            case 2:
                if(names.size() == 0){
                    System.out.println("No employees yet.");
                    break;
                }

                System.out.println("List of employees:");
                for(int i = 0; i < names.size(); i++){
                    System.out.println((i+1) + (". ") + names.get(i) + "-" + emails.get(i));
                }
                break;

            case 3:
                System.out.println("Goodbye");
                break;

            default:
                System.out.println("Invalid input.");
        }
        System.out.println();

        }
    }


public static void main(String[] args){
    System.out.println("Main started running");
    new session1();
    System.out.println("Main stopped running");
    }
}