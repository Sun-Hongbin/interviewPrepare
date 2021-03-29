package bjtu_prepare.linkedlist;

//输入一个链表，输出该链表中倒数第k个结点。
public class FindKthToTail {
	public ListNode findKthToTail(ListNode head, int k) {
		if (head == null || k < 1) {
			return null;
		}
		ListNode fastP = head;
		ListNode slowP = head;
		while (k-- > 1) {
			if (fastP.next == null) {
				return null;
			} else {
				fastP = fastP.next;
			}
		}
		while (fastP.next != null) {
			fastP = fastP.next;
			slowP = slowP.next;

		}
		return slowP;
	}

}
