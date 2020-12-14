package org.itstep;

public class Tree {
    @Override
    public String toString() {
        return "Tree{" +
                "root=" + root +
                '}';
    }

    private static class Node{
        int key;
        Object inf;
        Node left;
        Node right;
        boolean isRed;
        Node parent;

        public Node(int key){
            this.key = key;
        }

        public Node(int key, Object inf){
            this.key=key;
            this.inf=inf;
            this.isRed = true;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "key=" + key +
                    ", inf=" + inf +
                    ", isRed=" + isRed +
                    ",\n left=" + left +
                    ",\n right=" + right +
                    '}';
        }
    }

    private Node getGrandfather(Node n){
        if (n.parent != null){
            return n.parent.parent;
        } else {
            return null;
        }
    }

    private Node getUncle(Node n){
        Node g = n.parent.parent;
        if (g.left == n.parent){
            return g.right;
        } else {
            return g.left;
        }
    }

    private void case1(Node n){
        if (n == root){
            n.isRed = false;
        } else {
            case2(n);
        }
    }

    private void case2(Node n){
        if (n.parent.isRed){
            case3(n);
        }
    }

    private void case3(Node n) {
        Node u = getUncle(n);
        if (u != null && u.isRed){
            u.parent.isRed = true;
            n.parent.isRed = false;
            u.isRed = false;
            case1(u.parent);
        } else {
            case4(n);
        }
    }

    private void case4(Node n) {
        Node g = getGrandfather(n);
        Node p = n.parent;
        if (n == n.parent.left && g.right == n.parent){
            Node tmp = n.right;

            g.right = n;
            n.parent = g;

            n.right = p;
            p.parent = n;

            p.left = tmp;
            if (tmp != null){tmp.parent = p;}
        }
        if (n == n.parent.right && g.left == n.parent){

            Node tmp = n.left;

            g.left = n;
            n.parent = g;

            n.left = p;
            p.parent = n;

            p.right = tmp;
            if (tmp != null){tmp.parent = p;}
        }
        case5(p);
    }

    private void case5(Node n) {
        Node p = n.parent;
        Node g = getGrandfather(n);
        Node gg = getGrandfather(p);

        if (g.right == p){
            p.isRed = false;
            g.isRed = true;

            Node tmp = p.left;

            p.left = g;
            g.parent = p;

            g.right = tmp;
            if (tmp != null){tmp.parent = g;}

            if (gg == null){
                root = p;
            }
            else {
                if (gg.right == g){
                    gg.right = p;
                } else {
                    gg.left = p;
                }
                p.parent = gg;
            }
        } else {
            p.isRed = false;
            g.isRed = true;

            Node tmp = p.right;

            p.right = g;
            g.parent = p;

            g.left = tmp;
            if (tmp != null){tmp.parent = g;}

            if (gg == null){
                root = p;
            }
            else {
                if (gg.left == g){
                    gg.left = p;
                } else {
                    gg.right = p;
                }
                p.parent = gg;
            }
        }
    }

    private Node root;

    public Node getRoot() {
        return root;
    }

    public void add(int key, Object inf){
        Node n;
        if (root == null){
            root = new Node(key, inf);
            n = root;
        }
        else{
            Node parent = findNode(root, key);
            n = new Node(key, inf);
            if (key < parent.key){
                parent.left = n;
                //parent.left.perent = parent;
            }
            else {
                parent.right = n;
                //parent.right.perent = parent;
            }
            n.parent = parent;
        }
        case1(n);
    }

    public Node findNode(Node current, int key){
        if (key < current.key){
            if (current.left == null){return current;}
            else {return findNode(current.left, key);}
        }
        else {
            if (current.right == null){return current;}
            else {return findNode(current.right, key);}
        }
    }
    public Node find(Node current, int key){
        if (current != null) {
            if (key < current.key) {
                return find(current.left, key);
            } else if (key > current.key){
                return find(current.right, key);
            }
            return current;
        }
        else {
            return null;
        }
    }

    public boolean checkKey(int key){
        Node tmp = find(root, key);
        return tmp != null;
    }
}