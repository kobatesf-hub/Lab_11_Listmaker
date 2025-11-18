import java.util.ArrayList;
import java.util.Scanner;

public class ListMaker {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<String> list = new ArrayList<>();

        boolean keepGoing = true;

        while (keepGoing) {
            System.out.println("Menu:");
            System.out.println("1. Add item");
            System.out.println("2. Insert item at position");
            System.out.println("3. Remove item");
            System.out.println("4. Print list");
            System.out.println("5. Quit");

            int choice = SafeInput.getRangedInt(in, "Choose an option", 1, 5);

            switch (choice) {
                case 1:
                    // Add item
                    String item = SafeInput.getNonZeroLenString(in, "Enter an item to add");
                    list.add(item);
                    break;

                case 2:
                    // Insert item at position
                    item = SafeInput.getNonZeroLenString(in, "Enter an item to insert");
                    int location = SafeInput.getRangedInt(in, "Enter the position to insert at", 1, list.size() + 1);
                    list.add(location - 1, item); // subtract 1 because list indices start at 0
                    break;

                case 3:
                    // Remove item
                    if (list.size() > 0) {
                        location = SafeInput.getRangedInt(in, "Enter the position to remove", 1, list.size());
                        list.remove(location - 1);
                    } else {
                        System.out.println("List is empty. Nothing to remove.");
                    }
                    break;

                case 4:
                    // Print list
                    System.out.println("Current List:");
                    for (int i = 0; i < list.size(); i++) {
                        System.out.println((i + 1) + ". " + list.get(i));
                    }
                    break;

                case 5:
                    // Quit
                    keepGoing = !SafeInput.getYNconfirm(in, "Are you sure you want to quit? (Y/N)");
                    break;
            }
        }

        System.out.println("Goodbye!");
        in.close();
    }
}