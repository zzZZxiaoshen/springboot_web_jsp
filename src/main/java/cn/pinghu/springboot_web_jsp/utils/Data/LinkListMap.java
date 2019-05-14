package cn.pinghu.springboot_web_jsp.utils.Data;


/**
 * 数据结构抽象概念接口map 实现(链表结构实现map映射数据结构抽象概念)
 * @author shenkai
 * @date 2019/5/14
 */
public class LinkListMap <K ,V> implements Map<K,V> {

    private class  Node {
        private K key;
        private V value;
        private Node next;


        public Node(K key, V value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public Node(K key, V value) {
            this(key, value, null);
        }

        public Node() {
            this(null, null, null);
        }

        @Override
        public String toString() {
            return "Node{" +
                    "key=" + key +
                    ", value=" + value +
                    ", next=" + next +
                    '}';
        }
    }

    private Node dummyNode;
    private int size;

    public LinkListMap() {
        this.dummyNode = new Node();
        this.size = 0;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size ==0;
    }

    /**
    * 根据key获取容器中的value
    */
    @Override
    public V get(K key) {
        return this.get(key, dummyNode);
    }

    private V get(K key, Node node) {
        if (node == null) {
            return null;
        }
        if (node.key !=null && node.key.equals(key)) {
            return node.value;
        }
       return  get(key, node.next);
    }

    /**
    * 是否包含 true 为包含
    */
    @Override
    public boolean contains(K key) {
        return !(get(key) == null);
    }

    /**
    * 获取对应key 的节点
    */
    public Node getNode(K key) {
        return getNode(key, dummyNode);
    }
    private Node getNode(K key, Node node) {
        if (node == null) {
            return null;
        }
        if (node.key !=null && node.key.equals(key)) {
            return node;
        }
        Node cur = getNode(key, node.next);
        return cur;
    }

    /**
     * 添加key value
     * @param key
     * @param value
     */
    @Override
    public void add(K key, V value) {
        if (!contains(key)) {
            add(key,value,dummyNode);
        }
    }
    private Node add(K key, V value, Node node) {
        if (node == null) {
            size++;
            return new Node(key,value);
        }
        Node cur = add(key, value, node.next);
        node.next = cur;
        return node;
    }

    /**
    * 更新key 的value值
    */
    @Override
    public void set(K key, V newValue) {
        if (!contains(key)) {
            throw new RuntimeException(" set erro");
        }
        Node node = getNode(key);
        node.value = newValue;
    }

    /**
     * 删除key 对应的value值
     */
    @Override
    public V remove(K key) {
        V temp = get(key);
        remove(key, dummyNode);
        return temp;
    }

    private Node remove(K key, Node node) {
        if (node == null) {
            return null;
        }
        if (node.key !=null && node.key.equals(key)) {
            size--;
            return node.next;
        }
        node.next = remove(key, node.next);
        return node;
    }

    @Override
    public String toString() {
        return "LinkListMap{" +
                "dummyNode=" + dummyNode +
                ", size=" + size +
                '}';
    }
}
