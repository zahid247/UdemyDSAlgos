package singlyLinkedList;
public class SinglyLinkedList {
    public Node head;
    public Node tail;
    public int size;


    public void push(int nodeValue) {
        Node newNode = new Node();
        newNode.value = nodeValue;
        if (head == null){

            head = tail = newNode;
            size = 1;

        }else{

            tail.next = newNode;
            tail = newNode;
            size++;

        }

    }


    public Node pop() {

        Node last = new Node();

        if (size == 0) return null;
        else if (size == 1){
            last = head;
            head = null;
            tail = null;
            size--;
            return last;
        } else if (size == 2){
            last = tail;
            head.next = null;
            tail = head;
            size--;
            return last;
        } else {
            Node secondPrevious = head;
            //I need to capture the second last element
            for (int i=0;i<size-2;i++){
                secondPrevious = secondPrevious.next;
            }
            last = tail;
            System.out.println("last = " + last);

            secondPrevious.next=null;
            tail = secondPrevious;

            System.out.println("secondPrevious = " + secondPrevious);
            size--;
            return last;
        }
    }


    public void printSLL(){
        Node printNode = new Node();
        printNode = head;
        while (printNode != null){
            System.out.print(printNode);
            if (printNode.next != null) System.out.print(" -> ");
            printNode = printNode.next;
        }
        System.out.println();
    }


    public boolean insert(int data, int index){
        Node insert = new Node();
        insert.value = data;
        insert.next = null;

        if (index >= size) {
            push(data);
            size++;
            return true;
        } else if (index <= 0){
            insert.next = head;
            head = insert;
            size++;
            return true;
        } else {

            Node beforeInsert = head;
            Node afterInsert = head;
            for (int i = 0; i < index-1; i++) {
                beforeInsert = beforeInsert.next;
            }
            for (int i = 0; i < index; i++) {
                afterInsert = afterInsert.next;
            }

            beforeInsert.next = insert;
            insert.next = afterInsert;
            size++;
            return true;

        }
    }


    public Node get(int index) {
        Node current = head;
        if (index <= 0) return head;
        else if (index >= size) return tail;
        else {

            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            return current;
        }
    }


    public String rotate(int number) {
        int index = number; //assign index var to number
        if (number < 0) { //edge case where the number is a negative digit
            index = number + size; //if negative, add the number to the size of the List
        }
        if (index < 0 || index >= size) {//if index is outside the List return null
            return null;
        }
        if (index == 0) { //if index is 0 print out No Rotation
            return "No Rotation";
        }
        Node prevNode = head; //create a variable to find the rotation starting point
        for(int i=0; i<index-1; i++) { //loop through the List the index times to find the end point
            prevNode = prevNode.next; //find the new last element
        }
        if (prevNode == null) { //If prevNode is null, meaning that tail.next, print no rotation message
            return "No Rotation";
        }
        tail.next = head;  //the last element in the list points to the head
        head = prevNode.next; //new head becomes the node that came after the "new end" node from the for loop above
        tail = prevNode; //tail assigned to the new end point
        prevNode.next = null; //tail.next is null
        return "Success";
    }


    public boolean set(int index, int value) {

        if (index < 0 || index > size) return false;
        else if (index == 0) {
            head.value = value;
            return true;
        } else if (index == size) {
            tail.value = value;
            return true;
        } else {

            Node current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            current.value = value;
            return true;
        }
    }



    public Node remove(int index) {

        //CREATE LOCAL VARIABLES\\
        Node current = head;
        Node remove = null;

        //EDGE CASES\\
        if (head == null) {

            System.out.println("List is empty!");
            return null;

        } else if (size == 1) {

            remove = head;  //REMOVE\\
            head = tail = null;
            size--;
            return remove;

        } else if (size == 2) {

            //FILL UP HERE\\

        }

        //--------------------------------------------------------------------------\\
        if (index <= 0){                         //INDEX IS A NEGATIVE NUMBER OR A 0

            remove = head;  //REMOVE\\
            current = head.next;
            head = null;
            head = current;
            size--;

            //--------------------------------------------------------------------------\\
        } else if (index >= size) {   //INDEX IS EQUAL TO SIZE OF THE LIST OR HIGHER

            remove = tail; //REMOVE\\

            while (current.next != tail) { //assigning the second to last value
                current = current.next;
            }

            tail = current;
            tail.next = null;

            //--------------------------------------------------------------------------\\
        } else {                                 //INDEX IS IN BETWEEN HEAD AND TAIL

            Node beforeRemove = null;
            Node afterRemove = null;

            for (int i=0; i<index; i++){

                //Find the Nodes around the index Node
                //Then remove this node and assign the before.next to after
                if (i == index-1) {
                    beforeRemove = current;
                    remove = current.next;
                    afterRemove = current.next.next;
                }

                current = current.next;

            }

            beforeRemove.next = afterRemove;
            return remove;  //REMOVE\\

        }
        return null;
    }




}