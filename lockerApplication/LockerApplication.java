package lockerApplication;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import locker.users.Users;
import locker.users.UserCredentialspickup;

public class LockerApplication
{
	//input
	private static Scanner keyboard;
	private static Scanner input;
	private static Scanner lockerinput;
	//output
	private static PrintWriter output;
	private static PrintWriter lockerOutput;
	
	//store user credentials
	private static Users users;
	private static UserCredentialspickup UserCredentialspickup;
	
	
	public static void main(String[] args)
	{
		initApp();
		welcomeScreen();
		signInOptions();
	}

	public static void signInOptions()
	{
		System.out.println("1. Register");
		System.out.println("2. Login");
		int option = keyboard.nextInt();
		switch(option) 
		{
		
		case 1 :  
			registerUser();
			break;
		case 2 :
			loginUser();
			break;
		default : 
			System.out.println("Please select valid options 1 or 2");
			break;
		
		}
		keyboard.close();
		input.close();
	}
	
	public static void lockerOptions(String inpUsername)
	{
		System.out.println("1. View all stored Creentials");
		System.out.println("2. Stored Credentials");
		int option = keyboard.nextInt();
		switch (option)
		{
		case 1 : 
			fetchCredentials(inpUsername);
			break;
		case 2 : 
			storedCredentials(inpUsername);
			break;
		default : 
			System.out.println("Please select 1 or 2");
			break;
		}
		lockerinput.close();
	}
	
	public static void registerUser()
	{
		System.out.println("------------------------------------------");
		System.out.println("------------------------------------------");
		System.out.println("*                                        *");
		System.out.println(       "Welcome to Locker Application"      );
		System.out.println(       "          Register           "      );
		System.out.println("*                                        *");
		System.out.println("------------------------------------------");
		System.out.println("------------------------------------------");
		
		System.out.println("Enter Username");
		String username = keyboard.next();
		users.setUsername(username);
		
		System.out.println("Enter Password");
		String password = keyboard.next();
		users.setPassword(password);
		
		output.println(users.getUsername());
		output.println(users.getPassword());
		
		System.out.println("User Registered Sucessfully");
		output.close();
	}
	
	public static void loginUser() {
		System.out.println("------------------------------------------");
		System.out.println("------------------------------------------");
		System.out.println("*                                        *");
		System.out.println(       "Welcome to Locker Application"      );
		System.out.println(       "           Login             "      );
		System.out.println("*                                        *");
		System.out.println("------------------------------------------");
		System.out.println("------------------------------------------/n");
		System.out.println("Enter Username");
		String inpUsername = keyboard.next();
		boolean found = false;
		while(input.hasNext() && !found)
		{
			if(input.next().equals(inpUsername))
			{
				System.out.println("Enter Password");
				String inpPassword = keyboard.next();
				if(input.next().equals(inpPassword))
				{
					System.out.println("*********Login Sucessfull*********");
					found = true;
					lockerOptions(inpUsername);
					break;
				}
			}
				
		}
		
		if(!found)
		{
			System.out.println("User not found ::Login Failed");
		}
	}
	
	public static void welcomeScreen() {
		System.out.println("==========================================");
		System.out.println("*					                     *");
		System.out.println("*      Welcome To Locker Application     *");
		System.out.println("*      Your Personal Digital Locaker	 *");
		System.out.println("*					                     *");
		System.out.println("==========================================");
	}
	//Saving Credentials
	public static void storedCredentials(String loggedInUser)
	{
		System.out.println("==========================================");
		System.out.println("*					                     *");
		System.out.println("*      Welcome To Locker Application     *");
		System.out.println("*       Store Your Credentials here  	 *");
		System.out.println("*					                     *");
		System.out.println("==========================================");
	
	UserCredentialspickup.setloggedInUser(loggedInUser);
	
	
		System.out.println("Enter Website Name");
		String websiteName = keyboard.next();
		UserCredentialspickup.setwebsiteName(websiteName);
		
		System.out.println("Enter username");
		String username = keyboard.next();
		UserCredentialspickup.setusername(username);
		
		System.out.println("Enter Password");
		String password = keyboard.next();
		UserCredentialspickup.setpassword(password);
		
		lockerOutput.println(UserCredentialspickup.getwebsiteName());
		lockerOutput.println(UserCredentialspickup.getusername());
		lockerOutput.println(UserCredentialspickup.getpassword());
		lockerOutput.println(UserCredentialspickup.getloggedInuser());
		
		
		System.out.println("Credentials Stored in Locker Application");
		lockerOutput.close();
		
	}
	
	//Get Credentials
	public static void fetchCredentials(String inpUsername)
	{
		System.out.println("==========================================");
		System.out.println("*					             *");
		System.out.println("*   WELCOME TO LOCKER Application 	 *");
		System.out.println("*          YOUR CREDS ARE 	         *");
		System.out.println("*					*");
		System.out.println("==========================================");
		System.out.println(inpUsername);
		
		while(lockerinput.hasNext())
		{
		if(lockerinput.next().equals(inpUsername))
		{
			System.out.println("Website Name : /n"+lockerinput.next());
			System.out.println("Username : /n"+lockerinput.next());
			System.out.println("Password : /n"+lockerinput.next());
		}
			
		}
	}
	
	public static void initApp()
	{
		File dbfile = new File("database.txt");
		File lockerfile = new File("locker-file.txt");
		
		try//try statement allows you to define a block of code to be tested for errors while it is being executed
		{
			//read data from db
			input = new Scanner(dbfile);
			//read data from locker file
			lockerinput = new Scanner(lockerfile);
			//read data from keyboard
			keyboard = new Scanner(System.in);
			//Output
			output = new PrintWriter( new FileWriter(dbfile,true));
			lockerOutput = new PrintWriter ( new FileWriter(lockerfile,true));
			
			users = new Users();
			UserCredentialspickup = new UserCredentialspickup();
			
		}
		catch (IOException e)
		{
			System.out.println("File Not Found :ERROR");
		}
	}
	
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	



