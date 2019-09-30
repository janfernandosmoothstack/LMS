package com.ss.library.entities;

public class Author {
	//Declare variables
	private String authorId;
	private String authorName;
	
	public Author() {
	}
	
	public Author(String authorId, String authorName) {
		this.authorId = authorId;
		this.authorName = authorName;
	}
	
	//Constructor to read data from file into list
	public Author(String readAuthorFile) {
		String[] authorArray = readAuthorFile.split(",", 2);
		
		this.authorId = authorArray[0];
		this.authorName = authorArray[1];
	}
	
	public String toCSV() {
		return authorId + "," + authorName;
	}

	//get authorId
	public String getAuthorId() {
		return authorId;
	}

	//set authorId
	public void setAuthorId(String authorId) {
		this.authorId = authorId;
	}

	//get  authorName
	public String getAuthorName() {
		return authorName;
	}

	//set authorName
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}	
}
