package codsoft;
import java.util.Random;
import java.util.Scanner;
public class Numbergame {
	private static int win;
	   public static void main(String[] args) {
		      
				System.out.println("*****Number Game*****\n");
				System.out.println("Enter your name: \n");
				Scanner sc = new Scanner(System.in);
				String user = sc.nextLine();
				System.out.println("Hello" + user);
				String op;
				boolean flag= true;
				win = 0;
			    do
				{
					System.out.println("\nSelect an Option: \n\n1. Start\n2.Exit\n");
					op = sc.next();
					switch(op)
					{
					case "1":
						game(sc,flag);
						System.out.println("\n\nDo you want to play again?: \n\n1. Yes\n2. No\n");
						String ch = sc.next();
						while(ch.equals("1"))
						{
							game(sc,flag);
							System.out.println("\n\nDo you want to play again?: \n\n1. Yes\n2. No\n");
							ch = sc.next();
						}
						
						System.out.println("Bravo!You have Won " + win + " Round(s)");
						flag = false;
						break;
						case "2":
						System.out.println("Didn't make it,Try again");
						flag= false;
						break;
						default:
					    System.err.println("Invalid input, Please Enter Again!");
						break;
					}
					
				}while(flag);
					
			}
			
			public static void game(Scanner sc, boolean flag )
			{
				Random rand = new Random();
				int randVal = rand.nextInt(101);
				System.out.println("Let's get started!");
				int chance = 10;
				int guess;
				while(chance > 0)
				{
					System.out.println("\nChances Left: " + chance);
					System.out.println("Please enter Your Guess: ");
                    guess = sc.nextInt();
					if(guess > randVal)
					{
						System.out.println("Enter a Lower Value!!!\n");
						
					}else if(guess < randVal)
					{
						System.out.println("Enter a Higher Value!!!\n");
						
					}else
					{
						System.out.println("*****Congratulations!You Won*****");
						win++;
						flag = false;
						break;
					}
					
					chance -= 1;
				}
				
				if(flag)
				{
					System.out.println("\nRandom Value = " + randVal);
					System.out.println("\n****Game Over,You didn't win this time.****");
					flag = false;
				}				
			}
}


