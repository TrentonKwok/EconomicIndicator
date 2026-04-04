public class AVLTree<Key extends Comparable<Key>, Value>{
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
        Node T3 = x.right;

        x.right = y;
        y.left = T3;

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

        if(bf > 1 && balanceFactor(x.left) >= 0){      // LL
            return rightRotate(x);
        }

        if(bf < -1 && balanceFactor(x.right) <= 0){   // RR
            return leftRotate(x);
        }

        if(bf > 1 && balanceFactor(x.left) < 0){   // LR
            x.left = leftRotate(x.left);
            return rightRotate(x);
        }

        if(bf < -1 && balanceFactor(x.right) > 0){  // RL
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

}
