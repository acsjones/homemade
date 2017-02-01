package homemade;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
public class RecipeTextFile {

	private Path filePath;
private int recipeByNumber;


	public int getRecipeByNumber() {
	return recipeByNumber;
}

public void setRecipeByNumber(int recipeByNumber) {
	this.recipeByNumber = recipeByNumber;
}

	public RecipeTextFile(String filePathString) {
		this.filePath = Paths.get(filePathString);
	}

	// public RecipeTextFile() {
	// this("src/homemade/recipes/sample.txt");
	// }
	public RecipeTextFile(String fileName, String fillerVariable) {
		this("src/homemade/recipes/" + fileName + ".txt");

	}
	
	public String printFilePath(String fileName) {
		return ("src/homemade/recipes/" + fileName + ".txt");
		
	}

	public List<String> readRecipe() {
		List<String> recipe = new ArrayList<>();
		if (!Files.exists(filePath)) {
			return recipe;
		}
		try {
			File file = filePath.toFile();
			FileReader fileReader = new FileReader(file);
			BufferedReader reader = new BufferedReader(fileReader);

			String line = reader.readLine();
			while (line != null) {
				recipe.add(line);
				line = reader.readLine();

			}
			reader.close();
			return recipe;
		} catch (IOException ex) {
			throw new RuntimeException("Unable to read countries.", ex);
		}
	}

	public List<String> getAllRecipeNames() {
		File folder = new File("src/homemade/recipes");
		File[] listOfFiles = folder.listFiles();

		for (int i = 0; i < listOfFiles.length; i++) {
			if (listOfFiles[i].isFile()) {
				System.out.println((i+1) + ". " + listOfFiles[i].getName());
			} else if (listOfFiles[i].isDirectory()) {
				System.out.println((i+1) + ". " + listOfFiles[i].getName());
			}
		}
		return null;
	}
	
	public String getARecipeName(int recipeByNumber) {
		File folder = new File("src/homemade/recipes");
		File[] listOfFiles = folder.listFiles();

		for (int i = recipeByNumber; i < listOfFiles.length; i++) {
			if (listOfFiles[i].isFile()) {
				System.out.println("Opening " + listOfFiles[i].getName());
				break;
			} else if (listOfFiles[i].isDirectory()) {
				System.out.println("Opening " + listOfFiles[i].getName());
				break;
			}
		}
		return (listOfFiles[recipeByNumber].getName()).toString();
	}


	public boolean saveRecipe(String rawRecipeName, ArrayList<LineIngredient> recipe) {
		try {
			if (!Files.exists(filePath)) {
				Files.createFile(filePath);
			}
			File file = filePath.toFile();
			PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(file, true)));
			writer.println(rawRecipeName);
			writer.println();
			for (LineIngredient recipeLine : recipe) {
				writer.println(recipeLine);
			}
			writer.close();
		} catch (IOException ex) {
			throw new RuntimeException("Unable to save countries.", ex);
		}
		return true;
	}
	


}
