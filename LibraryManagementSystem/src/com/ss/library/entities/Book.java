package com.ss.library.entities;

public class Book {
	//Declare variables
	private String bookId;
	private String bookName;
	private String pubId;
	private String authorId;
	
	public Book() {
	}
	
	public Book(String bookId, String bookName, String pubId, String authorId) {
		this.bookId = bookId;
		this.bookName = bookName;
		this.pubId = pubId;
		this.authorId = authorId;
	}
	
	//Constructor to read data from file into list
	public Book(String readBookFile) {
		String[] bookArray = readBookFile.split(",", 4);
		
		this.bookId = bookArray[0];
		this.bookName = bookArray[1];
		this.pubId = bookArray[2];
		this.authorId = bookArray[3];
	}
	
	public String toCSV() {
		return bookId + "," + bookName + "," + pubId + "," + authorId;
	}

	/**
	 * @return the bookId
	 */
	public String getBookId() {
		return bookId;
	}

	/**
	 * @param bookId the bookId to set
	 */
	public void setBookId(String bookId) {
		this.bookId = bookId;
	}

	/**
	 * @return the bookName
	 */
	public String getBookName() {
		return bookName;
	}

	/**
	 * @param bookName the bookName to set
	 */
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	/**
	 * @return the pubId
	 */
	public String getPubId() {
		return pubId;
	}

	/**
	 * @param pubId the pubId to set
	 */
	public void setPubId(String pubId) {
		this.pubId = pubId;
	}

	/**
	 * @return the authorId
	 */
	public String getAuthorId() {
		return authorId;
	}

	/**
	 * @param authorId the authorId to set
	 */
	public void setAuthorId(String authorId) {
		this.authorId = authorId;
	}
}
