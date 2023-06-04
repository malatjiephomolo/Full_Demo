import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SearchByLyrics {

    public static void main(String[] args) {
        // Prompt the user to enter the song lyrics
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the song lyrics: ");
        String lyrics = scanner.nextLine();

        // Retrieve song details based on the lyrics
        Map<String, String> songDetails = retrieveSongDetails(lyrics);

        if (songDetails != null) {
            String title = songDetails.get("title");
            String artist = songDetails.get("artist");

            // Simulating starting a song with lyrics integration
            startSongWithLyrics(title, artist, lyrics);

            // Prompt the user for actions (pause or skip)
            System.out.println("What would you like to do?");
            System.out.println("1. Pause the song");
            System.out.println("2. Skip the song");
            System.out.print("Enter your choice (1 or 2): ");
            int choice = scanner.nextInt();

            if (choice == 1) {
                // Add code here to pause the song
                System.out.println("Song paused.");
            } else if (choice == 2) {
                // Add code here to skip the song
                System.out.println("Song skipped.");
            } else {
                System.out.println("Invalid choice.");
            }
        } else {
            System.out.println("Song details not found for the given lyrics.");
        }
    }

    private static void startSongWithLyrics(String title, String artist, String lyrics) {
        System.out.println("Now playing: " + title + " - " + artist);
        System.out.println("Lyrics:\n" + lyrics);
        // Add code here to play the song using the Deezer system
    }

    // Simulated method to retrieve song details based on lyrics from a dictionary or list
    private static Map<String, String> retrieveSongDetails(String lyrics) {
        // Simulated song details dictionary
        Map<String, String> songDetails = new HashMap<>();
        songDetails.put("Jerusalema, ikhaya lami, Ngilondoloze, uhambe nami", "Jerusalema - by Master KG ft. Nomcebo Zikode");
        songDetails.put("I love you, but I can't be with you", "SMA - by Nasty C ft. Rowlene");
        songDetails.put("Amademoni, siyathandana, siyajabula, siyalala nge 'Mali, ", "Amademoni - by Cassper Nyovest ft. Tweezy");
        songDetails.put("Umlilo wodwa, awazi mali, awazi phola", "Umlilo - by DJ Zinhle ft. Mvzzle, Rethabile");
        songDetails.put("ohn Cena, woah, John Cena, woah", "John Cena - by Sho Madjozi");
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
}
