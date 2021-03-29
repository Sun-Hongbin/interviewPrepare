package bjtu_prepare.linkedlist;

/*
 * 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。
 *  例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 */
public class DeleteDuplication {
	public ListNode deleteDuplication(ListNode pHead) {
		if (pHead == null) {
			return null;
		}
		ListNode first = new ListNode(-1);// 新建一个节点，以防头结点是重复的话会被删除
		first.next = pHead;
		ListNode p = pHead;
		ListNode pre = first;

		while (p != null && p.next != null) {
			if (p.data == p.next.data) {//
				int val = p.data;
				// while (p.next != null && val == p.next.val) {
				while (p != null && val == p.data) {// 将指针指向的每个值和val相比
					p = p.next;
				}
				pre.next = p;// 当前指针不重复的话就将P指向前一节点
			} else {// 如果当前节点和下一节点不一致，那么将指针往后移一位
				pre = p;
				p = p.next;
			}
		}
		return first.next;
	}
}
