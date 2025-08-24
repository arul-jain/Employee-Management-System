# 🚀 Employee Management System

## Project Overview

This project showcases an **Employee Management System** developed during my summer internship at GEOPIC, ONGC, Dehradun. It's a fundamental system designed to efficiently handle employee data within an organization.

---

## ✨ Features

* **Add Employee Data:** Seamlessly onboard new employees by adding their details to the system.

* **View Employee Data:** Access comprehensive employee information, with different viewing privileges for regular employees, managers, and administrators.

* **Update Employee Data:** Easily modify existing employee records to ensure accuracy.

* **Remove Employee Data:** Efficiently remove employee information upon their departure from the organization.

* **Secure Login:** Employees can access their data using their unique Employee ID and password, ensuring privacy.

* **User-Friendly Interface:** Designed with a clean and intuitive interface, featuring relevant office-themed backgrounds to enhance user experience.

---

## 🛠️ Technologies Used

The project leverages a robust set of Java-based technologies and a powerful database system:

* **Apache NetBeans IDE 22:** Integrated Development Environment for Java application development.

* **MySQL Workbench 8.0 CE:** Tool for managing and querying the MySQL database.

* **JDK 17.0.11 & JRE 17.0.11:** Java Development Kit and Java Runtime Environment for running the application.

* **MySQL Connector/J 8.0.28:** JDBC driver for connecting Java applications to MySQL databases.

* **rs2xml.jar:** Library used for populating JTable components with data from `ResultSet` objects.

---

## 📊 Database Schema

The core of the system relies on a `employee` table to store all employee-related information. The table schema includes:

* `name`: Employee's full name

* `address`: Employee's residential address

* `mob_no`: Employee's mobile number

* `pass_word`: Employee's login password

* `email_id`: Employee's email address

* `position`: Employee's job position (e.g., "Admin", "Manager", "Software Engineer")

* `team`: The team the employee belongs to

* `emp_id`: Unique Employee ID

---

## 💡 Key Learnings

This internship project provided invaluable experience in:

* **Real-world Project Development:** Gaining hands-on experience in building a complete application from scratch.

* **Core Computer Science Concepts:** Deepening understanding of event handling, database connectivity, and CRUD operations.

* **Database Integration:** Learning how to effectively connect a Java application to a MySQL database for data manipulation.

* **User Interface Design:** Focusing on creating a user-friendly and aesthetically pleasing application.

* **Logic Development:** Enhancing problem-solving and logical thinking skills essential for software engineering.

---

## 👨‍💻 Installation and Setup

To set up and run this project locally, follow these steps:

1.  **Clone the repository:**

    ```
    git clone [https://github.com/your-username/Employee-Management-System.git](https://github.com/your-username/Employee-Management-System.git)
    cd Employee-Management-System

    ```

2.  **Install MySQL:** Ensure you have MySQL Server and MySQL Workbench installed.

3.  **Create Database:** Create a database named `Employee_System` in MySQL.

4.  **Create Table:** Execute the following SQL query to create the `employee` table:

    ```
    CREATE TABLE employee (
        name VARCHAR(255),
        address VARCHAR(255),
        mob_no VARCHAR(20),
        pass_word VARCHAR(255),
        email_id VARCHAR(255),
        position VARCHAR(255),
        team VARCHAR(255),
        emp_id VARCHAR(255) PRIMARY KEY
    );

    ```

5.  **Update Database Credentials:** Modify the `Connections.java` file with your MySQL username and password.

    ```
    // In Connections.java
    c = DriverManager.getConnection("jdbc:mysql://localhost:3306/Employee_System","your_mysql_username","your_mysql_password");

    ```

6.  **Add JAR Dependencies:** Make sure `mysql-connector-java-8.0.28.jar` and `rs2xml.jar` are added to your project's build path in Apache NetBeans.

7.  **Run the Application:** Open the project in Apache NetBeans and run the `Main.java` file.

---

## 📸 Screenshots

Here are some glimpses of the Employee Management System in action:

![image alt](https://github.com/arul-jain/Employee-Management-System/blob/d3b0fe614aed329fa78d2ec3a7cc3dd8e694aaee/Picture1.png)

---

## 🎓 Contribution

This project was developed by **Arul Jain** under the guidance of **Mr. Abhishek Kumar**, Sr. Programming Officer, GEOPIC, ONGC, Dehradun, as part of a Bachelor of Technology in Computer Science and Engineering.

Feel free to explore the code, provide feedback, or suggest improvements!
