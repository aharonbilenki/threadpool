package source;
import java.util.LinkedList;
import java.util.Queue;
 
public class BlockingQueue<Type>  {
    private Queue<Type> queue = new LinkedList<Type>();
    private int EMPTY = 0;
    private int MAX_THREADS_QUEUE = -1;
 
    public BlockingQueue(int size){
        this.MAX_THREADS_QUEUE = size;
    }
 
    public synchronized void enqueue(Type thread)
            throws InterruptedException  {
        while(this.queue.size() == this.MAX_THREADS_QUEUE) {
            wait();
        }
        if(this.queue.size() == EMPTY) {
            notifyAll();
        }
        this.queue.offer(thread);
    }
 
    public synchronized Type dequeue()
            throws InterruptedException{
        while(this.queue.size() == EMPTY){
            wait();
        }
        if(this.queue.size() == this.MAX_THREADS_QUEUE){
            notifyAll();
        }
        return this.queue.poll();
    }
}