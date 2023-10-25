package Controller;

import FileWork.FileWork;
import Store.Store;
import SystemWork.SystemWork;
import View.ConsoleUI;

import java.util.Objects;

public class Controller {
    ConsoleUI consoleUI;
    SystemWork systemWork;
//    public Controller(ConsoleUI consoleUI, SystemWork systemWork){
//        this.consoleUI = consoleUI;
//        this.systemWork = systemWork;
//    }
    public Controller(){
        this.consoleUI = new ConsoleUI();
        this.systemWork = new SystemWork();
    }

    public void start(){
        this.consoleUI.setConnectWithController(this);
        this.systemWork.setConnectWithController(this);
        this.systemWork.setConnectWithFileWork(new FileWork());//TODO нужно ли
        this.consoleUI.mainMenu();
    }

    public void createNewStore(String name, String city, String street, String building) {
        systemWork.createNewStore(name, city, street, building);
    }

    public void goToMainMenu() {
        consoleUI.mainMenu();
    }

    public String[] loadToylist(){
       return systemWork.loadToylist();
    }
    public String[] loadStorelist(){
        return systemWork.loadStorelist();
    }

    public void replenishGoods(String dataset) {
        systemWork.replenishGoods(dataset);
    }

    public Store storeFromString(String choiceDataset) {
        return systemWork.storeFromDataset(choiceDataset);
    }

    public void deleteStore(String dataSet) {
        systemWork.deleteStore(dataSet);
    }
}
