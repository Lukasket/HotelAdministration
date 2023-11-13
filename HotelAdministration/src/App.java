import java.util.ArrayList;
import java.util.List;

import Objects.Guest;
import Objects.Hotel;
import Objects.Room;
import constants.CONST;

public class App {
    public static void main(String[] args) throws Exception {
        List<Room> rooms = new ArrayList<>();
        for (int i = 0; i < CONST.ROOM_COUNT; i++) {
            int roomNumber = i + 1;
            rooms.add(new Room("" + roomNumber, new ArrayList<Guest>(), null));
        }
        Hotel hotel = new Hotel("Hotel", rooms);

        HotelController.mainPage(hotel);
    }
}
