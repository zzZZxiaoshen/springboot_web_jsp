package cn.pinghu.springboot_web_jsp.utils.Data;

import org.apache.poi.hssf.record.PageBreakRecord;

/**
 * 数据结构抽象概念接口map 实现(树结构实现map映射数据结构抽象概念)
 * @author shenkai
 * @date 2019/5/14
 */
public class BSTreeMap <K extends Comparable,V> implements Map<K,V> {

    private class Node {
        private K key;
        private V value;
        Node left,right;

        public Node(K key, V value, Node left, Node right) {
            this.key = key;
            this.value = value;
            this.left = left;
            this.right = right;
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
                    '}';
        }
    }

    public BSTreeMap() {
        root = null;
        size = 0;
    }

    private Node root;
    private int size;

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(K key) {
        return get(key,root) !=null;
    }

    /**
    * 根据key获取对应的value值
    */
    @Override
    public V get(K key) {
        Node node = get(key, root);
        return node==null ? null :node.value;
    }
    private Node get(K key, Node node) {
        if (node == null) {
            return null;
        }
        if ( node.key !=null && node.key.equals(key)) {
            return node;
        } else if (node.key != null && node.key.compareTo(key) > 0) {
            return get(key, node.left);
        }else if (node.key != null && node.key.compareTo(key) < 0) {
            return get(key, node.right);
        }
        return node;
    }

    /**
    * 向容器中添加元素
    */
    @Override
    public void add(K key, V value) {
          root= add(key,value,root);
    }
    private Node add(K key, V value, Node node) {
        if (node == null) {
            size++;
            return new Node(key, value);
         }
        if (key.compareTo( node.key) > 0) {
            node.right = add(key, value, node.right);
        } else if (key.compareTo( node.key) < 0) {
            node.left = add(key, value, node.left);
        } else {
            node.value = value;
        }
        return node;
    }

    @Override
    public V remove(K key) {
        V res = get(key);
        root = remove(key, root);
         return res;
    }

    private Node remove(K key, Node node) {
        if (node == null) {
            return null;
        }
        if (node.key != null && node.key.compareTo(key) > 0) {
           node.left = remove(key, node.left);
            return node;
        } else if (node.key != null && node.key.compareTo(key) < 0) {
            node.right =  remove(key, node.right);
            return node;
        } else {
            // 删除只有右节点
            if (node.left ==null ) {
                Node rightNode = node.right;
                node.right = null;
                size--;
                return rightNode;
            }

            // 删除只有左节点
            if (node.right ==null ) {
                Node leftNode = node.left;
                node.left = null;
                size--;
                return leftNode;
            }

            // 删除两边都有的节点
            Node successor = new Node(minValueNode(node.right).key,minValueNode(node.right).value);
            successor.right = removeMin(node.right);
            successor.left = node.left;

            node.left = node.right = null;

            return successor;
        }

    }

    /**
     * 查询节点最小值
     */
    public V minValue() {
       return minValueNode(root).value;
    }

    private Node minValueNode(Node node) {
        if (node.left == null) {
            return node;
        }
        return   minValueNode(node.left);
    }

    // 返回以node为根的二分搜索树的最小值所在的节点
    private Node minimum(Node node){
        if(node.left == null)
            return node;
        return minimum(node.left);
    }

    // 删除掉以node为根的二分搜索树中的最小节点
    // 返回删除节点后新的二分搜索树的根
    private Node removeMin(Node node){

        if(node.left == null){
            Node rightNode = node.right;
            node.right = null;
            size --;
            return rightNode;
        }

        node.left = removeMin(node.left);
        return node;
    }

    /**
    * 查询节点最大值
    */
    public V maxValue() {
        return maxValueNode(root).value;
    }

    private Node maxValueNode(Node node) {
        if (node.left == null) {
            return node;
        }
        return  maxValueNode(node.right);
    }


    @Override
    public void set(K key, V newValue) {
        if (!contains(key)) {
            throw new RuntimeException("set erro");
        }
        set(key, newValue, root);
    }

    private void set(K key, V value, Node node) {
        if (node == null) {
            return;
        }
        if (node.key != null && node.key.equals(key)) {
            node.value = value;
            return;
        }
        if (node.key != null &&node.key.compareTo(key) > 0) {
          set(key, value, node.left);
        } else if ( node.key != null && node.key.compareTo(key) < 0) {
           set(key, value, node.right);
        }
    }

    @Override
    public String toString() {
        return "BSTreeMap{" +
                "root=" + root +
                ", size=" + size +
                '}';
    }
}
