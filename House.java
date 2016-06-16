/**
* Game of thrones house class
* @author Lovissa Winyoto
* @version 1.0
*/

import javax.swing.ImageIcon;
import java.awt.Graphics;
import java.util.Random;
import java.awt.Rectangle;

public abstract class House {

    protected int maxAge, health, healthBoost, age, magnitude, possibility;
    protected Rectangle bound, imageRectangle;
    protected String imageFilename;
    protected ImageIcon image;

    /**
     * This method constructs the new instance's initial variables
     * @param x and y position of the house instance, the rectangle bound of the
            panel, the house instance's picture filename, and its possibility
            of reproducing
     * @return none
     */
    public House(int x, int y, Rectangle rect, String fileName,
            int possibility) {
        bound = rect;
        image = new ImageIcon(fileName);
        imageRectangle = new Rectangle(x, y, image.getIconWidth(),
                image.getIconHeight());
        this.possibility = possibility;
        health = 300;
        age = 0;
        magnitude = 50;
    }

    /**
     * This method checks if the house is capable of harming other house
     * @param otherHosue
     * @return true/false
     */
    public abstract boolean canHarmHouse(House otherHouse);

    /**
     * This method checks if two houses can reproduce a new house with another
            house
     * @param otherHouse
     * @return true/false
     */
    public abstract boolean canReproduceWithHouse(House otherHouse);

    /**
     * This method checks if two houses collide
     * @param otherHouse
     * @return true/false
     */
    public boolean collidesWithHouse(House otherHouse) {
        return this.imageRectangle.intersects(otherHouse.imageRectangle);
    }

    /**
     * This method creates a new house instance
     * @param x and y coordinate of the this house instance, the rectangle bound
            of the panel
     * @return new house instance
     */
    public abstract House createHouse(int x, int y, Rectangle rect);

    /**
     * This method kills the instance
     * @param none
     * @return none
     */
    public void die() {
        //called for one reason or another
        health = 0;
    }

    /**
     * This method draws the house at its current location
     * @param g
     * @return none
     */
    protected void draw(Graphics g) {
        image.paintIcon(null, g, imageRectangle.x, imageRectangle.y);
    }

    /**
     * This method calculates the health boost when the house in specific area
            in the panel depending of the house
     * @param none
     * @return health boost
     */
    public abstract int getHealthBoost();

    /**
     * This method calculates the magnitude of movement, depending of the house
     * @param none
     * @return magnitude of movement
     */
    public abstract int getMagnitude();

    /**
     * This method make changes to the other house that lowers its qualities
     * @param otherHouse
     * @return none
     */
    public abstract void harmHouse(House otherHouse);

    /**
     * This method checks whether the instance is dead
     * @param none
     * @return true/false
     */
    public boolean isDead() {
        return (health == 0) ? true : false;
    }

    /**
     * This method checks if the house's age has exceeded the maximum age
     * @param none
     * @return true/false
     */
    public boolean isOld() {
        if (this instanceof Targaryan) {
            return (health <= 0) ? true : false;
        } else {
            return (age >= maxAge || health <= 0) ? true : false;
        }
    }

    /**
     * This method moves instances to a new position in the house
     * @param none
     * @return none
     */
    public void move() {
        Rectangle newPosition;
        boolean inBound = false;
        do {
            //randomize x direction
            Random randx = new Random();
            boolean xread = randx.nextBoolean();
            int xdir = (xread) ? 1 : -1;
            //randomize y direction
            Random randy = new Random();
            boolean yread = randy.nextBoolean();
            int ydir = (yread) ? 1 : -1;
            //set coordinates combination
            int x = getMagnitude() * xdir;
            int y = getMagnitude() * ydir;
            newPosition = new Rectangle(((int) imageRectangle.x) + x,
                    ((int) imageRectangle.y) + y,
                    (int) imageRectangle.getWidth(),
                    (int) imageRectangle.getHeight());
            //checks if the new position is in the bound
            inBound = bound.contains(newPosition);
            //System.out.println(inBound);
        } while (!inBound);
        //set the new position as the bound
        imageRectangle.setBounds(newPosition);
        health = health - 1 + getHealthBoost();
        age++;
    }

    /**
     * This method calculates the chance of reproduction of a new house when
            this house instance collides with another house instance
     * @param otherHouse
     * @return a new house if new house is reproduced, null if no house
            reproduced
     */
    public House reproduceWithHouse(House otherHouse) {
        Random random = new Random();
        int randnum = random.nextInt(100) + 1;
        if (randnum <= possibility) {
            House newHouse = createHouse(this.imageRectangle.x,
                    this.imageRectangle.y, this.bound);
            return newHouse;
        } else {
            return null;
        }
    }

}
