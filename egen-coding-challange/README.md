# Egen Coding Challenge

Used Postman Client (https://www.getpostman.com/) to test the endpoints.

1.) Download the Project from Git.
2.) Build this Project as Maven Project(pom.xml has all the dependencies)
3.) Run the Main file App.java
4.) go to www.getpostman.com and check the following endpoints

4.a) 0.0.0.0:4567/createUser(POST){Enter the following Json for the user in the body section of getpostman

{  
   "id":"1630215c-2608-44b9-aad4-9d56d8aafd4c",
   "firstName":"Dorris",
   "lastName":"Keeling",
   "email":"carby_Leffler68@gmail.com",
   "address":{  
      "street":"195 Talon Valley",
      "city":"South Tate furt",
      "zip":"47069",
      "state":"CA",
      "country":"US"
   },
   "dateCreated":"2016-03-15T07:02:40.896Z",
   "company":{  
      "name":"Denesik Group",
      "website":"http://jodie.org"
   },
   "profilePic":"http://lorempixel.com/640/480/people"
}

Once we have created the user we can change the email-id of this user and make new users.
Then we can insert couple of users in this way and check for updateUser by changing any field in the existing user.
The json has to be specified in the body section of updateUser end point also.

we can then use getAllUsers end point to get the list of all the users.

4.b) 0.0.0.0:4567/updateUser(PUT)
4.c) 0.0.0.0:4567/getAllUsers(GET)
The output would be visible on Postman

Following technologies have been used
Spark,Jackson,Lombok,Gson Maven
build all the dependencies according to Pom.xml

JUnit Test cases involves checking the database connectivity and whether the user exists in the database.
