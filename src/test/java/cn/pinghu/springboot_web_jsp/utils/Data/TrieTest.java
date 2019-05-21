package cn.pinghu.springboot_web_jsp.utils.Data;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * 字典树 数据结构测试
 * @author shenkai
 * @date 2019/5/21
 */
public class TrieTest {

    private Trie trie = new Trie();

    {
        try {
            trie.add("nihao");
            trie.add("abc");
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getSize() {

    }

    @Test
    public void add() {
        System.out.println(trie.getSize());
        try {
            trie.add("nihao");

        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        System.out.println(trie.getSize());
        System.out.println(trie);
    }

    @Test
    public void contain() {
        System.out.println(trie.contain("niho"));
        System.out.println(trie.contain("nib"));
    }

}