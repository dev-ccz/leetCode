package zcc._2.code;

/**
 * @author zcc  2022/3/30 16:24
 *
 */
public class Solution_2 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result=new ListNode(0);
        ListNode cur=result;
        int carry=0;
        while (l1!=null || l2!=null){
            int x= (l1==null)?0:l1.val;
            int y= (l2==null)?0:l2.val;
            int sum=x+y+carry;
            carry=sum/10;
            cur.next=new ListNode(sum%10);
            cur=cur.next;
            if(l1!=null){
                l1=l1.next;
            }
            if(l2!=null){
                l2=l2.next;
            }
        }
        if(carry>0){
            cur.next=new ListNode(carry);
        }
        return result.next;
    }
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
