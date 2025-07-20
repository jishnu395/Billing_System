import java.util.Scanner;

public class restaurant_billing_system {
    static String[] menuItems = {"Burger", "Pizza", "Pasta", "Fries", "Drinks", };
    static int[] prices = {120, 250, 180, 100, 20};
    public static void main(String[] args) {
        Scanner in = new Scanner (System.in);
        displayMenu();

        int orderCount = getOrderCount(in);

        int [] itemIndices = new int[orderCount];
        int [] itemQuantities = new int[orderCount];

        takeOrder(in, itemIndices, itemQuantities, orderCount);
        int total = printBill(itemIndices, itemQuantities, orderCount);
        discount(total);



    }
    
    public static void displayMenu(){
        System.out.println("========= Menu =========");
        System.out.println("--------------------------");
        System.out.printf( "%-10s %-10s\n", "    Item", "Price"); 
        for (int i = 0; i < menuItems.length; i++) {
            System.out.println((i+1) + ". " + menuItems[i] + " - " + prices[i] + "/-");
            }
        System.out.println("--------------------------");
    }

    public static int getOrderCount(Scanner in){
        System.out.println("Enter the number of different items you want to order: ");
        return in.nextInt();
        
    }

    public static void takeOrder(Scanner in, int[] itemIndices, int[] itemQuantities, int orderCount){
        for (int i = 0; i < orderCount; i++) {
            System.out.println("Enter the item number (1 to " + menuItems.length + "): ");
            int index = in.nextInt() - 1;

            if(index < 0 || index >= menuItems.length){
                System.out.println("invalid number, please try again");
                i--;
                continue;
            }
            System.out.print("Enter quantity: ");
            int quantity = in.nextInt();
            System.out.println();

            itemIndices[i] = index;
            itemQuantities[i] = quantity;
        }
    }

    public static int printBill(int[] itemIndices, int[] itemQuantities, int orderCount) {
        int total = 0;
        System.out.println("================= Bill Receipt ==================");
        System.out.println("------------------------------------------------");
        System.out.printf("%-10s %-10s %-10s %-10s\n", "Item", "price", "Qty", "Subtotal");
        for (int i = 0; i < itemQuantities.length; i++) {
            int index = itemIndices[i];
            int quantity = itemQuantities[i];
            int subtotal = prices[index] * quantity;
            total += subtotal;
            System.out.printf("%-10s %-10d %-10d Rs. %-10d\n", menuItems[index], prices[index],quantity, subtotal);
        }

        System.out.println("------------------------------------------------\n");
        System.out.println("Total bill: " + total + "/-");
        
        return total;
    }

    public static int discount(int total) {
        if(total >= 600) {
            total = total - (total * 25 / 100);
            System.out.println("Discount applied: 25%");
        } else {
            System.out.println("No discount");
        }
        
        System.out.println("To Be Paid: " + total + "/-");
        System.out.println("==========================================");
        System.out.println("-----Thank you, please visit again!------");
        System.out.println("==========================================");

        return total;
    }
}