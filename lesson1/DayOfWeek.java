package lesson1;

public enum DayOfWeek {
    Monday,
    Tuesday,
    Wednesday,
    Thursday,
    Friday,
    Saturday,
    Sunday;

    static void allDays() {
        System.out.println("Various: ");
        for (DayOfWeek d : DayOfWeek.values()) {
            System.out.print(d + ", ");
        }
    }

    static void getWorkingHours(DayOfWeek p) {
        int dayN = p.ordinal();
        if (dayN <= 4) {
            int hours = (5 - dayN) * 8;
            System.out.printf("%d hours before weekend", hours);
        } else {
            System.out.println("This day is a weekend!");
        }
    }
}

