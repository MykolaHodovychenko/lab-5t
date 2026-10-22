
public class TimeSpan {
    private int hours;
    private int minutes;

    // Empty arguments
    TimeSpan(){
        this.minutes = 0;
        this.hours = 0;
    }

    // Only minutes
    TimeSpan(int minutes){
        checkTime(0, minutes);
        this.minutes = minutes;
        this.hours = 0;


        normolizeTime();
    }

    // Hours and Minutes
    TimeSpan(int hours, int minutes){
        checkTime(hours, minutes);
        this.minutes = minutes;
        this.hours = hours;

        normolizeTime();
    }

    // Copy
    TimeSpan(TimeSpan other){
        this.hours = other.getHours();
        this.minutes = other.getMinutes();
    }

    public int getHours(){
        return this.hours;
    }

    public int getMinutes(){
        return this.minutes;
    }

    private  void checkTime (int hours, int minutes){
        if(minutes < 0 || hours < 0){
            throw new IllegalArgumentException("Time under 0");
        }
    }

    private void normolizeTime(){
        while(getMinutes() >= 60){
            this.minutes -= 60;
            this.hours += 1;
        }
    }

    // Hours and Minutes
    public void add(int hours, int minutes){
        checkTime(hours, minutes);
        this.minutes += minutes;
        this.hours += hours;

        normolizeTime();
    };

    // Only Minutes
    public void add(int minutes){
        checkTime(0, minutes);
        this.minutes += minutes;

        normolizeTime();
    };

    // Copy
    public void add(TimeSpan other){
        this.minutes += other.getMinutes();
        this.hours += other.getHours();

        normolizeTime();
    };

    public void subtract(int hours, int minutes){
        checkTime(hours, minutes);
        int TotalMinutesToSubtract = minutes + (hours * 60);
        int ThisTotalMinutes = this.getMinutes() + (this.getHours() * 60);

        if (minutes > this.minutes){
            System.out.println("Час який віднімаєте більше за поточний ");
            normolizeTime();
            return;
        }

        this.minutes = ThisTotalMinutes - TotalMinutesToSubtract;
        this.hours = 0;
        normolizeTime();
    }

    public void subtract(int minutes){
        checkTime(0, minutes);
        int ThisTotalMinutes = this.getMinutes() + (this.getHours() * 60);

        if (minutes > ThisTotalMinutes){
            System.out.println("Час який віднімаєте більше за поточний ");
            normolizeTime();
            return;
        }

        this.minutes = ThisTotalMinutes - minutes;
        this.hours = 0;
        normolizeTime();
    }

    public void subtract(TimeSpan other){
        int OtherTotalMinutes = other.getMinutes() + (other.getHours() * 60);
        int ThisTotalMinutes = this.getMinutes() + (this.getHours() * 60);

        if (OtherTotalMinutes > ThisTotalMinutes){
            System.out.println("Час який віднімаєте більше за поточний ");
            normolizeTime();
            return;
        }

        this.minutes = ThisTotalMinutes - OtherTotalMinutes;
        this.hours = 0;
        normolizeTime();
    }

    public double getTotalHours(){
        return (getHours() + (getMinutes() / 60.0));
    }

    public int getTotalMinutes(){
        return (getMinutes() + (getHours() * 60));
    }

    public void scale(int factor){
        if(factor <= 0){
            throw new IllegalArgumentException("Не надавайте відємних значень для фактора");
        }
        this.minutes *= factor;
        this.hours *= factor;
        normolizeTime();
    }

    public void printTime(){
        System.out.println(hours + " годин " + minutes + " хвилин");
    }

}
