package JDSAlgoMasterclass.stacks;

public class MyStack {

    //Class Node - inner
    class Node{
        int value;
        Node next;

        public Node (int value){
            this.value = value;
            this.next = null;
        }
    }//inner class ends here

    private Node top;
    private int height;

    public MyStack(int value){

        this.top = new Node(value);
        this.height = 1;

    }

    public void push(int value){
        Node addedNode = new Node(value);
        if (this.height == 0) {
            new MyStack(value);
        } else {
            addedNode.next = this.top;
            this.top = addedNode;
            this.height++;
        }
    }




}
