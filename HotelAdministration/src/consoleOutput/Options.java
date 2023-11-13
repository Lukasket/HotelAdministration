package consoleOutput;

import java.util.Scanner;

import Objects.Hotel;
import Objects.Room;

public class Options {
    public static String CONTINUE_OPTION = "Tap enter to continue";

    public static void printMainPageOptions() {
        System.out.println("1. Register\n2. Check-out\n3. Check guests\n4. Check rooms history\n5. Exit");
    }

    public static void askForName() {
        System.out.println();
        System.out.println("What is your name?");
    }

    public static void askForSurname() {
        System.out.println();
        System.out.println("What is your surname?");
    }

    public static void printContinueOption(Scanner scanner) {
        System.out.println();
        System.out.println("Tap enter to continue");
        scanner.nextLine();
    }

    public static void printRoomsOptions(Hotel hotel) {
        for (Room room : hotel.getRooms()) {
            System.out.println("Room " + room.getRoomNumber());
        }
        System.out.println("Do not type anything and tap Enter to go back");
    }

}
