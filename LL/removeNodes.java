public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { 
        this.val = val; 
    }
}

public ListNode removeNodes(ListNode head) {
    ListNode curr = head;
    Stack<ListNode> st = new Stack<>();
    while(curr != null){
        while(!st.isEmpty() && st.peek().val < curr.val){
            st.pop();
        }
        st.push(curr);
        curr = curr.next;
    }
    ListNode nxt = null;
    while(!st.isEmpty()){
        curr = st.pop();
        curr.next = nxt;
        nxt = curr;
    }
    return curr;
}

public ListNode removeNode(ListNode head) {
    ListNode prev = null;
    ListNode curr = head;
    while(curr != null){
        ListNode nxt = curr.next;
        curr.next = prev;
        prev = curr;
        curr = nxt;
    }

    curr = prev.next;
    prev.next = null;

    while(curr != null){
        ListNode temp = curr.next;
        if(curr.val >= prev.val){
            curr.next = prev;
            prev = curr;
        }
        curr = temp;
    }

    return prev;
}

public static void main(String[] args) {
    
}