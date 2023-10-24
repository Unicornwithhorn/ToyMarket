package FileWork;

import Store.Store;

import java.io.*;

public class FileWork {
    public String[] loadlist(String list) {
        StringBuilder stringBuilder = new StringBuilder();
        int a;
        boolean flag = true;
        FileReader fileReader = null;
        try {
            fileReader = new FileReader(list);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        while (flag) {
            try {
                if (((a = fileReader.read()) == -1)) flag = false;
                else stringBuilder.append((char) a);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }
        String[] data = stringBuilder.toString().split("\n");
        return data;
    }

    public String[] loadToylist() {
        return loadlist("toys.txt");
    }
    public String[] loadStorelist(){
        return loadlist("data.txt");
    }

    public void addStore(Store store) {
        try {
            FileWriter fileWriter = new FileWriter("data.txt", true);
            System.out.println(store.toString());
            fileWriter.write(store.toString());
            fileWriter.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        StringBuilder stringBuilder = new StringBuilder();
        try {
            FileReader fileReader = new FileReader("data.txt");
            int a = fileReader.read();
            System.out.println(a);
            System.out.println((char) a);
            while ((a = fileReader.read()) != -1) {
                stringBuilder.append ((char) a);
                }
            } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
        String[] data = stringBuilder.toString().split("\n");
    }
 }
