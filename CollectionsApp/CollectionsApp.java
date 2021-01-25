package CollectionsApp;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class CollectionsApp {

    public static void main(String[] args) {
        String [] words = {"flor", "flor","hall","window","window","window","wall"};
        HashMap<String,Integer> wordsHM = new HashMap<>();

        for(String s: words) {
            wordsHM.put(s, wordsHM.getOrDefault(s, 0) + 1);
        }
        System.out.println(wordsHM);

        PhoneBook phoneList = new PhoneBook();
        PhoneBook.putOnL("Ivanov","8(111)1111111");
        PhoneBook.putOnL("Sidorov","8(222)2222222");
        PhoneBook.putOnL("Zaycev","8(333)3333333");
        PhoneBook.putOnL("Burov","8(444)4444444");
        PhoneBook.putOnL("Ivanov","8(555)4444444");
        PhoneBook.putOnL("Zverev","8(666)4444444");
        PhoneBook.putOnL("Sidorov","8(777)4444444");

        System.out.println("Search by name:");
        System.out.println(phoneList.get("Ivanov"));
        System.out.println(phoneList.get("Zverev"));

    }


}
