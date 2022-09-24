package source;

public class ThreadPool {
    
    BlockingQueue <Runnable> threadqu;
    public ThreadPool(int size, int nThread) {
        threadqu = new BlockingQueue<>(size);
        String threadName = null;
        TaskExecutor task = null;
        for (int count = 0; count < nThread; count++) {
            threadName = "Thread-"+count;
            task = new TaskExecutor(threadqu);
            Thread thread = new Thread(task, threadName);
            thread.start();
        }
    }
 
    public void submitTask(Runnable task) throws InterruptedException {
    	threadqu.adqueue(task);
    }
}