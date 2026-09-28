import java.util.Scanner;

// custom exception for items we don't sell
class ItemNotFoundException extends Exception {
    public ItemNotFoundException(String message) {
        super(message);
    }
}

public class GroceryShopping {

    // prints the position of an item, or says it isn't there
    static void searchItem(String[] items, String itemName) {
        for (int i = 0; i < items.length; i++) {
            if (items[i].equalsIgnoreCase(itemName)) {
                System.out.println(items[i] + " found at index " + i);
                return;
            }
        }
        System.out.println("Item not found.");
    }

    // adds up every price and divides by how many there are
    static float calculateAveragePrice(float[] prices) {
        float sum = 0;
        for (int i = 0; i < prices.length; i++) {
            sum += prices[i];
        }
        return sum / prices.length;
    }

    // prints every item cheaper than the threshold
    static void filterItemsBelowPrice(String[] items, float[] prices, float threshold) {
        System.out.println("Items below $" + threshold + ":");
        for (int i = 0; i < items.length; i++) {
            if (prices[i] < threshold) {
                System.out.println("  " + items[i]);
            }
        }
    }

    public static void main(String[] args) {

        // items, prices and stock line up by index
        String[] item = new String[10];
        float[] price = new float[10];
        int[] stock = {50, 60, 30, 40, 35, 25, 30, 45, 40, 55};

        item[0] = "Apple";   price[0] = 0.50f;
        item[1] = "Banana";  price[1] = 0.30f;
        item[2] = "Bread";   price[2] = 2.00f;
        item[3] = "Milk";    price[3] = 1.50f;
        item[4] = "Eggs";    price[4] = 2.50f;
        item[5] = "Cheese";  price[5] = 3.00f;
        item[6] = "Chicken"; price[6] = 5.00f;
        item[7] = "Rice";    price[7] = 1.00f;
        item[8] = "Pasta";   price[8] = 1.20f;
        item[9] = "Tomato";  price[9] = 0.80f;

        // quick tests for the challenge methods
        searchItem(item, "Milk");
        searchItem(item, "Pizza");
        System.out.printf("Average price: $%.2f%n", calculateAveragePrice(price));
        filterItemsBelowPrice(item, price, 1.00f);
        filterItemsBelowPrice(item, price, 2.50f);

        Scanner scanner = new Scanner(System.in);

        // outer loop: shop stays open until the user types exit
        while (true) {
            System.out.println("Type 'start' to begin shopping or 'exit' to quit:");
            String userInput = scanner.nextLine();

            if (userInput.equalsIgnoreCase("exit")) {
                System.out.println("Thank you for using the shopping cart. Goodbye!");
                break;
            }

            float totalBill = 0; // fresh bill for each shopper

            // inner loop: keeps adding items until the user types finish
            while (true) {
                System.out.println("Enter the name of the item (or type 'finish' to end shopping):");
                String inputItem = scanner.nextLine();

                if (inputItem.equalsIgnoreCase("finish")) {
                    // discount only when the bill goes over $100
                    float discountedTotal = totalBill;
                    if (totalBill > 100) {
                        discountedTotal = totalBill * 0.90f;
                    }
                    System.out.printf("Original total: $%.2f%n", totalBill);
                    System.out.printf("Total after discount: $%.2f%n", discountedTotal);
                    System.out.println("Thank you for shopping with us!");
                    break;
                }

                try {
                    // look for the item, -1 means not found
                    int itemIndex = -1;
                    for (int i = 0; i < item.length; i++) {
                        if (item[i].equalsIgnoreCase(inputItem)) {
                            itemIndex = i;
                            break;
                        }
                    }

                    if (itemIndex == -1) {
                        throw new ItemNotFoundException("Item '" + inputItem + "' not found. Please try again.");
                    }

                    System.out.println("Enter the quantity of " + item[itemIndex] + ":");
                    int quantity = Integer.parseInt(scanner.nextLine().trim());

                    if (quantity <= 0) {
                        System.out.println("Quantity must be at least 1.");
                        continue;
                    }

                    // check stock before touching the bill
                    if (quantity > stock[itemIndex]) {
                        System.out.println("Sorry, " + item[itemIndex] + " is out of stock for that amount. Only "
                                + stock[itemIndex] + " left.");
                        continue;
                    }

                    float itemCost = price[itemIndex] * quantity;
                    totalBill += itemCost;
                    stock[itemIndex] -= quantity; // shelf count goes down

                    System.out.printf("Added %d x %s to the bill. Current total: $%.2f%n",
                            quantity, item[itemIndex], totalBill);

                } catch (ItemNotFoundException e) {
                    System.out.println(e.getMessage());
                } catch (NumberFormatException e) {
                    System.out.println("Please type the quantity as a whole number.");
                }
            }
        }

        scanner.close();
    }
}