import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Menu menu = new Menu();
        boolean continueRunning = true;

        while (continueRunning) {
            continueRunning = menu.runMenu();
        }
    }
}