package com.company.Tutorial7;

public class Tutorial7 {

    public Tutorial7() {
        Q1();
        Q2();
        Q3();
    }

    private void Q1() {
        BST<Integer> bst = new BST<>();
        bst.addNode(50);
        bst.addNode(30);
        bst.addNode(25);
        bst.addNode(71);
        bst.addNode(80);
        bst.addNode(99);
        bst.addNode(40);
        bst.addNode(1);
        bst.addNode(7);
        bst.addNode(5);
        bst.setOrder(BST.PREORDER);
        bst.showTree();
        bst.setOrder(BST.INORDER);
        bst.showTree();
        bst.setOrder(BST.POSTORDER);
        bst.showTree();
    }

    private void Q2() {
        BST<Character> bst = new BST<>();
        bst.addNode('F');
        bst.addNode('A');
        bst.addNode('C');
        bst.addNode('U');
        bst.addNode('L');
        bst.addNode('T');
        bst.addNode('Y');

        System.out.println("The number of elements in the tree : " + bst.getSize());
        System.out.print("The tree elements - PREORDER : ");
        bst.setOrder(BST.PREORDER);
        bst.showTree();
        System.out.print("The tree elements - INORDER : ");
        bst.setOrder(BST.INORDER);
        bst.showTree();
        System.out.print("The tree elements - POSTORDER : ");
        bst.setOrder(BST.POSTORDER);
        bst.showTree();

        System.out.println("Remove 1 Character L");
        bst.remove('L');

        System.out.println("The number of elements in the tree : " + bst.getSize());
        System.out.print("The tree elements - PREORDER : ");
        bst.setOrder(BST.PREORDER);
        bst.showTree();
        System.out.print("The tree elements - INORDER : ");
        bst.setOrder(BST.INORDER);
        bst.showTree();
        System.out.print("The tree elements - POSTORDER : ");
        bst.setOrder(BST.POSTORDER);
        bst.showTree();
    }

    private void Q3() {
        System.out.println("BST Implementation Using Array");
        ArrayBST<Character> arrayBST = new ArrayBST<>();
        arrayBST.addNode('F');
        arrayBST.addNode('A');
        arrayBST.addNode('C');
        arrayBST.addNode('U');
        arrayBST.addNode('L');
        arrayBST.addNode('T');
        arrayBST.addNode('Y');

        System.out.println("The number of elements in the tree : " + arrayBST.getSize());
        System.out.print("The tree elements - PREORDER : ");
        arrayBST.preOrder(0);
        System.out.println();
        System.out.print("The tree elements - INORDER : ");
        arrayBST.inOrder(0);
        System.out.println();
        System.out.print("The tree elements - POSTORDER : ");
        arrayBST.postOrder(0);
        System.out.println();

        System.out.println("Remove 1 Character L");
        arrayBST.removeNode('L');

        System.out.println("The number of elements in the tree : " + arrayBST.getSize());
        System.out.print("The tree elements - PREORDER : ");
        arrayBST.preOrder(0);
        System.out.println();
        System.out.print("The tree elements - INORDER : ");
        arrayBST.inOrder(0);
        System.out.println();
        System.out.print("The tree elements - POSTORDER : ");
        arrayBST.postOrder(0);
    }
}
