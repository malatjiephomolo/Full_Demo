import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class DeezerDemo {
    private static final int SLEEP_TIMER_DEFAULT_DURATION = 300000; // 5 minutes in milliseconds
    private static final Scanner scanner = new Scanner(System.in);
    private static boolean isLoggedIn = false;

    public static void main(String[] args) {
        System.out.println("Welcome to Deezer Demo!");

        // Prompt the user to login
        login();

        // Prompt the user to enter the song lyrics
        System.out.print("Enter the song lyrics: ");
        String lyrics = scanner.nextLine();

        // Retrieve song details based on the lyrics
        Map<String, String> songDetails = retrieveSongDetails(lyrics);

        if (songDetails != null) {
            String title = songDetails.get("title");
            String artist = songDetails.get("artist");

            // Simulating starting a song with lyrics integration
            startSongWithLyrics(title, artist, lyrics);

            // Prompt the user for playback control
            handlePlaybackControl();

            // Prompt the user to set the sleep timer duration
            int sleepTimerDuration = getSleepTimerDuration();

            // Set the sleep timer
            setSleepTimer(sleepTimerDuration);
        } else {
            System.out.println("Song details not found for the given lyrics.");
        }

        // Prompt the user to logout
        logout();
    }

    private static void login() {
        String username = promptDeezerUsername();
        String password = promptDeezerPassword();
        
        // TODO: Implement the login functionality using the provided username and password
        System.out.println("Logging in with username: " + username);
        isLoggedIn = true;
    }

    private static void logout() {
        if (isLoggedIn) {
            System.out.println("Do you want to logout? (Y/N)");
            String choice = scanner.nextLine().trim().toLowerCase();
            if (choice.equals("y")) {
                // TODO: Implement the logout functionality
                System.out.println("Logging out...");
                isLoggedIn = false;
            }
        }
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

    private static void startSongWithLyrics(String title, String artist, String lyrics) {
        System.out.println("Now playing: " + title + " - " + artist);
        System.out.println("Lyrics:\n" + lyrics);
        // Add code here to play the song using the Deezer system
        System.out.println("Playing song using Deezer...");
    }

    private static void handlePlaybackControl() {
        int option;
        while (true) {
            System.out.println("Choose an option:");
            System.out.println("1. Pause playback");
            System.out.println("2. Play previous song");
            System.out.println("3. Play next song");
            System.out.println("4. Adjust volume");
            System.out.println("5. Exit");

            try {
                System.out.print("Option: ");
                option = scanner.nextInt();
                scanner.nextLine(); // Consume the newline character

                switch (option) {
                    case 1:
                        // Add code here to pause playback
                        System.out.println("Playback paused.");
                        break;
                    case 2:
                        // Add code here to play the previous song
                        System.out.println("Playing previous song.");
                        break;
                    case 3:
                        // Add code here to play the next song
                        System.out.println("Playing next song.");
                        break;
                    case 4:
                        // Add code here to adjust volume
                        System.out.println("Adjusting volume...");
                        break;
                    case 5:
                        System.out.println("Exiting...");
                        return; // Exit the method and end the program
                    default:
                        System.out.println("Invalid option. Please choose a valid option.");
                        break;
                }
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a valid integer value.");
                scanner.nextLine(); // Consume the invalid input
            }
        }
    }

    private static Map<String, String> retrieveSongDetails(String lyrics) {
        // Simulated song details dictionary
        Map<String, String> songDetails = new HashMap<>();
        songDetails.put("Jerusalema, ikhaya lami, Ngilondoloze, uhambe nami", "Jerusalema - by Master KG ft. Nomcebo Zikode");
        songDetails.put("I love you, but I can't be with you", "SMA - by Nasty C ft. Rowlene");
        songDetails.put("Amademoni, siyathandana, siyajabula, siyalala nge 'Mali, ", "Amademoni - by Cassper Nyovest ft. Tweezy");
        songDetails.put("Umlilo wodwa, awazi mali, awazi phola", "Umlilo - by DJ Zinhle ft. Mvzzle, Rethabile");
        songDetails.put("John Cena, woah, John Cena, woah", "John Cena - by Sho Madjozi");
        songDetails.put("Come on, be my baby, come on", "Shape of You - by Ed Sheeran");
        songDetails.put("Despacito, quiero respirar tu cuello despacito", "Despacito - by Luis Fonsi ft. Daddy Yankee");
        songDetails.put("Hello from the other side", "Hello - by Adele");
        songDetails.put("This hit, that ice cold, Michelle Pfeiffer, that white gold", "Uptown Funk - by Mark Ronson ft. Bruno Mars");
        songDetails.put("I said, ooh, I'm blinded by the lights", "Blinding Lights - by The Weeknd");

        // Retrieve song details based on lyrics
        if (songDetails.containsKey(lyrics)) {
            String songDetail = songDetails.get(lyrics);
            String[] parts = songDetail.split(" - ");
            String title = parts[0];
            String artist = parts[1];

            Map<String, String> result = new HashMap<>();
            result.put("title", title);
            result.put("artist", artist);
            return result;
        } else {
            return null;
        }
    }

    // Prompt the user for Deezer username
    private static String promptDeezerUsername() {
        System.out.print("Enter your Deezer username: ");
        return scanner.nextLine();
    }

    // Prompt the user for Deezer password
    private static String promptDeezerPassword() {
        System.out.print("Enter your Deezer password: ");
        return scanner.nextLine();
    }

    // Prompt the user for Deezer song search query
    private static String promptDeezerSongQuery() {
        System.out.print("Enter the song you want to search on Deezer: ");
        return scanner.nextLine();
    }

    // Prompt the user to select a Deezer playlist
    private static String promptDeezerPlaylistSelection() {
        System.out.print("Enter the name or ID of the Deezer playlist: ");
        return scanner.nextLine();
    }

    // Prompt the user to logout
    private static void promptLogout() {
        System.out.println("Logout successful. Goodbye!");
    }
}
