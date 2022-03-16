import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Reader {
    private String masterString;

    public boolean loadFile(String fileName) {
        // create the scanner to read the file
        Scanner scanner;
        try {
            scanner = new Scanner(new File("data/" + fileName));
        } catch (FileNotFoundException e) {
            return false; // if failed return false
        }

        // load the file into stringOfFile
        StringBuilder sb = new StringBuilder();
        while(scanner.hasNextLine()) {
            sb.append(scanner.nextLine());
        }
        masterString = sb.toString();

        // return true when done
        return true;
    }

    public String read7() {
        return readN(7);
    }

    public String readN(int n) {
        String toReturn;

        if (masterString.length() > n ) {
            // if the string is long enough, take what is needed, and remove it from the master string
            toReturn = masterString.substring(0, n);
            masterString = masterString.substring(n);
        } else {
            // if there is not enough characters, take the whole string,
            // and set the master string to an empty string
            toReturn  = masterString;
            masterString = "";
        }

        return toReturn;
    }
}
