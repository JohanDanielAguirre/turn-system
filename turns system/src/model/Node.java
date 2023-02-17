package model;
public class Node {
    private Node previous;
    private int value;
	private int skips;
    private Node next;
    public Node(int value,int skips) {
        this.value = value;
		this.skips=skips;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
	 public int getSkips() {
        return skips;
    }

    public void setSkips(int skips) {
        this.skips= skips;
    }
    public Node getPrevious() {
        return previous;
    }

    public void setPrevious(Node previous) {
        this.previous = previous;
    }

    @Override
    public String toString() {
        return "Node{" + value +"}";
    }
}