import java.util.Scanner;

/**
 * @author Yanni Li
 *
 */
public class Vegetable extends FoodItem {
	/**
	 * Name of the farm the vegetable came from
	 */
	private String farmName;

	/**
	 * Default Constructor
	 */
	public Vegetable() {
		super();
		farmName = "";
	}

	@Override
	public boolean addItem(Scanner scanner) {
		if (super.addItem(scanner)) {
			System.out.print("Enter the name of the farm supplier: ");
			farmName = scanner.next();
		}
		return true;
	}

	@Override
	public String toString() {
		return super.toString() + " farm supplier: " + farmName;
	}
}
