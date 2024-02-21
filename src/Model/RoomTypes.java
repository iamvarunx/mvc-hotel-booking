package Model;

public class RoomTypes {
    public int id;
    public String type;
    public int capacity;
    public int pricePerDay;
    public int advanceAmt;

    public RoomTypes(int id, String type, int capacity, int priceperDay, int advanceAmt) {
        this.id = id;
        this.type = type;
        this.capacity = capacity;
        this.pricePerDay = priceperDay;
        this.advanceAmt = advanceAmt;
    }
}
// Room_id, Room_type, no_of_person, pricePerDay, advanceAmount