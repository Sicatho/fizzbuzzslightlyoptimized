/*****************************************************************
File:           PuzzleGame.java
Names:          Tristan Suppan, Waqar Khaliq, Usman Siddiqui
Date:           12/11/17
Description:    This is the button to submit your score
 ****************************************************************/
package UFOWars;

class DoneBtn extends Character {
    //Initialize and declare variables
    RoomList rl;
    RoomTwo rm2;
    RoomThree rm3;
    //private double mouseX,mouseY;
    public DoneBtn(String s, double x, double y, double fitX, double fitY,RoomList rl) {
        super(s, x, y, fitX, fitY);
        this.rm2 = (RoomTwo) rl.getRoom(1);
        this.rm3 = (RoomThree) rl.getRoom(0);
        this.rl = rl;
        
    }

    //If clicked, save and display scores
    @Override
    public void mouseLeftClicked() {
        if ((rm2.getMouseX() > this.x) && (rm2.getMouseX() < this.xStretch) && (rm2.getMouseY() > y) && (rm2.getMouseY() < yStretch)) {
            rl.rmGotoNext();
            rm3.addScore(rm2.getScore());
        }
    }
}