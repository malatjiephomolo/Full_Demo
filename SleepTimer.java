import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class SleepTimer {
    private static final int SLEEP_TIMER_DEFAULT_DURATION = 300000; // 5 minutes in milliseconds
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Welcome to Deezer Demo!");

        // Prompt the user to set the sleep timer duration
        int sleepTimerDuration = getSleepTimerDuration();

        // Simulating setting a sleep timer
        setSleepTimer(sleepTimerDuration);
    }

    private static int getSleepTimerDuration() {
        System.out.println("Please set the sleep timer duration (in minutes).");
        int durationInMinutes;
        while (true) {
            try {
                System.out.print("Duration: ");
                durationInMinutes = scanner.nextInt();
                scanner.nextLine(); // Consume the newline character
                break;
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a valid integer value.");
                scanner.nextLine(); // Consume the invalid input
            }
        }

        if (durationInMinutes <= 0) {
            System.out.println("Invalid duration. Using default duration: " + SLEEP_TIMER_DEFAULT_DURATION / 60000 + " minutes.");
            return SLEEP_TIMER_DEFAULT_DURATION;
        }

        int durationInMillis = durationInMinutes * 60000; // Convert minutes to milliseconds
        return durationInMillis;
    }

    private static void setSleepTimer(int duration) {
        Timer sleepTimer = new Timer();
        sleepTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("Sleep timer expired. Stopping playback...");
                // Add code here to stop the playback or perform any necessary actions.
                // For demonstration purposes, we can simply cancel the timer.
                sleepTimer.cancel();
            }
        }, duration);

        int durationInMinutes = duration / 60000; // Convert milliseconds to minutes
        System.out.println("Sleep timer set for " + durationInMinutes + " minutes.");

        System.out.println("Press any key to cancel the sleep timer...");
        scanner.nextLine();

        // Cancel the sleep timer if a key is pressed before it expires
        sleepTimer.cancel();
        System.out.println("Sleep timer canceled. Playback stopped.");
    }
}
