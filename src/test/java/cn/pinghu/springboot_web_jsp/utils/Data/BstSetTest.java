package cn.pinghu.springboot_web_jsp.utils.Data;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeMap;
import java.util.TreeSet;

public class BstSetTest {

    private BstSet<Integer> bstSet = new BstSet();

    {
        int[] arr = {5, 2, 7, 3, 1, 9};
        for (int i = 0; i < arr.length; i++) {
            bstSet.add(arr[i]);
        }
    }

    @Test
    public void add() {
        System.out.println(bstSet.toString());
    }

    @Test
    public void contain() {
        System.out.println(bstSet.contain(19));
    }

    @Test
    public void getSize() {
        System.out.println(bstSet.getSize());
    }

    @Test
    public void isEmpty() {
        System.out.println(bstSet.isEmpty());
    }

    @Test
    public void remove() {
        bstSet.remove(7);
        System.out.println(bstSet.getSize());
    }

    @Test
    public void uniqueMorseRepresentations() {
        String[] strs = {"c", "b", "v"};
        System.out.println(bstSet.uniqueMorseRepresentations(strs));
    }

    @Test
    public void intersection() {
        int[] arr1 = {5, 2, 3, 5, 2, 9};
        int[] arr2 = {45, 21, 32, 53, 22, 99};
        System.out.println(Arrays.asList(intersection(arr1, arr2)).toString());
    }

    @Test
    public void intersect() {
        int[] arr1 = {5, 2, 3, 5, 2, 9};
        int[] arr2 = {45, 21, 32, 53, 22, 99};
        System.out.println(Arrays.asList(intersect(arr1, arr2)).toString());
    }


    /**
     * 获取两个数字 的并集 使用set集合解决问题
     * @param nums1 数组容器一
     * @param nums2 数字容器二
     * @return 并级结果
     */
    public int[] intersection(int[] nums1, int[] nums2) {

        TreeSet<Integer> set = new TreeSet<>();
        for(int num: nums1)
            set.add(num);

        ArrayList<Integer> list = new ArrayList<>();
        for(int num: nums2){
            if(set.contains(num)){
                list.add(num);
                set.remove(num);
            }
        }

        int[] res = new int[list.size()];
        for(int i = 0 ; i < list.size() ; i ++)
            res[i] = list.get(i);
        return res;
    }


    /**
     * 获取两个数字 的并集 使用map映射解决问题
     * @param nums1 数组容器一
     * @param nums2 数字容器二
     * @return 并级结果
     */
    public int[] intersect(int[] nums1, int[] nums2) {

        TreeMap<Integer, Integer> map = new TreeMap<>();
        for(int num: nums1){
            if(!map.containsKey(num))
                map.put(num, 1);
            else
                map.put(num, map.get(num) + 1);
        }

        ArrayList<Integer> res = new ArrayList<>();
        for(int num: nums2){
            if(map.containsKey(num)){
                res.add(num);
                map.put(num, map.get(num) - 1);
                if(map.get(num) == 0)
                    map.remove(num);
            }
        }

        int[] ret = new int[res.size()];
        for(int i = 0 ; i < res.size() ; i ++)
            ret[i] = res.get(i);

        return ret;
    }

}