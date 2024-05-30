package JDSAlgoMasterclass.singlyLinkedList;

public class Main {

    public static void main(String[] args) {
        SinglyLinkedList sLL = new SinglyLinkedList();

        sLL.push(1);
//        System.out.println(sLL.pop());
        sLL.push(2);
        sLL.push(3);
        sLL.push(4);
//        System.out.println(sLL.pop());

        sLL.printSLL();

        sLL.insert(100,1);

        sLL.printSLL();
        System.out.println(sLL.get(3));

        sLL.set(5,200);
        sLL.printSLL();

    }


}
