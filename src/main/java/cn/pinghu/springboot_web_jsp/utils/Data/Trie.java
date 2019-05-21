package cn.pinghu.springboot_web_jsp.utils.Data;


import java.util.TreeMap;

/**
 * 字段树 数据结构
 * @author shenkai
 * @date 2019/5/21
 */
public class Trie {

    private class Node {
        public boolean isword;
        public TreeMap<Character, Node> next;

        public Node(boolean isword) {
            this.isword = isword;
            this.next = new TreeMap<>();
        }

        public Node() {
            this(false);
        }

        @Override
        public String toString() {
            return "Node{" +
                    "isword=" + isword +
                    ", next=" + next +
                    '}';
        }
    }

        public Node root;
        public int size;

    public Trie() {
        this.root = new Node();
        this.size = 0;
    }

      /**
        *  获取字典树中单词个数
        */
        public int getSize() {
            return size;
        }

        /**
         * 向Trie中添加一个新的单词word
         */
        public void add(String word) throws IllegalAccessException {
            Node cur = root;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (cur.next.get(c) == null)
                    cur.next.put(c, new Node());
                cur =cur.next.get(c);
            }
            if (!cur.isword) {
                cur.isword = true;
                size++;
            }
        }

        /**
        * 查询字典树
        */
        public boolean contain(String word) {
            Node cur = root;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (cur.next.get(c) == null)
                    return false;
               cur = cur.next.get(c);
            }
            return cur.isword;
        }
     /**
       *  查询是否在Trie中有单词以prefix为前缀
       */
       public boolean isPrefix(String word) {
           Node cur = root;
           for (int i = 0; i < word.length(); i++) {
               char c = word.charAt(i);
               if (cur.next.get(c) == null)
                   return false;
               cur = cur.next.get(c);
           }
           return true;
       }


    public boolean search(String word) {
        return match(root, word, 0);
    }

    private boolean match(Node node, String word, int index){
        if (index == word.length()) {
            return true;
        }
        char c = word.charAt(index);
        if (c != '.') {
            if (node.next.get(c) == null) {
                return false;
            }
            return match(node.next.get(c), word, index + 1);
        } else {
            for (Character character : node.next.keySet()) {
                // 将每个元素的后续元素进行匹配 然后判断是否匹配
                if (match(node.next.get(character), word, index + 1)) {
                    return true;
                }
            }
            return false;
        }
    }

    @Override
    public String toString() {
        return "Trie{" +
                "root=" + root +
                ", size=" + size +
                '}';
    }

}

