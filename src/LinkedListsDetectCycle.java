import java.util.HashSet;
import java.util.Set;

class Node2 {
    int data;
    Node2 next;
}

public class LinkedListsDetectCycle {
    boolean hasCycle(Node2 head) {

        Node2 aux = head;
        Set<Node2> set = new HashSet<Node2>();
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
