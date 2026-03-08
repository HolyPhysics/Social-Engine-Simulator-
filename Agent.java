/**
 * Author: Chidiebere Okafor
 * Purpose of Class: Isn't it obvious?
 */
public abstract class Agent{

    private double x;
    private double y;
    protected int radius;
    protected boolean moved;

    /**
     * Constructs an agent with positions x and y and radius
     * 
     * @param x a double for the x position
     * @param y a double for the y position
     * @param radius an int for the radius
     */
    public Agent(double x, double y, int radius){ //sets the position.
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.moved = false;
    }

    /** Returns the value of the x position
     * 
     * @return the double value of the x position
    */
    public double getX(){
        return x;
    }

    /** Returns the value of the y position
     * 
     * @return the double value of the y position
    */
    public double getY(){
        return y;
    }

    /** Returns the value of the radius
     * 
     * @return the int value of the radius
    */
    public int getRadius(){
        return radius;
    }

    /** Returns the value of the moved field
     * 
     * @return the boolean value for agent's movements
    */
    public boolean getMoved(){
        return moved;
    }

    /** Sets the value of the x position
     * 
     * @param newX the new value of the x position
    */
    public void setX( double newX){
        this.x = newX;
    }

    /** Sets the value of the y position
     * 
     * @param newY the new value of the y position
    */
    public void setY( double newY){
        this.x = newY;
    }

    /** Sets the value of the radius
     * 
     * @param newRadius the new value of the radius
    */
    public void setRadius( int newRadius){
        this.x = newRadius;
    }

    @Override
    public String toString(){
        String returnString = "(";

        returnString += x + ", " + y + ")";

        return returnString;
    } 

    public abstract void updateState( Landscape scape); // does nothing for now.

    public abstract void draw( Graphics g); // does nothing for now.








}