package consoleOutput;

import Objects.Guest;
import Objects.Hotel;
import Objects.Room;
import enums.RoomOccupancy;

public class Results {
    public static void optionsError() {
        System.out.println("\u001B[31mThis option is not available. Please select available option.\u001B[0m");
    }

    public static void availableRoomsError() {
        System.out.println("\u001B[31mThere are currently no available rooms. Please check later!\u001B[0m");
    }

    public static void checkoutError(String guestName, String guestSurname) {
        System.out.println("\u001B[31mCheck-out failed. " + guestName + " " + guestSurname
                + " is not on our guest list.\u001B[0m");
    }

    public static void roomError(String roomNumber) {
        System.out.println("\u001B[31mRoom " + roomNumber + " does not exist.\u001B[0m");
    }

    public static void registrationSuccessful(Room room) {
        System.out
                .println("\u001B[32mRegistration successful! Your room number: " + room.getRoomNumber() + ".\u001B[0m");
    }

    public static void checkoutSuccessful() {
        System.out.println("\u001B[32mCheck-out successful!\u001B[0m");
    }

    public static void emptyGuestList(){
        System.out.println();
        System.out.println("No guests are staying at the hotel");
    }

    public static void printGuestList(Hotel hotel) {
        for (Room room : hotel.getRooms()) {
            if (room.getGuest() != null) {
                System.out.println("Room " + room.getRoomNumber() + ": " + room.getGuest().getName() + " "
                        + room.getGuest().getSurname() + ".");
            }
        }
    }

    public static void printRoomStatus(Room room) {
        if (room.getGuest() == null) {
            System.out.println("Current status: " + RoomOccupancy.Available);
        } else {
            System.out.println("Current status: " + RoomOccupancy.Occupied);
        }
    }

    public static void printRoomHistory(Room room) {
        System.out.println();
        System.out.println("List of guests who lived in this room:");
        for (Guest guest : room.getHistory()) {
            System.out.println(guest.getName() + " " + guest.getSurname());
        }
    }
}
