Java Swing Student Registration Form
This is a simple desktop application built using Java Swing (GUI) that captures student registration data and saves it to a local SQLite database.
🚀 Features


Clean GUI: A straightforward and clean data entry form built with Java Swing.
Database Storage: Student data is saved to a persistent students.db (SQLite) file.
Data Validation: Includes basic validation to ensure 'Name' and 'Student ID' fields are not empty.

Error Handling: Prevents duplicate Student IDs from being saved to the database.


🏃‍♂️ How to Run
Clone this repository to your local machine.

Open the project in IntelliJ IDEA.

Add the sqlite-jdbc driver:

Right-click the project -> Open Module Settings.

Go to Libraries -> + (Add) -> From Maven...

Search for org.xerial:sqlite-jdbc and add it.

Right-click the src/Main.java file and select "Run 'Main.main()'".
📸 Screenshots

Here is a demo of the application in action:

1. Registration Form

This is the main form presented to the user upon running the application.
![Student Registration Form](images/form.png)


2. Saved Database Data

After successfully submitting the data, it is saved to the students.db file. This screenshot shows the data as viewed using "DB Browser for SQLite".
![Data in SQLite Database](images/database.png)