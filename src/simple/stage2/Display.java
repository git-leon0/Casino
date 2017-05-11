package simple.stage2;
import java.util.Scanner;

public class Display {
    public static void println(String val) {
        System.out.println(val);
    }

    public static String getStringInput(String prompt) {
        println(prompt);
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();
        return userInput;
    }

    public static Double getDoubleInput(String prompt) {
        String stringInput = getStringInput(prompt);
        Double doubleInput = Double.parseDouble(stringInput);
        return doubleInput;
    }

    public static Integer getIntegerInput(String prompt) {
        String stringInput = getStringInput(prompt);
        Integer integerInput = Integer.parseInt(stringInput);
        return integerInput;
    }
}
