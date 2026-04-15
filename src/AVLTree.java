import java.util.Iterator;

public class AVLTree<Key extends Comparable<Key>, Value> implements Iterable<Value>{
    private Node root;
    private int N;

    private class Node{
        Key key;
        Value value;
        Node left;
        Node right;
        int height;

        public Node(Key key, Value value){
            this.key = key;
            this.value = value;
            this.height = 1;
        }
    }

    public boolean isBalanced(){
        return isBalanced(root);
    }

    private boolean isBalanced(Node x){
        if(x == null){
            return true;
        }

        int bf = balanceFactor(x);

        if(bf < -1 || bf > 1){
            return false;
        }

        return isBalanced(x.left) && isBalanced(x.right);
    }

    public int size(){
        return N;
    }

    public boolean isEmpty(){
        return N == 0;
    }

    private int height(Node x){
        if(x == null){
            return 0;
        }
        return x.height;
    }

    private void updateHeight(Node x){
        x.height = Math.max(height(x.left), height(x.right)) + 1;
    }

    private int balanceFactor(Node x){
        if(x == null){
            return 0;
        }
        return height(x.left) - height(x.right);
    }

    private Node rightRotate(Node y){
        Node x = y.left;
        Node T2 = x.right;

        x.right = y;
        y.left = T2;

        updateHeight(y);
        updateHeight(x);

        return x;
    }

    private Node leftRotate(Node y){
        Node x = y.right;
        Node T2 = x.left;

        x.left = y;
        y.right = T2;

        updateHeight(y);
        updateHeight(x);

        return x;
    }

    private Node rebalance(Node x){
        if(x == null){
            return null;
        }

        updateHeight(x);
        int bf = balanceFactor(x);

        if(bf > 1 && balanceFactor(x.left) >= 0){           // LL
            return rightRotate(x);
        }

        if(bf < -1 && balanceFactor(x.right) <= 0){         // RR
            return leftRotate(x);
        }

        if(bf > 1 && balanceFactor(x.left) < 0){            // LR
            x.left = leftRotate(x.left);
            return rightRotate(x);
        }

        if(bf < -1 && balanceFactor(x.right) > 0){          // RL
            x.right = rightRotate(x.right);
            return leftRotate(x);
        }

        return x;
    }

    public void put(Key key, Value value){
        root = put(root, key, value);
    }

    private Node put(Node x, Key key, Value value){
        if(x == null){
            N++;
            return new Node(key, value);
        }
        int cmp = key.compareTo(x.key);

        if(cmp < 0){
            x.left = put(x.left, key, value);
        }

        else if(cmp > 0){
            x.right = put(x.right, key, value);
        }

        else{
            x.value = value;
            return x;
        }

        return rebalance(x);
    }

    public Value get(Key key){
        Node x = root;

        while(x != null){
            int cmp = key.compareTo(x.key);

            if(cmp < 0){
                x = x.left;
            }else if(cmp > 0){
                x = x.right;
            }else {
                return x.value;
            }
        }
        return null;
    }

    public boolean contains(Key key){
        return get(key) != null;
    }

    public Key min(){
        if(root == null){
            return null;
        }

        return min(root).key;
    }

    private Node min(Node x){
        while(x.left != null){
            x = x.left;
        }
        return x;
    }

    public Key max(){
        if(root == null){
            return null;
        }
        return max(root).key;
    }

    private Node max(Node x){
        while(x.right != null){
            x = x.right;
        }
        return x;
    }

    public void delete(Key key) {
        root = delete(root, key);
    }

    private Node delete(Node x, Key key) {
        if (x == null){
            return null;
        }

        int cmp = key.compareTo(x.key);

        if(cmp < 0){
            x.left = delete(x.left, key);
        }

        else if(cmp > 0){
            x.right = delete(x.right, key);
        }

        else{
            if(x.left == null && x.right == null){
                N--;
                return null;
            }

            if(x.left == null){
                N--;
                return x.right;
            }

            if (x.right == null){
                N--;
                return x.left;
            }

            Node successor = min(x.right);
            x.key = successor.key;
            x.value = successor.value;
            x.right = delete(x.right, successor.key);
        }

        return rebalance(x);
    }

    public int height(){
        return height(root);
    }

    public void inorder(){
        inorder(root);
        System.out.println();
    }

    private void inorder(Node x){
        if(x == null){
            return;
        }
        inorder(x.left);
        System.out.print(x.key + " ");
        inorder(x.right);
    }

    public void preorder(){
        preorder(root);
        System.out.println();
    }

    private void preorder(Node x){
        if (x == null){
            return;
        }
        System.out.print(x.key + " ");
        preorder(x.left);
        preorder(x.right);
    }

    public void postorder(){
        postorder(root);
        System.out.println();
    }

    private void postorder(Node x){
        if(x == null){
            return;
        }
        postorder(x.left);
        postorder(x.right);
        System.out.print(x.key + " ");
    }

    public String printTree(){
        return printTree(root, 0);
    }

    private String printTree(Node x, int level){
        if(x == null){
            return "";
        }

        String result = "";
        result = result + printTree(x.left, level + 1);

        for (int i = 0; i < level; i++){
            result = result + "              ";
        }
        result = result + "--| " + x.key + "\n";

        result = result + printTree(x.right, level + 1);

        return result;
    }

    public Key floor(Key key){
        Node x = floor(root, key);
        if(x == null){
            return null;
        }
        return x.key;
    }

    private Node floor(Node x, Key key){
        if(x == null){
            return null;
        }

        int cmp = key.compareTo(x.key);

        if(cmp == 0){
            return x;
        }

        if(cmp < 0){
            return floor(x.left, key);
        }

        Node t = floor(x.right, key);
        if(t != null){
            return t;
        }
        return x;
    }

    public Key ceiling(Key key){
        Node x = ceiling(root, key);
        if(x == null){
            return null;
        }
        return x.key;
    }

    private Node ceiling(Node x, Key key){
        if(x == null){
            return null;
        }

        int cmp = key.compareTo(x.key);

        if(cmp == 0){
            return x;
        }

        if(cmp > 0){
            return ceiling(x.right, key);
        }

        Node t = ceiling(x.left, key);
        if(t != null){
            return t;
        }
        return x;
    }

    public void deleteMin(){
        if(root == null){
            return;
        }
        root = deleteMin(root);
    }

    private Node deleteMin(Node x){
        if(x.left == null){
            N--;
            return x.right;
        }
        x.left = deleteMin(x.left);
        return rebalance(x);
    }

    public void deleteMax(){
        if(root == null){
            return;
        }
        root = deleteMax(root);
    }

    private Node deleteMax(Node x){
        if(x.right == null){
            N--;
            return x.left;
        }
        x.right = deleteMax(x.right);
        return rebalance(x);
    }


    public Iterator<Value> iterator() {   // The default would be InorderIterator
        return new InorderIterator();
    }

    private class InorderIterator implements Iterator<Value> {
        private SequenceList<Node> stack;

        public InorderIterator() {
            stack = new SequenceList<>(height() + 1);
            pushLeft(root);
        }

        private void pushLeft(Node x) {
            while (x != null) {
                stack.insert(x);
                x = x.left;
            }
        }

        public boolean hasNext() {
            return stack.length() > 0;
        }

        public Value next() {
            Node x = stack.remove(stack.length() - 1);
            pushLeft(x.right);
            return x.value;
        }
    }

    private class PreorderIterator implements Iterator<Value>{
        private SequenceList<Node> stack;

        public PreorderIterator(){
            stack = new SequenceList<>(height() + 1);
            if(root != null){
                stack.insert(root);
            }
        }

        public boolean hasNext(){
            return stack.length() > 0;
        }

        public Value next(){
            Node x = stack.remove(stack.length() - 1);

            if(x.right != null){
                stack.insert(x.right);
            }
            if(x.left != null){
                stack.insert(x.left);
            }

            return x.value;
        }
    }

    public Iterator<Value> preorderIterator(){
        return new PreorderIterator();
    }

    public Iterator<Value> postorderIterator(){
        return new PostorderIterator();
    }

    private class PostorderIterator implements Iterator<Value>{
        private SequenceList<Value> list;
        private int cursor;

        public PostorderIterator(){
            list = new SequenceList<>(N + 1);
            cursor = 0;
            buildList(root);
        }

        private void buildList(Node x){
            if(x == null){
                return;
            }
            buildList(x.left);
            buildList(x.right);
            list.insert(x.value);
        }

        public boolean hasNext(){
            return cursor < list.length();
        }

        public Value next(){
            Value v = list.get(cursor);
            cursor++;
            return v;
        }
    }

}



