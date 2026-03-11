/*
file name:      AgentTests.java
Authors:        Ike Lage
last modified:  03/04/2025

How to run:     java -ea AgentTests
*/

/* Completed by Chidiebere Okafor */
public class AgentTests {

    public static double agentTests() {

        double score = 0. ;

        SocialAgent socialAgentContainer = new SocialAgent(10,10,6);
        AntiSocialAgent antisocialAgentContainer = new AntiSocialAgent(10,10,7);

        // case 1: testing SocialAgent( double , double , int ) and AntiSocialAgent( double , double , int )
        {
            //TODO

            if ( (socialAgentContainer.getX() == 10) && (socialAgentContainer.getY() == 10) && (socialAgentContainer.getRadius() == 6) && (antisocialAgentContainer.getX() == 10) && (antisocialAgentContainer.getY() == 10) && (antisocialAgentContainer.getRadius() == 7)) {
                System.out.println("Agent constructor correctly implemented");
                score += 1.0;
            } else {
                System.out.println("Agent constructor incorrectly implemented");
            }

        }

        // case 2: testing getX() for both SocialAgent and AntiSocialAgent
        {
            //TODO
            if ( (socialAgentContainer.getX() == 10) && (antisocialAgentContainer.getX() == 10) ) {
                System.out.println("getX() method correctly implemented for the agents");
                score += 1.0;
            } else {
                System.out.println("getX() method incorrectly implemented for the agents");
            }
        }

        // case 3: testing getY() for both SocialAgent and AntiSocialAgent
        {
            //TODO
            if ( (socialAgentContainer.getY() == 10) && (antisocialAgentContainer.getY() == 10) ) {
                System.out.println("getY() method correctly implemented for the agents");
                score += 1.0;
            } else {
                System.out.println("getY() method incorrectly implemented for the agents");
            }
            
        }

        // case 4: testing getRadius() for both SocialAgent and AntiSocialAgent
        {
            //TODO
            if ( (socialAgentContainer.getRadius() == 10) && (antisocialAgentContainer.getRadius() == 10) ) {
                System.out.println("getRadius() method correctly implemented for the agents");
                score += 1.0;
            } else {
                System.out.println("getRadius() method incorrectly implemented for the agents");
            }
        }

        // case 5: testing setX() for both SocialAgent and AntiSocialAgent
        {
            //TODO
            socialAgentContainer.setX(8);
            antisocialAgentContainer.setX(10);

            if ( (socialAgentContainer.getX() == 8) && (antisocialAgentContainer.getX() == 10) ) {
                System.out.println("setX() method correctly implemented for the agents");
                score += 1.0;
            } else {
                System.out.println("setX() method incorrectly implemented for the agents");
            }
        }

        // case 6: testing setY()  for both SocialAgent and AntiSocialAgent
        {
            //TODO
            socialAgentContainer.setY(8);
            antisocialAgentContainer.setY(10);

            if ( (socialAgentContainer.getY() == 8) && (antisocialAgentContainer.getY() == 10) ) {
                System.out.println("setY() method correctly implemented for the agents");
                score += 1.0;
            } else {
                System.out.println("setY() method incorrectly implemented for the agents");
            }
        }

        // case 7: testing setRadius()  for both SocialAgent and AntiSocialAgent
        {
            //TODO
            socialAgentContainer.setRadius(8);
            antisocialAgentContainer.setRadius(10);

            if ( (socialAgentContainer.getRadius() == 8) && (antisocialAgentContainer.getRadius() == 10) ) {
                System.out.println("setRadius() method correctly implemented for the agents");
                score += 1.0;
            } else {
                System.out.println("setRadius() method incorrectly implemented for the agents");
            }
        }

        // case 8: testing getMoved()  for both SocialAgent and AntiSocialAgent
        {
            //TODO
            if ( (socialAgentContainer.getMoved() == false) && (antisocialAgentContainer.getMoved() == false) ) {
                System.out.println("getMoved() method correctly implemented for the agents");
                score += 1.0;
            } else {
                System.out.println("getMoved() method incorrectly implemented for the agents");
            }
        }

        System.out.println("Total score: " + score + "/7.0");
        return score ;
    }
    


    public static void main(String[] args) {

        System.out.println( agentTests() );
    }
}