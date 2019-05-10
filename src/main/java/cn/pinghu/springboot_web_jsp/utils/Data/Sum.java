package cn.pinghu.springboot_web_jsp.utils.Data;

/**
 * 递归求和
 * @author shenkai
 * @date 2019/5/10
 */
public class Sum {

    public static Integer sum(int[] arr) {
        return sum(arr, 0);
    }

    /**
    * 计算arr[l...n)这个区间内所有数字的和
    */
    private static Integer sum(int[] arr,int le) {
        if (le == arr.length) {
            return 0;
        }
        return arr[le] + sum(arr, le + 1);
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8};
        System.out.println(sum(arr));
    }

}
