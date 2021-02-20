package java2.collection;

import java.util.ArrayList;
import java.util.Objects;

public class PhoneNode {
    private String name;
    private String tel;
    private ArrayList<String> tels;
    private ArrayList<String> tels2;

    public PhoneNode(String name, String tel) {
        this.name = name;
        this.tel = tel;
        this.tels = new ArrayList<>();
        tels.add(tel);
    }

    public String getName() {
        return name;
    }

    public ArrayList<String> getTels() {
        return tels;
    }

    public void setTels(ArrayList<String> tels) {
        this.tels = tels;
    }

    public void ChangePnList (PhoneNode pn2){
        name = getName();
        tels = getTels();
        tels2 = pn2.getTels();
        if(!tels.addAll(tels2)) System.out.println("Произошел сбой в момент добавления номера к уже имеющемуся контакту");
        setTels(tels);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PhoneNode phoneBook = (PhoneNode) o;
        return getName().equals(phoneBook.getName()) &&
                getTels().equals(phoneBook.getTels());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getTels());
    }

    @Override
    public String toString() {
        return ("\nИмя: "+getName()+"  Номер телефона: "+getTels().toString());
    }
}
