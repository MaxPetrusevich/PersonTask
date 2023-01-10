package src;

import src.Data;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ExecuteTask {
    public void executor() {
        List<Person> list = createPersonList();
        list = streamTask(list);
        writeIntoFile(list);
        list = readInfoFromFile();
        finalTask(list);
    }

    private static void finalTask(List<Person> list) {
        List<String> stringList = list.stream()
                .map(person -> person.getName() + " " + person.getSurname())
                .collect(Collectors.toList());
        for (String string :
                stringList) {
            System.out.println(string);
        }
    }

    private static List<Person> createPersonList() {
        List<Person> list = Stream
                .generate(() -> new Person(new Random().nextInt(Data.AGE_BOUND) + Data.AGE_BOUND,
                        Data.NAMES[new Random().nextInt(Data.NAMES.length)],
                        Data.SURNAMES[new Random().nextInt(Data.SURNAMES.length)]))
                .limit(Data.PERSONS_COUNT)
                .peek(System.out::println)
                .collect(Collectors.toList());
        System.out.println();
        System.out.println();
        return list;
    }

    private static List<Person> streamTask(List<Person> list) {
        list = list.stream()
                .filter((Person person) -> person.getAge() < 21)
                .peek(System.out::println)
                .sorted(Comparator.comparing(Person::getSurname).thenComparing(Person::getName))
                .distinct()
                .collect(Collectors.toList());
        return list;
    }

    private static void writeIntoFile(List<Person> list) {
        File file = new File("src\\output.bin");
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
            for (Person person :
                    list) {
                oos.writeObject(person);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static List<Person> readInfoFromFile() {
        File file = new File("src\\output.bin");
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        List<Person> newList = new ArrayList<>();
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))){
            while(file.canRead()){
                newList.add((Person)ois.readObject());
            }
        }catch (IOException | ClassNotFoundException e){
            System.out.println("Data were reading");
        }
        return newList;
    }
}
