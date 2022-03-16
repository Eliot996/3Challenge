import java.util.Scanner;

public class Main {

    private static final Reader READER = new Reader();
    private static final Scanner INPUT = new Scanner(System.in);

    public static void main(String[] args) {
        // load file
        boolean fileLoaded = false;
        while(!fileLoaded) {
            System.out.print("Enter the the file to load(must be located in /data/): ");
            fileLoaded = READER.loadFile(INPUT.nextLine());

            if (fileLoaded) {
                System.out.println("File was loaded");
            } else {
                System.out.println("Cannot find the file, please try again");
            }
        }

        // get what the user would like to do
        int choice;
        while(true) {
            System.out.println("""
                    What would you like to do?
                    1. Print the next 7 characters
                    2. Enter how many characters you want to print
                    0. End the program""");
            choice = INPUT.nextInt();

            switch (choice) {
                case 1 -> System.out.println(READER.read7());
                case 2 -> readN();
                case 0 -> System.exit(0);
            }

            System.out.println("-----------------------");
        }
    }

    private static void readN() {
        System.out.print("How many characters to print? ");
        System.out.println(READER.readN(INPUT.nextInt()));
    }
}