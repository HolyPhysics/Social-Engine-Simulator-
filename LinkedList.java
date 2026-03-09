
/**
 * Author: Chidiebere Okafor
 * Purpose of Class: Isn't it obvious?
 */
public class LinkedList<T>{

    private class Node{

        Node next; // pointer to the next node
        T data; // Contains the actual data stored in the list

        public Node( T item){
            this.next = null;
            this.data = item;
        }

        public T getData(){ // returns the value of the container field.
            return this.data;
        }

        public void setNext(Node n){ // sets next to the given node.
            this.next = n;
        }

        public Node getNext(){
            return this.next;
        }

        /* I understand that the constructor already sets the data, but why can't don't we
        have a separate set method to change that value to something else if we so desire. */

    }


    Node head;
    int size;


    public LinkedList(){

        // clear();

        this.head = null; // this creates a new list header whose value is null and whose pointer is null
        this.size = 0;
    }


    public int size(){ // returns the size of the list
        return size;
    }


    public void clear(){

        this.head = new Node(null); // this creates a new list header whose value is null and whose pointer is null
        this.size = 0;
    }


    public boolean isEmpty(){
        return (size == 0);
    }

    @Override
    public String toString() {

        String returnString = "";

        Node temp = head;

        for (int i = 0; i < size(); i++){
            returnString += temp.getData() + " ";
            temp = temp.getNext();
        }

        return returnString;
    }

    public void add(T item){

        if ( head == null){
            head = new Node(item);
        }

        Node temporaryNode = head;
        
        head = new Node(item);
        head.setNext(temporaryNode);
        size += 1; // this increments the size of the LinkedList
    }


    public T get(int index){

        Node getNode = head;

        for (int i = 0; i < index; i++){
            getNode = getNode.getNext();
            // getNode.getData();
        }

        return getNode.getData();
    }

    // public Node getNode(int index){
        
    //     Node getNode = head;

    //     for (int i = 0; i < index; i++){
    //         getNode = getNode.getNext();
    //         // getNode.getData();
    //     }

    //     return getNode;
    // }

    public void add(int index, T item){

        if ( index == 0 ){
           add(item);
        }
        else{

            Node tempOne = head;

            for (int i = 0; i < index-1; i++){
                tempOne = tempOne.getNext();
                // getNode.getData();
            }
            Node tempTwo = tempOne.getNext();
            
            Node anotherTemp = new Node(item);
            tempOne.setNext(anotherTemp);
            anotherTemp.setNext(tempTwo);
            size += 1; // this increments the size of the LinkedList
        }

    }


    public boolean contains(Object o){

        boolean returnVal = false; 

        for (int i = 0; i < size(); i++){
            
            if(get(i) == o){
                returnVal = true;
                break;
            }
        }

        return returnVal;
    }


    public T remove(){

        // Node tempOne = head.getNext();
        T returnVal = head.getData();
        head = head.getNext();
        size -=1;

        return returnVal;
    }





}