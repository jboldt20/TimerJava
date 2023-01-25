import java.util.Scanner;
public class Timer {
    private int hours;
    private int minutes;
    private int seconds;

    public Timer() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter number of hours: ");
        this.hours = scan.nextInt();
        System.out.print("Enter number of minutes: ");
        this.minutes = scan.nextInt();
        System.out.print("Enter number of seconds: ");
        this.seconds = scan.nextInt();
    }

    public void tick() {
        if (seconds == 0 && minutes == 0 && hours == 0) {
            System.out.println("beep");
            System.exit(0);
        }
        seconds--;
        if (seconds < 0) {
            seconds = 59;
            minutes--;
            if (minutes < 0) {
                minutes = 59;
                hours--;
            }
        }
    }

    public void add30Seconds() {
        seconds += 30;
        if (seconds >= 60) {
            seconds -= 60;
            minutes++;
            if (minutes >= 60) {
                minutes -= 60;
                hours++;
            }
        }
    }

    public String toString() {
        return String.format("%02d:%02d:%02d", hours, minutes, seconds);
    }
    public static void main(String[] args) {
        Timer timer = new Timer();
        System.out.println(timer);
        timer.add30Seconds();
        System.out.println(timer);

        for (int i = 0; i < 100000; i++) {
            timer.tick();
            System.out.println(timer);
        }
        timer.tick();
   }
}

