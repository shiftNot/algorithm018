class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
     if(l1==null)return l2;
     if(l2==null)return l1;
     ListNode pre = new ListNode(-1);
     ListNode prehead = pre;
     while(l1!=null && l2!=null){
        if(l1.val > l2.val){
            pre.next = l2;
            l2 = l2.next;
        }
        else{
            pre.next = l1;
            l1 = l1.next;
        }

        pre = pre.next;
     }

     pre.next = (l1==null)?l2:l1;

     return prehead.next;
    }
}