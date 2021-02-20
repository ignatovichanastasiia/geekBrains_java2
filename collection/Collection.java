package java2.collection;

import java.util.HashMap;

public class Collection {
    public static void main(String[] args) {
        System.out.println("Подсчет слов:");
        String [] words = {"flor", "flor","hall","window","window","window","wall","flor", "flor","hall","window","window","window","wall"};
        HashMap<String,Integer> wordsHM = new HashMap<>();

        for(String s: words) {
            wordsHM.put(s, wordsHM.getOrDefault(s, 0) + 1);
        }
        System.out.println(wordsHM);
        System.out.println("Расчет окончен");


        System.out.println("Работа с записной книгой");
        PhoneBook ph = new PhoneBook("First");
        PhoneNode a = new PhoneNode("Petrov","8(901)111-11-11");
        ph.addPN(a);
        PhoneNode b = new PhoneNode("Sidorov","8(901)222-11-11");
        ph.addPN(b);
        PhoneNode c = new PhoneNode("Kochkin","8(901)333-11-11");
        ph.addPN(c);
        PhoneNode d = new PhoneNode("Petrov","8(901)111-11-11");
        ph.addPN(d);
        PhoneNode e = new PhoneNode("Petrov","8(901)444-11-11");
        ph.addPN(e);
        PhoneNode f = new PhoneNode("Savelov","8(901)888-11-11");
        ph.addPN(f);
        PhoneNode g = new PhoneNode("Molokov","8(901)999-11-11");
        ph.addPN(g);
        PhoneNode h = new PhoneNode("Rutov","8(901)110-11-11");
        ph.addPN(h);
        ph.searchPN("Petrov");
        ph.searchPN("Molokov");
    }

}
