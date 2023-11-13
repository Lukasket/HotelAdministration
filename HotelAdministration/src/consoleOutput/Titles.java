package consoleOutput;

import Objects.Hotel;
import Objects.Room;

public class Titles {

    public static void printWelcomeTitle(Hotel hotel) {
        System.out.println("Welcome to " + hotel.getName() + " page!");
    }

    public static void printMainPageTitle() {
        System.out.println();
        System.out.println("What would you like to do? (Write number and tap Enter to select an option)");
    }

    public static void printRegistrationTitle() {
        System.out.println();
        System.out.println("Registration");
    }

    public static void printCheckoutTitle() {
        System.out.println();
        System.out.println("Check-out");
    }

    public static void printGuestListTitle() {
        System.out.println();
        System.out.println("List of guests currently staying at the hotel.");
    }

    public static void printRoomsHistoryTitle() {
        System.out.println();
        System.out.println("Rooms history");
    }

    public static void printRoomsOptionsTitle() {
        System.out.println("Which room history would you like to check? (Write room number)");
    }

    public static void printSelectedRoomTitle(Room room) {
        System.out.println();
        System.out.println("Room " + room.getRoomNumber() + " history");
    }

}
