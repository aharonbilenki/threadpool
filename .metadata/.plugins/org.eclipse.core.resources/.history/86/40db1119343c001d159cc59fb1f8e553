package source;
import java.util.LinkedList;
import java.util.Queue;
 
public class BlockingQueue<Type>  {
    private Queue<Type> threadqu = new LinkedList<Type>();
    private int EMPTY = 0;
    private int MAX_THREADS_QUEUE = -1;
 
    public BlockingQueue(int size){
        this.MAX_THREADS_QUEUE = size;
    }
 
    public synchronized void adqueue(Type thread)throws InterruptedException  {
        while(this.threadqu.size() == this.MAX_THREADS_QUEUE) {
            wait();
        }
        if(this.threadqu.size() == EMPTY) {
            notifyAll();
        }
        this.threadqu.offer(thread);
    }
 
    public synchronized Type dequeue()
            throws InterruptedException{
        while(this.threadqu.size() == EMPTY){
            wait();
        }
        if(this.threadqu.size() == this.MAX_THREADS_QUEUE){
            notifyAll();
        }
        return this.threadqu.poll();
    }
}