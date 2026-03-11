import java.util.Random;

/**
 * Author: Chidiebere Okafor
 * Purpose of Class: Runs the agent-based simulation experiment
 */
public class AgentSimulation {

    /**
     * Runs the experiment with N initial SocialAgents
     * @param N the number of initial SocialAgents to place on the landscape
     * @return the number of iterations until the simulation stops (or 5000 if it times out)
     */
    public static int runExpt(int N) {
        // Create a 500x500 landscape
        Landscape scape = new Landscape(500, 500);
        Random rand = new Random();
        
        // Generate and randomly place N SocialAgents with radius 25
        for (int i = 0; i < N; i++) {
            double x = rand.nextDouble() * 500;
            double y = rand.nextDouble() * 500;
            SocialAgent agent = new SocialAgent(x, y, 25);
            scape.addAgent(agent);
        }
        
        // Create the display
        LandscapeDisplay display = new LandscapeDisplay(scape);
        
        // Track number of agents moved and iterations
        int agentsMoved = 1;  // Start with non-zero to enter the loop
        int iterations = 0;
        int maxIterations = 5000;
        
        // Run simulation while agents are moving and we haven't exceeded max iterations
        while (agentsMoved > 0 && iterations < maxIterations) {
            // Update agents and get count of how many moved
            agentsMoved = scape.updateAgents();
            
            // Update the display
            display.repaint();
            
            // Slow down the simulation for visualization
            try {
                Thread.sleep(10);  // 10ms delay
            } catch (InterruptedException e) {
                System.out.println("Sleep interrupted");
            }
            
            iterations++;
            
            // Optional: Print progress every 100 iterations
            if (iterations % 100 == 0) {
                System.out.println("Iteration " + iterations + ": " + agentsMoved + " agents moved");
            }
        }
        
        // Close the display
        // display.dispose();  // Uncomment if LandscapeDisplay has a dispose method
        
        System.out.println("Simulation ended after " + iterations + " iterations");
        if (iterations >= maxIterations) {
            System.out.println("  (Timed out at " + maxIterations + " iterations)");
        }
        
        return iterations;
    }
    
    /**
     * Runs multiple experiments with different agent counts for the exploration
     */
    public static void runExploration() {
        int[] agentCounts = {50, 100, 150, 200, 250};
        
        System.out.println("\n=== Running Exploration Experiments ===");
        System.out.println("Agent Count\tIterations");
        System.out.println("-----------\t----------");
        
        for (int count : agentCounts) {
            int iterations = runExpt(count);
            System.out.println(count + "\t\t" + iterations);
        }
    }
    
    /**
     * Runs a custom experiment for Required Element 2
     * This experiment varies the radius size while keeping agent count constant
     */
    public static void runRadiusExperiment() {
        int agentCount = 150;  // Fixed number of agents
        int[] radii = {10, 25, 50, 75, 100};
        
        System.out.println("\n=== Running Radius Experiment (Required Element 2) ===");
        System.out.println("Agent Count: " + agentCount);
        System.out.println("Radius\t\tIterations");
        System.out.println("------\t\t----------");
        
        for (int radius : radii) {
            // Custom landscape for this experiment
            Landscape scape = new Landscape(500, 500);
            Random rand = new Random();
            
            // Place agents with the specified radius
            for (int i = 0; i < agentCount; i++) {
                double x = rand.nextDouble() * 500;
                double y = rand.nextDouble() * 500;
                SocialAgent agent = new SocialAgent(x, y, radius);
                scape.addAgent(agent);
            }
            
            // Run simulation without display for faster results
            int agentsMoved = 1;
            int iterations = 0;
            int maxIterations = 5000;
            
            while (agentsMoved > 0 && iterations < maxIterations) {
                agentsMoved = scape.updateAgents();
                iterations++;
            }
            
            System.out.println(radius + "\t\t" + iterations);
        }
    }
    
    /**
     * Runs a custom experiment with mixed agent types
     */
    public static void runMixedAgentExperiment() {
        int totalAgents = 200;
        int radius = 25;
        
        System.out.println("\n=== Running Mixed Agent Experiment ===");
        System.out.println("Total Agents: " + totalAgents + ", Radius: " + radius);
        System.out.println("Social%\t\tIterations");
        System.out.println("-------\t\t----------");
        
        // Test different ratios of Social to AntiSocial agents
        int[] socialPercentages = {0, 25, 50, 75, 100};
        
        for (int percent : socialPercentages) {
            Landscape scape = new Landscape(500, 500);
            Random rand = new Random();
            
            int numSocial = (totalAgents * percent) / 100;
            int numAnti = totalAgents - numSocial;
            
            // Add SocialAgents
            for (int i = 0; i < numSocial; i++) {
                double x = rand.nextDouble() * 500;
                double y = rand.nextDouble() * 500;
                SocialAgent agent = new SocialAgent(x, y, radius);
                scape.addAgent(agent);
            }
            
            // Add AntiSocialAgents
            for (int i = 0; i < numAnti; i++) {
                double x = rand.nextDouble() * 500;
                double y = rand.nextDouble() * 500;
                AntiSocialAgent agent = new AntiSocialAgent(x, y, radius);
                scape.addAgent(agent);
            }
            
            // Run simulation
            int agentsMoved = 1;
            int iterations = 0;
            int maxIterations = 5000;
            
            while (agentsMoved > 0 && iterations < maxIterations) {
                agentsMoved = scape.updateAgents();
                iterations++;
            }
            
            System.out.println(percent + "%\t\t" + iterations);
        }
    }

    /**
     * Main method - runs the simulation based on command line arguments
     */
    public static void main(String[] args) {
        if (args.length > 0) {
            try {
                // If a number is provided, run experiment with that many agents
                int N = Integer.parseInt(args[0]);
                System.out.println("Running experiment with " + N + " agents...");
                runExpt(N);
            } catch (NumberFormatException e) {
                System.out.println("Invalid argument. Please provide a number or use:");
                System.out.println("  java AgentSimulation <number>  - Run with N agents");
                System.out.println("  java AgentSimulation explore   - Run exploration experiments");
                System.out.println("  java AgentSimulation radius    - Run radius experiment");
                System.out.println("  java AgentSimulation mixed     - Run mixed agent experiment");
            }
        } else {
            // Default: run with 200 agents
            System.out.println("No arguments provided. Running default experiment with 200 agents...");
            runExpt(200);
        }
        
        // Handle special commands
        if (args.length > 0) {
            if (args[0].equalsIgnoreCase("explore")) {
                runExploration();
            } else if (args[0].equalsIgnoreCase("radius")) {
                runRadiusExperiment();
            } else if (args[0].equalsIgnoreCase("mixed")) {
                runMixedAgentExperiment();
            }
        }
    }
}


/*java AgentSimulation 150 - Run with 150 agents

java AgentSimulation explore - Run exploration experiments

java AgentSimulation radius - Run radius experiment

java AgentSimulation mixed - Run mixed agent experiment


runExpt(int N):

Creates a 500x500 landscape

Places N SocialAgents randomly with radius 25

Creates a visualization

Runs until agents stop moving or 5000 iterations

Returns the number of iterations

runExploration():

Runs experiments with 50, 100, 150, 200, and 250 agents

Prints a table of results for Required Element 1

runRadiusExperiment():

Custom experiment for Required Element 2

Varies the radius size while keeping agent count constant

Runs without display for faster results

runMixedAgentExperiment():

Additional experiment mixing Social and AntiSocial agents

Tests different ratios of agent types

 */