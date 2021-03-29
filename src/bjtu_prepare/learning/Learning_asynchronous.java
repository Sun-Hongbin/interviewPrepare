package bjtu_prepare.learning;

import java.util.concurrent.CompletableFuture;

/**
 * Async结尾的方法都是可以异步执行的，如果指定了线程池，会在指定的线程池中执行，如果没有指定，默认会在ForkJoinPool.commonPool()中执行。
 * 下面很多方法都是类似的，不再做特别说明。
 * 四个静态方法用来为一段异步执行的代码创建CompletableFuture对象，方法的参数类型都是函数式接口，所以可以使用lambda表达式实现异步任务
 * runAsync方法：它以Runnabel函数式接口类型为参数，所以CompletableFuture的计算结果为空。
 * supplyAsync方法以Supplier<U>函数式接口类型为参数，CompletableFuture的计算结果类型为U。
 *
 * @author SuperBin
 *
 * @date: 2020年7月31日
 */
public class Learning_asynchronous {

	public static void main(String[] args) {

	/*	// 1.变换结果
		String result1 = CompletableFuture.supplyAsync(() -> {
			return "Hello ";
		}).thenApplyAsync(v -> v + "Hello world").join();
		System.out.println(result1);

		// 2.消费结果
		CompletableFuture.supplyAsync(() -> {
			return "Hello ";
		}).thenAccept(v -> {
			System.out.println("consumer: " + v);
		});

		// 3.结合两个CompletionStage的结果，进行转化后返回
		String reult3 = CompletableFuture.supplyAsync(() -> {
			try {
				System.out.println("开始1");
				Thread.sleep(2000);
				System.out.println("结束1");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			return "Hello?";
		}).thenCombine(CompletableFuture.supplyAsync(() -> {
			try {
				System.out.println("开始2");
				Thread.sleep(5000);
				System.out.println("结束2");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			return "world!";
		}), (s1, s2) -> {
			return s1 + s2;
		}).join();

		System.out.println(reult3);

		// 4.两个CompletionStage，谁计算的快，就用那个CompletionStage的结果进行下一步的处理
		String reult4 = CompletableFuture.supplyAsync(() -> {
			try {
				System.out.println("开始1");
				Thread.sleep(2000);
				System.out.println("结束1");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			return "boy fastter!";
		}).applyToEither(CompletableFuture.supplyAsync(() -> {
			try {
				System.out.println("开始2");
				Thread.sleep(5000);
				System.out.println("结束2");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			return "girl fastter!";
		}), (s) -> {
			return s;
		}).join();

		System.out.println(reult4);*/

		// 5.运行时出现了异常，可以通过exceptionally进行补偿
		String reult5 = CompletableFuture.supplyAsync(() -> {
			try {
				System.out.println("开始1");
				Thread.sleep(2000);
				System.out.println("结束1");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			if (true) {
				throw new RuntimeException("Exception test");
			}

			return "boy!";
		}).exceptionally(e -> {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			System.out.println(e.getLocalizedMessage());
			return "deal success!";
		}).join();

		System.out.println(reult5);



	}

}
















