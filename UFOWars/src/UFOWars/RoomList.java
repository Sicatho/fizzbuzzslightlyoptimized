/*****************************************************************
File:           PuzzleGame.java
Names:          Tristan Suppan, Waqar Khaliq, Usman Siddiqui
Date:           12/11/17
Description:    This is the list of all rooms
 ****************************************************************/
package UFOWars;

import java.util.ArrayList;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class RoomList {
    private ArrayList<Room> rooms = new ArrayList<>();
    private StackPane stack;
    private int numRooms, rmIndex;
    private VBox root;
    ObservableList<Node> childs;
    //Constructor
    public RoomList() {
        this.stack = new StackPane();
        numRooms = 0;
        rmIndex = -1;
        root  = new VBox();
        
    }
    //Add room
    public void addRoom(Room rm) {
        rooms.add(rm);
        stack.getChildren().add(rm);
        rm.rmIndex = numRooms;
        numRooms++;
        rmIndex++;
    }
    
    //Switch rooms
    public void rmGoto(int index) {
        while (!(rooms.get(rmIndex).rmIndex == index)) {
            rmGotoNext();
        }
    }
    public void rmGotoNext() {
        childs = stack.getChildren();
        if (childs.size() > 1) {
            Node topNode = childs.get(childs.size()-1);
            topNode.toBack();
            getRoom(rmIndex).pause();
            increment();
            getRoom(rmIndex).runRoom();
        }
    }
    public Room getRoom(int numRm) {
        return rooms.get(numRm);
    }
    private void increment() {
        if (rmIndex == 0) {
                rmIndex = numRooms;
            } else {
                rmIndex--;
            }
    }
    public VBox roomShowed() {
        root.getChildren().add(stack);
        return root;
    }
    
    
}
