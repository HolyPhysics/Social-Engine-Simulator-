public class AntiSocialAgent extends Agent{
    private int radius; // sets the radius of 

    /**
     * Constructs an agent with positions x and y and radius
     * 
     * @param x a double for the x position
     * @param y a double for the y position
     * @param radius an int for the radius
     */
    public AntiSocialAgent(double x, double y, int radius){
        super(x, y, radius);

        this.radius = radius;
    }

    @Override 
    public void draw(Graphics g){
        if(!moved) g.setColor(new Color(255, 0, 0));
        else g.setColor(new Color(255, 125, 125));

        g.fillOval((int) getX(), (int) getY(), 5, 5);
    }

    @Override 
    public void updateState( Landscape scape){
        
    } // does nothing for now.
}