package homemade;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import javax.mail.MessagingException;
import javax.mail.SendFailedException;
import javax.mail.internet.AddressException;

public class mainApp {

	public static void main(String[] args) {
		mainMenu: do {
			Scanner kb = new Scanner(System.in);
			Scanner kb2 = new Scanner(System.in);

			String moreIngredients = "y";
			String menuChoice;
			ArrayList<LineIngredient> recipe = new ArrayList<LineIngredient>();

			System.out.println("1. Create New Recipe");
			System.out.println("2. Edit Existing Recipe");
			System.out.println("3. View/Share a Recipe");
			System.out.println("4. Exit");

			menuChoice = Validator.validMenuChoices(kb);
			System.out.println();
			String optionNum = null;

			switch (menuChoice) {
			case "1":
				optionNum = "1";
				break;
			case "2":
				optionNum = "2";
				break;
			case "3":
				optionNum = "3";
				break;
			case "4":
				optionNum = "4";
				break;
			}
			if (optionNum.equals("1")) {
				makeRecipe: do {

					System.out.println("Please enter ingredient: ");
					String kbIngredient = kb.nextLine();
					String kbUnit = Validator.unitIntegrity(kb,
							"Please enter the unit of measurement for " + kbIngredient + ": ");
					Double kbAmount = Validator.getDouble(kb, "Please enter the numerical amount: ");
					recipe.add(new LineIngredient(kbIngredient, kbUnit, kbAmount));
					System.out.println();
					moreIngredients = Validator.yesOrNo(kb, "Should we add another ingredient?");

					if (moreIngredients.equalsIgnoreCase("y")) {
						System.out.println();
						continue makeRecipe;
					}
					if (moreIngredients.equalsIgnoreCase("n")) {
						System.out.println("Enter a name for your recipe: ");
						String recipeName = kb.nextLine();
						;
						String recipeNameNoSpace = recipeName.replaceAll("\\s+", "");
						System.out.println();
						System.out.println("[" + recipeName + "]");

						for (LineIngredient lineList : recipe)
							System.out.println(lineList);

						RecipeTextFile recipeTxt = new RecipeTextFile(recipeNameNoSpace.toLowerCase(),
								recipeNameNoSpace.toLowerCase());
						recipeTxt.saveRecipe(recipeName, recipe);
						System.out.println();

						System.out.println("Recipe has been saved!");
						System.out.println();
						recipe.clear();
						System.out.println("Would you like to do?");
						System.out.println("1. Create Another Recipe");
						System.out.println("2. Back to Main Menu");
						String optionsForFirst = Validator.validMenuChoices3(kb);

						if (optionsForFirst.equals("1")) {
							System.out.println();

							continue makeRecipe;
						}

						if (optionsForFirst.equals("2")) {
							System.out.println();
							continue mainMenu;
						}

					}
					break makeRecipe;
				} while (true);

			}
			if (optionNum.equals("3")) {
				viewRecipe: do {

					RecipeTextFile txtTitles = new RecipeTextFile(null, null);
					txtTitles.getAllRecipeNames();
					System.out.println();
				

					int recipeNameInt =  (int) Validator.getInt2(kb, "Please choose a recipe (by number)", "Or enter '0' to cancel: ");
		
					System.out.println();
					try {
						try { 
							if(recipeNameInt == 0)
							{ throw new WordContainsException();
						     }
						 }
						 catch(WordContainsException ex)
						 {
							 continue mainMenu;
						 }
						
					ArrayList<String> recipeList = new ArrayList<String>();
				
					recipeList.addAll(Arrays.asList(txtTitles.getARecipeName(recipeNameInt - 1)));

					String recipeChoice = recipeList.get(0).substring(0, recipeList.get(0).lastIndexOf('.'));

					System.out.println();

					RecipeTextFile recipes = new RecipeTextFile(recipeChoice, null);
					List<String> txtFileContents = recipes.readRecipe();
					for (String lineList : txtFileContents)
						System.out.println(lineList);

					System.out.println();
					System.out.println("Would you like to do?");
					System.out.println("-----------------------");
					System.out.println("1. Share this Recipe");
					System.out.println("2. View Another Recipe");
					System.out.println("3. Back to Main Menu");
					
					String optionsForThird = Validator.validMenuChoices2(kb);
					if (optionsForThird.equals("1")) {

						String orgPath = txtTitles.printFilePath(recipeChoice);
						String[] attachFiles = new String[1];
						{
							attachFiles[0] = orgPath;

						}
sendEmail: do {
						try {
						
							EmailAttachmentSender testing = new EmailAttachmentSender();
							System.out.println("Enter recepient's email address: ");
							String mailTo = kb.next();
							
							System.out.println("Enter message (press Enter to continue with no message) ");
							String message = kb2.nextLine();
							String subject = testing.getSubject(txtFileContents.get(0));
							String password = testing.getPassword();
							String mailFrom = testing.getMailFrom();
							String port = testing.getPort();
							String host = testing.getHost();

							testing.sendEmailWithAttachments(host, port, mailFrom, password, mailTo, subject, message,
									attachFiles);
						 }catch (AddressException e) {
							e.printStackTrace();
						} catch (SendFailedException e) {
						
							String tryAgain = Validator.yesOrNo(kb, "An error occured. Try again?");
							
							if (tryAgain.equalsIgnoreCase("y")) {
							
								continue sendEmail;
							}
							if (tryAgain.equalsIgnoreCase("n")) {
								System.out.println("Returning to main menu...");
								continue mainMenu;
							}
							}catch (MessagingException e) {
							e.printStackTrace();
						} 
						
						System.out.println();
						System.out.println("...successfully sent!");

						System.out.println("Returning to Main Menu.");
						System.out.println();
						continue mainMenu;
} while (true);
						} 

					if (optionsForThird.equals("2")) {
						System.out.println();
						continue viewRecipe;
					}

					if (optionsForThird.equals("3")) {
						System.out.println();
						continue mainMenu;
					}} catch (ArrayIndexOutOfBoundsException ex) {
						System.out.println();
						System.out.println("Recipe does not exist.");
						System.out.println();
			
						
					}
				} while (true);
			}
			if (optionNum.equals("4")) {
				System.out.print("Goodbye!");
				kb.close();
				kb2.close();
			}
			
			break mainMenu;
		} while (true);
	}
}

