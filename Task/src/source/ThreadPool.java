package source;

public class ThreadPool {

	BlockingQueue<Runnable> taskqu;

	public ThreadPool(int size, int nThread) {
		taskqu = new BlockingQueue<>(size);
		String threadName = null;
		TaskExecutor task = null;
		for (int count = 0; count < nThread; count++) {
			threadName = "Thread-" + count;
			task = new TaskExecutor(taskqu);
			Thread thread = new Thread(task, threadName);
			thread.start();
		}
	}

	public void submitTask(Runnable task) throws InterruptedException {
		taskqu.adqueue(task);
	}
}