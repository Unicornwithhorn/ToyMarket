package SystemWork;

import Controller.Controller;
import FileWork.FileWork;
import Store.Store;

import java.io.File;


public class SystemWork {
    Controller controller;
    FileWork fileWork;
    public void loadFile() {

    }

    public String[] loadToylist() {
        return fileWork.loadToylist();
    }

    public String[] loadStorelist() {
        return fileWork.loadStorelist();
    }

    public void createNewStore(String name, String city, String street, String building){
        Store store = new Store(name, city, street, building);
        store.createStandartAssortment();
        FileWork fileWork = new FileWork();
        fileWork.addStore(store);
        controller.goToMainMenu();
    }

    public void setConnectWithController(Controller controller){
        this.controller = controller;
    }

    public void setConnectWithFileWork(FileWork fileWork){
        this.fileWork = fileWork;
    }

    public void replenishGoods(Store store) {
        store.createStandartAssortment();

    }

    public Store storeFromDataset(String dataSet){
        String[] dataSetSplitted = dataSet.split(" ");
        Store store = new Store(dataSetSplitted[0], dataSetSplitted[1], dataSetSplitted[2], dataSetSplitted[3]);
        store.setAssortmentFromDataSet(dataSetSplitted);
        return store;
    }
}
