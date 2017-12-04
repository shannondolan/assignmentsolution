package ie.lyit.hotel;

import java.util.ArrayList;
import java.io.*;
import java.util.*;

public class CustomerDAOImpl implements Serializable, CustomerDAO{
	private ArrayList<Customer> customers; 
	final String FILENAME = "customer.bin"; //used to create a file 
	
	public CustomerDAOImpl()
	{
		customers = new ArrayList<Customer>(); 
	}
	
	@Override
	public void add()
	{
		Scanner keyboard = new Scanner(System.in); 
		
		System.out.println("Enter customer title:");
		String t = keyboard.nextLine();
		System.out.println("Enter customer first name:");
		String fN = keyboard.nextLine();
		System.out.println("Enter customer surname:");
		String sn = keyboard.nextLine();
		System.out.println("Enter customer address:");
		String address = keyboard.nextLine();
		System.out.println("Enter customer phone number:");
		String pNo = keyboard.nextLine();
		System.out.println("Enter customer email:");
		String email = keyboard.nextLine();
		
		Customer custIn = new Customer(t, fN, sn, address, pNo, email); 
		customers.add(custIn); 
	}
	
	@Override
	public void list()
	{
		for(Customer c: customers)
		{
			System.out.print(c); 
		}
	}
	@Override
	public Customer view()
	{
		Scanner keyboard = new Scanner(System.in);	
		

		//ask customer to enter customer number to retrieve object
		System.out.println("Enter customer number: ");
		int custIn=keyboard.nextInt();
		
		
	    for(Customer c:customers){
		   if(c.getNumber() == custIn){
			  System.out.println(c);
			  return c;
		   }
		}
	    return null; 
	}
	@Override
	public void edit()
	{
		Customer custToEdit = view(); 
		
		Scanner keyboard = new Scanner(System.in);
		if(custToEdit != null)
		{
			int index = customers.indexOf(custToEdit);
			
			System.out.println("Enter customer title:");
			String t = keyboard.nextLine();
			System.out.println("Enter customer first name:");
			String fN = keyboard.nextLine();
			System.out.println("Enter customer surname:");
			String sn = keyboard.nextLine();
			System.out.println("Enter customer address:");
			String address = keyboard.nextLine();
			System.out.println("Enter customer phone number:");
			String pNo = keyboard.nextLine();
			System.out.println("Enter customer email:");
			String email = keyboard.nextLine();
			
			Customer newCustomer = new Customer(t, fN, sn, address, pNo, email); 
			
			customers.set(index, newCustomer);
			
		}
	}
	
	@Override
	public void delete()
	{
		Customer custToDelete = view(); 
		
		if(custToDelete != null)
		{
			customers.remove(custToDelete); //remove customer chosen
		}
	}
	@Override
	public void serialize()
	{
		try
		{
			// Serialize the ArrayList
			FileOutputStream fileStream = new FileOutputStream(FILENAME);
	
			ObjectOutputStream objectStream = new ObjectOutputStream(fileStream);
	
			objectStream.writeObject(customers); //writing object to file
	
			objectStream.close();
		}
		catch(FileNotFoundException filenotfound)
		{
			System.out.println("Sorry - unable to create file");
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
	@Override
	public void deserialize(){
		try{
			// deserialize the ArrayList
			FileInputStream fileStream = new FileInputStream(FILENAME);
			
			ObjectInputStream outputStream = new ObjectInputStream(fileStream);
		
			customers = (ArrayList<Customer>)outputStream.readObject(); //reading object from File

			outputStream.close();
		}
		catch(FileNotFoundException filenotfound)
		{
			System.out.println("Unable to locate file");
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}				
	}
	
	

}
