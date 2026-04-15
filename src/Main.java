import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        System.out.println("=========================================");
        System.out.println("UC17 - Sorting Bogie Names using Arrays.sort()");
        System.out.println("=========================================\n");

        String[] bogieNames = {"Sleeper", "AC Chair", "First Class", "General", "Luxury"};

        System.out.println("Original Bogie Names:");
        System.out.println(Arrays.toString(bogieNames));

        Arrays.sort(bogieNames);

        System.out.println("\nSorted Bogie Names (Alphabetical):");
        System.out.println(Arrays.toString(bogieNames));

        System.out.println("\nUC17 completed.");
    }
}