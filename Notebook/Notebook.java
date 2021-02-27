package Notebook;

import java.util.HashMap;

public class Notebook {
    private String nameBook;
    private HashMap<String,String> book;

    Notebook(String nameBook) {
        this.nameBook = nameBook;
        this.book = new HashMap<>();
    }

    public HashMap<String, String> getBook() {
        return book;
    }

    public void setBook(HashMap <String, String> book) {
        this.book = book;
    }

    public void addNum(String name, String number) {
        book = getBook();
        if (book.containsKey(name)) {
            if (book.get(name).equals(number)) {
                System.out.println("Такой контакт уже есть в записной книге");
            } else {
                String num = book.get(name) + ", " + number;
                book.put(name, num);
                System.out.println("Добавлен новый номер имеющемуся контакту");
            }
        } else {
            book.put(name, number);
        }
        setBook(book);
        System.out.println("Запись в записную книгу произведена: " + name + " - " + book.get(name));
    }


    public void searchNum(String name){
        book = getBook();
        if (book.containsKey(name)){
            String numOut = book.get(name);
            System.out.println(name + ": " + numOut);
        }else{
            System.out.println("Нет такого имени в записной книге: "+ name);
        }
    }

    @Override
    public String toString() {
        return ("Notebook:\n" + getBook());
    }
}


