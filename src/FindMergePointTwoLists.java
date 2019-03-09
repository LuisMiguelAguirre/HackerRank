import java.util.HashSet;
import java.util.Set;

class SinglyLinkedListNode {
    int data;
    SinglyLinkedListNode next;
}

public class FindMergePointTwoLists {
// Complete the findMergeNode function below.

    /*
     * For your reference:
     *
     * SinglyLinkedListNode {
     *     int data;
     *     SinglyLinkedListNode next;
     * }
     *
     */
    static int findMergeNode(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
        SinglyLinkedListNode aux = head1;

        Set<SinglyLinkedListNode> set = new HashSet<SinglyLinkedListNode>();

        int mergedValue = 0;

        while (aux != null) {
            set.add(aux);
            aux = aux.next;
        }

        aux = head2;
        while (aux != null) {
            if (set.contains(aux)) {
                mergedValue = aux.data;
                break;
            }
            aux = aux.next;
        }

        return mergedValue;
    }
}


