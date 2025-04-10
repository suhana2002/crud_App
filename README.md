# Spring Boot CRUD Application

A simple **Spring Boot** application that performs **CRUD (Create, Read, Update, Delete)** operations on an Employee entity using **Spring Data JPA**, **Thymeleaf**, and **H2/MySQL database**.

## 📁 Project Structure

com.crud.crudapp --> Main application package ├── CrudApplication.java └── Controller endpoints

com.database --> Database-related classes ├── crudApp.java --> Entity class ├── crudAppRepo.java --> JPA Repository └── Services.java --> Service layer

## Features

- Add a new employee
- View all employees
- Edit employee details
- Delete an employee
- Flash messages on operations
- MVC architecture using Thymeleaf (or JSP/HTML templates)

##  Tech Stack

- Java 17+
- Spring Boot
- Spring Data JPA
- Thymeleaf (or HTML views)
- H2 / MySQL database
- Maven

##  How to Run

### 1. Clone the Repository

```bash
git clone https://github.com/your-username/your-repo-name.git
cd your-repo-name

### 2.Set Up the Database
If using MySQL:
spring.datasource.url=jdbc:mysql://localhost:3306/yourdbname
spring.datasource.username=yourusername
spring.datasource.password=yourpassword
spring.jpa.hibernate.ddl-auto=update

###3.Run the Application
IDE: Run CrudApplication.java as a Java application

Maven:
mvn spring-boot:run

### 4. Access the Application
Visit: http://localhost:8080

Home: / or /showEmp

Add Employee: Submit the form on the homepage

Edit Employee: Click "Edit" on a listed employee

Delete Employee: Click "Delete" on a listed employee

## Endpoints
Method	   Endpoint	         Description
GET   	    /	               Redirects to employee list
GET        /showEmp	         View all employees
POST	    /addEmp	           Add a new employee
GET	     /editEmp/{id}	     Edit employee by ID
POST	  /updateEmp	         Update an employee
POST	 /deleteEmp/{id}	     Delete employee by ID




