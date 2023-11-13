package Objects;

import java.util.List;

public class Room {
    private String roomNumber;
    private List<Guest> history;
    private Guest guest;

    public Room(String roomNumber, List<Guest> history, Guest guest) {
        this.roomNumber = roomNumber;
        this.history = history;
        this.guest = guest;
    }

    public void addGuestToHistory(Guest guest) {
        history.add(guest);
    }

    public void putGuestToHistory(Guest guest){
        history.add(0, guest);
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public List<Guest> getHistory() {
        return history;
    }

    public void setHistory(List<Guest> history) {
        this.history = history;
    }

    public Guest getGuest() {
        return guest;
    }

    public void setGuest(Guest guest) {
        this.guest = guest;
    }
}
