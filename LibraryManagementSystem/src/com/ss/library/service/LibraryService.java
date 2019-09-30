package com.ss.library.service;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.ss.library.DAO.*;
import com.ss.library.entities.*;

public class LibraryService {
	static Scanner input = new Scanner(System.in);
	static String choice = "";
	
	//Create new author record
	public static void createAuthor(String authorId, String authorName, List<Author> authorList) {
		//check if author ID exists
		for(Author checkId : authorList) {
			if(checkId.getAuthorId().equals(authorId)) {
				System.out.println();
				System.out.println("Author ID already exists.");
				System.out.println("Press any key to continue...");
				choice = input.nextLine();
				return;// Go back to menu1
			}
		}
		
		//Add new record to list
		Author newAuth = new Author(authorId, authorName);
		authorList.add(newAuth);
		
		AuthorDAO.writeAuthor(authorList); //write new list to file
		System.out.println();
		System.out.println("Author successfully added.");
		System.out.println("Press any key to continue...");
		choice = input.nextLine();
	}
	
	//Update author record
	public static void updateAuthor(String authorId, String authorName, List<Author> authorList) {
		int listIndex = 0;
		
		//check if author ID exists
		for(Author checkId : authorList) {
			if(checkId.getAuthorId().equals(authorId)) {
				listIndex = authorList.indexOf(checkId);// get index of the record to be updated
				
				if(!"N/A".equals(authorName)) {
					authorList.get(listIndex).setAuthorName(authorName); //update the record
				}
				AuthorDAO.writeAuthor(authorList); //write new list to file
				
				System.out.println();
				System.out.println("Author successfully updated.");
				System.out.println("Press any key to continue...");
				choice = input.nextLine();
				return;
			}
		}
		
		System.out.println();
		System.out.println("Author ID does not exist.");
		System.out.println("Press any key to continue...");
		choice = input.nextLine();
	}
	
	//Delete author record
	public static void deleteAuthor(String authorId, List<Author> authorList, List<Book> bookList) {
		//look for books with that author and delete them
		for(Iterator<Book> checkId = bookList.iterator(); checkId.hasNext();) {
			Book newBook = checkId.next();
			
			if(newBook.getAuthorId().equals(authorId)) {
				checkId.remove();
			}
		}
		
		BookDAO.writeBook(bookList);
		
		//delete author
		for(Author checkId : authorList) {
			if(checkId.getAuthorId().equals(authorId)) {
				authorList.remove(checkId);//Delete record
				AuthorDAO.writeAuthor(authorList); //write new list to file
				System.out.println();
				System.out.println("Author successfully deleted.");
				System.out.println("Press any key to continue...");
				choice = input.nextLine();
				return;
			}
		}
		
		System.out.println();
		System.out.println("Author ID does not exist.");
		System.out.println("Press any key to continue...");
		choice = input.nextLine();
	}
	
	//View author records
	public static void viewAuthor() {
		System.out.println("Author ID\tAuthor Name");
		for(Author viewAuthor : AuthorDAO.readAuthor()) {
			System.out.println(viewAuthor.getAuthorId() + "\t\t" + viewAuthor.getAuthorName());
		}
	}
	
	//Create new book record
	public static void createBook(String bookId, String bookName, String pubId, String authorId, List<Book> bookList, List<Author> authorList, List<Publisher> pubList) {
		//check if book ID exists
		for(Book checkId : bookList) {
			if(checkId.getBookId().equals(bookId)) {
				System.out.println();
				System.out.println("Book ID already exists.");
				System.out.println("Press any key to continue...");
				choice = input.nextLine();
				return;
			}
		}
		
		//check if author ID exists
		boolean check = false;
		for(Author checkId : authorList) {
			if(checkId.getAuthorId().equals(authorId)) {
				check = true;
				break;
			}
		}
		
		//If author ID exists check if publisher ID exists
		if(check == true) {
			for(Publisher checkId : pubList) {
				if(checkId.getPubId().equals(pubId)) {
					check = true;
					break;
				}
			}
				
			//End function if publisher ID does not exist
			if(check == false) {
				System.out.println();
				System.out.println("Publisher ID does not exist.");
				System.out.println("Press any key to continue...");
				choice = input.nextLine();
				return;
			}
		} else {
			//End function if author ID does not exist
			System.out.println();
			System.out.println("Author ID does not exist.");
			System.out.println("Press any key to continue...");
			choice = input.nextLine();
			return;
		}
		
		//Add new record to list
		Book newBook = new Book(bookId, bookName, pubId, authorId);
		bookList.add(newBook);
		
		BookDAO.writeBook(bookList); //write new list to file
		System.out.println();
		System.out.println("Book successfully created.");
		System.out.println("Press any key to continue...");
		choice = input.nextLine();
	}
	
	//Update book record
	public static void updateBook(String bookId, String bookName, List<Book> bookList) {
		int listIndex = 0;
		
		//check if publisher ID exists
		for(Book checkId : bookList) {
			if(checkId.getBookId().equals(bookId)) {
				listIndex = bookList.indexOf(checkId);// get index of the record to be updated
				
				if(!"N/A".equals(bookName)) {
					bookList.get(listIndex).setBookName(bookName); //update the record
				}
				BookDAO.writeBook(bookList); //write new list to file
				
				System.out.println();
				System.out.println("Book successfully updated.");
				System.out.println("Press any key to continue...");
				choice = input.nextLine();
				return;
			}
		}
		
		System.out.println();
		System.out.println("Book ID does not exist.");
		System.out.println("Press any key to continue...");
		choice = input.nextLine();
	}
	
	//Delete book record
	public static void deleteBook(String bookId, List<Book> bookList) {
		for(Iterator<Book> checkId = bookList.iterator(); checkId.hasNext();) {
			Book newBook = checkId.next();
			
			if(newBook.getBookId().equals(bookId)) {
				checkId.remove();
				BookDAO.writeBook(bookList); //write new list to file
				
				System.out.println();
				System.out.println("Book successfully deleted.");
				System.out.println("Press any key to continue...");
				choice = input.nextLine();
				return;
			}
		}
		
		System.out.println();
		System.out.println("Book ID does not exist.");
		System.out.println("Press any key to continue...");
		choice = input.nextLine();
    }
	
	//View publisher records
	public static void viewBook() {
		System.out.println("Book ID\t\tBook Name\tPublisher ID\tAuthor ID");
		for(Book viewBook : BookDAO.readBook()) {
			System.out.println(viewBook.getBookId() + "\t\t" + viewBook.getBookName() + "\t\t" + viewBook.getPubId() + "\t\t" + viewBook.getAuthorId());
		}
	}
	
	//Create new publisher record
	public static void createPublisher(String pubId, String pubName, String pubAddress, List<Publisher> pubList) {
		//check if publisher ID exists
		for(Publisher checkId : pubList) {
			if(checkId.getPubId().equals(pubId)) {
				System.out.println();
				System.out.println("Publisher ID already exists.");
				System.out.println("Press any key to continue...");
				choice = input.nextLine();
				return;
			}
		}
		
		//Add new record to list
		Publisher newPub = new Publisher(pubId, pubName, pubAddress);
		pubList.add(newPub);
		
		PublisherDAO.writePublisher(pubList); //write new list to file
		
		System.out.println();
		System.out.println("Publisher successfully created.");
		System.out.println("Press any key to continue...");
		choice = input.nextLine();
	}
	
	//Update publisher record
	public static void updatePublisher(String pubId, String pubName, String pubAddress, List<Publisher> pubList) {
		int listIndex = 0;
		
		//check if publisher ID exists
		for(Publisher checkId : pubList) {
			if(checkId.getPubId().equals(pubId)) {
				listIndex = pubList.indexOf(checkId);// get index of the record to be updated
				
				if(!"N/A".equals(pubName)) {
					pubList.get(listIndex).setPubName(pubName); //update the record
				}
				
				if(!"N/A".equals(pubAddress)) {
					pubList.get(listIndex).setPubAddress(pubAddress); //update the record
				}
				
				PublisherDAO.writePublisher(pubList); //write new list to file
				
				System.out.println();
				System.out.println("Publisher successfully updated.");
				System.out.println("Press any key to continue...");
				choice = input.nextLine();
				return;
			}
		}
		
		System.out.println();
		System.out.println("Publisher ID does not exist.");
		System.out.println("Press any key to continue...");
		choice = input.nextLine();
	}
	
	//Delete publisher record
	public static void deletePublisher(String pubId, List<Publisher> pubList, List<Book> bookList) {
		//look for books that have the publisher and delete them
		for(Iterator<Book> checkId = bookList.iterator(); checkId.hasNext();) {
			Book newBook = checkId.next();
			
			if(newBook.getPubId().equals(pubId)) {
				checkId.remove();
			}
		}
		
		BookDAO.writeBook(bookList);
		
		//delete publisher
		for(Publisher checkId : pubList) {
			if(checkId.getPubId().equals(pubId)) {
				pubList.remove(checkId);//Delete record
				PublisherDAO.writePublisher(pubList); //write new list to file
				
				System.out.println();
				System.out.println("Publisher successfully deleted.");
				System.out.println("Press any key to continue...");
				choice = input.nextLine();
				return;
			}
		}
		
		System.out.println();
		System.out.println("Publisher ID does not exist.");
		System.out.println("Press any key to continue...");
		choice = input.nextLine();
	}
	
	//View publisher records
	public static void viewPublisher() {
		System.out.println("Publisher ID\tPublisher Name\tPublisher Address");
		for(Publisher viewPub : PublisherDAO.readPublisher()) {
			System.out.println(viewPub.getPubId() + "\t\t" + viewPub.getPubName() + "\t\t" + viewPub.getPubAddress());
		}
	}
}
