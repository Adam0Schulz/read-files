import java.io.FileNotFoundException;
import java.io.File;
import java.util.Scanner;

public class App {

    private static File f = new File("C:/02_Škola/Dánsko/Škola/Programovanie/files/bin/textOne.txt");
    private static Scanner input;
    private static boolean keepRunning = true;

    public static void main(String[] args) throws Exception {
        while (keepRunning) {
            askForFile();
            askForAction();
            if (askForContinue() == 1) {
                keepRunning = false;
            }
        }

        closeFile();
    }

    public static void askForFile() {
        System.out.println("\nWrite the name or the file that you want to open.");
        Scanner file = new Scanner(System.in);
        String fileName = file.nextLine();
        f = new File("C:/02_Škola/Dánsko/Škola/Programovanie/files/bin/" + fileName + ".txt");

    }

    public static void askForAction() {
        System.out.println("\nWrite what you want to do with the file (options: 'read line' or 'read file').");
        Scanner action = new Scanner(System.in);
        String fileAction = action.nextLine();

        if (fileAction.equals("read line")) {
            readLine();
        } else if (fileAction.equals("read file")) {
            readFile();
        } else {
            System.out.println("incorect action");
        }

    }

    public static int askForContinue() {
        System.out.println("\nDo you want to continue? (options: 'y' = yes, 'n' = no)");
        Scanner action = new Scanner(System.in);
        String actionNextLine = action.nextLine();
        if (actionNextLine.equals("y")) {

            return 0;
        } else if (actionNextLine.equals("n")) {

            return 1;
        } else {
            System.out.println("\nincorrect choice");

            return 1;
        }
    }

    public static void readFile() {
        try {
            input = new Scanner(f);
            while (input.hasNextLine()) {
                System.out.println(input.nextLine());

            }
        } catch (FileNotFoundException e) {
            System.out.println("\nfile not found at the given location");
        }

    }

    public static void readLine() {
        try {
            input = new Scanner(f);
            if (input.hasNextLine()) {
                System.out.println(input.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("\nfile not found at the given location");
        }
    }

    public static void closeFile() {
        input.close();
    }
}
