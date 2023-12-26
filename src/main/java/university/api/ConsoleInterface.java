package university.api;

import university.datastorage.DataStorage;

import java.io.*;
import java.util.Objects;
import java.util.Scanner;

public class ConsoleInterface {


    static DataStorage dataStorage = DataStorage.getInstance();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        FileInputStream fileInputStream = new FileInputStream("dataStorage.out");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        dataStorage = (DataStorage) objectInputStream.readObject();
//        System.out.println("write your email: ");
//        var email = sc.nextLine();
        FileOutputStream fileOutputStream = new FileOutputStream("dataStorage.out");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(dataStorage);
        objectOutputStream.flush();
        objectOutputStream.close();
    }

}
