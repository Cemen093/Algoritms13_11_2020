package tree;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
/*        В д/з реализовать методы обхода дерева: симметричный, прямой, обратный,
          а также метод удаления узла дерева.
          Продемонстрировать их работу в Main
*/
        Tree tree = new Tree();
        /*Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 5; i++) {
            System.out.println("Enter the value: ");
            tree.add(scanner.nextInt(), i);
        }*/
        tree.add(100, 1);
        tree.add(80, 2);
        tree.add(120, 3);
        tree.add(70, 4);
        tree.add(90, 5);
        tree.add(85, 6);
        tree.add(95, 7);
        tree.add(83, 8);
        tree.add(96, 9);
        tree.add(84, 10);


        /*System.out.println(tree.getRoot());
        System.out.println("---------------------------------------------------------\n");

        tree.bypassSymmetric();
        System.out.println("---------------------------------------------------------\n");
        tree.bypassDirect();
        System.out.println("---------------------------------------------------------\n");
        tree.bypassReverse();
        System.out.println("---------------------------------------------------------\n");*/


        tree.bypassSymmetric();
        System.out.println("---------------------------------------------------------\n");
        tree.deleteNode(95);
        System.out.println("---------------------------------------------------------\n");
        tree.deleteNode(96);
        tree.bypassSymmetric();
        System.out.println("---------------------------------------------------------\n");
        tree.deleteNode(80);
        tree.bypassSymmetric();
        System.out.println("---------------------------------------------------------\n");
        tree.deleteNode(100);
        tree.bypassSymmetric();
        System.out.println("---------------------------------------------------------\n");

    }
}
