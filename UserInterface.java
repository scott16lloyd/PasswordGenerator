import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class UserInterface {

    PasswordGenerator passwordGenerator = new PasswordGenerator();
    PasswordStrengthChecker passwordStrengthChecker = new PasswordStrengthChecker();

    public void mainLoop() {
        System.out.println("Welcome to the password generator!");
        Scanner keyboard = new Scanner(System.in);

        String selection;
        do {
            this.menu();
            selection = keyboard.nextLine();
            switch (selection) {
                case "1" -> {
                    this.generateMenu();
                    System.out.println("Your generated password is: " + passwordGenerator.getPassword());
                    this.delay();
                }
                case "2" -> this.strengthCheckMenu();
                case "3" -> System.out.println("Goodbye!");
                default -> System.out.println("Invalid input");
            }
        } while (!selection.equals("3"));
    }
    private void menu() {
        System.out.println();
        System.out.println("1) Generate password");
        System.out.println("2) Check password strength");
        System.out.println("3) Quit");
        System.out.println("Select an option above:");
    }

    private void generateMenu() {
        String input;
        passwordGenerator.setPassword("");

        System.out.println();
        System.out.println("Select 'yes' or 'no' to the following: ");
        Scanner keyboard = new Scanner(System.in);

        // Check for uppercase
        System.out.println("Do you wanted uppercase character?");
        input = keyboard.nextLine();
        if(inputCheck(input) && input.equals("yes")){
            passwordGenerator.generate(Alphabet.UPPERCASE_LETTERS, passwordGenerator.getPassword());
        }

        // Check for lowercase
        System.out.println("Do you want lowercase characters?");
        input = keyboard.nextLine();
        if(inputCheck(input) && input.equals("yes")){
            passwordGenerator.generate(Alphabet.LOWERCASE_LETTERS, passwordGenerator.getPassword());
        }

        //Check for numbers
        System.out.println("Do you want numbers?");
        input = keyboard.nextLine();
        if(inputCheck(input) && input.equals("yes")){
            passwordGenerator.generate(Alphabet.NUMBERS, passwordGenerator.getPassword());
        }

        // Check for symbols
        System.out.println("Do you want symbols?");
        input = keyboard.nextLine();
        if(inputCheck(input) && input.equals("yes")){
            passwordGenerator.generate(Alphabet.SYMBOLS, passwordGenerator.getPassword());
        }
    }

    private void strengthCheckMenu() {
        String input;
        Scanner keyboard = new Scanner(System.in);

        System.out.println();
        System.out.println("Welcome to the password strength checker!");
        System.out.println("Enter 0 to go back,");
        System.out.println("Please enter your password below: ");
        input = keyboard.nextLine();
        if (input.equals("0")) {
        } else {
            String result = passwordStrengthChecker.strengthCheck(input);
            System.out.println("Result: ");
            System.out.println(result);
        }
    }


    private boolean inputCheck(String input) {
        final String YES_OPTION = "yes";
        final String NO_OPTION = "no";
        boolean validInput = false;
        Scanner keyboard;

        do {
            if (input.equalsIgnoreCase(YES_OPTION)) {
                System.out.println("UPPERCASE SELECTED");
                validInput = true;
            } else if (input.equalsIgnoreCase(NO_OPTION)) {
                System.out.println("UPPERCASE NOT SELECTED");
                validInput = true;
            } else {
                System.out.println("Please enter a valid input 'yes' or 'no':");
                keyboard = new Scanner(System.in);
                input = keyboard.nextLine();
            }
        } while (!validInput);
        return true;
    }

    private void delay() {
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
