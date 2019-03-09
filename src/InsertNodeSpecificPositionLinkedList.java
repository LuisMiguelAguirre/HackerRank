class SinglyLinkedListNode1 {
    int data;
    SinglyLinkedListNode1 next;

    public SinglyLinkedListNode1(int data) {

    }
}

public class InsertNodeSpecificPositionLinkedList {
    // Complete the insertNodeAtPosition function below.

    /*
     * For your reference:
     *
     * SinglyLinkedListNode {
     *     int data;
     *     SinglyLinkedListNode next;
     * }
     *
     */
    static SinglyLinkedListNode1 insertNodeAtPosition(SinglyLinkedListNode1 head, int data, int position) {

        SinglyLinkedListNode1 node = new SinglyLinkedListNode1(data);

        SinglyLinkedListNode1 aux = head;

        if (position == 0) {
            node.next = head.next;
            head = node;
        } else {
            int i = 0;
            while (aux != null) {
                if (i + 1 == position) {
                    node.next = aux.next;
                    aux.next = node;
                    break;
                }
                i++;
                aux = aux.next;
            }
        }
        return head;
    }
}


