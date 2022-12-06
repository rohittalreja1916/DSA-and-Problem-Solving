//LinkedListImplement is given in Templates
class LeetCode_Odd_Even_Linked_List{
    public static void main(String[] args) {
        LinkedListImplement l = new LinkedListImplement();
        l.createList(new int[]{1,2,3,4,5});

        l.head = oddEvenList(l.head);
        l.printList();
    }
    public static ListNode oddEvenList(ListNode head) {
        if(head==null)return null;
        ListNode odd=head,even=head.next,evenHead=even;

        while(even!=null && even.next!=null){
            odd.next=even.next;
            odd=odd.next;
            even.next=odd.next;
            even=even.next;
        }
        odd.next = evenHead;
        return head;
    }
}