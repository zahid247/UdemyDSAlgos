package JDSAlgoMasterclass.linkedListInterviewQuestions;

public class Questions {

    public boolean deleteDups(LinkedListMine ll) {

        int size = ll.size;
        if (size == 0 || size == 1) return false;
        Node first = ll.head;
        Node second;
        for (int i = 0; i < size-1; i++) {
            second = first.next;
            for (int j = i+1; j < size; j++) {
                if (first.value == second.value){
                    Node prevSecond = ll.head;
                    while (prevSecond.next != second) prevSecond = prevSecond.next;
                    Node afterSecond = second.next;
                    if (afterSecond == null || second == ll.tail){
                        prevSecond.next = null;
                        ll.tail = prevSecond;
                        ll.size--;
                        return deleteDups(ll);
                    } else {
                        prevSecond.next = afterSecond;
                        ll.size--;
                        return deleteDups(ll);
                    }
                }
                second = second.next;
            }
            first = first.next;
        }
        return false;
    }

    public Node nthToLast(LinkedListMine ll, int location){

        if (ll.size == 0) return null;

        if (ll.size == 1 || location >= ll.size) return ll.head;

        Node current = ll.head;
        for (int i = 0; i < ll.size; i++) {

            if (i == ll.size-location) return current;

            current = current.next;
        }
        return null;
    }

}
