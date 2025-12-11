# QuizApp

QuizApp is a Java-based web application that allows users to register, take quizzes, and view their results. Administrators can manage users, quiz questions, and view submitted messages. Built using Spring Boot, JSP, JDBC, and MySQL, it demonstrates a complete full-stack Java web project.

## Features

### User Features

* Register and log in
* Take random quizzes (3 questions per quiz)
* View quiz results
* Submit messages via the Contact Us page (even without logging in)

### Admin Features

* Admin-only dashboard (`/admin-home`)
* User Management:
  * View users with pagination
  * Activate/Suspend user accounts
* Question Management:
  * View all questions
  * Add, edit, activate/suspend questions
* Quiz Result Management:
  * View quiz results (with filters by user/category)
  * See individual quiz result details
* Contact Us Management:
  * View user messages
  * Open full view of message content

## Technologies Used

* Java 17+
* Spring Boot
* JSP + JSTL
* MySQL
* JDBC Template
* Embedded Tomcat

## Getting Started

### Prerequisites

* Java 17+
* Maven
* MySQL

### Database Setup

1. Create a database called `quizdb` (for local setups)
2. Import the schema and any seed data using the included SQL file: `Quiz_Project_SQL.sql`

### Configuration

Edit `src/main/resources/application.properties` for local development:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/quizdb
spring.datasource.username=your_db_user
spring.datasource.password=your_db_password
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.mvc.view.prefix=/WEB-INF/jsp/
spring.mvc.view.suffix=.jsp
```

### Run the Application

```bash
./mvnw spring-boot:run
```

Visit [http://localhost:8080/login](http://localhost:8080/login) in your browser.

### Pre-created Accounts (for testing without registration)

* **Admin:** admin@example.com / admin123
* **Test User:** user1@example.com / user123

## Deployment / Hosted Version (Optional)

A live version of QuizApp is hosted on Render:
[https://quizapp-67i3.onrender.com/login](https://quizapp-67i3.onrender.com/login)

> Note: Free Render instances may spin down after inactivity, causing initial requests to take longer. You can use services like [UptimeRobot](https://uptimerobot.com/) to ping the app periodically if you want it to stay "awake."

For Render, the database is called `defaultdb` on Aiven MySQL. Connection info can be configured in `application.properties` or as environment variables.

## Folder Structure

```
src/
 └── main/
     ├── java/
     │   └── com/example/quiz/
     │       ├── controller/
     │       ├── service/
     │       ├── dao/
     │       └── domain/
     │
     ├── resources/
     │   ├── application.properties
     │   
     │
     └── webapp/
         └── WEB-INF/
             └── jsp/
                 ├── admin-contact-messages.jsp
                 ├── admin-contact-view.jsp
                 ├── admin-home.jsp
                 ├── admin-question-management.jsp
                 ├── admin-quiz-results.jsp
                 ├── admin-user-management.jsp
                 ├── admin-users.jsp
                 ├── contact.jsp
                 ├── home.jsp
                 ├── login.jsp
                 ├── navbar.jsp
                 ├── question-add.jsp
                 ├── question-edit.jsp
                 ├── quiz-result.jsp
                 ├── quiz.jsp
                 ├── register.jsp
                 └── unauthorized.jsp

```

## Contributions

Pull requests and issues are welcome. Please fork the repository and submit a PR.

