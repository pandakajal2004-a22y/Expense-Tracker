import java.util.Scanner;
import java.util.ArrayList;
import java.io.*;

public class ExpenseTracker {

    // Save expenses in a file
    static void saveExpenses(ArrayList<Expense> expenses) {

        try {
            FileWriter writer = new FileWriter("expenses.txt");

            for (Expense expense : expenses) {
                writer.write(
                    expense.amount + "|" +
                    expense.category + "|" +
                    expense.description + "|" +
                    expense.date + "\n"
                );
            }

            writer.close();
            System.out.println("Expenses saved successfully!");

        } catch (IOException e) {
            System.out.println("Error saving expenses.");
        }
    }

    // Load saved expenses from the file
    static void loadExpenses(ArrayList<Expense> expenses) {

        File file = new File("expenses.txt");

        if (!file.exists()) {
            return;
        }

        try {
            BufferedReader reader =
                new BufferedReader(new FileReader(file));

            String line;

            while ((line = reader.readLine()) != null) {

                String[] data = line.split("\\|", 4);

                if (data.length == 4) {

                    double amount = Double.parseDouble(data[0]);
                    String category = data[1];
                    String description = data[2];
                    String date = data[3];

                    Expense expense = new Expense(
                        amount, category, description, date
                    );

                    expenses.add(expense);
                }
            }

            reader.close();

        } catch (IOException | NumberFormatException e) {
            System.out.println("Error loading expenses.");
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ArrayList<Expense> expenses = new ArrayList<>();

        // Load previously saved expenses
        loadExpenses(expenses);

        int choice;

        do {
            System.out.println();
            System.out.println("================================");
            System.out.println("       EXPENSE TRACKER");
            System.out.println("================================");

            System.out.println("1. Add Expense");
            System.out.println("2. View Expenses");
            System.out.println("3. Monthly Summary");
            System.out.println("4. Category Summary");
            System.out.println("5. Exit");
            System.out.println("6. Delete Expense"); 

            
System.out.print("Enter your choice: ");

String menuInput = sc.nextLine();

try {
    choice = Integer.parseInt(menuInput);
} catch (NumberFormatException e) {
    System.out.println("Invalid input! Please enter a number.");
    choice = 0;
}

            // Option 1: Add Expense
            if (choice == 1) {

                
System.out.print("Enter expense amount: ");
double amount;

while (true) {
    String input = sc.nextLine();

    try {
        amount = Double.parseDouble(input);

        if (amount > 0 && Double.isFinite(amount)) {
            break;
        } else {
            System.out.print("Enter an amount greater than 0: ");
        }

    } catch (NumberFormatException e) {
        System.out.print("Invalid amount! Enter a number: ");
    }
}

                
System.out.println("Select a category:");
System.out.println("1. Food");
System.out.println("2. Travel");
System.out.println("3. Academics");
System.out.println("4. Personal");
System.out.print("Enter category choice: ");




String categoryInput;
int categoryChoice;

while (true) {
    categoryInput = sc.nextLine();

    try {
        categoryChoice = Integer.parseInt(categoryInput);

        if (categoryChoice >= 1 && categoryChoice <= 4) {
            break;
        } else {
            System.out.print("Invalid choice! Enter 1, 2, 3, or 4: ");
        }

    } catch (NumberFormatException e) {
        System.out.print("Please enter a number (1-4): ");
    }
}

String category;

if (categoryChoice == 1) {
    category = "Food";
} else if (categoryChoice == 2) {
    category = "Travel";
} else if (categoryChoice == 3) {
    category = "Academics";
} else {
    category = "Personal";
}





                System.out.print("Enter description: ");
                String description = sc.nextLine();

                
System.out.print("Enter date (YYYY-MM-DD): ");
String date;

while (true) {
    date = sc.nextLine();

    try {
        java.time.LocalDate.parse(date);
        break;
    } catch (java.time.format.DateTimeParseException e) {
        System.out.print("Invalid date! Enter date as YYYY-MM-DD: ");
    }
}

                Expense expense = new Expense(
                    amount, category, description, date
                );

                expenses.add(expense);

                // Save expenses after adding a new expense
                saveExpenses(expenses);
            }

            // Option 2: View Expenses
            else if (choice == 2) {

                System.out.println();
                System.out.println("========== ALL EXPENSES ==========");

                if (expenses.isEmpty()) {
                    System.out.println("No expenses added yet.");
                } else {
                    for (Expense expense : expenses) {
                        System.out.println("Amount: Rs." + expense.amount);
                        System.out.println("Category: " + expense.category);
                        System.out.println("Description: " + expense.description);
                        System.out.println("Date: " + expense.date);
                        System.out.println("--------------------------------");
                    }
                }
            }

            // Option 3: Monthly Summary
            else if (choice == 3) {

                System.out.print("Enter month (YYYY-MM): ");
                String month = sc.nextLine();

                double total = 0;

                for (Expense expense : expenses) {
                    if (expense.date.startsWith(month)) {
                        total += expense.amount;
                    }
                }

                System.out.println();
                System.out.println("========== MONTHLY SUMMARY ==========");
                System.out.println("Month: " + month);
                System.out.println("Total Expenses: Rs." + total);
            }

            // Option 4: Category Summary
            else if (choice == 4) {

                double foodTotal = 0;
                double travelTotal = 0;
                double academicsTotal = 0;
                double personalTotal = 0;

                for (Expense expense : expenses) {

                    if (expense.category.equalsIgnoreCase("Food")) {
                        foodTotal += expense.amount;
                    } else if (expense.category.equalsIgnoreCase("Travel")) {
                        travelTotal += expense.amount;
                    } else if (expense.category.equalsIgnoreCase("Academics")) {
                        academicsTotal += expense.amount;
                    } else if (expense.category.equalsIgnoreCase("Personal")) {
                        personalTotal += expense.amount;
                    }
                }

                System.out.println();
                System.out.println("========== CATEGORY SUMMARY ==========");
                System.out.println("Food: Rs." + foodTotal);
                System.out.println("Travel: Rs." + travelTotal);
                System.out.println("Academics: Rs." + academicsTotal);
                System.out.println("Personal: Rs." + personalTotal);
            }
             // Option 6: Delete Expense
        
            else if (choice == 6) {

                if (expenses.isEmpty()) {
                    System.out.println("No expenses available to delete.");
                } else {

                    for (int i = 0; i < expenses.size(); i++) {
                        Expense expense = expenses.get(i);

                        System.out.println(
                            (i + 1) + ". Rs." + expense.amount
                            + " | " + expense.category
                            + " | " + expense.description
                            + " | " + expense.date
                        );
                    }

                    System.out.print("Enter expense number to delete: ");

                    String deleteInput = sc.nextLine();
                    int deleteChoice;

                    try {
                        deleteChoice = Integer.parseInt(deleteInput);
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input! Please enter a number.");
                        continue;
                    }

                    if (deleteChoice >= 1 && deleteChoice <= expenses.size()) {
                        expenses.remove(deleteChoice - 1);
                        saveExpenses(expenses);
                        System.out.println("Expense deleted successfully!");
                    } else {
                        System.out.println("Invalid expense number.");
                    }
                }
            }

            // Option 5: Exit
            else if (choice == 5) {
                System.out.println("Thank you for using Expense Tracker!");
            }

            // Invalid Option
            else {
                System.out.println("Invalid choice. Please try again.");
            }

        } while (choice != 5);

        sc.close();
    }
}