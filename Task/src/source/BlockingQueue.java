package source;
import java.util.LinkedList;
import java.util.Queue;
 
public class BlockingQueue<Type>  {
    private Queue<Type> taskqu = new LinkedList<Type>();
    private int EMPTY = 0;
    private int MAX_THREADS_QUEUE = -1;
 
    public BlockingQueue(int size){
        this.MAX_THREADS_QUEUE = size;
    }
 
    public synchronized void adqueue(Type thread)throws InterruptedException  {
        while(this.taskqu.size() == this.MAX_THREADS_QUEUE) {
        	System.out.println("Wait the thread is to busy now.");
            wait();
        }
        if(this.taskqu.size() == EMPTY) {
            notifyAll();
        }
        this.taskqu.offer(thread);
    }
 
    public synchronized Type dequeue()
            throws InterruptedException{
        while(this.taskqu.size() == EMPTY){
            wait();
        }
        if(this.taskqu.size() == this.MAX_THREADS_QUEUE){
            notifyAll();
        }
        return this.taskqu.poll();
    }
}