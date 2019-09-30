package com.ss.library.DAO;

import java.util.ArrayList;
import java.util.List;
import com.ss.library.entities.Publisher;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;

public class PublisherDAO {
	//Method to read publisher data
	public static List<Publisher> readPublisher() {
		String path = "/Users/janet/Documents/LibraryDB/publisher.csv";
		BufferedReader br = null;
		List<Publisher> pubList = null;
		
		try {
			br = new BufferedReader(new FileReader(path));
			br.readLine(); //skip header in file
			
			String inputLine = "";
			
			pubList = new ArrayList<Publisher>(); //create list for publisher records
			
			//Populate list with data from file
			while((inputLine = br.readLine()) != null) {
				Publisher pubRecord = new Publisher(inputLine);
				pubList.add(pubRecord);
			}
			
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
		return pubList;
	}
		
	//Method to write publisher data to file
	public static void writePublisher(List<Publisher> pubList) {
		String path = "/Users/janet/Documents/LibraryDB/publisher.csv";
		BufferedWriter bw = null;
		StringBuilder sb = new StringBuilder();
		
		try {
			bw = new BufferedWriter(new FileWriter(path));
			
			sb.append("Publisher ID,Publisher Name,Publisher Address\n"); //create headers in file
			
			//write data to file line by line
			for(Publisher outputLine: pubList) {
				sb.append(outputLine.toCSV() + "\n");
			}
			
			bw.write(sb.toString());
			
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
