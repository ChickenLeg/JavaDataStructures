import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * This class contains the dynamically allocated array and it's processing
 * Student Name: Yanni Li
 * Student Number:  040914267
 * Course: CST8130 - Data Structures
 * @author Linda Crane
 * @author Melissa Sienkiewicz
 *
 */
public class Numbers {
	/**
	 * Stores Float values.
	 */
	private static float[] numbers;
	
	/**
	 * Store the number of items currently in the array.
	 */
	private int numItems;
	
	private static int currItems;

	/**
	 * Default Constructor
	 */
	public Numbers() {
		// TODO Write code here to initialize a "default" array since this is the default constructor
		//array size
		numItems = 500;
		//after user input, current array size and elements
		currItems =0;
		//float type array named numbers and size is numItems
		numbers = new float[numItems];
	}

	/**
	 * Constructor that initializes the numbers array.
	 * @param size - Max size of the numbers array
	 */
	public Numbers(int size) {
		// TODO Write code here to initialize the numbers array of max 'size'
		//array size doesn't change, only current array element changes
		currItems = 0;
		numItems = size;
		numbers = new float[size];
	}
	
	/**
	 * Adds a value in the array
	 * @param keyboard - Scanner object to use for input
	 */
	public void addValues(Scanner sca) {
		//take multivalues add into array
		//add variable as number of numbers adding into array
		System.out.println("How many values do you wish to add? ");
		Scanner sca2 = new Scanner(System.in);
		int add = sca.nextInt();
		
		//currItems changes every time when user add one element into array
		int n = currItems;
			for(int i=n;i<n+add;i++) {
				if (currItems == numItems) {
					System.err.println("Array full.");
					break;
				}
				currItems++;
				System.out.println("Enter values: ");
				numbers[i]=sca2.nextFloat();
			}
	}
	public void addValue(Scanner keyboard) {
		// TODO Write code here to add the values in the array
		if (currItems == numItems) {
			System.err.println("Array full.");
		}
		else {
		System.out.println("Enter Value: ");
		//parse: int to float
		try {
			numbers[currItems] = Float.parseFloat(keyboard.nextLine());
			currItems++;
		} catch (Exception e) {
			System.err.printf("Invalid Array Item! Again: \n");
		}
		}
	}
	
	/**
	 * Calculates the average of all the values in the numbers array.
	 * @return float value that represents the average
	 */
	public float calcAverage() {
		// TODO Write code to return the average of the values in the array
		//if there is no items entered
		//average will be 0.0
		if(currItems == 0)
			return 0;
		float sum = 0;
		for (int i = 0; i < numItems ; i++)
			sum += numbers[i];
		//denominator always changes by user input
		//thus we cannot user numItems
		float average = sum / currItems;
		return average;
	}

	public String toString() {
		//create a string(str)
		String str = "";
		//add elements to toString 
		//and print it
		for (int i=0;i<currItems;i++) {
			str += numbers[i] + "\n";
		}
		return str;
	}
	
	public void readFile() {
		String name2 ="c:\\temp\\";
		System.out.println("Name of the file to read from: \n");
		Scanner input = new Scanner(System.in);
		String name = input.next();
		//path + file name
		name = name2 + name;
		try(BufferedReader input1 = new BufferedReader(new FileReader(name))){
			//read file from the first line to the end
			String line;
			//add as the current elements in array
			int add = Integer.parseInt(input1.readLine());
			if(add + currItems >= numItems) {
				System.out.println("Array full");
				return;
			}
			while((line=input1.readLine())!=null) {
				numbers[currItems] = Float.parseFloat(line);
				currItems++;
			}
		}catch(FileNotFoundException e) {
			System.out.println("File not found: " + e.getMessage());
		}catch(IOException e) {
			System.out.println("IO exception: " + e.getMessage() );
		}
	}

	public static void toTextFile(Path path) throws IOException{
		//create a list to take array
		List<String> l = new ArrayList<>();
		//add elements to the list
		l.add(Integer.toString(currItems));
		//write every element in list
		for(int i = 0; i < currItems; i++) {
			l.add(Float.toString(numbers[i]));
		}
		
		try
		{
			Files.write(path, l, Charset.forName("UTF-8"));
		}catch (IOException e) {
			System.out.println("Write failed -"+e.getMessage());
			}
	}

	public void sortArray() {
		for(int i=1; i<numItems;i++) {
			float insert = numbers[i];
			int j=i-1;
			while(j >= 0 && numbers[j] >insert) {
				numbers[j+1] =numbers[j];
				j=j-1;
			}
			numbers[j+1]=insert;
		}
	}
	
}