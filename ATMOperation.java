package internship;
import java.util.Scanner;

class BankAccount {
 private double balance;

 public BankAccount(double initialBalance) {
     this.balance = initialBalance;
 }

 public double getBalance() {
     return balance;
 }

 public void deposit(double amount) {
     if (amount > 0) {
         balance += amount;
         System.out.println("Deposit successful. Current balance: " + balance);
     } else {
         System.out.println("Invalid deposit amount.");
     }
 }

 public void withdraw(double amount) {
     if (amount > 0 && amount <= balance) {
         balance -= amount;
         System.out.println("Withdrawal successful. Current balance: " + balance);
     } else {
         System.out.println("Invalid withdrawal amount or insufficient funds.");
     }
 }
}

class ATM {
 private BankAccount bankAccount;

 public ATM(BankAccount account) {
     this.bankAccount = account;
 }

 public void displayMenu() {
     System.out.println("\nATM Menu:");
     System.out.println("1. Check Balance");
     System.out.println("2. Deposit");
     System.out.println("3. Withdraw");
     System.out.println("4. Exit");
 }

 public void processOption(int option) {
     Scanner scan = new Scanner(System.in);

     switch (option) {
         case 1:
             System.out.println("Current Balance: " + bankAccount.getBalance());
             break;
         case 2:
             System.out.print("Enter deposit amount: ");
             double depositAmount = scan.nextDouble();
             bankAccount.deposit(depositAmount);
             break;
         case 3:
             System.out.print("Enter withdrawal amount: ");
             double withdrawalAmount = scan.nextDouble();
             bankAccount.withdraw(withdrawalAmount);
             break;
         case 4:
             System.out.println("Exiting. Thank you!");
             System.exit(0);
             break;
         default:
             System.out.println("Invalid option. Please choose a valid option.");
     }
 }
}

public class ATMOperation {
 public static void main(String[] args) {
     BankAccount userAccount = new BankAccount(1000.0);

     ATM atm = new ATM(userAccount);

     Scanner scan = new Scanner(System.in);

     while (true) {
         atm.displayMenu();
         System.out.print("Enter your choice (1-4): ");
         int choice = scan.nextInt();

         atm.processOption(choice);
     }
 }
}
