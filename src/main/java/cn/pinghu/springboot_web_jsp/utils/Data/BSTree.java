package cn.pinghu.springboot_web_jsp.utils.Data;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 二分搜索树
 *
 * @author shenkai
 * @date 2019/5/13
 */
public class BSTree<T extends Comparable> {

    private class Node {
        private T element;
        private Node left, right;

        public Node(T element) {
            this.element = element;
            this.left = null;
            this.right = null;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "element=" + element +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }

    private Node node;
    private Integer size;

    public BSTree() {
        this.node = null;
        size = 0;
    }

    public BSTree(T element) {
        this.node = new Node(element);
        this.size = 0;
    }


   /*
    总结 1.再这里使用递归将业务处理放在了最后处理
    public void  add(T element) {
        if (node == null) {
            node = new Node(element);
        } else {
            this.add(element,node);
        }
    }

    private void add(T element, Node node) {
        if (node.element.equals(element)) {
            return;
        }
        if (node.element.compareTo(element) > 0 && node.right ==null)  {
            node.right = new Node(element);
            size++;
            return;
        }
        if (node.element.compareTo(element) < 0 &&  node.left ==null) {
            node.left = new Node(element);
            size++;
            return;
        }
        if ( node.element.compareTo(element) > 0) {
            add(element, node.right);
        } else if (node.element.compareTo(element) < 0) {
            add(element, node.left);
        }
    }*/

    /**
     * 向二分搜索树添加元素
     *   优化: 讲处理的结果放在了递归的接过之后处理问题 减少了代码冗余
     */
    public void  add(T element) {
       node = this.add(element, node);
    }

    private Node add(T element, Node node) {
        if (node == null) {
            size++;
            return   new Node(element);
        }
        if (node.element.compareTo(element) < 0) {
             node.right = add(element,node.right);
        } else if (node.element.compareTo(element) > 0) {
             node.left = add(element,node.left);
        }
        return node;
    }

    /**
    * 二分搜索树是否包含元素
    */
    public boolean contain(T element){
        return  this.contain(element, node);
    }

    private boolean contain(T element, Node node) {
        if (  node != null && node.element.equals(element)) {
            return true;
        }
        if (node != null &&  node.element.compareTo(element) < 0) {
           return contain(element, node.right);
        } else if ( node != null && node.element.compareTo(element) > 0) {
           return contain(element, node.left);
        }
        return false;
    }

    /**
     * 前序遍历（深度有限遍历）
     */
    public void preTranserve() {
        this.preTranserve(node);
    }
    private void preTranserve(Node node) {
        if (node == null) {
            return;
        }
        System.out.println(node.element);
        preTranserve(node.right);
        preTranserve(node.left);
    }

    /**
    * 中序 遍历（深度有限遍历）
    */
    public void interTranserve() {
        this.interTranserve(node);
    }
    private void interTranserve(Node node) {
        if (node == null) {
            return;
        }
        interTranserve(node.right);
        System.out.println(node.element);
        interTranserve(node.left);
    }

    /**
     * 后续 遍历（深度有限遍历）
     */
    public void postTranserve() {
        this.postTranserve(node);
    }
    private void postTranserve(Node node) {
        if (node == null) {
            return;
        }
        postTranserve(node.right);
        postTranserve(node.left);
        System.out.println(node.element);
    }

    /**
    * 非递归实现遍历（深度有限遍历）
    */
    public void transerve() {
        this.transerve(node);
    }

    public void transerve(Node node) {
        Stack<Node> stack = new Stack<>();
        stack.push(node);
        while (!stack.isEmpty()) {
            Node cur = stack.pop();
            System.out.println(cur.element);
            if (cur.right != null) {
                stack.push(cur.right);
            }
            if (cur.left != null) {
                stack.push(cur.left);
            }
        }
    }

    /**
    *  广度有限遍历
    */
    public void breathTranserve() {
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            Node cur = queue.remove();
            System.out.println(cur.element);
            if (cur.left != null) {
                queue.add(cur.left);
            }
            if (cur.right != null) {
                queue.add(cur.right);
            }
        }
    }

    /**
     * 寻找二分搜索树中最小的元素
     */
    public T minElement() {
        if (size == 0) {
            throw new RuntimeException(" minElement erro");
        }
        return minElement(node).element;
    }

    private Node minElement(Node node) {
        if (node.left == null) {
            return node;
        }
        return minElement(node.left);
    }

    /**
    * 寻找二分搜索树中最大的元素
    */
    public T maxElement() {
        if (size == 0) {
            throw new RuntimeException(" maxElement erro");
        }
        return maxElement(node).element;
    }

    private Node maxElement(Node node) {
        if (node.right == null) {
            return node;
        }
        return maxElement(node.right);
    }

    /**
    * 删除 树结构中最小的节点
    */
    public T removeMinElement() {
        T res = minElement();
         node =removeMinElement(node);
        return res;
    }

    private Node removeMinElement(Node node) {
        if (node.left == null) {
            Node rightNode = node.right;
            node.right = null;
            size--;
            return rightNode;
        }
        node.left = removeMinElement(node.left);
        return node;
    }

    /**
     * 删除 树结构中最大的节点
     */
    public T removeMaxElement() {
        T res = maxElement();
        node = removeMaxElement(node);
        return res;
    }

    private Node removeMaxElement(Node node) {
        if (node.right == null) {
            Node leftNode = node.left;
            node.left = null;
            size--;
            return leftNode;
        }
        node.right = removeMaxElement(node.right);
        return  node;
    }

    // 从二分搜索树中删除元素为e的节点
    public void remove(T e){
        node = remove(node, e);
    }

    // 删除掉以node为根的二分搜索树中值为e的节点, 递归算法
    // 返回删除节点后新的二分搜索树的根
    Node remove(Node node, T e){

        if( node == null )
            return null;

        if( e.compareTo(node.element) < 0 ){
            node.left = remove(node.left , e);
            return node;
        }
        else if(e.compareTo(node.element) > 0 ){
            node.right = remove(node.right, e);
            return node;
        }
        else{   // e.compareTo(node.e) == 0

            // 待删除节点左子树为空的情况
            if(node.left == null){
                Node rightNode = node.right;
                node.right = null;
                size --;
                return rightNode;
            }

            // 待删除节点右子树为空的情况
            if(node.right == null){
                Node leftNode = node.left;
                node.left = null;
                size --;
                return leftNode;
            }

            // 待删除节点左右子树均不为空的情况

            // 找到比待删除节点大的最小节点, 即待删除节点右子树的最小节点
            // 用这个节点顶替待删除节点的位置
            Node successor = new Node(minElement(node.right).element);
            size ++;

            successor.right = removeMinElement(node.right);
            successor.left = node.left;

            node.left = node.right = null;
            size --;

            return successor;
        }
    }



    /**
     * 获取元素大小
     */
    public Integer getSize() {
        return size;
    }

    /**
     * 判断树是否为空
     */
    public Boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        return "BSTree{" +
                "node=" + node +
                ", size=" + size +
                '}';
    }

}
