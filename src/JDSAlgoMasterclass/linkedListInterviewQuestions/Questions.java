package JDSAlgoMasterclass.linkedListInterviewQuestions;

public class Questions {

    /*
    linkedList = 1->2->1->3
    deleteDups(linkedList)

    Output:
    1->2->3
     */
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

}
