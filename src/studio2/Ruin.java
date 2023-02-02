package studio2;

import java.util.Scanner;

public class Ruin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);

		System.out.print("Enter days played: ");
		int totalSimulations = in.nextInt();
		
		System.out.print("Enter your starting money: ");
		int startAmount = in.nextInt();

		System.out.print("Enter your win chance (0-1.0): ");
		double winChance = in.nextDouble();
		
		System.out.print("Enter your win limit: ");
		double winLimit = in.nextDouble();
		
		int losses = 0;
		double expectedRuin = 0;
		for (int x=1; totalSimulations>=x; x++)
		{
			int plays = 0;
			int money = startAmount;
			while ((money != 0) && (money != winLimit)) {
				plays++;
				if (Math.random()>winChance)
					money--;
				else 
					money++;
			}
			System.out.print("Simulation " + x + ": " + plays);
			if (money==0)
			{	losses++;
				System.out.println(" LOSE");}
			else
				System.out.println(" WIN");
			
	
			double a = ((1-winChance)/winChance);
			if (winChance == 0.5)
				expectedRuin = (1 - (startAmount/winLimit));
			else
				expectedRuin = ((Math.pow(a, startAmount))-(Math.pow(a, winLimit))/(1-(Math.pow(a, winLimit))));
				
				
		}
		System.out.println("Losses: " + losses + " Simulations: " + totalSimulations);
		System.out.println("Ruin Rate from Simuilation: "+(1.0*losses/totalSimulations) + " Expected Ruin Rate: "+ expectedRuin);
		
	}
}
