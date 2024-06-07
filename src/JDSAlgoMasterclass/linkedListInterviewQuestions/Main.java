package JDSAlgoMasterclass.linkedListInterviewQuestions;


public class Main {

    public static void main(String[] args) {
        LinkedListMine ll = new LinkedListMine();
        ll.createLL(1);
        ll.insertNode(2);
        ll.insertNode(3);
        ll.insertNode(3);
        ll.insertNode(4);
        ll.insertNode(5);
        ll.insertNode(1);
        ll.insertNode(1);
        ll.insertNode(2);
        ll.traversalLL();

        Questions q = new Questions();
        System.out.println("deleteDups is running!" + q.deleteDups(ll));
        ll.traversalLL();

        System.out.println("nthToLast = " + q.nthToLast(ll, 4).value);

    }

}
