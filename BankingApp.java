import java.util.Scanner;

public class BankingApp {
    public static void main(String[] args) {
        Account object = new Account("James Glass", "jpg0044");
        object.menu();
    }
}

class Account {
    //variables
    int balance;
    int lastTransaction;
    String userName;
    String userID;
    //constructor
    Account(String name, String id) {
        userName = name;
        userID = id;
    }

    //function for deposits
    //changes the balance based on the amount deposited
    //adds the user input amount to the balance
    void deposit(int amount) {
        if (amount > 0) {
            balance += amount;
            lastTransaction = amount;
        }
    }

    //withdraw function
    //takes the user input amount and subtracts that amount from the balance
    void withdraw(int amount) {
        if (amount > 0) {
            balance -= amount;
            lastTransaction = -amount;
        }
    }

    //When the user uses this function, it shows the last transaction(deposit or withdrawl)
    //otherwise says there have been no transactions
    void getLastTransaction() {
        if (lastTransaction > 0) {
            System.out.println("Deposited: " + lastTransaction);
        }

        else if (lastTransaction < 0) {
            System.out.println("Withdraw " +Math.abs(lastTransaction));
        }

        else {
            System.out.println("No Transactions Occured");
        }
    }
    //Prints the main menu that the user will see and interact with
    void menu() {
        //initialize variable for switch statement
        char ch = '\0';
        Scanner myScan = new Scanner(System.in);

        System.out.println("Welcome " +userName);
        System.out.println("Your ID is: " +userID);
        System.out.println("\n");

        //Show the user a list of keybinds for each option
        System.out.println("B: Check Your Balance");
        System.out.println("D: Deposit");
        System.out.println("W: Withdraw");
        System.out.println("T: View Your Latest Transaction");
        System.out.println("E: Exit The System");

        //While the user has not exited the system, run the following steps...
        do {
            System.out.println("****************************************************************************");
            System.out.println("Enter An Option");
            System.out.println("****************************************************************************");
            ch = myScan.next().charAt(0);
            System.out.println("\n");

            switch (ch) {
                case 'B':
                    System.out.println("-------------------------------------------------------");
                    System.out.println("Balance = " +balance);
                    System.out.println("-------------------------------------------------------");
                    System.out.println("\n");
                    break;

                case 'D':
                    System.out.println("-------------------------------------------------------");
                    System.out.println("Enter an amount to deposit ");
                    System.out.println("-------------------------------------------------------");
                    int amount = myScan.nextInt();
                    deposit(amount);
                    System.out.println("\n");
                    break;

                case 'W':
                    System.out.println("-------------------------------------------------------");
                    System.out.println("Enter an amount to withdraw ");
                    System.out.println("-------------------------------------------------------");
                    int amount2 = myScan.nextInt();
                    withdraw(amount2);
                    System.out.println("\n");
                    break;

                case 'T':
                    System.out.println("-------------------------------------------------------");
                    getLastTransaction();
                    System.out.println("-------------------------------------------------------");
                    System.out.println("\n");
                    break;

                case 'E':
                    System.out.println("=============================================================================================================");
                    break;

                default:
                    System.out.println("Invalid Input! Please Enter One of the Options Listed");
                    break;
            }
        }

        while(ch != 'E');
        
        System.out.println("Thank You for Using Our Services.....!!");

        myScan.close();

    }
    
}