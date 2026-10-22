
public class Main {

    public static void main(String[] args) {

        TimeSpan first = new TimeSpan();
        first.printTime();
        TimeSpan second = new TimeSpan(80);
        second.printTime();
        TimeSpan third = new TimeSpan(1, 45);
        third.printTime();
        TimeSpan copy = new TimeSpan(third);
        copy.printTime();

        third.add(1, 20);
        third.printTime();
        third.add(30);
        third.printTime();
        third.add(second);
        third.printTime();

        third.subtract(1, 15);
        third.printTime();
        third.subtract(20);
        third.printTime();
        third.subtract(second);
        third.printTime();

        double hours = third.getTotalHours();
        System.out.println("К-сть годин " + hours);
        int minutes = third.getTotalMinutes();
        System.out.println("К-сть хвилин " + minutes );

        third.scale(3);
        third.printTime();

    }
}
