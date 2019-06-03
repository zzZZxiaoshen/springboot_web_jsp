package cn.pinghu.springboot_web_jsp.utils.Data;

import java.security.Key;
import java.util.TreeMap;

/**
 * 哈希表数据结构
 * @author shenkai
 * @date 2019/6/3
 */
public class HashTable<K,V> {

    private static final int upperTol = 10;
    private static final int lowerTol = 2;
    private static final int initCapacity = 7;

    private TreeMap<K, V>[] hashTable;
    private int M;
    private int size;


    public HashTable( int M) {
        this.M = M;
        this.size = 0;
        this.hashTable = new  TreeMap[M];
        for (int i = 0; i < M; i++) {
            hashTable[i] = new TreeMap<>();
        }
    }

    public HashTable() {
        this(97);
    }

    public int hash(K key) {
        return (key.hashCode() & 0x7fffffff) % M;
    }

    public int getSize() {
        return size;
    }

    public void add(K key, V value) {
        TreeMap<K, V> map = hashTable[hash(key)];
        if (map.containsKey(key)) {
            map.put(key, value);
        } else {
            map.put(key, value);
            size++;
        }
        if (size >= upperTol * M) {
            resize(2*M);
        }
    }



    public V remove(K key) {
        V ret = null;
        TreeMap<K, V> map = hashTable[hash(key)];
        if (!map.containsKey(key)) {
            throw new IllegalArgumentException("remove Exception key not exist ");
        } else {
            ret =  map.remove(key);
            size--;
        }
        if (size <= lowerTol * M && M / 2 >= initCapacity) {
            resize(M / 2);
        }
        return ret;
    }

    public V get(K key){
        TreeMap<K, V> map = hashTable[hash(key)];
        if (!map.containsKey(key) ) {
            throw new IllegalArgumentException("remove Exception key not exist ");
        }
        return  map.get(key);
    }

    public boolean contain(K key ){
        TreeMap<K, V> map = hashTable[hash(key)];
        return map.containsKey(key);
    }

    /**
    * 动态扩容
    */
    private void resize(int newM) {
        TreeMap<K, V>[] newTable = new TreeMap[M];
        for (int i = 0; i < M; i++) {
            newTable[i] = new TreeMap();
        }
        int oldM = this.M;
        this.M = newM;
        for (int i = 0; i < oldM; i++) {
            TreeMap<K, V> treeMap = hashTable[i];
            for (K key : treeMap.keySet()) {
                newTable[hash(key)].put(key, treeMap.get(key));
            }
        }
        this.hashTable = newTable;
    }

}
