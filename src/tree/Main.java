package tree;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Tree tree = new Tree();
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 5; i++) {
            System.out.println("Enter the value: ");
            tree.add(scanner.nextInt(), i);
        }

        System.out.println(tree.getRoot());

        System.out.println(tree.checkKey(52));

    }
}
