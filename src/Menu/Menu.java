package Menu;

import Store.Store;
import View.ConsoleUI;

import java.util.Scanner;

public class Menu {
    String text;
    int[] values;
    Store store;
    ConsoleUI consoleUI;
    public Menu(String text, int[] values, Store store){
        this.text = text;
        this.values = values;
        this.store = store;
    }

    public void setConnectWithConsoleUI(ConsoleUI consoleUI){
        this.consoleUI = consoleUI;
    }
    public void menuRun() {
        System.out.println(text);
        Scanner scanner = new Scanner(System.in);
        try {
            int intChoice = Integer.parseInt(scanner.next());
            try {
                if (store == null){
                    consoleUI.controllerMenu(values[intChoice-1], null);
                } else {
                    consoleUI.controllerMenu(values[intChoice-1], store.toString());
                }
            } catch (ArrayIndexOutOfBoundsException t) {
                System.out.println("Некорректный ввод. Введите число от 1 до " + values.length);
                menuRun();
            }
        } catch (NumberFormatException e) {
            System.out.println("Некорректный ввод. Необходимо ввести число");
            menuRun();
        }
    }
}
