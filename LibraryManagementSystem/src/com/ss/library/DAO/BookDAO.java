package com.ss.library.DAO;

import java.util.ArrayList;
import java.util.List;
import com.ss.library.entities.Book;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;

public class BookDAO {
	//Method to read book data
	public static List<Book> readBook() {
		String path = "/Users/janet/Documents/LibraryDB/book.csv";
		BufferedReader br = null;
		List<Book> bookList = null;
		
		try {
			br = new BufferedReader(new FileReader(path));
			br.readLine(); //skip header in file
			
			String inputLine = "";
			
			bookList = new ArrayList<Book>(); //create list for book records
			
			//Populate list with data from file
			while((inputLine = br.readLine()) != null) {
				Book bookRecord = new Book(inputLine);
				bookList.add(bookRecord);
			}
			
			//Output list test
			/*for(Book bookOut : bookList) {
				System.out.println(bookOut.getBookId() + " " + bookOut.getBookName() + " " + bookOut.getPubId() + " " + bookOut.getAuthorId());
			}*/
				
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				br.close(); //close file
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return bookList;
		}
		
		//Method to write book data to file
		public static void writeBook(List<Book> bookList) {
			String path = "/Users/janet/Documents/LibraryDB/book.csv";
			BufferedWriter bw = null;
			StringBuilder sb = new StringBuilder();
			
			try {
				bw = new BufferedWriter(new FileWriter(path));
				
				sb.append("Book ID,Book Name,Publisher ID,Author ID\n"); //create headers in file
				
				//write data to file line by line
				for(Book outputLine: bookList) {
					sb.append(outputLine.toCSV() + "\n");
				}
				
				bw.write(sb.toString());
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				try {
					bw.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
}
