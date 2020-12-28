/*****************************************************************
File:           PuzzleGame.java
Names:          Tristan Suppan, Waqar Khaliq, Usman Siddiqui
Date:           12/11/17
Description:    This is the first room
 ****************************************************************/
package UFOWars;

import java.util.ArrayList;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

//Constructors
public class RoomOne extends Room {
    private ArrayList<Enemy> enemies = new ArrayList<>();
    private ArrayList<EnemyBullet> enemyBullets = new ArrayList<>();
    private NullCharacter nu;
    private int score;
    private Text label;
    
    public RoomOne() {
        super();
        numObjects = 0;
        score = 0;
        label = new Text();
        label.setX(900);
        label.setY(100);
        label.setText(String.valueOf(score));
        label.setFill(Color.WHITE);
        label.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 50));
    }
    
    
    //Game events
    @Override
    public void setEvents() {
        nu.step();
    }
    
    public void setText() {
        getChildren().add(label);
    }
    
    public void addNull(NullCharacter nu) {
        this.nu = nu;
    }
    
    protected void addEnemy(Enemy en) {
        addCharacter(en);
        enemies.add(en);
    }
    
    public void destroyEnemy(int enNum) {
        instanceDestroy(enemies.get(enNum).numInst);
        enemies.remove(enNum);
        score++;
        label.setText(String.valueOf(score));
    }
    
    protected void addEnemyBullet(EnemyBullet en) {
        addCharacter(en);
        enemyBullets.add(en);
    }
    
    public void destroyEnemyBullet(int enNum) {
        instanceDestroy(enemyBullets.get(enNum).numInst);
        enemyBullets.remove(enNum);
    }
    
    int getEnemyCount() {
        return enemies.size();
    }
    Enemy getEnemies(int i) {
        return enemies.get(i);
    }
    
    int getEnemyBulletCount() {
        return enemyBullets.size();
    }
    EnemyBullet getEnemyBullet(int i) {
        return enemyBullets.get(i);
    }

    protected int getScore() {
        return score;
    }
}

    
    /*public void destroyAll() {
        while (numObjects > 2)
            instanceDestroy(2);
    }*/
    
    