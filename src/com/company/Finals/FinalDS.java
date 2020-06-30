package com.company.Finals;

public class FinalDS {

    public FinalDS() {
        Q6();
        Q7();
    }

    private void Q6() {
        int x = 2;
        int[] co1 = { 5, 0, -3, 8, -4};
        int[] co2 = { -2, -4, 0, 5};
        Polynomial p1 = new Polynomial(co1);
        Polynomial p2 = new Polynomial(co2);
        Polynomial p3 = new Polynomial();
        p3.add(p1, p2);
        System.out.println(p1.toString() + " + " + p2.toString() + " = " + p3.toString());
        System.out.println("When x = " + x + " ; " + p3.toString() + " = " + p3.getValue(x));
    }

    private void Q7() {
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.addNode(258);
        linkedList.addNode(312);
        linkedList.addNode(675);
        linkedList.addNode(806);
        linkedList.addNode(910);
        System.out.println("The number in original linked list");
        linkedList.showList();

        LinkedList<Integer> specialList = new LinkedList<>();
        specialList.addNode(123);

        int count = linkedList.length();
        while (count != 0) {
            for (int i = 0; i < linkedList.length(); i++)  {
                if (specialList.addSpecialNode(linkedList.get(i))) {
                    linkedList.deleteNode(linkedList.get(i));
                }
            }
            count--;
        }

        System.out.println("The number in special linked list");
        specialList.showList();

        System.out.println("The number in original linked list");
        linkedList.showList();
    }
}
