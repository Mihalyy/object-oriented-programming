//GROCERIES MANAGEMENT SYSTEM
package lab03;

import java.util.Scanner;
import java.util.ArrayList;

public class session03 {
    Scanner userInput = new Scanner(System.in);
    ArrayList<String> items = new ArrayList<String>();
    
    int findItem(String name) {
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).equalsIgnoreCase(name)) {
                return i;      // found: return its position
            }
        }
        return -1;             // not found    
    }
    
    
    public session03(){
        int choice = 0;
        
        
        
        
        while(choice != 5){
            System.out.println("== Groceries Management System ==");
            System.out.println("1. Add item");
            System.out.println("2. Remove item");
            System.out.println("3. Search item");
            System.out.println("4. View List");
            System.out.println("5. Exit");
            
            choice = userInput.nextInt();
            userInput.nextLine();   // consume leftover Enter
            
            
            switch (choice) {
                case 1:
                System.out.println("Enter item name: ");
                String inputItem = userInput.nextLine().trim(); //stores the input from user
                
                if(inputItem.isEmpty()){
                    System.out.println("Data is empty!");
                }
                else if(findItem(inputItem) != -1){
                    System.out.println("Data already exists!");
                }
                else{
                    items.add(inputItem);
                    System.out.println("Item added!");
                }
                break;
                

                case 2:
                System.out.println("Enter item to remove: ");
                String deleteItem = userInput.nextLine().trim();

                int index = findItem(deleteItem);
                if(index == -1){
                    System.out.println("Item not found!");
                }else{
                    items.remove(index);
                    System.err.println((deleteItem) + " removed!");
                }
                break;


                case 3:
                    System.out.println("Enter search keyword: ");
                    String searchItem = userInput.nextLine().trim();

                    System.out.println();
                    System.out.println("Search Result: ");                        

                    boolean found = false;

                    for (int i = 0; i < items.size(); i++) {
                            if (items.get(i).toLowerCase().contains(searchItem.toLowerCase())) {
                                System.out.println("- " + items.get(i));
                                found = true;
                            }
                        }
                    
                    if(found != true){
                        System.out.println("No items match your search.");
                    }
                    break;


                case 4:
                    System.out.println("Your grocery list: ");
                    for(int i = 0; i < items.size(); i++){
                        System.out.println((i+1) + (". ") + (items.get(i)));
                    }
                    break;

                    
                case 5:
                    System.err.println("Byebye");
                    break;

                default:
                    System.out.println("Invalid!");
            }
        }
    }
    
    
    public static void main(String[] args) {
        new session03();
    }
}