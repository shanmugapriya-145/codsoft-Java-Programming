package codsoft;
import java.util.Scanner;
public class ATMinterface {
 		    private BankAcc acc;
		    private static final int WITHDRAWAL_OPTION = 1;
		    private static final int DEPOSIT_OPTION = 2;
		    private static final int CHECK_BALANCE_OPTION = 3;
		    private static final int EXIT_OPTION = 4;

		    public ATMinterface(BankAcc account) {
		        this.acc = account;
		    }

		    public void start() {
		        Scanner ip = new Scanner(System.in);

		        while (true) {
		            displayMenu();
		            int ch = getUserChoice(ip);

		            switch (ch) {
		                case WITHDRAWAL_OPTION:
		                    performWithdrawal(ip);
		                    break;
		                case DEPOSIT_OPTION:
		                    performDeposit(ip);
		                    break;
		                case CHECK_BALANCE_OPTION:
		                    checkAccountBalance();
		                    break;
		                case EXIT_OPTION:
		                    System.out.println("Exiting ATM...");
		                    return;
		                default:
		                    System.out.println("Invalid choice. Please try again.");
		            }
		        }
		    }

		    private int getUserChoice(Scanner sc) {
		        System.out.print("Enter your choice: ");
		        while (!sc.hasNextInt()) {
		            System.out.println("Invalid input. Please enter a number.");
		            sc.next(); 
		        }
		        return sc.nextInt();
		    }

		    private void displayMenu() {
		        System.out.println("Welcome to the ATM!");
		        System.out.println(WITHDRAWAL_OPTION + ". Withdraw");
		        System.out.println(DEPOSIT_OPTION + ". Deposit");
		        System.out.println(CHECK_BALANCE_OPTION + ". Check balance");
		        System.out.println(EXIT_OPTION + ". Exit");
		    }

		    private void performWithdrawal(Scanner sc) {
		        System.out.print("Enter withdrawal amount: ");
		        double amt;
		        while (true) {
		            try {
		                amt = Double.parseDouble(sc.next());
		                break;
		            } catch (NumberFormatException e) {
		                System.out.println("Invalid input. Please enter a valid number.");
		                System.out.print("Enter withdrawal amount: ");
		            }
		        }

		        if (acc.withdraw(amt)) {
		            System.out.println("Withdrawal successful.");
		        } else {
		            System.out.println("Insufficient balance.");
		        }
		    }

		    private void performDeposit(Scanner sc) {
		        System.out.print("Enter deposit amount: ");
		        double amount;
		        while (true) {
		            try {
		                amount = Double.parseDouble(sc.next());
		                break;
		            } catch (NumberFormatException e) {
		                System.out.println("Invalid input. Please enter a valid number.");
		                System.out.print("Enter deposit amount: ");
		            }
		        }

		        acc.deposit(amount);
		        System.out.println("Deposit successful.");
		    }

		    private void checkAccountBalance() {
		        System.out.println("Your account balance is: " + acc.getBalance());
		    }

		    private static class BankAcc {

		        private double bal;

		        public BankAcc(double initBal) {
		            this.bal = initBal;
		        }

		        public boolean withdraw(double amt) {
		            if (amt <= bal) {
		                bal -= amt;
		                return true;
		            } else {
		                return false;
		            }
		        }

		        public void deposit(double amt) {
		            bal += amt;
		        }

		        public double getBalance() {
		            return bal;
		        }
		    }

		    public static void main(String[] args) {
		        BankAcc account = new BankAcc(1000.0);
		        ATMinterface atm = new ATMinterface(account);
		        atm.start();
		    }
		}


