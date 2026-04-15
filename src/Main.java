public class Main {

    public static void main(String[] args) {

        System.out.println("=========================================");
        System.out.println("UC20 - Exception Handling During Search");
        System.out.println("=========================================\n");

        // Case 1: Empty array (to test exception)
        String[] bogieIds = {};

        // Change this to test normal case:
        // String[] bogieIds = {"BG101", "BG205", "BG309"};

        String searchKey = "BG101";

        try {
            boolean result = searchBogie(bogieIds, searchKey);

            if (result) {
                System.out.println("Bogie ID " + searchKey + " found.");
            } else {
                System.out.println("Bogie ID " + searchKey + " NOT found.");
            }

        } catch (IllegalStateException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("\nUC20 execution completed...");
    }

    public static boolean searchBogie(String[] bogieIds, String key) {


        if (bogieIds == null || bogieIds.length == 0) {
            throw new IllegalStateException("No bogies available to search.");
        }

        // Linear Search
        for (int i = 0; i < bogieIds.length; i++) {
            if (bogieIds[i].equals(key)) {
                return true;
            }
        }

        return false;
    }
}