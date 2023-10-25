package View;

import java.util.Objects;
import java.util.Scanner;
import Controller.Controller;
import Menu.Menu;
import Store.Store;

public class ConsoleUI {
    Controller controller;
    public void setConnectWithController(Controller controller) {
        this.controller = controller;
    }
    public void menu(String text, int[] values, Store store) {
        Menu menu = new Menu(text, values, store);
        menu.setConnectWithConsoleUI(this);
        menu.menuRun();
//        System.out.println(text);
//        Scanner scanner = new Scanner(System.in);
//        String choice = scanner.next();
//        try {
//            int intChoice = Integer.parseInt(choice);
//            try {
//                if (store == null){
//                    controllerMenu(values[intChoice-1], null);
//                } else {
//                    controllerMenu(values[intChoice-1], store.toString());
//                }
//            } catch (ArrayIndexOutOfBoundsException t) {
//                System.out.println("Некорректный ввод. Введите число от 1 до " + values.length);
//                menu(text, values, null);
//            }
//        } catch (NumberFormatException e) {
//            System.out.println("Некорректный ввод. Необходимо ввести число");
//            menu(text, values, null);
//        }
    }
    public void controllerMenu(int i, String dataSet) {
            switch (i) {
                case (1):
                    mainMenu();
                    break;
                case (2):
                    replenishGoods(dataSet);
                    break;
                case (3):
                    showStoreInfo();
                    break;
                case (4):
                    toysListMenu();
                    break;
                case (5):
                    letsStartLottery();
                    break;
                case (6):
                    showToyInfoMenu();
                    break;
                case (7):
                    changeToyInfoMenu();
                    break;
                case (8):
                    createNewStore();
                    break;
                case (9):
                    createNewToy();
                    break;
                case (10):
                    break;
                case (11):
                    deleteStore(dataSet);
                    break;
            }
        }

    private void deleteStore(String dataSet) {
        controller.deleteStore(dataSet);
        System.out.println("Выбранный магазин был удалён");
        mainMenu();
    }

    private void replenishGoods(String dataset) {
        controller.replenishGoods(dataset);
        System.out.println("Склад пополнен. На складе находятся три игрушки каждого из имеющегося в наличии типа");
        storeMenu(dataset);
    }

    private void createNewToy() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите имя новой игрушки");
        String name = scanner.nextLine();
        System.out.println("Введите частоту встречаемости в лотерее (от 1 до 100");
        String frequency = scanner.nextLine();
        System.out.println("Введите город");
        String city = scanner.nextLine();
        System.out.println("Введите улицу");
        String street = scanner.nextLine();
        System.out.println("Введите № дома");
        String building = scanner.nextLine();

//        достаём из файла список магазинов
//        даём новому магазину iud
//        засовываем новый магазин в список
//        записываем список в файл
        System.out.println("Новый магазин " + name + " создан\n" +
                "На складе находятся три игрушки каждого из имеющегося в наличии типа");
    }


    private void createNewStore() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите имя нового магазина ");
        String name = scanner.nextLine();
        System.out.println("Введите адрес нового магазина ");
        System.out.println("Введите город ");
        String city = scanner.nextLine();
        System.out.println("Введите улицу ");
        String street = scanner.nextLine();
        System.out.println("Введите № дома ");
        String building = scanner.nextLine();
        System.out.println("Новый магазин " + name + " создан\n" +
                "На складе находятся три игрушки каждого из имеющегося в наличии типа");
        this.controller.createNewStore(name, city, street, building);
//        достаём из файла список магазинов
//        даём новому магазину iud
//        засовываем новый магазин в список
//        записываем список в файл

    }

    private void showStoreInfo() {
        String[] storeData = controller.loadStorelist();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Выберите интересующий вас магазин \n");
        stringBuilder.append("№  Название         Адрес                         Ассортимент \n");
        for (int i = 0; i < storeData.length; i++) {
            String[] currentStore = storeData[i].split(" ");
            stringBuilder.append(currentStore[0]);
            stringBuilder.append(" ");
            stringBuilder.append(currentStore[1]);
            stringBuilder.append(" ");
            stringBuilder.append(currentStore[2]);
            stringBuilder.append(" ");
            stringBuilder.append(currentStore[3]);
            stringBuilder.append(" ");
            for (int j = 4; j < currentStore.length; j++) {
                if ((j-3)%3 == 2) {
                    stringBuilder.append("'");
                    stringBuilder.append(currentStore[j]);
                    stringBuilder.append("' - ");
                } else if ((j-3)%3 == 0) {
                    stringBuilder.append(currentStore[j]);
                    stringBuilder.append("шт. ");
                } else {
                    stringBuilder.append(currentStore[j]);
                    stringBuilder.append(")");
                }
            }
            stringBuilder.append("\n");
        }
        System.out.println(stringBuilder.toString());
        storesListMenu(storeData);
    }

    private void toysListMenu() {
    }

    private void letsStartLottery() {
    }

    private void showToyInfoMenu() {
    }

    private void changeToyInfoMenu() {
    }

    private void exitProgramm() {
    }

    private void storesListMenu(String[] storeData) {
        Scanner scanner = new Scanner(System.in);
        boolean flag = true;
        StringBuilder choiceDatasetbuilder = new StringBuilder();
        String choice;
        while (flag){
            choice = scanner.next();
            try {
                int intChoice = Integer.parseInt(choice);
                try{
                   choiceDatasetbuilder.append(storeData[intChoice-1]);
                   flag = false;
                } catch (ArrayIndexOutOfBoundsException t){
                    System.out.println("Введите номер от 1 до" + storeData.length);
                }
            } catch (NumberFormatException n){
                System.out.println("Введите число");
            }
        }
        String choiceDataset = choiceDatasetbuilder.toString();
        storeMenu(choiceDataset);
    }

    private void storeMenu(String choiceDataset) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Выбран следующий магазин:");
        stringBuilder.append(choiceDataset);
        stringBuilder.append("""
                \n
                Выберите интересующий вас пункт меню:
                1) Лотерея
                2) Пополнить запас игрушек
                3) Удалить магазин
                4) Главное меню
                """);
        Store myStore = controller.storeFromString(choiceDataset);
        menu(stringBuilder.toString(), new int[]{5,2,11,1}, myStore);
    }

    public void mainMenu() {
//        showStoreInfo();
        String text = """
                1) Список магазинов\s
                2) Создать новый магазин\s
                3) Создать новую игрушку\s
                4) Выход из программы\s
                """;
        int[] values = new int[] {3,8,9,10};
        menu(text,values, null);
    }

}
