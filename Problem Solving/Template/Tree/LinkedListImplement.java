public class LinkedListImplement {
    ListNode head;
    public LinkedListImplement(){
        head = null;
    }
    //methods
    public void createList(int input[]){
        for(int i:input)insertNodeAtLast(i);
    }
    public void insertNodeAtLast(int i){
        if(head==null){
            head=new ListNode(i);
        }else{
            ListNode temp = head;
            while(temp.next!=null){
                temp=temp.next;
            }
            ListNode newNode = new ListNode(i);
            temp.next = newNode;
        }
    }
    public void printList(){
        ListNode temp = head;
        while(temp!=null){
            System.out.print(temp.val+" ");
            temp=temp.next;
        }
	}
}
