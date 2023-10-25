package SystemWork;

import Controller.Controller;
import FileWork.FileWork;
import Store.Store;

import java.io.File;
import java.util.Objects;


public class SystemWork {
    Controller controller;
    FileWork fileWork;

    public String[] loadToylist() {
        return fileWork.loadToylist();
    }

    public String[] loadStorelist() { return fileWork.loadStorelist(); }

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

    public void replenishGoods(String dataset) {
        Store store = storeFromDataset(dataset);
        store.createStandartAssortment();
        String newDataSet = store.toString();
        reloadStore(dataset, newDataSet);
    }
    public void reloadStore(String oldDataSet, String newDataSet){
        deleteStore(oldDataSet);
        Store store = storeFromDataset(newDataSet);
        fileWork.addStore(store);
    }
    public Store storeFromDataset(String dataSet){
        String[] dataSetSplitted = dataSet.split(" ");
        Store store = new Store(dataSetSplitted[0], dataSetSplitted[1], dataSetSplitted[2], dataSetSplitted[3]);
        System.out.println("Test4");//TODO Test
        store.setAssortmentFromDataSet(dataSetSplitted);
        return store;
    }
    public void deleteStore(String dataSet) {
        FileWork fileWork = new FileWork();
        String[] allStoresData = fileWork.loadStorelist();
        StringBuilder stringBuilder =new StringBuilder();
        for (int i = 0; i < allStoresData.length; i++) {
            if (!Objects.equals(allStoresData[i].split(" ")[0], dataSet.split(" ")[0])){
                stringBuilder.append(allStoresData[i]);
            }
        }
        fileWork.saveListStores(stringBuilder.toString());
    }
}
