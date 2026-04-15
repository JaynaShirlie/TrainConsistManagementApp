import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        System.out.println("=========================================");
        System.out.println("UC19 - Binary Search for Bogie ID");
        System.out.println("=========================================\n");

        // Unsorted array of bogie IDs
        String[] bogieIds = {"BG309", "BG101", "BG550", "BG205", "BG412"};

        // Search key (change this to test)
        String searchKey = "BG205";

        // Step 1: Sort array (required for binary search)
        Arrays.sort(bogieIds);

        System.out.println("Sorted Bogie IDs:");
        System.out.println(Arrays.toString(bogieIds));

        boolean found = false;

        int low = 0;
        int high = bogieIds.length - 1;

        // Binary Search
        while (low <= high) {

            int mid = (low + high) / 2;

            int result = searchKey.compareTo(bogieIds[mid]);

            if (result == 0) {
                found = true;
                break;
            } else if (result < 0) {
                high = mid - 1; // search left
            } else {
                low = mid + 1; // search right
            }
        }

        // Output result
        if (found) {
            System.out.println("\nBogie ID " + searchKey + " found.");
        } else {
            System.out.println("\nBogie ID " + searchKey + " NOT found.");
        }

        System.out.println("\nUC19 search completed...");
    }
}