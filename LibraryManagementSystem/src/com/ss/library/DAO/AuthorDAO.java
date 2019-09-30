package com.ss.library.DAO;

import java.util.ArrayList;
import java.util.List;
import com.ss.library.entities.Author;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;

public class AuthorDAO {
	//Method to read author data
	public static List<Author> readAuthor() {
		String path = "/Users/janet/Documents/LibraryDB/author.csv";
		BufferedReader br = null;
		List<Author> authorList = null;
		
		try {
			br = new BufferedReader(new FileReader(path));
			br.readLine(); //skip header in file
			
			String inputLine = "";
			
			authorList = new ArrayList<Author>(); //create list for author records
			
			//Populate list with data from file
			while((inputLine = br.readLine()) != null) {
				Author authorRecord = new Author(inputLine);
				authorList.add(authorRecord);
			}
			
			//Output list test
			/*for(Author authorOut : authorList) {
				System.out.println(authorOut.getAuthorId() + " " + authorOut.getAuthorName());
			}*/
			
		} catch (FileNotFoundException e) {
			System.out.println("Error.");
		} catch (IOException e) {
			System.out.println("Error.");
		} finally {
			try {
				br.close(); //close file
			} catch (IOException e) {
				System.out.println("Error.");
			}
		}
		return authorList;
	}
	
	//Method to write author data to file
	public static void writeAuthor(List<Author> authorList) {
		String path = "/Users/janet/Documents/LibraryDB/author.csv";
		BufferedWriter bw = null;
		StringBuilder sb = new StringBuilder();
		
		try {
			bw = new BufferedWriter(new FileWriter(path));
			
			sb.append("Author ID,Author Name\n"); //create headers in file
			
			//change data into comma separated data in string builder
			for(Author outputLine: authorList) {
				sb.append(outputLine.toCSV() + "\n");
			}
			
			bw.write(sb.toString());//
			
		} catch (IOException e) {
			System.out.println("Error.");
		} finally {
			try {
				bw.close();
			} catch (IOException e) {
				System.out.println("Error.");
			}
		}
	}	
}
	
	
