package thoughtworks.problem.salesTax.application;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class FileParser {

	@Rep private FileReader fileReader;
	@Rep private BufferedReader bufferedReader;
	@Rep private String filePath;
	@Rep private ArrayList<InputData> inputDataArray;

	public FileParser(String filePath) {
		this.filePath = filePath;
		this.inputDataArray = new ArrayList<InputData>();
		try {
			fileReader = new FileReader(filePath);
			bufferedReader = new BufferedReader(fileReader);
			String currentLine = null;
			while ((currentLine = bufferedReader.readLine()) != null) {
				currentLine = currentLine.replaceAll("\\s+$", "");
				String[] array = currentLine.split(" ");
				int quantity = new Integer(array[0]).intValue();
				double cost = new Double(array[array.length - 1]).doubleValue();
				String[] product = Arrays.copyOfRange(array, 1, array.length - 2);
				String productDescription = "";
				for (int index = 0; index < product.length; index++) {
					productDescription += " " + product[index].toLowerCase();
				}

				boolean isImported = productDescription.contains("imported")
						|| productDescription.contains("Imported");
				String productName = productDescription.replaceAll("[i,I]mported", "");
				inputDataArray.add(new InputData(quantity, productName, isImported, cost));
			}

		} catch (FileNotFoundException notFoundException) {
			notFoundException.printStackTrace();
		} catch (IOException ioException) {
			ioException.printStackTrace();
		}

	}

	public ArrayList<InputData> getInputData() {
		return inputDataArray;

	}
}
