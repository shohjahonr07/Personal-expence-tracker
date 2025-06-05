package expense_tracker;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class ExpenseTracker {
    private double balance;
    private double savingsGoal;
    private ArrayList<Transaction> transactions;
    private HashMap<String, Double> spendingLimits;
    private HashMap<String, Double> spendingPerCategory;
    private Scanner scanner;

    public ExpenseTracker() {
        this.balance = 0;
        this.savingsGoal = 0;
        this.transactions = new ArrayList<>();
        this.spendingLimits = new HashMap<>();
        this.spendingPerCategory = new HashMap<>();
        this.scanner = new Scanner(System.in);
        preloadCategories();
    }

    private void preloadCategories() {
        String[] defaultCategories = {"Food", "Transport", "Entertainment", "Health", "Education"};
        for (String category : defaultCategories) {
            spendingLimits.put(category, 100.0); // Default limit for preloaded categories
            spendingPerCategory.put(category, 0.0);
        }
    }

    public void addBalance() {
        System.out.print("Enter the amount to add to your balance: ");
        double amount = scanner.nextDouble();
        scanner.nextLine();
        balance += amount;
        System.out.println("Balance updated. Current balance: $" + balance);
    }

    public void setSavingsGoal() {
        System.out.print("Enter your monthly savings goal: ");
        savingsGoal = scanner.nextDouble();
        scanner.nextLine();
        System.out.println("Savings goal set to $" + savingsGoal);
    }

    public void addCategory() {
        System.out.print("Enter the name of the new category: ");
        String category = scanner.nextLine();
        if (spendingLimits.containsKey(category)) {
            System.out.println("This category already exists.");
            return;
        }
        System.out.print("Enter the spending limit for this category: ");
        double limit = scanner.nextDouble();
        scanner.nextLine();
        spendingLimits.put(category, limit);
        spendingPerCategory.put(category, 0.0);
        System.out.println("Category added: " + category + " with a limit of $" + limit);
    }

    public void addExpense() {
        System.out.println("Available categories: " + spendingLimits.keySet());
        System.out.print("Enter category: ");
        String category = scanner.nextLine();
        if (!spendingLimits.containsKey(category)) {
            System.out.println("Category not found. Please add it first.");
            return;
        }
        System.out.print("Enter amount: ");
        double amount = scanner.nextDouble();
        scanner.nextLine();
        if (amount > balance) {
            System.out.println("Insufficient balance!");
            return;
        }
        if (spendingLimits.get(category) < spendingPerCategory.get(category) + amount) {
            System.out.println("Warning: This expense exceeds your spending limit for " + category + "!");
        }
        balance -= amount;
        spendingPerCategory.put(category, spendingPerCategory.get(category) + amount);
        transactions.add(new Transaction(category, amount, LocalDate.now()));
        System.out.println("Expense added. Remaining balance: $" + balance);
    }

    public void viewTransactions() {
        for (Transaction transaction : transactions) {
            System.out.println(transaction);
        }
    }

    public void searchByDate() {
        System.out.print("Enter date (YYYY-MM-DD): ");
        String dateInput = scanner.nextLine();
        LocalDate searchDate = LocalDate.parse(dateInput);
        for (Transaction transaction : transactions) {
            if (transaction.getDate().equals(searchDate)) {
                System.out.println(transaction);
            }
        }
    }

    public void viewSpendingPerCategory() {
        for (String category : spendingPerCategory.keySet()) {
            System.out.println("Category: " + category + ", Total Spent: $" + spendingPerCategory.get(category));
        }
    }

    public void checkSavingsGoal() {
        double totalSpent = transactions.stream().mapToDouble(Transaction::getAmount).sum();
        if (balance + totalSpent >= savingsGoal) {
            System.out.println("You are on track to meet your savings goal!");
        } else {
            System.out.println("Warning: You are falling short of your savings goal.");
        }
    }

    public void menu() {
        while (true) {
            System.out.println("\n1. Add Balance");
            System.out.println("2. Set Savings Goal");
            System.out.println("3. Add Category");
            System.out.println("4. Add Expense");
            System.out.println("5. View Transactions");
            System.out.println("6. Search Transactions by Date");
            System.out.println("7. View Spending Per Category");
            System.out.println("8. Check Savings Goal");
            System.out.println("9. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1 -> addBalance();
                case 2 -> setSavingsGoal();
                case 3 -> addCategory();
                case 4 -> addExpense();
                case 5 -> viewTransactions();
                case 6 -> searchByDate();
                case 7 -> viewSpendingPerCategory();
                case 8 -> checkSavingsGoal();
                case 9 -> {
                    System.out.println("Exiting...");
                    return;
                }
                default -> System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
