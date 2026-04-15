import java.util.*;
import java.util.stream.*;

public class UseCase13TrainConsistent {

    // 🔹 Bogie Model
    static class Bogie {
        String type;
        int capacity;

        Bogie(String type, int capacity) {
            this.type = type;
            this.capacity = capacity;
        }

        @Override
        public String toString() {
            return type + " (" + capacity + ")";
        }
    }

    public static void main(String[] args) {

        System.out.println("======================================");
        System.out.println("UC13 - Performance Comparison (Loops vs Streams)");
        System.out.println("======================================\n");

        // 🔹 Create large dataset
        List<Bogie> bogies = new ArrayList<>();

        // Adding sample data (large dataset simulation)
        for (int i = 0; i < 100000; i++) {
            if (i % 3 == 0)
                bogies.add(new Bogie("Sleeper", 72));
            else if (i % 3 == 1)
                bogies.add(new Bogie("AC Chair", 50));
            else
                bogies.add(new Bogie("First Class", 65));
        }

        // 🔴 LOOP-BASED FILTERING
        long loopStart = System.nanoTime();

        List<Bogie> loopResult = new ArrayList<>();
        for (Bogie b : bogies) {
            if (b.capacity > 60) {
                loopResult.add(b);
            }
        }

        long loopEnd = System.nanoTime();
        long loopTime = loopEnd - loopStart;

        // 🔵 STREAM-BASED FILTERING
        long streamStart = System.nanoTime();

        List<Bogie> streamResult = bogies.stream()
                .filter(b -> b.capacity > 60)
                .collect(Collectors.toList());

        long streamEnd = System.nanoTime();
        long streamTime = streamEnd - streamStart;

        // 🔹 OUTPUT RESULTS
        System.out.println("Loop Result Count   : " + loopResult.size());
        System.out.println("Stream Result Count : " + streamResult.size());

        System.out.println("\nExecution Time:");
        System.out.println("Loop Time   : " + loopTime + " ns");
        System.out.println("Stream Time : " + streamTime + " ns");

        // 🔹 Verify both results match
        if (loopResult.size() == streamResult.size()) {
            System.out.println("\n✔ Results Match");
        } else {
            System.out.println("\n❌ Results Do NOT Match");
        }
    }
}
