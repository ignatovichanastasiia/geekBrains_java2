package java2.collection;

import java.util.HashMap;


public class PhoneBook {
    private String name;
    private PhoneNode pn2;
    private HashMap <String,PhoneNode> book;


    PhoneBook(String name) {
        this.name = name;
        this.book = new HashMap<>();
    }

    public HashMap<String, PhoneNode> getBook() {
        return book;
    }

    public void setBook(HashMap <String, PhoneNode> book) {
        this.book = book;
    }

    public void addPN(PhoneNode pn1){
        book = getBook();
        if (book.containsKey(pn1.getName())) {
            pn2 = book.get(pn1.getName());
            if(pn1.equals(pn2)){
                System.out.println("Такой контакт уже есть в записной книге");
            }else {
                pn1.ChangePnList(pn2);
                System.out.println("Добавлен новый номер имеющемуся контакту");
            }
        }
        book.put(pn1.getName(), pn1);
        setBook(book);
        System.out.println("Запись в записную книгу произведена: "+pn1.toString());
    }

    public void searchPN(String key){
        book = getBook();
        if (book.containsKey(key)){
            pn2 = book.get(key);
            System.out.println(pn2.toString());
        }else{
            System.out.println("Нет такого имени в записной книге: "+key);
        }
    }

    @Override
    public String toString() {
        return ("PhoneBook:\n" + book.toString());
    }
}
