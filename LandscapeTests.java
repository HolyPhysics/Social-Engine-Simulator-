/*
file name:      LandscapeTests.java
Authors:        Ike Lage
last modified:  03/04/2025

How to run:     java -ea LandscapeTests
*/

/* Completed by Chidiebere Okafor */
public class LandscapeTests {

    public static double landscapeTests() {

        double score = 0.;

        // case 1: testing Landscape(int, int)
        {

            //TODO
            Landscape scape = new Landscape(100, 100);

            if ((scape.getHeight() == 100) && (scape.getWidth() == 100) & (scape.toString() != null) ) {
                System.out.println("Landscape constructor correctly implemented");
                score += 1.0;
            } else {
                System.out.println("Landscape constructor incorrectly implemented");
            }
        
        }

        // case 2: testing getWidth()
        {

            //TODO
            Landscape scape = new Landscape(100, 100);

            if ( scape.getWidth() == 100 ) {
                System.out.println("Landscape constructor correctly implemented");
                score += 1.0;
            } else {
                System.out.println("Landscape constructor incorrectly implemented");
            }

        }

        // case 3: testing getHeight()
        {
            
            //TODO
            Landscape scape = new Landscape(100, 100);

            if ( scape.getHeight() == 100 ) {
                System.out.println("Landscape constructor correctly implemented");
                score += 1.0;
            } else {
                System.out.println("Landscape constructor incorrectly implemented");
            }

        }

        System.out.println("Total score: " + score + "/3.0");
        return score ;
    }

    public static void main(String[] args) {

        System.out.println( landscapeTests() );
    }
}