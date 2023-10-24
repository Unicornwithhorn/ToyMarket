import Controller.Controller;
import FileWork.FileWork;
import SystemWork.SystemWork;
import View.ConsoleUI;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class Main {
    public static void main(String[] args) {
        Controller controller = new Controller();
        controller.start();


//        FileWork fileWork = new FileWork();
//        String[] assortmentData = fileWork.loadToylist();
//        System.out.println(assortmentData[0]);



//        StringBuilder stringBuilder = new StringBuilder();
//        int a;
//        boolean flag = true;
//        FileReader fileReader = null;
//        try {
//            fileReader = new FileReader("data.txt");
//        } catch (FileNotFoundException e) {
//            throw new RuntimeException(e);
//        }
//        while (flag) {
//            try {
//                if (((a = fileReader.read()) == -1)) flag = false;
//                else stringBuilder.append((char) a);
//            } catch (IOException e) {
//                throw new RuntimeException(e);
//            }
//
//        }
//        String datastr = stringBuilder.toString();
//        System.out.println(datastr);
//        String[] data = (datastr).split("\n");
//        System.out.println(data[2]);


//        FileWriter fileWriter = new FileWriter("data");
//        fileWriter.write("ололо!");
//        fileWriter.flush();
    }
}