import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

/**
 * Author: Chidiebere Okafor
 * Purpose of Class: Isn't it obvious?
 */
public class AntiSocialAgent extends Agent{
    // Remove this redundant field - it's already in the parent class
    // private int radius; // sets the radius of 
    
    private Random random;

    /**
     * Constructs an agent with positions x and y and radius
     * 
     * @param x a double for the x position
     * @param y a double for the y position
     * @param radius an int for the radius
     */
    public AntiSocialAgent(double x, double y, int radius){
        super(x, y, radius);
        // No need to set radius here - it's already set by super constructor
        this.random = new Random();
    }

    @Override 
    public void draw(Graphics g){
        if(!moved) {
            g.setColor(new Color(255, 0, 0));        // Dark red for agents that didn't move
        } else {
            g.setColor(new Color(255, 125, 125));    // Light red for agents that moved
        }

        g.fillOval((int) getX(), (int) getY(), 5, 5);
    }

    @Override 
    public void updateState(Landscape scape){
        // Get all neighbors within this agent's radius
        LinkedList<Agent> neighbors = scape.getNeighbors(getX(), getY(), getRadius());
        
        // Count neighbors (excluding self)
        int neighborCount = neighbors.size();
        
        // AntiSocialAgent moves if there is MORE THAN 1 neighbor
        if (neighborCount > 1) {
            // Generate random movement between -10 and 10
            double dx = (random.nextDouble() * 20) - 10;  // random between -10 and 10
            double dy = (random.nextDouble() * 20) - 10;  // random between -10 and 10
            
            // Calculate new position
            double newX = getX() + dx;
            double newY = getY() + dy;
            
            // Keep agent within landscape boundaries
            // Landscape width is from 0 to scape.getWidth()
            // Landscape height is from 0 to scape.getHeight()
            if (newX < 0) {
                newX = 0;
            } else if (newX > scape.getWidth()) {
                newX = scape.getWidth();
            }
            
            if (newY < 0) {
                newY = 0;
            } else if (newY > scape.getHeight()) {
                newY = scape.getHeight();
            }
            
            // Update position
            setX(newX);
            setY(newY);
            
            // Set moved flag to true
            moved = true;
        } else {
            // Agent didn't move
            moved = false;
        }
    }
}