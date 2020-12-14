package org.itstep;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Tree tree = new Tree();
        Scanner scanner = new Scanner(System.in);

//        int[] arr = {100, 80, 120, 70, 90, 85, 95, 83,84};
//
//        for (int i = 0; i < arr.length; i++) {
//            tree.add(arr[i], i);
//        }
        System.out.print("How many elements do you want to add to the tree? > ");
        int numInputNode = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < numInputNode; i++) {
            System.out.print("Input key and inf > ");
            tree.add(scanner.nextShort(), scanner.nextShort());
        }
        System.out.println(tree.toString());
    }
}
