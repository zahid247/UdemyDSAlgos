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

    public LinkedListMine partition(LinkedListMine ll, int x){
        Node currentNode = ll.head;
        ll.tail = ll.head;
        while (currentNode != null){
            Node next = currentNode.next;
            if (currentNode.value < x){
                currentNode.next = ll.head;
                ll.head = currentNode;
            }else {
                ll.tail.next = currentNode;
                ll.tail = currentNode;
            }
            currentNode = next;
        }
        ll.tail.next = null;
        return ll;
    }

    public LinkedListMine sumLists(LinkedListMine llA, LinkedListMine llB){
        Node n1 = llA.head;
        Node n2 = llB.head;

        int carry =0;
        LinkedListMine resultLL = new LinkedListMine();

        while (n1 != null || n2 != null){
            int result = carry;
            if (n1 != null){
                result += n1.value;
                n1 = n1.next;
            }
            if (n2 != null){
                result += n2.value;
                n2 = n2.next;
            }
            resultLL.insertNode(result%10);
            carry = result / 10;
        }
        return resultLL;
    }

    //Intersection
    //Creating helper methods below
    private Node getKthNode(Node head, int k){
        Node current = head;
        while (k>0 && current != null){
            current = current.next;
            k--;
        }
        return current;
    }
    //Intersection Method
    public Node findIntersection(LinkedListMine list1, LinkedListMine list2){
        if (list1.head == null || list2.head == null) return null;
        if (list1.tail != list2.tail) return null;

        Node shorter = new Node();
        Node longer = new Node();

        if (list1.size > list2.size){
            longer = list1.head;
            shorter = list2.head;
        } else {
            longer = list2.head;
            shorter = list1.head;
        }

        longer = getKthNode(longer, Math.abs(list1.size - list2.size));

        while (shorter != longer){
            shorter = shorter.next;
            longer = longer.next;
        }
        return longer;
    }
    //Add same node
    public void addSameNode(LinkedListMine llA, LinkedListMine llB, int nodeValue){

        Node newNode = new Node();
        newNode.value = nodeValue;
        llA.tail.next = newNode;
        llA.tail = newNode;
        llB.tail.next = newNode;
        llB.tail = newNode;

    }




}
