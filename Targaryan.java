import java.awt.Rectangle;
import java.util.Random;

public class Targaryan extends House {

    /**
     * This method constructs the new initial variables for Targaryan House
     * @param x and y position of the house instance, the rectangle bound of the
          panel
     * @return none
     */
    public Targaryan(int x, int y, Rectangle rect) {
        super(x, y, rect, "dragon.png", 1);
        maxAge = -1;
    }

    /**
     * This method checks if the house is capable of harming other house
     * @param otherHosue
     * @return true/false
     */
    public boolean canHarmHouse(House otherHouse) {
        return (!(otherHouse instanceof Targaryan)
                && !(otherHouse instanceof Baratheon));
    }

    /**
     * This method checks if two houses can reproduce a new house with another
            house
     * @param otherHouse
     * @return true/false
     */
    public boolean canReproduceWithHouse(House otherHouse) {
        return (otherHouse instanceof Targaryan);
    }

    /**
     * This method creates a new house instance
     * @param x and y coordinate of the this house instance, the rectangle bound
            of the panel
     * @return new house instance
     */
    public House createHouse(int x, int y, Rectangle rect) {
        Targaryan newHouse = new Targaryan(x, y, rect);
        return newHouse;
    }

    /**
     * This method calculates the health boost when the house in specific area
            in the panel depending of the house
     * @param none
     * @return health boost
     */
    public int getHealthBoost() {
        return 0;
    }

    /**
     * This method calculates the magnitude of movement, depending of the house
     * @param none
     * @return magnitude of movement
     */
    public int getMagnitude() {
        return 50;
    }

    /**
     * This method make changes to the other house that lowers its qualities
     * @param otherHouse
     * @return none
     */
    public void harmHouse(House otherHouse) {
        Random random = new Random();
        int randnum = random.nextInt(100) + 1;
        otherHouse.health -= 20;
    }

}
