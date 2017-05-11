package advanced.stage4;

import java.util.Scanner;

public class Display {
    public static void printlnf(String val, Object... vals) {
        System.out.format(val + "\n", vals);
    }

    public static void println(String val) {
        printlnf(val);
    }

    public static String getStringInput(String prompt) {
        println(prompt);
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();
        return userInput;
    }

    public static Double getDoubleInput(String prompt) {
        String stringInput = getStringInput(prompt);
        try {
            Double doubleInput = Double.parseDouble(stringInput);
            return doubleInput;
        } catch (NumberFormatException nfe) {
            printlnf("[ %s ] is an invalid user input!", stringInput);
            println("Try inputting a numeric value!");
            return getDoubleInput(prompt);
        }
    }

    public static Long getLongInput(String prompt) {
        String stringInput = getStringInput(prompt);
        try {
            Long longInput = Long.parseLong(stringInput);
            return longInput;
        } catch (NumberFormatException nfe) {
            printlnf("[ %s ] is an invalid user input!", stringInput);
            println("Try inputting an integer value!");
            return getLongInput(prompt);
        }
    }

    public static Integer getIntegerInput(String prompt) {
        return getLongInput(prompt).intValue();
    }

    public static void printDashes() {
        println("-----------------------------------------------------");
    }
}
