package ui;
import model.*;
import java.util.Scanner;
public class Main {
	public static Scanner  sc = new Scanner(System.in);
	 private static DoubleLinkedList list;
    public static void main(String[] args) {
		list = new DoubleLinkedList();
		operation();
    }
	private static void operation() {
        Sturns(0,0);
    }
	private static void Sturns(int turn,int turnindicator) {
        int decision=0;
        System.out.println(
						"1. Dar turno\n"
						+"2. Mostrar turno actual\n"
						+"3. Pasar turno\n"
						+"4. Seguir");
        decision = sc.nextInt();
		System.out.println();
        switch (decision){
            case 1:
              list.addNodeAtEnd(new Node(turnindicator+1,0));
			  turnindicator=list.getTail().getValue();
			  if(turn==0){turn=turn+1;}
            break;
			case 2:
				if(turn==0){
					 System.out.println("no hay turnos disponibles");
					  System.out.println();
				}else{
					 System.out.println(turn);
					  System.out.println();
				}
			break;
            case 3:
				if(list.getHead()!=null){
					list.findNode(list.getHead(),turn).setSkips((list.findNode(list.getHead(),turn).getSkips())+1);
					if(list.findNode(list.getHead(),turn).getSkips()==3){
						list.deleteNode(list.findNode(list.getHead(),turn));
						turn=turn+1;
						if(list.getHead()==null && list.getTail()==null){
							turn=0;
						}
					}else if(turn==list.getTail().getValue()){
						turn=list.getHead().getValue();
					}else{
						turn=list.findNode(list.getHead(),turn).getNext().getValue();
					}
				}
			break;
			case 4:
				if(list.getHead()!=null){
					list.deleteNode(list.findNode(list.getHead(),turn));
					if(list.getHead()==null && list.getTail()==null){
						turn=0;
					}else {
						turn = list.getHead().getValue();
					}
				}

			break;
        }
		Sturns(turn,turnindicator);
    }
}