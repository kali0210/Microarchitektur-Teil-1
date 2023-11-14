public class Spieler {
    private String name;
    private Raum currentRoom;


    public Spieler(String name)
    {
        this.name = name;
    }


    public void enterRoom(Raum room) {
        currentRoom = room;
    }

    public Raum getCurrentRoom() {
        return currentRoom;
    }

    public String getName() {
        return name;
    }

}
