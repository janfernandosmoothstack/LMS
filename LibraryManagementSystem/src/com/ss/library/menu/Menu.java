package com.ss.library.menu;

import java.util.List;
import java.util.Scanner;

import com.ss.library.DAO.*;
import com.ss.library.entities.*;
import com.ss.library.service.LibraryService;

import java.io.IOException;

public class Menu {
	static Scanner input = new Scanner(System.in);
	static String choice = "";
	
	//Main menu
	public static void main(String[] args) {
		do {
			clr();
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~");
			System.out.println("Library Management System");
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~");
			System.out.println();
			System.out.println("1. Author");
			System.out.println("2. Book");
			System.out.println("3. Publisher");
			System.out.println("4. Exit");
			System.out.println();
			System.out.println("Please select an option(1-4):");
			
			boolean checkChoice = false;
			
			//loop until user enters a valid choice
			while(checkChoice != true) {
				choice = input.nextLine();
				
				switch(choice) {
					case "1":
						authorMenu();
						checkChoice = true;
						break;
					case "2":
						bookMenu();
						checkChoice = true;
						break;
					case "3":
						pubMenu();
						checkChoice = true;
						break;
					case "4":
						return;
					default:
						System.out.println("Please enter a valid option.");
						break;
				}
			}
		} while(choice != "4");
	}
	
	//Author Menu
	public static void authorMenu() {
		do {
			clr();
			System.out.println("~~~~~~~~~~~");
			System.out.println("Author Menu");
			System.out.println("~~~~~~~~~~~");
			System.out.println();
			System.out.println("1. Create");
			System.out.println("2. Update");
			System.out.println("3. Delete");
			System.out.println("4. View");
			System.out.println("5. Exit");
			System.out.println();
			System.out.println("Please select an option(1-5):");
			
			boolean checkChoice = false;
			String authorId = "";
			String authorName = "";
			
			//loop until user enters a valid choice
			while(checkChoice != true) {
				choice = input.nextLine();
				
				switch(choice) {
				case "1": //Create
					//Prompt user for input
					System.out.println("Please enter the Author's ID:");
					authorId = input.nextLine();
					
					System.out.println("Please enter the Author's name:");
					authorName = input.nextLine();
					
					//Call function to create author
					LibraryService.createAuthor(authorId, authorName, AuthorDAO.readAuthor());
					
					checkChoice = true;
					break;
				
				case "2": //Update
					LibraryService.viewAuthor();
					System.out.println();
					
					System.out.println("Please enter the Author's ID:");
					authorId = input.nextLine();
					
					System.out.println("Please enter the Author's name:");
					authorName = input.nextLine();
					
					LibraryService.updateAuthor(authorId, authorName, AuthorDAO.readAuthor());
					checkChoice = true;
					break;
				
				case "3": //Delete
					LibraryService.viewAuthor();
					System.out.println();
					
					System.out.println("Please enter the Author's ID:");
					authorId = input.nextLine();
					
					LibraryService.deleteAuthor(authorId, AuthorDAO.readAuthor(), BookDAO.readBook());
					checkChoice = true;
					break;
				
				case "4": //View
					LibraryService.viewAuthor();
					System.out.println();
					
					System.out.print("Press any key to continue...");
					choice = input.nextLine();
					
					checkChoice = true;
					break;
				
				case "5": //Exit
					return;
				
				default:
					System.out.println("Please enter a valid option.");
					break;
				}
			}
		}while(choice != "5");
	}
	
	//Book Menu
	public static void bookMenu() {
		do {
			clr();
			System.out.println("~~~~~~~~~");
			System.out.println("Book Menu");
			System.out.println("~~~~~~~~~");
			System.out.println();
			System.out.println("1. Create");
			System.out.println("2. Update");
			System.out.println("3. Delete");
			System.out.println("4. View");
			System.out.println("5. Exit");
			System.out.println();
			System.out.println("Please select an option(1-5):");
			
			boolean checkChoice = false;
			String bookId = "";
			String bookName = "";
			String pubId = "";
			String authorId = "";
			
			//loop until user enters a valid choice
			while(checkChoice != true) {
				choice = input.nextLine();
				
				switch(choice) {
				case "1": //Create
					//Prompt user for input
					System.out.println("Please enter the Book's ID:");
					bookId = input.nextLine();
					
					System.out.println("Please enter the Book's name:");
					bookName = input.nextLine();
					
					System.out.println("Please enter the Publisher's ID:");
					pubId = input.nextLine();
					
					System.out.println("Please enter the Author's ID:");
					authorId = input.nextLine();
					
					//Call function to create author
					LibraryService.createBook(bookId, bookName, pubId, authorId, BookDAO.readBook(), AuthorDAO.readAuthor(), PublisherDAO.readPublisher());
					checkChoice = true;
					break;
				
				case "2": //Update
					LibraryService.viewBook();
					System.out.println();
					
					//Prompt user for input
					System.out.println("Please enter the Book's ID:");
					bookId = input.nextLine();
					
					System.out.println("Please enter the Book's name:");
					bookName = input.nextLine();
					
					LibraryService.updateBook(bookId, bookName, BookDAO.readBook());
					checkChoice = true;
					break;
				
				case "3": //Delete
					LibraryService.viewBook();
					System.out.println();
		
					//Prompt user for input
					System.out.println("Please enter the Book's ID:");
					bookId = input.nextLine();
					
					LibraryService.deleteBook(bookId, BookDAO.readBook());
					checkChoice = true;
					break;
				
				case "4": //View
					LibraryService.viewBook();
					System.out.println();
					
					System.out.print("Press any key to continue...");
					choice = input.nextLine();
					
					checkChoice = true;
					break;
				
				case "5":
					return;
				
				default:
					System.out.println("Please enter a valid option.");
					break;
				}
			}
		}while(choice != "5");
	}
	
	//Publisher Menu
	public static void pubMenu() {
		do {
			clr();
			System.out.println("~~~~~~~~~~~~~~");
			System.out.println("Publisher Menu");
			System.out.println("~~~~~~~~~~~~~~");
			System.out.println();
			System.out.println("1. Create");
			System.out.println("2. Update");
			System.out.println("3. Delete");
			System.out.println("4. View");
			System.out.println("5. Exit");
			System.out.println();
			System.out.println("Please select an option(1-5):");
			
			boolean checkChoice = false;
			String pubId = "";
			String pubName = "";
			String pubAddress = "";
			
			while(checkChoice != true) {
				choice = input.nextLine();
				
				switch(choice) {
				case "1": //Create
					//Prompt user for input
					System.out.println("Please enter the Publisher's ID:");
					pubId = input.nextLine();
					
					System.out.println("Please enter the Publisher's name:");
					pubName = input.nextLine();
					
					System.out.println("Please enter the Publisher's address:");
					pubAddress = input.nextLine();
					
					//Call function to create author
					LibraryService.createPublisher(pubId, pubName, pubAddress, PublisherDAO.readPublisher());
					checkChoice = true;
					break;
				
				case "2": //Update
					LibraryService.viewPublisher();
					System.out.println();
					
					//Prompt user for input
					System.out.println("Please enter the Publisher's ID:");
					pubId = input.nextLine();
					
					System.out.println("Please enter the Publisher's name:");
					pubName = input.nextLine();
					
					System.out.println("Please enter the Publisher's address:");
					pubAddress = input.nextLine();
					
					LibraryService.updatePublisher(pubId, pubName, pubAddress, PublisherDAO.readPublisher());
					checkChoice = true;
					break;
				
				case "3": //Delete
					LibraryService.viewPublisher();
					System.out.println();
					
					//Prompt user for input
					System.out.println("Please enter the Publisher's ID:");
					pubId = input.nextLine();
					
					LibraryService.deletePublisher(pubId, PublisherDAO.readPublisher(), BookDAO.readBook());
					checkChoice = true;
					break;
				
				case "4": //View
					//View all records
					LibraryService.viewPublisher();
					System.out.println();
					
					System.out.print("Press any key to continue...");
					choice = input.nextLine();
					
					checkChoice = true;
					break;
				
				case "5":
					return;
				
				default:
					System.out.println("Please enter a valid option.");
					break;
				}
			}
		}while(choice != "5");
	}
	
	public static void clr() {  
	    try {
	    	new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
	    } catch(IOException | InterruptedException E) {
	    }
	}
	
	//Helper function to make sure ID is a number
	public static boolean checkIdType(String recordID) {
		try {
			int id = Integer.parseInt(recordID);
		} catch(NumberFormatException | NullPointerException e) {
			return false;
		}
		return true;
	}
}