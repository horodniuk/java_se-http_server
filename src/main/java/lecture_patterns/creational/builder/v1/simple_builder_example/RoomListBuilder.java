package lecture_patterns.creational.builder.v1.simple_builder_example;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class RoomListBuilder {
    private ArrayList listOfRoom;

    public RoomListBuilder addList(){
        this.listOfRoom = new ArrayList();
        return this;
    }
    public RoomBuilder addRoom(){
        return new RoomBuilder(this);
    }

    public RoomListBuilder addRoom(Room room){
        listOfRoom.add(room);
        return this;
    }

    public ArrayList<Room> buildList() {
        return listOfRoom;
    }
}
