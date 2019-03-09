class DoublyLinkedListNode {
        int data;
        DoublyLinkedListNode next;
        DoublyLinkedListNode prev;
}

public class ReverseDoublyLinkedList {
    static DoublyLinkedListNode reverse(DoublyLinkedListNode head) {

        DoublyLinkedListNode aux = head;
        DoublyLinkedListNode tmp = null;

        while (aux != null) {
            tmp = aux.next;

            aux.next = aux.prev;
            head = aux;
            aux.prev = tmp;
            aux = tmp;
        }

        return head;
    }
}


