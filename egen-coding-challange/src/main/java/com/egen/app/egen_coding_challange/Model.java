package com.egen.app.egen_coding_challange;

import java.io.IOException;
import java.util.UUID;

import spark.Request;
import spark.Response;
import Json.Address;
import Json.Company;
import Json.User;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class Model {

	/**
	 * helper method for postCreateNewUser, creates POJO
	 * 
	 * @Parameter user attributes
	 * @return _id
	 */
	public static String createUser(String firstName, String lastName,
			String email, Address address, String dateCreated, Company company,
			String profilePic) {

		User post = new User();
		UUID.fromString("38400000-8cf0-11bd-b23e-10b96e4ef00d");
		String id = UUID.randomUUID().toString();
		post.setId(id);
		post.setFirstName(firstName);
		post.setLastName(lastName);
		post.setEmail(email);
		post.setAddress(address);
		post.setDateCreated(dateCreated);
		post.setCompany(company);
		post.setProfilePic(profilePic);
		return id;
	}

	/**
	 * gets all the Documents from mongoDB, calls helper method from DOA class
	 * getAllUsers
	 * 
	 * @Parameter HTTP Request , HTTP Response , DOA object for data persistence
	 * @return json String of all existing users
	 */
	public JsonArray reponseGetAllUser(Request request, Response response,
			DAO databaseObject) {
		response.status(200);
		response.type("application/json");
		return databaseObject.getAllUsers();
	}

	/**
	 * create new user from input json request object
	 * 
	 * @Parameter HTTP Request , HTTP Response , DOA object for data persistence
	 * @return _id and response
	 */
	public JsonObject postCreateNewUser(Request request, Response response,
			DAO databaseObject)
			throws com.fasterxml.jackson.core.JsonParseException,
			JsonMappingException, IOException {
		try {
			String id = "";
			ObjectMapper mapper = new ObjectMapper();
			User creation = mapper.readValue(request.body(), User.class);
			// check is user already exists
			if (!databaseObject.userExist(creation)) {
				id = Model.createUser(creation.getFirstName(),
						creation.getLastName(), creation.getEmail(),
						creation.getAddress(), creation.getDateCreated(),
						creation.getCompany(), creation.getProfilePic());
				creation.setId(id);
				response.status(201);
				response.type("application/json");
				databaseObject.storeInDatabase(creation);
			} else {
				response.status(409);
				String _ids= creation.getId();
				String obj = "{'result' :'user already exist with id : "+_ids + " '}";
				JsonObject json = (JsonObject) new JsonParser().parse(obj);
				return json;
			}
			String obj = "{'result' :'Insertion Successfull'}";
			JsonObject json = (JsonObject) new JsonParser().parse(obj);
			return json;
		} catch (JsonParseException jpe) {
			response.status(404);
			String obj = "{'result' :'404 Not Found'}";
			JsonObject json = (JsonObject) new JsonParser().parse(obj);
			return json;
		}
	}

	/**
	 * update existing user from input json request object
	 * 
	 * @Parameter HTTP Request , HTTP Response , DOA object for data persistence
	 * @return _id and response
	 */
	public JsonObject postUpdateUser(Request request, Response response,
			DAO databaseObject)
			throws com.fasterxml.jackson.core.JsonParseException,
			JsonMappingException, IOException {
		try {
			String id = "";
			ObjectMapper mapper = new ObjectMapper();
			User creation = mapper.readValue(request.body(), User.class);
			// check is user already exists
			if (databaseObject.userExist(creation)) {
				databaseObject.UpdateUser(creation);
				response.status(200);
				response.type("application/json");
			} else {
				response.status(406);
				String obj = "{'result' :'User Not Found'}";
				JsonObject json = (JsonObject) new JsonParser().parse(obj);
				return json;
			}
			String _ids = creation.getId();
			String obj = "{'result' :'Update Successfull on Id:" + _ids + "'}";
			JsonObject json = (JsonObject) new JsonParser().parse(obj);
			return json;
		} catch (JsonParseException jpe) {
			response.status(404);
			String obj = "{'result' :'Bad Error'}";
			JsonObject json = (JsonObject) new JsonParser().parse(obj);
			return json;
		}
	}
}
