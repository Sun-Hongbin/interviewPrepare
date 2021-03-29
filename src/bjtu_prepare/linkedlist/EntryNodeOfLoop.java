package bjtu_prepare.linkedlist;

/**
 * 给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null。
 * @author SuperBin
 *
 */
public class EntryNodeOfLoop {

	public ListNode entryNodeOfLoop(ListNode pHead)
	{
		if(pHead == null && pHead.next == null){
			return null;
		}
		ListNode fast = pHead;
		ListNode slow = pHead;
		while(pHead.next != null){
			fast = fast.next.next;
			slow = slow.next;
			if(fast == slow){
				fast = pHead;
				while(fast != slow){
					fast = fast.next;
					slow = slow.next;
				}
				return slow;
			}
		}
		return null;
	}

}
