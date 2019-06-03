package cn.pinghu.springboot_web_jsp.utils.Data;

import org.junit.Test;

import static org.junit.Assert.*;


public class HashTableTest {
    private HashTable<Integer, Integer> hashTable = new HashTable<>();

    {
        for (int i = 0; i < 100; i++) {
            hashTable.add(i,i);
        }
    }

    @Test
    public void getSize() {
    }

    @Test
    public void add() {
    }

    @Test
    public void remove() {
        System.out.println(hashTable.getSize());
        System.out.println(hashTable.remove(1));
        System.out.println(hashTable.getSize());
        System.out.println(hashTable.contain(101));
        System.out.println(hashTable.get(99));

    }

    @Test
    public void get() {
    }

    @Test
    public void contain() {
    }
}