package bjtu_prepare.other;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。
 * 如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
 * 我们使用Insert()方法读取数据流，使用GetMedian()方法获取当前读取数据的中位数。
 *
 * @author SuperBin
 *
 * @date: 2018年12月21日
 */
public class GetMedian {

	int count = 0;

	PriorityQueue<Integer> minHeap = new PriorityQueue<>();

	PriorityQueue<Integer> maxHeap = new PriorityQueue<>(15, new Comparator<Integer>() {

		@Override
		public int compare(Integer o1, Integer o2) {
			return o2.compareTo(o1);
		}
	});

	public void insert(Integer num) {

		count++;

		// 从最大堆开始加，最大堆在左，最小堆在右
		if (count % 2 == 0) { // 偶数
			maxHeap.offer(num);
			minHeap.offer(maxHeap.poll());
		} else {
			minHeap.offer(num);
			maxHeap.offer(minHeap.poll());
		}
	}

	public Double getMedian() {

		if (count == 0) {
			return null;
		}

		if ((count & 1) == 1) {
			return Double.valueOf(maxHeap.peek());
		} else {
			return Double.valueOf((maxHeap.peek() + minHeap.peek())) / 2;
		}
	}

}
