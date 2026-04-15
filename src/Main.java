class InvalidCapacityException extends Exception {
    public InvalidCapacityException(String message) {
        super(message);
    }
}

class Bogie {
    private String name;
    private int capacity;

    public Bogie(String name, int capacity) throws InvalidCapacityException {
        if (capacity <= 0) {
            throw new InvalidCapacityException("Capacity must be greater than zero");
        }
        this.name = name;
        this.capacity = capacity;
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }
}

public class Main {
    public static void main(String[] args) {

        System.out.println("======================================");
        System.out.println("UC14 - Handle Invalid Bogie Capacity");
        System.out.println("======================================\n");

        try {
            Bogie b1 = new Bogie("Sleeper", 72);
            System.out.println("Created Bogie: " + b1.getName() + " -> " + b1.getCapacity());

            Bogie b2 = new Bogie("AC Chair", 0);
            System.out.println("Created Bogie: " + b2.getName() + " -> " + b2.getCapacity());

        } catch (InvalidCapacityException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("\nUC14 exception handling completed...");
    }
}