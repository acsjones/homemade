package homemade;

import java.util.Scanner;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

public class Validator {

	public static String yesOrNo(Scanner sc, String prompt) {
		System.out.println(prompt);
		while (true) {
			String s = sc.next().toLowerCase();
			sc.nextLine();
			if (s.startsWith("y")) {
				return "y";
			} else if (s.startsWith("n")) {
				return "n";
			} else {
				System.out.println("I didn't understand your response. Please enter 'Y' or 'N'.");
			}
		}
	}

	public static String validMenuChoices(Scanner sc) {

		while (true) {
			String s = sc.next().toLowerCase();
			sc.nextLine();
			if (s.equals("1")) {
				return "1";
			}
			if (s.equals("2")) {
				return "2";
			}
			if (s.equals("3")) {
				return "3";
			} else if (s.equals("4")) {
				return "4";
			} else {
				System.out.println("Please choose between options 1-4.");
			}
		}
	}
	public static String validMenuChoices2(Scanner sc) {

		while (true) {
			String s = sc.next().toLowerCase();
			sc.nextLine();
			if (s.equals("1")) {
				return "1";
			}
			if (s.equals("2")) {
				return "2";
			}
			else if (s.equals("3")) {
				return "3";
			} else {
				System.out.println("Please choose between options 1-3.");
			}
		}
	}
	
	public static String validMenuChoices3(Scanner sc) {

		while (true) {
			String s = sc.next().toLowerCase();
			sc.nextLine();
			if (s.equals("1")) {
				return "1";
			}
			else if (s.equals("2")) {
				return "2";
			}
			else {
				System.out.println("Please choose between options 1-2.");
			}
		}
	}
	public static String unitIntegrity(Scanner sc, String prompt) {
		System.out.println(prompt);
		while (true) {
			String s = sc.next().toLowerCase(); // read user entry
			sc.nextLine(); // discard any other data entered on the line
			if (s.startsWith("tb") || s.startsWith("tab")) {
				return "tbsp";
			}
			if (s.startsWith("ts") || s.startsWith("tea")) {
				return "tsp";
			}
			if (s.startsWith("o")) {
				return "oz";
			}
			if (s.startsWith("c")) {
				return "cup";
			}
			if (s.startsWith("pn") || s.startsWith("pi")) {
				return "pt";
			}
			if (s.startsWith("qt") || s.startsWith("qu")) {
				return "qt";
			}
			if (s.startsWith("ga")) {
				return "gal";
			}
			if (s.startsWith("lb") || s.startsWith("po")) {
				return "lb";
			}
			if (s.startsWith("ml") || s.startsWith("mil")) {
				return "ml";
			}
			if (s.startsWith("gr")) {
				return "g";
			} else if (s.startsWith("n")) {
				return "";
			} else {
				System.out.println(
						"Unit of measurements available: teaspoon, tablespoon, ounce, cup, pint, quart, gallon, pound, milliliter, gram");
				System.out.println("To leave blank, please enter \"none\"");
			}
		}
	}

	public static double getDouble(Scanner sc, String prompt) {
		double i = 0;
		boolean isValid = false;
		while (isValid == false) {
			System.out.print(prompt);
			if (sc.hasNextDouble()) {
				i = sc.nextDouble();
				isValid = true;
			} else {
				System.out.println("Error! Invalid integer value. Try again.");
			}
			sc.nextLine();
		}
		return i;
	}
	
	public static double getInt(Scanner sc, String prompt) {
		int i = 0;
		boolean isValid = false;
		while (isValid == false) {
			System.out.print(prompt);
			if (sc.hasNextInt()) {
				i = sc.nextInt();
				isValid = true;
			} else {
				System.out.println();
				System.out.println("Error! Invalid integer value. Try again.");
				System.out.println();
			}
			sc.nextLine();
		}
		return i;
	}

	public static double getInt2(Scanner sc, String prompt, String prompt2) {
		int i = 0;
		boolean isValid = false;
		while (isValid == false) {
			System.out.println(prompt);
			System.out.print(prompt2);
			if (sc.hasNextInt()) {
				i = sc.nextInt();
				isValid = true;
			} else {
				System.out.println();
				System.out.println("Error! Invalid integer value. Try again.");
				System.out.println();
			}
			sc.nextLine();
		}
		return i;
	}
	

}