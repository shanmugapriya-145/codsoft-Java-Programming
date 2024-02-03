package codsoft;
import java.util.Scanner;
public class Currencyconverter {

	public static void main(String[] args) {
		
		        Scanner sc = new Scanner(System.in);

		        System.out.println("Currency Converter!");

		        while (true) {
		            displayMenu();
		            int ch = getUserChoice(sc);

		            switch (ch) {
		                case 1:
		                    convertCurrency(sc, "Euro (EUR)", 0.012);
		                    break;
		                case 2:
		                    convertCurrency(sc, "British Pound (GBP)", 0.011);
		                    break;
		                case 3:
		                    convertCurrency(sc, "Japanese Yen (JPY)", 1.53);
		                    break;
		                case 4:
		                    convertCurrency(sc, "US Dollar (USD)", 0.014);
		                    break;
		                case 5:
		                    convertCurrency(sc, "Australian Dollar (AUD)", 0.019);
		                    break;
		                case 6:
		                    System.out.println("Exiting Currency Converter...");
		                    return;
		                default:
		                    System.out.println("Invalid choice. Please try again.");
		            }
		        }
		    }

		    private static void displayMenu() {
		        System.out.println("1. Convert to Euro (EUR)");
		        System.out.println("2. Convert to British Pound (GBP)");
		        System.out.println("3. Convert to Japanese Yen (JPY)");
		        System.out.println("4. Convert to US Dollar (USD)");
		        System.out.println("5. Convert to Australian Dollar (AUD)");
		        System.out.println("6. Exit");
		    }

		    private static int getUserChoice(Scanner sc) {
		        System.out.print("Enter your choice: ");
		        while (!sc.hasNextInt()) {
		            System.out.println("Invalid input. Please enter a number.");
		            sc.next();
		        }
		        return sc.nextInt();
		    }

		    private static void convertCurrency(Scanner sc, String targetCurrency, double conversionRate) {
		        System.out.print("Enter the amount in INR: ");
		        while (!sc.hasNextDouble()) {
		            System.out.println("Invalid input. Please enter a valid number.");
		            sc.next();
		        }
		        double inrAmount = sc.nextDouble();

		        double convertedAmount = inrAmount * conversionRate;

		        System.out.printf("Converted amount: %.2f INR = %.2f %s%n", inrAmount, convertedAmount, targetCurrency);
		    }
		

	}


