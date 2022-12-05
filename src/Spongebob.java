import java.awt.*;

public class Spongebob {

    //VARIABLE DECLARATION SECTION
    //Here's where you state which variables you are going to use.
    public String name;               //name of the hero
    public int xpos;                  //the x position
    public int ypos;                  //the y position
    public int dx;                    //the speed of the hero in the x direction
    public int dy;                    //the speed of the hero in the y direction
    public int width;                 //the width of the hero image
    public int height;                //the height of the hero image
    public boolean isAlive;           //a boolean to denote if the hero is alive or dead
    public Rectangle rec;
    public Rectangle rightHitBox;
    public Rectangle leftHitBox;
    public Rectangle topHitBox;
    public Rectangle bottomHitBox;


    public Spongebob(String pName, int pXpos, int pYpos) { // Astronaut constructor
        name = pName;
        xpos = pXpos;
        ypos = pYpos;
//        dx = (int)(Math.random()*3+1);
//        dy = (int)(Math.random()*3+1);
        dx = 3;
        dy = 3;
        width = 100;
        height = 100;
        isAlive = true;
        rec = new Rectangle(xpos, ypos, width, height);
        topHitBox = new Rectangle(xpos+5,ypos,width-10,5);
        bottomHitBox = new Rectangle(xpos+5, ypos+height-10, width-10, 5);
        rightHitBox = new Rectangle(xpos+width-5,ypos,5, height-5);
        leftHitBox = new Rectangle(xpos, ypos, 5, height-5);


    }

    public void bounce(){
        xpos = xpos + dx;
        ypos = ypos + dy;

        if (xpos >= 1000 - width || xpos<= 0){ // right wall or left wall
            dx = -dx;

        }

        if (ypos >= 700 - height || ypos<= 0){ // right wall or left wall
            dy = -dy;

        }

        rec = new Rectangle(xpos, ypos, width, height);
        topHitBox = new Rectangle(xpos+5,ypos,width-10,5);
        bottomHitBox = new Rectangle(xpos+5, ypos+height-10, width-10, 5);
        rightHitBox = new Rectangle(xpos+width-5,ypos,5, height-5);
        leftHitBox = new Rectangle(xpos, ypos, 5, height-5);

    }
    public void bounce1(){
        xpos = xpos + dx;
        ypos = ypos + dy;

        if (xpos >= 500 - width || xpos<= 0){ // right wall or left wall
            dx = -dx;

        }

        if (ypos >= 700 - height || ypos<= 0){ // right wall or left wall
            dy = -dy;

        }

        rec = new Rectangle(xpos, ypos, width, height);
        topHitBox = new Rectangle(xpos+5,ypos,width-10,5);
        bottomHitBox = new Rectangle(xpos+5, ypos+height-10, width-10, 5);
        rightHitBox = new Rectangle(xpos+width-5,ypos,5, height-5);
        leftHitBox = new Rectangle(xpos, ypos, 5, height-5);

    }
    // public void wrap() { // move
    //   xpos = xpos + dx;
    // ypos = ypos + dy;

    //if (xpos >=1000 && dx > 0){
    //  xpos = -width;

    //}
    //if (xpos <=  -width && dx < 0){ // right wall or left wall
    //  xpos = 1000;

    //}
    //if (ypos >= 700 - height || ypos<= 0){ // right wall or left wall
    //  dy = -dy;

    //}

    //rec = new Rectangle(xpos, ypos, width, height);

    //}

}



