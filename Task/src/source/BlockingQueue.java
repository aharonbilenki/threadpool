package source;

import java.util.LinkedList;
import java.util.Queue;

public class BlockingQueue<Type> {
	private Queue<Type> taskqu = new LinkedList<Type>();
	private int EMPTY = 0;
	private int MAX = -1;

	public BlockingQueue(int size) {
		this.MAX = size;
	}

	public synchronized int adqueue(Type task) throws InterruptedException {
		while (this.taskqu.size() == this.MAX) {
			wait(500);
		}
		
		this.taskqu.offer(task);

		if (this.taskqu.size() == EMPTY) {
			notifyAll();
		}
		return 0;

	}

	public synchronized Type dequeue() throws InterruptedException {
		while (this.taskqu.size() == EMPTY) {
			wait(500);
			return this.taskqu.poll();
		}
		if (this.taskqu.size() == this.MAX) {
			notifyAll();
		}
		return this.taskqu.poll();
	}
}