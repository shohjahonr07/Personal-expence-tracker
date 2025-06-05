# Personal Expense Tracker

A simple console-based Java application to help users manage their personal finances by tracking expenses by categories and dates, and keeping an updated balance.

---

## Project Purpose

This project allows users to input an initial amount of money they have, add expenses under different categories such as Food, Transport, and Entertainment, automatically saves the date of each expense, and view a summary of all transactions with the remaining balance. It is designed to practice Java Object-Oriented Programming (OOP) concepts and Java Collections.

---

## Features Implemented

- Input initial balance.
- Add expenses with predefined categories.
- Automatically records the date of each transaction using Java's `LocalDate`.
- View a detailed summary of all expenses and remaining balance.
- Console-based menu interface for easy interaction.

---

## Technologies Used

- Java 8+
- Object-Oriented Programming (OOP) principles
- Java Collections Framework (`ArrayList`)
- Java Date and Time API (`java.time.LocalDate`)

---

## How to Run the Code

1. Clone or download the repository:
   ```bash
   git clone https://github.com/your-username/PersonalExpenseTracker.git
2. Navigate to the project directory:
   cd PersonalExpenseTracker
3. Compile the Java files:
   javac Main.java ExpenseTracker.java Transaction.java
4. Run the program:
   java Main
5. Follow the prompts in the console:
   Enter your initial balance.
   Choose to add expenses or view the summary.
   Enter expense categories and amounts when prompted.
## Example Usage 

Enter your initial balance: 500

Menu:
1. Add Expense
2. Show Summary
3. Exit
Choose an option: 1

Available Categories: Food, Transport, Entertainment
Enter category: Food
Enter amount: 50
Expense added successfully!

Menu:
1. Add Expense
2. Show Summary
3. Exit
Choose an option: 2

Transaction Summary:
Category: Food, Amount: 50.0, Date: 2025-06-04
Remaining Balance: 450.0

## Future Improvements
  Add dynamic categories to allow users to create custom expense types.
  Save transaction data to a file for persistence across sessions.
  Add budget alerts or spending limits per category.
  Implement a graphical user interface (GUI) for easier use.

## Contact
  For questions or feedback, feel free to contact me at: rustamovshoxjaxon32@gmail.com
