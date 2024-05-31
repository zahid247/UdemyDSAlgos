package JDSAlgoMasterclass.circularLinkedList;

public class CSLinkedList {

    Node head;
    Node tail;
    int length;

    public CSLinkedList() {
        head = null;
        tail = null;
        this.length = 0;
    }

    public void append(int value) {
        Node node = new Node(value);
        if (head == null){
            head = node;
            tail = node;
            tail.next = head;
        } else {

            tail.next = node;
            node.next = head;
            tail = node;

        }
        this.length++;
    }

    public void prepend(int value) {
        Node node = new Node(value);
        if (head == null){
            head = node;
            tail = node;
            node.next = node;
        } else {

            node.next = head;
            head = node;
            tail.next = node;

        }
        this.length++;
    }

    @Override
    public String toString() {

        if (this.length == 0) {
            return "";
        }

        Node current = head;
        String s = "";

        for (int i = 0; i < this.length; i++) {
            s = s + current.value;
            if (current != tail) s = s + " -> ";
            current = current.next;
        }

        return s;
    }


    public boolean deleteByValue(int value) {

        if (this.length == 0) return false;

        Node current = head;

        int index = -1;
        for (int i = 0; i < this.length; i++) {

            if (current.value == value) {
                index = i;
            }
            current = current.next;
        }
        if (index == -1) return false;
        else if (this.length == 1){

            head = null;
            tail.next = null;
            tail = null;

        }
        else if (index == 0){//BEGINNING

            head = head.next;
            tail.next = head;

        } else if (index == this.length-1) {//END
            Node previousTail = head;
            for (int i = 0; i < index - 1; i++) {
                previousTail = previousTail.next;
            }

            tail = previousTail;
            previousTail.next = head;

        }else {//MIDDLE
            current = head;

            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }

            current.next = current.next.next;

        }
        this.length--;
        return true;
    }


    public int countNodes() {
        int count = 0;
        Node temp = this.head;
        if (temp == null) {
            return 0;  // Return 0 immediately if the list is empty
        }

        do {
            count++;  // Increment the count for each node
            temp = temp.next;  // Move to the next node
        } while (temp != this.head);  // Continue until the list cycles back to the head

        return count;  // Return the total count
    }


}
