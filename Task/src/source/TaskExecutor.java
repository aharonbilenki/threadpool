//TaskExecutor class responsible of execution of tasks.
package source;

public class TaskExecutor implements Runnable {
	BlockingQueue<Runnable> taskqu;

	public TaskExecutor(BlockingQueue<Runnable> queue) {
		this.taskqu = queue;
	}
//run function implementation
	 void run() {
		try {
			while (true) {//infinite loop(the thead)
				String name = Thread.currentThread().getName();
				Runnable task = taskqu.dequeue();
				// run the task only if it's not a null.
				if (task != null) {
					System.out.println(name + " start runing");
					task.run();
					System.out.println(name + " end runing");
				}

			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}