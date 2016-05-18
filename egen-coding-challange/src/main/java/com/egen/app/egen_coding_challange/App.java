package com.egen.app.egen_coding_challange;

import static spark.Spark.*;

public class App {

	public static void main(String[] args) {

		/**
		 * Model class has Post and Get method for the application
		 */
		Model model = new Model();

		/**
		 * Data Access Object creates and maintains connection with MongoDB
		 */
		DAO databaseObject = new DAO();

		/**
		 * calls postCreateUser method of Model class to create new user
		 * 
		 * @return Json object of the created user and response -> 200 (Created) || 409
		 *         (for conflict)
		 */

		post("/createUser", (request, response) -> {
			return model.postCreateNewUser(request, response, databaseObject).toString();
		});

		/**
		 * calls postUpdateUser method of Model class to update existing user
		 * 
		 * @return Json object of updated user and response -> 200 (Created) || 406 (for
		 *         NA)
		 */
		put("/updateUser", (request, response) -> {
			return model.postUpdateUser(request, response, databaseObject).toString();
		});

		/**
		 * calls responseGetAllUsers method of Model class to get all new user
		 * 
		 * @return returns a json array of all the users in the database -> 200(OK)
		 */

		get("/getAllUsers", (request, response) -> {
			return model.reponseGetAllUser(request, response, databaseObject).toString();
		});
	}
}