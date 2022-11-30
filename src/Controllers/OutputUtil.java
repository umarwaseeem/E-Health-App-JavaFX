package Controllers;


public class OutputUtil {

    public static void clrScreen() {
        System.out.print("\033[H\033[2J");
    }

    public static void printLine() {
        System.out.println(
                "------------------------------------------------------------------------------------------------------------------------");
    }

    public static void print(String value) {
        System.out.print(value);
    }

    public static void printLn(String value) {
        System.out.println(value);
    }

    public static void printBlue(String value) {
        System.out.println("\033[94m" + value + "\033[0m");
    }

    public static void printRed(String value) {
        System.out.println("\033[91m" + value + "\033[0m");
    }

    public static void printGreen(String value) {
        System.out.println("\033[92m" + value + "\033[0m");
    }

    public static void printYellow(String value) {
        System.out.println("\033[93m" + value + "\033[0m");
    }

    public static void printPurple(String value) {
        System.out.println("\033[95m" + value + "\033[0m");
    }

    public static void printCyan(String value) {
        System.out.println("\033[96m" + value + "\033[0m");
    }
}