/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
       if(lists == null || lists.length == 0){
            return null; 
       }
       return mergeRange(lists, 0, lists.length-1);
    }

    public ListNode mergeRange(ListNode[] lists, int start, int end){
        if(start == end){
            return lists[start];
        }
        int mid = start + (end - start)/2;
        ListNode left = mergeRange(lists, start , mid);
        ListNode right = mergeRange(lists, mid+1, end);
        return mergeList(left , right);
    }

    public ListNode mergeList(ListNode l1, ListNode l2){
        ListNode newList = new ListNode(0);
        ListNode tail = newList;
        while(l1 != null && l2 != null){
            if(l1.val < l2.val){
                tail.next = l1;
                l1 = l1.next;
            } else {
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
        }
        if(l1 != null){
            tail.next = l1;
        }
        if(l2 != null){
            tail.next = l2;
        }

        return newList.next;
    }
}