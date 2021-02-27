package Notebook;

public class NBMain {
    public static void main(String[] args) {
        System.out.println("Работа с записной книгой");
        Notebook ph = new Notebook("First");
        ph.addNum("Petrov","8(901)111-11-11");
        ph.addNum("Sidorov","8(901)222-11-11");
        ph.addNum("Kochkin","8(901)333-11-11");
        ph.addNum("Petrov","8(901)111-11-11");
        ph.addNum("Petrov","8(901)444-11-11");
        ph.addNum("Savelov","8(901)888-11-11");
        ph.addNum("Molokov","8(901)999-11-11");
        ph.addNum("Rutov","8(901)110-11-11");
        ph.searchNum("Petrov");
        ph.searchNum("Molokov");
    }
}
