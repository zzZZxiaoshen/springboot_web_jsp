package cn.pinghu.springboot_web_jsp.utils.Data;

class Solution4 {

    public ListNode removeElements1(ListNode head, int val) {

        if (head == null) {
            return head;
        }

        ListNode res = removeElements1(head.next, val);
        if (head.val == val) {
            return res;
        } else {
            head.next = res;
            return head;
        }
    }



  public static void main(String[] args) {
        int[] nums = {1, 2, 6, 3, 4, 5, 6};
        ListNode head = new ListNode(nums);
        System.out.println(head);

        ListNode res = (new Solution4()).removeElements1(head, 5);
        System.out.println("res1 = " + res);
    }
}