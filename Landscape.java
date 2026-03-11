import java.awt.Graphics;
import java.util.Iterator;
import java.util.Random;

/**
 * Author: Chidiebere Okafor
 * Purpose of Class: Isn't it obvious?
 */
public class Landscape {
    private int width;
    private int height;
    private LinkedList<Agent> agentList;
    private Random random;  // Added for random number generation

    /** 
     * Constructor that creates a landscape with specified dimensions
     * @param width the width of the landscape
     * @param height the height of the landscape
     */
    public Landscape(int width, int height) {
        this.width = width;
        this.height = height;
        agentList = new LinkedList<>();
        this.random = new Random();  // Initialize random generator
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public void addAgent(Agent agent) {
        agentList.add(agent);
    }

    @Override
    public String toString() {
        return "There are " + agentList.size() + " agents on the Landscape";
    }

    /**
     * Returns a list of all agents within the specified radius of the given location
     * @param x0 the x coordinate of the center point
     * @param y0 the y coordinate of the center point
     * @param radius the radius within which to look for neighbors
     * @return a LinkedList containing all agents within the radius
     */
    public LinkedList<Agent> getNeighbors(double x0, double y0, double radius) {
        LinkedList<Agent> neighbors = new LinkedList<>();
        
        // Iterate through all agents using the iterator
        Iterator<Agent> iter = agentList.iterator();
        while (iter.hasNext()) {
            Agent agent = iter.next();
            
            // Calculate Euclidean distance
            double dx = agent.getX() - x0;
            double dy = agent.getY() - y0;
            double distance = Math.sqrt(dx * dx + dy * dy);
            
            // If within radius (and not the same agent if we're checking for self)
            if (distance <= radius) {
                neighbors.add(agent);
            }
        }
        
        return neighbors;
    }

    /**
     * Draws all agents on the landscape
     * @param g the Graphics object to draw with
     */
    public void draw(Graphics g) {
        // Draw all agents using the iterator
        Iterator<Agent> iter = agentList.iterator();
        while (iter.hasNext()) {
            Agent agent = iter.next();
            agent.draw(g);
        }
    }

    /**
     * Updates all agents on the landscape
     * 1. Randomly selects an agent and converts it to AntiSocialAgent
     * 2. Updates the state of all agents
     * 3. Counts how many agents moved
     * @return the number of agents that moved during the update
     */
    public int updateAgents() {
        // Step 1: Randomly select an agent and convert it to AntiSocialAgent
        if (agentList.size() > 0) {
            // Generate a random index
            int randomIndex = random.nextInt(agentList.size());
            
            // Get the agent at that index (need to iterate to find it)
            Iterator<Agent> iter = agentList.iterator();
            Agent selectedAgent = null;
            int currentIndex = 0;
            
            while (iter.hasNext()) {
                Agent agent = iter.next();
                if (currentIndex == randomIndex) {
                    selectedAgent = agent;
                    break;
                }
                currentIndex++;
            }
            
            if (selectedAgent != null) {
                // Store its properties
                double x = selectedAgent.getX();
                double y = selectedAgent.getY();
                int radius = selectedAgent.getRadius();
                
                // Remove the selected agent (need to remove by index)
                // Since we don't have remove by index in our LinkedList yet,
                // we'll need to implement a helper method or modify LinkedList
                // For now, let's add a temporary solution:
                removeAgent(selectedAgent);
                
                // Create a new AntiSocialAgent and add it
                AntiSocialAgent newAgent = new AntiSocialAgent(x, y, radius);
                agentList.add(newAgent);
            }
        }
        
        // Step 2 & 3: Update state of all agents and count how many moved
        int movedCount = 0;
        Iterator<Agent> iter = agentList.iterator();
        
        while (iter.hasNext()) {
            Agent agent = iter.next();
            agent.updateState(this);  // Pass the landscape to the agent
            if (agent.getMoved()) {
                movedCount++;
            }
        }
        
        return movedCount;
    }
    
    /**
     * Helper method to remove a specific agent from the list
     * This is needed because our LinkedList doesn't have a remove by object method
     * @param agent the agent to remove
     */
    private void removeAgent(Agent agent) {
        LinkedList<Agent> newList = new LinkedList<>();
        Iterator<Agent> iter = agentList.iterator();
        
        while (iter.hasNext()) {
            Agent current = iter.next();
            if (current != agent) {
                newList.add(current);
            }
        }
        
        agentList = newList;
    }
}