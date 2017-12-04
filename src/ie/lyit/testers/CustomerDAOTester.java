package ie.lyit.testers;
import ie.lyit.hotel.CustomerDAOImpl; 

import java.util.Scanner;

public class CustomerDAOTester {
	public static void main(String[] args) 
	{
		CustomerDAOImpl dao1 = new CustomerDAOImpl(); 
		dao1.deserialize(); //deserialize the file first
		
		Scanner keyboard = new Scanner(System.in); 
		int choice; 
		
		do {
			 System.out.println("\n1. Add");
			 System.out.println("2. List");
			 System.out.println("3. View");
			 System.out.println("4. Edit");
			 System.out.println("5. Delete");
			 System.out.println("6. Quit");
			 
			 choice = keyboard.nextInt(); 
			 
			 switch(choice)
			 {
			   case 1:dao1.add();break;
			   case 2:dao1.list();break;
			   case 3:dao1.view();break;
			   case 4:dao1.edit();break;
			   case 5:dao1.delete();break;
			   case 6: System.out.println("Goodbye..");break;				
			   default:System.out.println("Invalid - please enter a number between 1 and 6");
			}
			 
			 
		}while(choice!= 6); 
		
		//serialize the object, write back into the file
		dao1.serialize();
	}

}
