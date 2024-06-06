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

        //get the first value to compare
        for (int i = 0; i < size-1; i++) {
            second = first.next;
            //get the second value to compare with the first
            for (int j = i+1; j < size; j++) {

                if (first.value == second.value){

                    //if here, remove the second node, by connecting the previous node to the next of the second
                    //First find the previous node from the one that needs removed
                    Node prevSecond = ll.head;
                    while (prevSecond.next != second) prevSecond = prevSecond.next;

                    Node afterSecond = second.next;

                    //perform the removal for the last element in the list
                    if (afterSecond == null || second == ll.tail){
                        prevSecond.next = null;
                        ll.tail = prevSecond;
                        ll.size--;
                        return true;
                    } else {

                        //Continue removing the second element while it is not being the last
                        prevSecond.next = afterSecond;
                        ll.size--;
                        return true;

                    }
                }
                //iterate the second node
                second = second.next;
            }
            //iterate the first node
            first = first.next;
        }
        return false;
    }

}
