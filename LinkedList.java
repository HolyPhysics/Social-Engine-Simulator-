import java.util.Iterator;

/**
 * Author: Chidiebere Okafor
 * Purpose of Class: Isn't it obvious?
 */
public class LinkedList<T> implements Iterable<T> {

    private class Node {
        Node next; // pointer to the next node
        T data; // Contains the actual data stored in the list

        public Node(T item) {
            this.next = null;
            this.data = item;
        }

        public T getData() { // returns the value of the container field.
            return this.data;
        }

        public void setNext(Node n) { // sets next to the given node.
            this.next = n;
        }

        public Node getNext() {
            return this.next;
        }
    }

    // Inner class for Iterator
    private class LLIterator implements Iterator<T> {
        private Node current;

        public LLIterator(Node head) {
            this.current = head;
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            T data = current.getData();
            current = current.getNext();
            return data;
        }

        @Override
        public void remove() {
            // Optional - do nothing
        }
    }

    Node head;
    int size;

    public LinkedList() {
        this.head = null;
        this.size = 0;
    }

    public int size() { // returns the size of the list
        return size;
    }

    public void clear() {
        this.head = null; // Fixed: set to null, not new Node(null)
        this.size = 0;
    }

    public boolean isEmpty() {
        return (size == 0);
    }

    @Override
    public String toString() {
        if (head == null) {
            return "";
        }
        
        String returnString = "";
        Node temp = head;

        for (int i = 0; i < size(); i++) {
            returnString += temp.getData() + " ";
            temp = temp.getNext();
        }

        return returnString.trim(); // Remove trailing space
    }

    public void add(T item) {
        if (head == null) {
            head = new Node(item);
        } else {
            Node temporaryNode = head;
            head = new Node(item);
            head.setNext(temporaryNode);
        }
        size += 1;
    }

    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        
        Node getNode = head;
        for (int i = 0; i < index; i++) {
            getNode = getNode.getNext();
        }
        return getNode.getData();
    }

    public void add(int index, T item) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        
        if (index == 0) {
            add(item);
        } else {
            Node tempOne = head;
            for (int i = 0; i < index - 1; i++) {
                tempOne = tempOne.getNext();
            }
            Node tempTwo = tempOne.getNext();
            
            Node anotherTemp = new Node(item);
            tempOne.setNext(anotherTemp);
            anotherTemp.setNext(tempTwo);
            size += 1;
        }
    }

    public boolean contains(Object o) {
        Node current = head;
        while (current != null) {
            if (o == null) {
                if (current.getData() == null) {
                    return true;
                }
            } else if (o.equals(current.getData())) { // Fixed: use .equals() instead of ==
                return true;
            }
            current = current.getNext();
        }
        return false;
    }

    public T remove() {
        if (head == null) {
            return null;
        }
        
        T returnVal = head.getData();
        head = head.getNext();
        size -= 1;
        return returnVal;
    }

    public T remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        
        if (index == 0) {
            return remove();
        }
        
        Node prev = head;
        for (int i = 0; i < index - 1; i++) {
            prev = prev.getNext();
        }
        
        Node toRemove = prev.getNext();
        T returnVal = toRemove.getData();
        prev.setNext(toRemove.getNext());
        size -= 1;
        
        return returnVal;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof LinkedList)) {
            return false;
        }
        
        LinkedList<T> otherList = (LinkedList<T>) o;
        
        if (this.size != otherList.size) {
            return false;
        }
        
        Node thisCurrent = this.head;
        Node otherCurrent = otherList.head;
        
        while (thisCurrent != null) {
            T thisData = thisCurrent.getData();
            Object otherData = otherCurrent.getData();
            
            if (thisData == null) {
                if (otherData != null) {
                    return false;
                }
            } else if (!thisData.equals(otherData)) {
                return false;
            }
            
            thisCurrent = thisCurrent.getNext();
            otherCurrent = otherCurrent.getNext();
        }
        
        return true;
    }

    @Override
    public Iterator<T> iterator() {
        return new LLIterator(this.head);
    }
}