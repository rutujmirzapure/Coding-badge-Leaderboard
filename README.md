# Coding-badge-Leaderboard
Develop a RESTful API service using Spring Boot to manage the Leaderboard for a Coding Platform while using MongoDB to persist the data.

# Coding Platform Leaderboard

This project is a RESTful API service built with Spring Boot to manage the leaderboard for a coding platform. It uses MongoDB to persist the data and provides endpoints for CRUD operations on user registrations, as well as awarding badges based on user scores.

## Setup
1. **Clone the repository:**
   ```bash
   git clone https://github.com/your-username/coding-badge-Leaderboard.git
Navigate to the project directory:

Run the application:
Make sure you have Java 8 or higher installed.
Install MongoDB and start the MongoDB service.
Update the MongoDB connection details in the application.properties file if necessary.
Build and run the application using Maven:

Access the application:
The application will be accessible at http://localhost:8080.
Dependencies
Java 8 or higher
Spring Boot
MongoDB
Maven
API Endpoints
GET /users - Retrieve a list of all registered users, sorted by score.
GET /users/{userId} - Retrieve the details of a specific user.
POST /users - Register a new user to the contest.
PUT /users/{userId} - Update the score of a specific user.
DELETE /users/{userId} - Deregister a specific user from the contest.
Postman Collection
Download Postman Collection
