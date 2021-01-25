package CollectionsApp;

import java.util.HashMap;
import java.util.LinkedList;

public class PhoneBook {
    private static HashMap<String,LinkedList<String>> phoneBook = new HashMap<>();

    public static void putOnL(String name, String phone) {
        LinkedList<String> phones = phoneBook.getOrDefault(name, new LinkedList<>());
        phones.add(phone);
        phoneBook.put(name, phones);
    }

    public LinkedList <String> get(String name){
        return phoneBook.get(name);
    }
}
