package JDSAlgoMasterclass.circularLinkedList;

public class Main {

    public static void main(String[] args) {

        CSLinkedList csll = new CSLinkedList();
        csll.append(1);
        csll.append(2);
        csll.append(3);
        csll.append(4);
        csll.append(5);
        System.out.println(csll);

//        csll.prepend(100);
//        System.out.println(csll);
//        System.out.println("length = " + csll.length);
//        System.out.println(csll.deleteByValue(1));
        System.out.println(csll.countNodes());
//        System.out.println("Tail value = " + csll.tail.value);
//        System.out.println("length = " + csll.length);

    }

}
