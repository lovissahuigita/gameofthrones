import java.awt.Rectangle;
import java.awt.Point;

public abstract class NorthHouse extends House {

    protected String fileName;

    /**
     * This method constructs the new instance's initial variables
     * @param x and y position of the house instance, the rectangle bound of the
            panel, the house instance's picture filename, and its possibility of
            reproducing
     * @return none
     */
    public NorthHouse(int x, int y, Rectangle rect, String fileName,
            int possibility) {
        super(x, y, rect, fileName, possibility);
    }

    /**
     * This method calculates the health boost when the house in specific area
            in the panel depending of the house
     * @param none
     * @return health boost
     */
    public int getHealthBoost() {
        Rectangle northBox = new Rectangle(0, 0, 600, 300);
        Point coordinate = new Point(imageRectangle.x, imageRectangle.y);
        return (northBox.contains(coordinate)) ? 2 : 0;
    }

    /**
     * This method calculates the magnitude of movement, depending of the house
     * @param none
     * @return magnitude of movement
     */
    public int getMagnitude() {
        return 50;
    }

}
