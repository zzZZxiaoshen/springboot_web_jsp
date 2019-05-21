package cn.pinghu.springboot_web_jsp.utils.Data;

import org.junit.Test;

import static org.junit.Assert.*;

public class SegmentTreeTest {
    private SegmentTree<Integer> segmentTree = null;

    {
        Integer[] nums = {3,4,1, 1, 1, 5,5, };
        segmentTree   = new SegmentTree<Integer>(nums, new Merge<Integer>() {
            @Override
            public Integer merge(Integer a, Integer b) {
                return a+b;
            }
        });
    }

    @Test
    public void getSize() {
        Integer[] nums = {3,4,1, 1, 1, 5,5, };
        SegmentTree<Integer> segmentTree = new SegmentTree<Integer>(nums, new Merge<Integer>() {
            @Override
            public Integer merge(Integer a, Integer b) {
                return a+b;
            }
        });
        System.out.println(segmentTree);
    }

    @Test
    public void get() {

    }

    @Test
    public void query() {
        System.out.println(segmentTree.query(0, 4));
    }

}