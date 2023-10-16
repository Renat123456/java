//Реализуйте структуру телефонной книги с помощью HashMap.
//Программа также должна учитывать, что в во входной структуре будут повторяющиеся имена с разными телефонами, их необходимо считать, как одного человека с разными телефонами.
//Вывод должен быть отсортирован по убыванию числа телефонов.

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

class PhoneBook {
    private static HashMap<String, ArrayList<Integer>> phoneBook = new HashMap<>();

    public void add(String name, Integer phoneNum) {
        if (phoneBook.containsKey(name)){
            ArrayList<Integer> arr = new ArrayList<>();
            arr = phoneBook.get(name);
            arr.add(phoneNum);
            phoneBook.put(name, arr);
        }else {
            ArrayList<Integer> arr = new ArrayList<>();
            arr.add(phoneNum);
            phoneBook.put(name, arr);
        }
    }
    public ArrayList<Integer> find(String name) {
        if (phoneBook.containsKey(name)){
            ArrayList<Integer> arr = new ArrayList<>();
            arr = phoneBook.get(name);
            return arr;
        }else {
            ArrayList<Integer> arr = new ArrayList<>();
            return arr;
        }
    }
    public static void getPhoneBook() {
        ArrayList<Map.Entry<String, ArrayList<Integer>>> sortedPhoneBook = new ArrayList<>(phoneBook.entrySet());
        Comparator<Map.Entry<String, ArrayList<Integer>>> comparator = Comparator.comparing(entry -> entry.getValue().size());
        sortedPhoneBook.sort(comparator);
        for (Map.Entry<String, ArrayList<Integer>> entry : sortedPhoneBook) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}

public class hw6 {
    public static void main(String[] args) {
        String name1;
        String name2;
        String name3;
        int phone1;
        int phone2;
        int phone3;

        name1 = "Ivanov";
        name2 = "Petrov";
        name3 = "Putin";
        phone1 = 123456;
        phone2 = 654321;
        phone3 = 756321;

        PhoneBook myPhoneBook = new PhoneBook();
        myPhoneBook.add(name1, phone1);
        myPhoneBook.add(name1, phone2);
        myPhoneBook.add(name2, phone2);
        myPhoneBook.add(name3, phone2);
        myPhoneBook.add(name3, phone2);
        myPhoneBook.add(name3, phone1);
        myPhoneBook.add(name3, phone3);

        System.out.println(myPhoneBook.find(name1));
        PhoneBook.getPhoneBook();
    }
}
