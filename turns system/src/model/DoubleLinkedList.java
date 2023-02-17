package model;
public class DoubleLinkedList {
    private Node head;
    private Node tail;
	  public void addNodeAtEnd(Node node) {
        if (tail == null) {
            tail = node;
            head = node;
        } else {
            addNodeAtEnd(node,0);
        }
    }
    private void addNodeAtEnd(Node node, int overcharge) {
        head.setNext(node);
        node.setPrevious(tail);
        node.setNext(tail);
        tail.setPrevious(node);
        head = node;
		tail.setNext(head);
		head.setPrevious(tail);
    }
    public Node findNode(Node pointer, int value){
          if(pointer==null){return null;}
          else {
              if (pointer.getValue() == value) return pointer;
              if (pointer != head && pointer.getValue() != value) { // hace la recursion cuando no encunetra al nodo
                  findNode(pointer.getNext(), value);
              }
          }
        return pointer; // null cuando no lo encuentra
    }
	public void  deleteNode(Node node){
          if( node!=null &&node.getNext()==node ){
              tail=null;
              head=null;
          }else{
              if(node.getValue()==tail.getValue()){
                  Node node1=tail.getNext();
                  tail.getPrevious().setNext(tail.getNext());
                  tail.getNext().setPrevious(tail.getPrevious());
                  tail=node1;
              }else if(node.getValue()==head.getValue()){
                  Node node1=head.getPrevious();
                  head.getPrevious().setNext(head.getNext());
                  head.getNext().setPrevious(head.getPrevious());
                  head=node1;
              }else {
                  node.getPrevious().setNext(node.getNext());
                  node.getNext().setPrevious(node.getPrevious());
              }
          }
	}
	
	public Node getHead(){
		return head;
	}
	public Node getTail(){
		return tail;
	}
}