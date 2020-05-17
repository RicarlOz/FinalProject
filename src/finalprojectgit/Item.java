package finalprojectgit;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;

/**
 *
 * @author RicardoGomez and HeribertoGil
 */
public abstract class Item {

    protected int x;        // to store x position
    protected int y;        // to store y position
    protected int width;
    protected int height;

    /**
     * Set the initial values to create the item
     *
     * @param x <b>x</b> position of the object
     * @param y <b>y</b> position of the object
     */
    public Item(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    /**
     * Get x value
     *
     * @return x
     */
    public int getX() {
        return x;
    }

    /**
     * Get y value
     *
     * @return y
     */
    public int getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    /**
     * Set x value
     *
     * @param x to modify
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * Set y value
     *
     * @param y to modify
     */
    public void setY(int y) {
        this.y = y;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    /**
     * To update positions of the item for every tick
     */
    public abstract void tick();

    /**
     * To paint the item
     *
     * @param g <b>Graphics</b> object to paint the item
     */
    public abstract void render(Graphics g);

    public boolean collision(Object o) {
        boolean bStatus = false;        // assuming not collision
        if (o instanceof Item) {
            Rectangle rThis = new Rectangle(getX(), getY(), getWidth(), getHeight());
            Item i = (Item) o;
            Rectangle rOther = new Rectangle(i.getX(), i.getY(), i.getWidth(), i.getHeight());

            bStatus = rThis.intersects(rOther);
        }

        return bStatus;
    }
    
    public boolean hold(Point p){
        boolean bStatus = false;
        Rectangle rThis = new Rectangle(getX(), getY(), getWidth(), getHeight());
        
        bStatus = rThis.contains(p);
        
        return bStatus;
    }
    
    public boolean isInside(Object o) {
        boolean bStatus = true;        // assuming is inside
        if (o instanceof Item) {
            Rectangle rThis = new Rectangle(getX(), getY(), getWidth(), getHeight());
            Item i = (Item) o;
            Rectangle rOther = new Rectangle(i.getX(), i.getY(), i.getWidth(), i.getHeight());

            bStatus = rThis.contains(rOther);
        }

        return bStatus;
    }
}
