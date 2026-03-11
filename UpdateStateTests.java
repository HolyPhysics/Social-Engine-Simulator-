/*
file name:      UpdateStateTests.java
Authors:        Ike Lage
last modified:  03/04/2025

How to run:     java -ea UpdateStateTests
*/

public class UpdateStateTests {

    public static double updateStateTests() {

        double score = 0.;

        // case 1: testing updateState() doesn't move the agent for a social agent when it has many neighbors
        {
            // set up
            // Make a landscape of 100x100
            Landscape scape = new Landscape(100, 100);
            
            // Make a social agent at x=10, y=10 with radius of 5 called a1
            SocialAgent a1 = new SocialAgent(10, 10, 5);
            
            // Add a1 to the landscape
            scape.addAgent(a1);
            
            // Make 4 Social Agents within a radius of 5 of the agent
            // These agents are within 5 units of (10,10)
            SocialAgent neighbor1 = new SocialAgent(12, 10, 5);  // 2 units away
            SocialAgent neighbor2 = new SocialAgent(10, 12, 5);  // 2 units away
            SocialAgent neighbor3 = new SocialAgent(8, 10, 5);   // 2 units away
            SocialAgent neighbor4 = new SocialAgent(10, 8, 5);   // 2 units away
            
            scape.addAgent(neighbor1);
            scape.addAgent(neighbor2);
            scape.addAgent(neighbor3);
            scape.addAgent(neighbor4);
            
            // verify
            // update the agent's state
            a1.updateState(scape);
            
            // test
            // Check that a1 didn't move (with many neighbors, SocialAgent shouldn't move)
            if ((a1.getX() == 10) && (a1.getY() == 10) && (a1.getMoved() == false)) {
                System.out.println("1: SocialAgent with many neighbors - correct (didn't move)");
                score += 0.75;
            } else {
                System.out.println("1: SocialAgent with many neighbors - FAILED (should not move)");
            }
        }

        // case 2: testing updateState() moves the agent for an antisocial agent when it has many neighbors
        {
            // set up
            // Make a landscape of 100x100
            Landscape scape = new Landscape(100, 100);
            
            // Make an antisocial agent at x=10, y=10 with radius of 5 called a1
            AntiSocialAgent a1 = new AntiSocialAgent(10, 10, 5);
            
            // Add a1 to the landscape
            scape.addAgent(a1);
            
            // Make 4 Social Agents within a radius of 5 of the agent
            // These agents are within 5 units of (10,10)
            SocialAgent neighbor1 = new SocialAgent(12, 10, 5);
            SocialAgent neighbor2 = new SocialAgent(10, 12, 5);
            SocialAgent neighbor3 = new SocialAgent(8, 10, 5);
            SocialAgent neighbor4 = new SocialAgent(10, 8, 5);
            
            scape.addAgent(neighbor1);
            scape.addAgent(neighbor2);
            scape.addAgent(neighbor3);
            scape.addAgent(neighbor4);
            
            // verify
            // update the agent's state
            a1.updateState(scape);
            
            // test
            // Check that a1 did move (with many neighbors, AntiSocialAgent should move)
            // Note: We can't guarantee both x and y change, just that at least one changed
            if ((a1.getX() != 10 || a1.getY() != 10) && (a1.getMoved() == true)) {
                System.out.println("2: AntiSocialAgent with many neighbors - correct (moved)");
                score += 0.75;
            } else {
                System.out.println("2: AntiSocialAgent with many neighbors - FAILED (should move)");
            }
        }

        // case 3: testing updateState() moves the agent for a social agent when it has few neighbors
        {
            // set up
            // Make a landscape of 100x100
            Landscape scape = new Landscape(100, 100);
            
            // Make a social agent at x=10, y=10 called a1
            SocialAgent a1 = new SocialAgent(10, 10, 5);
            
            // Add a1 to the landscape
            scape.addAgent(a1);
            
            // No other agents added - a1 has few neighbors (just itself)
            
            // verify
            // update the agent's state
            a1.updateState(scape);
            
            // test
            // Check that a1 did move (with few neighbors, SocialAgent should move)
            if ((a1.getX() != 10 || a1.getY() != 10) && (a1.getMoved() == true)) {
                System.out.println("3: SocialAgent with few neighbors - correct (moved)");
                score += 0.75;
            } else {
                System.out.println("3: SocialAgent with few neighbors - FAILED (should move)");
            }
        }

        // case 4: testing updateState() doesn't move the agent for an antisocial agent when it has few neighbors
        {
            // Setup
            // Make a landscape of 100x100
            Landscape scape = new Landscape(100, 100);
            
            // Make an antisocial agent at x=10, y=10 called a1
            AntiSocialAgent a1 = new AntiSocialAgent(10, 10, 5);
            
            // Add a1 to the landscape
            scape.addAgent(a1);
            
            // No other agents added - a1 has few neighbors (just itself)
            
            // Verify
            // update the agent's state
            a1.updateState(scape);
            
            // test
            // Check that a1 didn't move (with few neighbors, AntiSocialAgent shouldn't move)
            if ((a1.getX() == 10) && (a1.getY() == 10) && (a1.getMoved() == false)) {
                System.out.println("4: AntiSocialAgent with few neighbors - correct (didn't move)");
                score += 0.75;
            } else {
                System.out.println("4: AntiSocialAgent with few neighbors - FAILED (should not move)");
            }
        }

        System.out.println("Total score: " + score + "/3.0");
        return score;
    }

    public static void main(String[] args) {
        updateStateTests();
    }
}