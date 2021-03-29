package bjtu_prepare.linkedlist;

/*
 * 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 */
public class Merge {

	public ListNode merge(ListNode list1, ListNode list2) {
		if (list1 == null) {
			return list1;
		}
		if (list2 == null) {
			return list2;
		}
		ListNode newHead = null;

		if (list1.data <= list2.data) {
			newHead = list1;
			newHead.next = merge(list1.next, list2);
		} else {
			newHead = list2;
			newHead.next = merge(list1, list2.next);
		}
		return newHead;
	}

}
