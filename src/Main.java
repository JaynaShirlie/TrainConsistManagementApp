public class Main {

    public static void main(String[] args) {

        System.out.println("=========================================");
        System.out.println("UC18 - Linear Search for Bogie ID");
        System.out.println("=========================================\n");

        // Array of bogie IDs
        String[] bogieIds = {"BG101", "BG205", "BG309", "BG412", "BG550"};

        // Search key (you can change this value)
        String searchKey = "BG309";

        boolean found = false;

        // Linear Search
        for (int i = 0; i < bogieIds.length; i++) {
            if (bogieIds[i].equals(searchKey)) {
                found = true;
                break; // stop when found
            }
        }

        // Output result
        if (found) {
            System.out.println("Bogie ID " + searchKey + " found in the list.");
        } else {
            System.out.println("Bogie ID " + searchKey + " NOT found.");
        }

        System.out.println("\nUC18 search completed...");
    }
}