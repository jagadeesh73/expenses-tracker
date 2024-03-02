import java.util.ArrayList;
import java.util.Scanner;

class Expense {
    private String date;
    private String category;
    private double amount;

    public Expense(String date, String category, double amount) {
        this.date = date;
        this.category = category;
        this.amount = amount;
    }

    public String getDate() {
        return date;
    }

    public String getCategory() {
        return category;
    }

    public double getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return "Expense{" +
                "date='" + date + '\'' +
                ", category='" + category + '\'' +
                ", amount=" + amount +
                '}';
    }
}

public class ExpenseTracker {
    private ArrayList<Expense> expenses;

    public ExpenseTracker() {
        expenses = new ArrayList<>();
    }

    public void addExpense(String date, String category, double amount) {
        Expense newExpense = new Expense(date, category, amount);
        expenses.add(newExpense);
    }

    public void listExpenses() {
        for (Expense expense : expenses) {
            System.out.println(expense);
        }
    }

    public static void main(String[] args) {
        ExpenseTracker tracker = new ExpenseTracker();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Expense Tracker Menu:");
            System.out.println("1. Add Expense");
            System.out.println("2. View Expenses");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter date (YYYY-MM-DD): ");
                    String date = scanner.next();
                    scanner.nextLine(); // Consume newline left-over
                    System.out.print("Enter category: ");
                    String category = scanner.nextLine();
                    System.out.print("Enter amount: ");
                    double amount = scanner.nextDouble();
                    tracker.addExpense(date, category, amount);
                    break;
                case 2:
                    tracker.listExpenses();
                    break;
                case 3:
                    System.out.println("Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }
}
