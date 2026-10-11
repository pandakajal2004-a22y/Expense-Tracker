# Expense Tracker

A simple Java-based Expense Tracker application designed to help college students manage and monitor their daily expenses.

## Features

* **Add Expense:** Record an expense with amount, category, description, and date.
* **View Expenses:** Display all saved expenses.
* **Monthly Summary:** Calculate the total expenses for a selected month.
* **Category Summary:** View expenses by category, including Food, Travel, Academics, and Personal.
* **Delete Expense:** Remove an expense from the records.
* **Input Validation:** Handle invalid amounts, dates, and menu choices.
* **File Handling:** Save expenses to a file and load them when the application starts.

## Technologies Used

* Java
* Object-Oriented Programming (OOP)
* ArrayList
* File Handling
* Exception Handling
* Git and GitHub

## Project Structure

```text
Expense-Tracker/
├── Expense.java
├── ExpenseTracker.java
├── README.md
└── .gitignore
```

## How to Run the Project

1. Install the Java Development Kit (JDK).

2. Clone or download this repository.

3. Open the project folder in VS Code.

4. Open the terminal in the project folder.

5. Compile the Java files:

   ```bash
   javac Expense.java ExpenseTracker.java
   ```

6. Run the application:

   ```bash
   java ExpenseTracker
   ```

## Data Storage

The application stores expense records in a local file named `expenses.txt`. The file is generated when the application saves expenses and is excluded from Git tracking.

## Future Improvements

* Add charts to visualize spending.
* Add budget limits and alerts.
* Create a graphical user interface.
* Export expense reports.

## Author

Kajal Panda
