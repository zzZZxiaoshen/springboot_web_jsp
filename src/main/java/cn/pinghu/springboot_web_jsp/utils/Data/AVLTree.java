package cn.pinghu.springboot_web_jsp.utils.Data;


import java.util.ArrayList;

/**
 * 平衡二叉树 数据结构
 * @author shenkai
 * @date 2019/5/28
 */
public class AVLTree <K extends  Comparable,V> {

    private class Node {
        private K key;
        private V value;
        private Node left, right;
        private int height; // 用于计算平衡因子

        public Node(K key, V value, Node left, Node right) {
            this.key = key;
            this.value = value;
            this.left = left;
            this.right = right;
            this.height = 1;
        }

        public Node(K key, V value) {
            this(key, value, null, null);
        }

        public Node() {
            this(null, null, null, null);
        }

        @Override
        public String toString() {
            return "Node{" +
                    "key=" + key +
                    ", value=" + value +
                    ", left=" + left +
                    ", right=" + right +
                    ", height=" + height +
                    '}';
        }
    }

    private Node root;
    private int size;

    public  int getSize() {
        return size;
    }

    public boolean contain(K key) {
        return getNode(key, root) != null;
    }

    // 获得节点node的高度
    public int getHeight(Node node) {
        if (node == null) {
            return 0;
        }
        return node.height;
    }
    // 获得节点node的平衡因子
    public int getbalanceFactory(Node node) {
        if (node == null) {
            return 0;
        }
        return getHeight(node.left) - getHeight(node.right);
    }


    // 判断该二叉树是否是一棵二分搜索树
    public boolean isBST(){
        ArrayList<K> array = new ArrayList<>();
        inOrder(root,array);
        for (int i = 1; i < getSize(); i++) {
            if (array.get(i - 1).compareTo(array.get(i)) > 0) {
                return false;
            }
        }
        return true;
    }

    private void inOrder(Node node, ArrayList<K> array) {
        if (node == null) {
            return ;
        }
        inOrder(node.left, array);
        array.add(node.key);
        inOrder(node.right, array);
    }

    // 判断该二叉树是否是一棵平衡二叉树
    public boolean isBanlanceAvl() {
        return isBanlanceAvl(root);
    }

    private boolean isBanlanceAvl(Node node) {
        if (node == null) {
            return true;
        }
        int banlance = getbalanceFactory(node);
        if (Math.abs(banlance) > 1 ) {
            return false;
        }
        return isBanlanceAvl(node.left)
                && isBanlanceAvl(node.right);
    }


    // 对节点y进行向右旋转操作，返回旋转后新的根节点x
    //        y                              x
    //       / \                           /   \
    //      x   T4     向右旋转 (y)        z     y
    //     / \       - - - - - - - ->    / \   / \
    //    z   T3                       T1  T2 T3 T4
    //   / \
    /**
    * 右旋转
    */
    public Node rightRotate(Node y) {
        Node x = y.left;
        Node T3 = x.right;

        x.right = y;
        y.left = T3;
        // 维护高度
        y.height = Math.max(getHeight(y.left), getHeight(y.right)) + 1;
        x.height = Math.max(getHeight(x.left), getHeight(y.right)) + 1;
        return x;
    }

    // 对节点y进行向左旋转操作，返回旋转后新的根节点x
    //    y                             x
    //  /  \                          /   \
    // T1   x      向左旋转 (y)       y     z
    //     / \   - - - - - - - ->   / \   / \
    //   T2  z                     T1 T2 T3 T4
    //      / \
    //     T3 T4
    /**
     * 左旋转
     */
    public Node leftRotate(Node y) {
        Node x = y.right;
        Node T2 = x.left;

        // 向左旋转
        x.left=y;
        y.right = T2;
        // 维护高度
        y.height = Math.max(getHeight(y.left), getHeight(y.right)) + 1;
        x.height = Math.max(getHeight(x.left), getHeight(y.right)) + 1;
        return x;
    }

    public void add(K key, V value) {
        root = add(key ,value ,root);
    }

    private Node add(K key, V value, Node node) {
        if (node == null) {
            size++;
            return new Node(key,value);
        }
        if (node.key.compareTo(key) > 0) {
             node.left = add(key, value, node.left);
        } else if (node.key.compareTo(key) < 0) {
            node.right = add(key, value, node.right);
        } else {
            node.value = value;
        }
        // 维护高度
        node.height = 1 + Math.max(getHeight(node.left), getHeight(node.right));

        // 计算平衡因子
        int banlance = getbalanceFactory(node);

        // 维护平衡
        if (banlance > 1 && getbalanceFactory(node.left) >= 0) {
            return  rightRotate(node);
        } else if (banlance < -1 && getbalanceFactory(node.right) <= 0) {
            return leftRotate(node);
        } else if (banlance > 1 && getbalanceFactory(node.left) < 0) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        } else if (banlance < -1 && getbalanceFactory(node.right) > 0) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }
        return node;
    }

    /**
     * 寻找树种最小的元素
     */
    public V minElement() {

        return minElement(root).value;
    }

    private Node minElement(Node node) {
        if (node.left == null) {
            return node;
        }
        // 因为函数在栈种 需要层层返回 所以在这里需要返回末尾处的node节点。
        return minElement(node.left);
    }

    /**
     * 寻找树种最大的元素
     */
    public V maxElement() {
        Node node = root;
        while (node.right != null) {
            node = node.right;
        }
        return node.value;
    }


    /**
    * 删除树中最小的节点
    */
    public V removeMin() {
        V minElement = minElement();
        root = removeMin(root);
        return minElement;
    }

    private Node removeMin( Node node) {
        if (node.left == null) {
            size--;
            Node rightNode = node.right;
            node.right = null;
            return rightNode;
        }
        node.left = removeMin(node);
        return node;
    }

    /**
    * 删除树结构中最大节点
    */
    public V removeMax() {
        V maxElement = maxElement();
        root = removeMax(root);
        return maxElement;
    }

    private Node removeMax(Node node) {
        if (node.right == null) {
            Node leftNode = node.left;
            node.right = null;
            size--;
            return leftNode;
        }
        node.right = removeMax(node.right);
        return node;
    }



    public V remove(K key) {
        V element = get(key);
        root = remove(key, root);
        return element;
    }

    public V get(K key) {
        return getNode(key, root) == null ? null :getNode(key, root).value;
    }

    private Node getNode(K key, Node node) {
        if (node== null) {
            return null;
        }
        if (node.key == key) {
            return node;
        } else if (node.key.compareTo(key) > 0) {
            return getNode(key, node.left);
        } else  { // (node.key.compareTo(key) < 0)
            return getNode(key, node.right);
        }
    }

    private Node remove(K key, Node node) {
        if (node == null) {
            return null;
        }
        if (node.key.compareTo(key) > 0) {
            node.left = remove(key, node.left);
            return node;
        } else if (node.key.compareTo(key) < 0) {
            node.right = remove(key, node.right);
            return node;
        } else {//node.key.compareTo(key)== 0
            // 删除只有右子树的节点
            if (node.left == null) {
                Node rightNode = node.right;
                node.right = null;
                size--;
                return rightNode;
            }

            // 删除只有左子树的节点
            if (node.right == null) {
                Node leftNode = node.left;
                node.left = null;
                size--;
                return leftNode;
            }

            // 待删除节点左右子树均不为空的情况

            // 找到比待删除节点大的最小节点, 即待删除节点右子树的最小节点
            // 用这个节点顶替待删除节点的位置
            Node successor = minElement(node);
            successor.right= removeMin(node);
            successor.left = node.left;

            node.left = node.right = null;
            return successor;
        }
    }


    @Override
    public String toString() {
        return "AVLTree{" +
                "root=" + root +
                ", size=" + size +
                '}';
    }
}
