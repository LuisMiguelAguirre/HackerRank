import java.util.HashSet;
import java.util.Set;

class Node {
    int data;
    Node next;
}

public class LinkedListsDetectCycle {
    boolean hasCycle(Node head) {

        Node aux = head;
        Set<Node> set = new HashSet<Node>();
        boolean isClycled = false;

        while(aux!= null) {
            if (set.contains(aux)){
                isClycled = true;
                break;
            }
            set.add(aux);
            aux = aux.next;
        }

        return isClycled;

    }
}
