import java.awt.Rectangle;
import java.util.Random;

public class Stark extends NorthHouse {

    /**
     * This method constructs the new initial variables for Stark House
     * @param x and y position of the house instance, the rectangle bound of the
          panel
     * @return none
     */
    public Stark(int x, int y, Rectangle rect) {
        super(x, y, rect, "direwolf.png", 10);
        maxAge = 40;
    }

    /**
     * This method checks if the house is capable of harming other house
     * @param otherHosue
     * @return true/false
     */
    public boolean canHarmHouse(House otherHouse) {
        return (otherHouse instanceof Lannister);
    }

    /**
     * This method checks if two houses can reproduce a new house with another
            house
     * @param otherHouse
     * @return true/false
     */
    public boolean canReproduceWithHouse(House otherHouse) {
        return (otherHouse instanceof Tully);
    }

    /**
     * This method creates a new house instance
     * @param x and y coordinate of the this house instance, the rectangle bound
            of the panel
     * @return new house instance
     */
    public House createHouse(int x, int y, Rectangle rect) {
        Stark newHouse = new Stark(x, y, rect);
        return newHouse;
    }

    /**
     * This method make changes to the other house that lowers its qualities
     * @param otherHouse
     * @return none
     */
    public void harmHouse(House otherHouse) {
        Random random = new Random();
        int randnum = random.nextInt(100) + 1;
        if (randnum <= 40) {
            otherHouse.health -= 20;
        }
    }

}
