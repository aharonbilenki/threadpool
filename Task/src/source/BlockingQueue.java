// BlockingQueue class managing the task queue
package source;

import java.util.LinkedList;
import java.util.Queue;

public class BlockingQueue<Type> {
	private Queue<Type> taskqu = new LinkedList<Type>();
	private final int EMPTY = 0;
	private int max = -1;

	public BlockingQueue(int size) {
		this.max = size;
	}

	// ad task to task taskqu(task queue)
	public synchronized void adqueue(Type task) throws InterruptedException {
		while (this.taskqu.size() == this.max) {
			wait();
		}

		this.taskqu.offer(task);

		if (this.taskqu.size() == EMPTY) {
			notifyAll();
		}
	}

	// remove task from task taskqu(task queue) and return the task
	public synchronized Type dequeue() throws InterruptedException {
		while (this.taskqu.size() == EMPTY) {

			return null;
		}
		if (this.taskqu.size() == this.max) {
			notifyAll();
		}
		return this.taskqu.poll();
	}
}