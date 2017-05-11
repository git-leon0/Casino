package advanced.stage8;

import java.util.Scanner;

public class Display {
    private static final Scanner scanner = new Scanner(System.in);

    public static void print(String val, Object... args) {
        System.out.format(val, args);
    }

    public static void println(String val, Object... vals) {
        print(val + "\n", vals);
    }

    public static String getStringInput(String prompt, Object... args) {
        println(prompt, args);
        return scanner.nextLine();
    }

    public static Double getDoubleInput(String prompt, Object... args) {
        String stringInput = getStringInput(prompt, args);
        try {
            Double doubleInput = Double.parseDouble(stringInput);
            return doubleInput;
        } catch (NumberFormatException nfe) {
            println("[ %s ] is an invalid user input!", stringInput);
            println("Try inputting a numeric value!");
            return getDoubleInput(prompt, args);
        }
    }

    public static Long getLongInput(String prompt, Object... args) {
        String stringInput = getStringInput(prompt, args);
        try {
            Long longInput = Long.parseLong(stringInput);
            return longInput;
        } catch (NumberFormatException nfe) {
            println("[ %s ] is an invalid user input!", stringInput);
            println("Try inputting an integer value!");
            return getLongInput(prompt, args);
        }
    }

    public static Integer getIntegerInput(String prompt, Object... args) {
        return getLongInput(prompt, args).intValue();
    }

    public static void printDashes() {
        repeatPrint(80, "-");
        println("");
    }

    public static void repeatPrint(int numberOfRepeats, String val) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numberOfRepeats; i++) {
            sb.append(val);
        }
        print(sb.toString());
    }
}
