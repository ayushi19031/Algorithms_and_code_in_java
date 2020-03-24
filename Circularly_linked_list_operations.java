
import java.util.*;

public class DLL{
    Node head;
    public static class Node{
        int data; 
        Node prev; Node next;
        Node (int d){this.data = d;}
    }
    public static void Insert_Node(Node head, int x, Node pointer){
 
    	Node px = pointer.next;
        Node inserted = new Node(x);
        pointer.next = inserted;
        inserted.next = px;
      
    }
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        String a__ = scan.nextLine();
        int a = Integer.parseInt(a__);
        Node head = new Node(1); Node ptr1 = head;
        head.next = head;
        for (int i = 0; i < a; i++){
            String b__ = scan.nextLine();
            String[] b_ = b__.split(" ");
            int[] b = new int[b_.length];
            for (int j = 0; j < b_.length; j++){b[j] = Integer.parseInt(b_[j]);}
            if (b[0] == 3){System.out.println(ptr1.data);}
            else if (b[0] == 2){ptr1 = ptr1.next;}
            else if (b[0] == 1){Insert_Node(head, b[1], ptr1);}
        }
    }
     
}