/*****************************************************************
File:           PuzzleGame.java
Names:          Tristan Suppan, Waqar Khaliq, Usman Siddiqui
Date:           12/11/17
Description:    This is the main file for our game that runs everything
 ****************************************************************/
package UFOWars;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class UFOWars extends Application {
    public static void main(String[] args) {
        //Launch the game
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        //Initialize and declare variables
        RoomList rl = new RoomList();
        Room rmStart = new Room();
        RoomOne rm = new RoomOne();
        RoomTwo rm2 = new RoomTwo();
        RoomThree rm3 = new RoomThree();
        //Add the rooms
        rl.addRoom(rm3);
        rl.addRoom(rm2);
        rl.addRoom(rm);
        rl.addRoom(rmStart);
        rmStart.runRoom();
        //Add images and characters to game
        ClickToStart cl = new ClickToStart("click.png",0,0,1080,720, rl);
        rmStart.addCharacter(cl);
        Character backImgRm1 = new Character("back.png",0,0,1080,720);
        rm.addCharacter(backImgRm1);
        Plr character = new Plr(30,540,360, rm, rl);
        rm.addCharacter(character);
        Controller nu = new Controller(rm);
        Character backImgRm2 = new Character("gameover.png",-450,-360,1080,720);
        rm2.addCharacter(backImgRm2);
        rm.addNull(nu);
        rm.setText();
        Character backImgRm3 = new Character("leaderboard.png",0,0,1080,720);
        rm3.addCharacter(backImgRm3);   
        
        Scene scene = new Scene(rl.roomShowed(),1080,720);
        
        //Start the game
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}