/**
 * Author: Chidiebere Okafor
 * Purpose of Class: Isn't it obvious?
 */
public class SocialAgent extends Agent{

    private int radius; // sets the radius of interaction for the social agents.
    
    /**
     * Constructs an agent with positions x and y and radius
     * 
     * @param x a double for the x position
     * @param y a double for the y position
     * @param radius an int for the radius
     */
    public SocialAgent(double x, double y, int radius){
        super(x, y, radius); // Calls the Agent super class to initiate the inheritance
        this.radius = radius;
    }


    @Override
    public void draw( Graphics g ){
        if(!moved) g.setColor(new Color(0, 0, 255));
        else g.setColor(new Color(255, 125, 125));

        g.fillOval((int) getX(), (int) getY(), 5, 5);
    }

    @Override
    public void updateState( Landscape scape){
        
    } // does nothing for now.
    

}