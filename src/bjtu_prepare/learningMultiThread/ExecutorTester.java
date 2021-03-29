package bjtu_prepare.learningMultiThread;

import bjtu_prepare.learningMultiThread.CodingTask;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * 线程池 JAVA Executor Framework演示
 *
 * @Title
 * @Description
 * @Author SuperBin
 * @Date 2020年9月1日
 */
public class ExecutorTester {

	public static void main(String[] args)
			throws InterruptedException, ExecutionException {


//		new ThreadPoolExecutor(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue)

		// 上面那个参数太多了，用这个就行，里面是把参数包装了一下
		ExecutorService executor = Executors.newFixedThreadPool(3);

		List<Future<?>> taskResults = new LinkedList<>();

		// 一次跑10个任务，发现是3个为一组一起执行的
		for (int i = 1; i < 11; i++) {
			Future<?> task = executor.submit(new CodingTask(i));
			taskResults.add(task);

		}
		System.out.println("10个任务派发完成~");

		for (Future<?> taskResult : taskResults) {
			// get的作用为等待task的结束，结束会返回一个null（传null是因为Runnable是没有返回值的）
			taskResult.get();
		}
		System.out.println("所有任务执行完成！");

		executor.shutdown();
		System.out.println("任务检查是否结束：" + executor.isShutdown());
	}

}
