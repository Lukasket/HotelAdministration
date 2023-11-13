import java.util.Scanner;

import Objects.Guest;
import Objects.Hotel;
import Objects.Room;
import consoleOutput.Options;
import consoleOutput.Results;
import consoleOutput.Titles;

public class HotelController {

    public static void mainPage(Hotel hotel) {
        Scanner scanner = new Scanner(System.in);
        String selectedOption = "";
        while (!selectedOption.equals("5")) {
            Titles.printMainPageTitle();
            Options.printMainPageOptions();
            selectedOption = scanner.nextLine();

            switch (selectedOption) {
                case "1":
                    registration(hotel, scanner);
                    break;
                case "2":
                    checkOut(hotel, scanner);
                    break;
                case "3":
                    checkGuestList(hotel, scanner);
                    break;
                case "4":
                    checkRoomsHistory(hotel, scanner);
                    break;
                case "5":
                    // end of session
                    break;
                default:
                    Results.optionsError();
                    break;
            }
        }

        scanner.close();
    }

    private static void registration(Hotel hotel, Scanner scanner) {
        Room availableRoom = findEmptyRoom(hotel);
        if (availableRoom == null) {
            Results.availableRoomsError();
            return;
        }
        Titles.printRegistrationTitle();
        Options.askForName();
        String guestName = scanner.nextLine();
        Options.askForSurname();
        String guestSurname = scanner.nextLine();
        Guest guest = new Guest(guestName, guestSurname);
        availableRoom.setGuest(guest);
        availableRoom.putGuestToHistory(guest);
        Results.registrationSuccessful(availableRoom);
    }

    private static Room findEmptyRoom(Hotel hotel) {
        for (Room room : hotel.getRooms()) {
            if (room.getGuest() == null) {
                return room;
            }
        }
        return null;
    }

    private static void checkOut(Hotel hotel, Scanner scanner) {
        Titles.printCheckoutTitle();
        Options.askForName();
        String guestName = scanner.nextLine();
        Options.askForSurname();
        String guestSurname = scanner.nextLine();
        boolean isGuestExist = false;
        for (Room room : hotel.getRooms()) {
            if (room.getGuest() != null && room.getGuest().getName().equals(guestName)
                    && room.getGuest().getSurname().equals(guestSurname)) {
                room.setGuest(null);
                isGuestExist = true;
                Results.checkoutSuccessful();
            }
        }
        if (!isGuestExist) {
            Results.checkoutError(guestName, guestSurname);
        }
    }

    private static void checkGuestList(Hotel hotel, Scanner scanner) {
        boolean isAnyGuestAvailable = false;
        for (Room room : hotel.getRooms()) {
            if (room.getGuest() != null) {
                isAnyGuestAvailable = true;
                break;
            }
        }

        if (!isAnyGuestAvailable) {
            Results.emptyGuestList();
            Options.printContinueOption(scanner);
            return;
        }

        Titles.printGuestListTitle();
        Results.printGuestList(hotel);
        Options.printContinueOption(scanner);
    }

    private static void checkRoomsHistory(Hotel hotel, Scanner scanner) {
        String roomNumber = "history";
        while (!roomNumber.equals("")) {
            Titles.printRoomsHistoryTitle();
            Titles.printRoomsOptionsTitle();
            Options.printRoomsOptions(hotel);
            roomNumber = scanner.nextLine();
            if (roomNumber == null) {
                return;
            }
            Boolean isRoomExist = false;
            for (Room room : hotel.getRooms()) {
                if (room.getRoomNumber().equals(roomNumber)) {
                    isRoomExist = true;
                    checkSelectedRoomHistory(room, scanner);
                    break;
                }
            }
            if (!isRoomExist && !roomNumber.equals("")) {
                Results.roomError(roomNumber);
            }
        }
    }

    private static void checkSelectedRoomHistory(Room room, Scanner scanner) {
        Titles.printSelectedRoomTitle(room);
        Results.printRoomStatus(room);
        Results.printRoomHistory(room);
        Options.printContinueOption(scanner);
    }
}
