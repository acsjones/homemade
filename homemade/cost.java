package homemade;

import java.util.Scanner;

public class cost {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner kb = new Scanner(System.in);
		makeRecipe: do {
		System.out.println("Enter ingredient: ");
		String kbIngredient = kb.nextLine();
		System.out.println("Enter price: ");
		double kbPrice = kb.nextDouble();
		System.out.println("Enter calories: ");
		int kbCalories = kb.nextInt();
		
		System.out.println("Another ingredient?");
		String anotherIngredient = kb.next();
		
		if (anotherIngredient.equalsIgnoreCase("y")) {
			System.out.println();
			continue makeRecipe;
		
		}

	} while (true);

}
}