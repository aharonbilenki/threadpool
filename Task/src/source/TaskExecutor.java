package source;

public class TaskExecutor implements Runnable {
	BlockingQueue<Runnable> taskqu;

	public TaskExecutor(BlockingQueue<Runnable> queue) {
		this.taskqu = queue;
	}

	public void run() {
		try {
			while (true) {
				String name = Thread.currentThread().getName();
				Runnable task = taskqu.dequeue();
				System.out.println(name+" start runing");
				task.run();
				System.out.println(name+" end runing");

			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}