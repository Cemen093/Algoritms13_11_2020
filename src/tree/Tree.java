package tree;

public class Tree {

    private static class Node {
        int key;
        Object inf;
        Node left;
        Node right;

        /*public Node(int key){
            this.key = key;
        }*/

        public Node(int key, Object inf) {
            this.key = key;
            this.inf = inf;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "key=" + key +
                    ", inf=" + inf +
                    ", left=" + ((left == null) ? null : left.key) +
                    ", right=" + ((right == null) ? null : right.key)  +
                    '}';
        }
    }

    private Node root;

    public Node getRoot() {
        return root;
    }

    public void add(int key, Object inf) {
        //метод добавляет элемент метода по ключу
        if (root == null) {
            root = new Node(key, inf);
        } else {

            Node parent = findParentToNode(root, key);
            if (key > parent.key) {
                parent.right = new Node(key, inf);
            } else {
                parent.left = new Node(key, inf);
            }
        }
    }

    public Node findParentToNode(Node current, int key) {
        //мето ищет родителя для нового элемента
        Node tmp;
        if (key > current.key) {tmp = current.right;}
        else {tmp = current.left;}

        if (tmp == null) {return current;}
        else {return findParentToNode(tmp, key);}

        /*if (key < current.key){
            if (current.left == null){return current;}
            else {return findNode(current.left, key);}
        }
        else {
            if (current.right == null){return current;}
            else {return findNode(current.right, key);}
        }*/
    }

    public Node find(Node current, int key) {
        //метод ищет и возвращает елемент по ключу
        if (current == null) {return null;}
        if (current.key == key) {return current;}
        return (key < current.key) ? find(current.left, key) : find(current.right, key);
        /*if (key < current.key) {
            return find(current.left, key);
        } else if (key < current.key) {
            return find(current.right, key);
        }
        return current;*/
    }

    public boolean checkKey(int key) {
        //метод проверяет наличие ключа в дереве
        return find(root, key) != null;
    }

    public void bypassSymmetric(){
        bypassSymmetric(root);
    }
    private void bypassSymmetric(Node current){
        if (current != null){
            bypassSymmetric(current.left);
            System.out.println(current);
            bypassSymmetric(current.right);
        }
    }

    public void bypassDirect(){
        bypassDirect(root);
    }

    private void bypassDirect(Node current){
        if (current != null){
            System.out.println(current);
            bypassDirect(current.left);
            bypassDirect(current.right);
        }
    }

    public void bypassReverse(){
        bypassReverse(root);
    }

    private void bypassReverse(Node current){
        if (current != null){
            bypassReverse(current.left);
            bypassReverse(current.right);
            System.out.println(current);
        }
    }

    public Node findParentNode(Node current, int key) {
        //мето ищет родителя элемента
        Node tmp;
        if (key > current.key) {tmp = current.right;}
        else {tmp = current.left;}

        if (tmp.key == key) {return current;}
        else {return findParentNode(tmp, key);}
    }

    public void deleteNode(int key){
        if (root == null) {return;}
        if (!checkKey(key)) {return;}

        if (root.key == key) {
            root = null;
            return;
        }

        Node parent = findParentNode(root, key);
        Node element = find(root, key);
        boolean side = element.key > parent.key;

        if (element.left == null && element.right == null){
            if (side){ parent.right = null;}
            else {parent.left = null;}
            return;
        }

        if (element.left == null || element.right == null){
            Node tmp = (element.left == null) ? element.right : element.left;
            if (side){ parent.right = tmp;}
            else {parent.left = tmp;}
            return;
        }

        Node newEl = element.right;
        while (newEl.left != null){
            newEl = newEl.left;
        }
        findParentNode(element.right, newEl.key).left = newEl.right;
        newEl.right = element.right;
        if (side){ parent.right = newEl;}
        else {parent.left = newEl;}
        newEl.left = element.left;
    }
}
