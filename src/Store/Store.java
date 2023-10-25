package Store;

import FileWork.FileWork;
import Toy.Toy;

import java.util.ArrayList;

public class Store {
    ArrayList<Toy> assortment;
    String name;
    String city;
    String street;
    String building;

    public Store(String name, String city, String street, String building){
        this.assortment = new ArrayList<>();
        this.name = name;
        this.city = city;
        this.street = street;
        this.building = building;
    }
    Store (){
        this.assortment = new ArrayList<>();
        this.name = "Магазин без названия";
    }

    public void createStandartAssortment(){
        FileWork fileWork = new FileWork();
        String[] assortmentData = fileWork.loadToylist();
        for (int i = 0; i < assortmentData.length; i++) {
            String[] toyData = assortmentData[i].split(" ");
            Toy toy = new Toy(toyData[0], Float.parseFloat(toyData[1]));
            toy.setUid(i+1);
            toy.setCount(3);
            assortment.add(toy);
        }

    }

    public void setAssortmentFromDataSet (String[] dataSet){
        for (int i = 4; i < dataSet.length; i++) {
            Toy toy = new Toy(Integer.parseInt(dataSet[i]), dataSet[i=i+1], Float.parseFloat(dataSet[i=i+1]));
            assortment.add(toy);
        }
    }

    public void addToyToAssort(Toy toy){
        toy.setUid(this.assortment.size() + 1);
        this.assortment.add(toy);
    }

    public String getName(){
        return name;
    }
    public String getCity(){
        return city;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < assortment.size(); i++) {
            stringBuilder.append(" " + assortment.get(i).getUid() + " " +
                    assortment.get(i).getName() + " " +
                    assortment.get(i).getFrequency());
        }
        return name + " " + city + " " + street + " " + building + stringBuilder.toString();
    }
}
