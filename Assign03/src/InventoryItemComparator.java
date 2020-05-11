import java.util.Comparator;

/**
 * Used to compare objects of type FoodItem
 * 
 * @author Yanni Li
 *
 */
public class InventoryItemComparator implements Comparator<InventoryItem> {
	// Compares its two arguments for order. Returns a negative integer, zero, or a
	// positive integer as the first argument is less than, equal to, or greater
	// than the
	// second.
	@Override
	public int compare(InventoryItem o1, InventoryItem o2) {
		 // work for compare the item code
		return o1.getItemCode() - o2.getItemCode();
	}

}
