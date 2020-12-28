/*****************************************************************
File:           PuzzleGame.java
Names:          Tristan Suppan, Waqar Khaliq, Usman Siddiqui
Date:           12/11/17
Description:    This is the overarching character class that most game objects inherit
 ****************************************************************/

package UFOWars;

import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import javafx.scene.shape.*;

public class Character {
    //Initialize and declare variables
    protected Circle cir;
    private Rectangle rec;
    private ImageView image;
    private int type;
    public int numInst;
    public double x,y;
    public double xStretch,yStretch;
    double rad;
    
    //Constructors
    public Character(double rad,double x,double y) {
        this.rad = rad;
        cir = new Circle(x, y, rad);
        xStretch = yStretch = rad*2;
        type = 1;
        setPos(x,y);
    }
    public Character(double width, double height, double x, double y) {
        rec = new Rectangle(x, y, width,height);
        xStretch = width;
        yStretch = height;
        type = 2;
        setPos(x,y);
    }
    public Character(String s, double x, double y, double fitX, double fitY){
        image = new ImageView();
        Image img = new Image("sprite/" + s);
        image.setImage(img);
        xStretch = fitX;
        yStretch = fitY;
        image.setFitHeight(fitY); 
        image.setFitWidth(fitX);
        type = 3;
        setPos(x,y);
    }
    
    public Node get() {
        switch (type) {
            case 1:
                return cir;
            case 2:
                return rec;
            default:
                return image;
        }
    }
    //Scaling
    public void setPos(double x, double y) {
        this.x = x;
        this.y = y;
        switch (type) {
            case 1:
                cir.setCenterX(x);
                cir.setCenterY(y);
                break;
            case 2:
                rec.setX(x);
                rec.setY(y);
                break;
            default:
                image.setX(x);
                image.setY(y);
                break;
        }
    }
    public void setX(double x) {
        this.x = x;
        switch (type) {
            case 1:
                cir.setCenterX(x);
                //cir.setCenterY(y);
                break;
            case 2:
                rec.setX(x);
                //rec.setY(y);
                break;
            default:
                image.setX(x);
                //image.setY(y);
                break;
        }
    }
    public void setY(double y) {
        this.y = y;
        switch (type) {
            case 1:
                //cir.setCenterX(x);
                cir.setCenterY(y);
                break;
            case 2:
                //rec.setX(x);
                rec.setY(y);
                break;
            default:
                //image.setX(x);
                image.setY(y);
                break;
        }
        
    }
    public double getX() {
        return x;
    }
    public double getY() {
        return y;
    }
    //Change character type
    public void setNewCircle(double rad, double x, double y) {
        type = 1;
        cir = new Circle(x,y,rad);
    }
    public void setCircle(double rad) {
        type = 1;
        cir.setRadius(rad);
    }
    public void setNewRectangle(double width, double height, double x, double y) {
        type = 2;
        rec = new Rectangle(x,y,width, height);
    }
    public void setRectangle(double width, double height) {
        type = 2;
        rec.setWidth(width);
        rec.setHeight(height);
    }
    //Change image
    public void imageIndex(Image i) {
        type = 3;
        image.setImage(i);
    }
    public void imageIndex(String i) {
        type = 3;
        image.setImage(new Image("sprite/"+i));
    }
    public void imageNewIndex(String i, double x, double y) {
        type = 3;
        image.setImage(new Image("sprite/"+i));
        setPos(x,y);
    }
    
    //Movement
    public void moveToPoint(double x,double y,double spd) {
        double xMove, yMove, dist;
        xMove = x-this.x;
        yMove = y-this.y;
        dist = Math.sqrt((xMove*xMove)+(yMove*yMove));
        xMove = spd*Math.cos(Math.acos(xMove/dist));
        yMove = spd*Math.sin(Math.asin(yMove/dist));
        if ((x < this.x) && (this.x-x > spd)) {
                    setX(getX()+xMove);
            } else if ((x > this.x)&& (this.x-x < -spd)) {
                    setX(getX()+xMove);
            } else {
                setX(x);
                
            }
        if ((y < this.y) && (this.y-y > spd)) {
                    setY(getY()+yMove);
            } else if ((y > this.y)&& (this.y-y < -spd)) {
                    setY(getY()+yMove);
            } else {
                setY(y);
                
            }
    }
//Collision
    public boolean characterMeeting(double x,double y, Character character) {

        double radSum = character.rad + rad;
        double radDif = character.rad - rad;
        double distX = character.getX() - x + radDif;
        double distY = character.getY() - y + radDif;
        return(radSum * radSum > distX * distX + distY * distY);
    }
    
    
    public void step() {

    }
    public void mouseLeftClicked() {
        
    }

}
