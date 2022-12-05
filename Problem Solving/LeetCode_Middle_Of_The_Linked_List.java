class LeetCode_Middle_Of_The_Linked_List{
    public static void main(String args[]){
        LinkedListImplement l = new LinkedListImplement();
        l.createList(new int[]{1,2,3,4,5,6});

        l.head=middleNode(l.head); 
        l.printList();
    }
    public static ListNode middleNode(ListNode head) {
        ListNode fast = head, slow = head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
}