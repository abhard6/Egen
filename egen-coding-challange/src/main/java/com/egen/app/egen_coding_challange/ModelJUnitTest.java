package com.egen.app.egen_coding_challange;

import static org.junit.Assert.*;
import Json.Address;
import Json.Company;
import Json.User;

import org.junit.Test;

/**
 * JUNIT test class to check if user exists in the system
 * 
 */
public class ModelJUnitTest {

	@Test
	public void UpdateUsertest() {

		DAO junit = new DAO();

		// assert equal condition - User doesn't exist in the system
		User testUser1 = new User();
		testUser1.setId("1630215c-2608-44b9-aad4-9d56d8aafd4c");
		testUser1.setFirstName("Steve");
		testUser1.setLastName("Jobs");
		testUser1.setEmail("abc@hotmail.com");
		Address addressDosntExists = new Address();
		addressDosntExists.setStreet("South Lincoln");
		addressDosntExists.setCity("NYC");
		addressDosntExists.setZip("61801");
		addressDosntExists.setState("NY");
		addressDosntExists.setCountry("US");
		testUser1.setAddress(addressDosntExists);
		testUser1.setDateCreated("2016-03-15T07:02:40.896Z");
		Company companyDosntExists = new Company();
		companyDosntExists.setName("Apple");
		companyDosntExists.setWebsite("http://Apple.com");
		testUser1.setCompany(companyDosntExists);
		testUser1.setProfilePic("http://staveJobs.png");
		boolean result1 = junit.userExist(testUser1);
		assertEquals("Test Case Sucessful", false, result1);

		// assert equal condition - User does exist in the system
		User testUser2 = new User();
		testUser2.setId("d313b7d9-804b-4bf3-b94b-936caccb5616");
		testUser2.setFirstName("Dorris");
		testUser2.setLastName("Keeling");
		testUser2.setEmail("farby_Leffler68@gmail.com");
		Address addressDoesExists = new Address();
		addressDoesExists.setStreet("193 Talon Valley");
		addressDoesExists.setCity("South Tate furt");
		addressDoesExists.setZip("47063");
		addressDoesExists.setState("IA");
		addressDoesExists.setCountry("US");
		testUser2.setAddress(addressDoesExists);
		testUser2.setDateCreated("2016-03-15T09:02:40.896Z");
		Company companyDoesExists = new Company();
		companyDoesExists.setName("Denesik Group");
		companyDoesExists.setWebsite("http://jodie.org");
		testUser2.setCompany(companyDosntExists);
		testUser2.setProfilePic("http://lorempixel.com/640/480/people");
		boolean result2 = junit.userExist(testUser2);
		assertEquals("Test Case Sucessful", true, result2);
		
	}

}
