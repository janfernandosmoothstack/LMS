package com.ss.library.entities;

public class Publisher {
	private String pubId;
	private String pubName;
	private String pubAddress;
	
	public Publisher() {
	}
	
	public Publisher(String pubId, String pubName, String pubAddress) {
		this.pubId = pubId;
		this.pubName = pubName;
		this.pubAddress = pubAddress;
	}
	
	//Constructor to read data from file into list
	public Publisher(String readPubFile) {
		String[] pubArray = readPubFile.split(",", 3);
		
		this.pubId = pubArray[0];
		this.pubName = pubArray[1];
		this.pubAddress = pubArray[2];
	}
	
	public String toCSV() {
		return pubId + "," + pubName + "," + pubAddress;
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
	 * @return the pubName
	 */
	public String getPubName() {
		return pubName;
	}

	/**
	 * @param pubName the pubName to set
	 */
	public void setPubName(String pubName) {
		this.pubName = pubName;
	}

	/**
	 * @return the pubAddress
	 */
	public String getPubAddress() {
		return pubAddress;
	}

	/**
	 * @param pubAddress the pubAddress to set
	 */
	public void setPubAddress(String pubAddress) {
		this.pubAddress = pubAddress;
	}
}
