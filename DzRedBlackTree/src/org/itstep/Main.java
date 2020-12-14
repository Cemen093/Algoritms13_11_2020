package org.itstep;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Tree tree = new Tree();
        Scanner scanner = new Scanner(System.in);

        int[] arr = {100, 80, 120, 70, 90, 85, 95, 83,84};

        for (int i = 0; i < arr.length; i++) {
            tree.add(arr[i], i);
        }

        System.out.println(tree.toString());
    }
}
