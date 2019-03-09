class DoublyLinkedListNode1 {
    int data;
    DoublyLinkedListNode1 next;
    DoublyLinkedListNode1 prev;

    public DoublyLinkedListNode1(int data) {
    }
}

public class InsertingNodeIntoSortedDoublyLinkedList {
    static DoublyLinkedListNode1 sortedInsert(DoublyLinkedListNode1 head, int data) {

        DoublyLinkedListNode1 node = new DoublyLinkedListNode1(data);


        if (node.data < head.data) {
            head.prev = node;
            node.next = head;
            head = node;
        } else {

            DoublyLinkedListNode1 aux = head.next;

            while (aux != null) {
                if (node.data < aux.data) {
                    node.next = aux;
                    node.prev = aux.prev;
                    aux.prev.next = node;
                    aux.prev = node;
                    break;
                }

                if (aux.next == null) {
                    aux.next = node;
                    node.prev = aux;
                    aux = node;
                }
                aux = aux.next;
            }
        }
        return head;
    }


}
