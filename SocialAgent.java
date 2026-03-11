import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

/**
 * Author: Chidiebere Okafor
 * Purpose of Class: Isn't it obvious?
 */
public class SocialAgent extends Agent{
    // Remove this redundant field - it's already in the parent class
    // private int radius; // sets the radius of interaction for the social agents.
    
    private Random random;
    
    /**
     * Constructs an agent with positions x and y and radius
     * 
     * @param x a double for the x position
     * @param y a double for the y position
     * @param radius an int for the radius
     */
    public SocialAgent(double x, double y, int radius){
        super(x, y, radius); // Calls the Agent super class to initiate the inheritance
        // No need to set radius here - it's already set by super constructor
        this.random = new Random();
    }


    @Override
    public void draw( Graphics g ){
        if(!moved) {
            g.setColor(new Color(0, 0, 255));        // Dark blue for agents that didn't move
        } else {
            g.setColor(new Color(125, 125, 255));    // Light blue for agents that moved
        }

        g.fillOval((int) getX(), (int) getY(), 5, 5);
    }

    @Override
    public void updateState(Landscape scape){
        // Get all neighbors within this agent's radius
        LinkedList<Agent> neighbors = scape.getNeighbors(getX(), getY(), getRadius());
        
        // Count neighbors (excluding self)
        int neighborCount = neighbors.size();
        
        // SocialAgent moves if there are LESS THAN 4 neighbors
        // Note: neighborCount includes self, so < 4 means 3 or fewer total agents in radius
        // This effectively means 2 or fewer other agents (since self is included)
        if (neighborCount < 4) {
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