public class Landscape{
    private int width;
    private int height;
    LinkedList<Agent> agentList;

    /**  */
    public Landscape(int width, int height){
        this.width = width;
        this.height = height;
        agentList = new LinkedList<>(); // initializes the Agent LinkedList
    }

    public int getHeight(){
        return height;
    }

    public int getWidth(){
        return width;
    }

    public void addAgent( Agent agent){
        agentList.add(agent);
    }

    @Override
    public String toString(){
        return "There are " + agentList.size() + " agents on the Landscape";
    }

    public LinkedList<Agent> getNeighbors(double a, double b, double radius){

        return null; // update with correct code later
    }

    public void  draw(Graphics g){

    }



}