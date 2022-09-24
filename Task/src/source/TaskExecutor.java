package source;

public class TaskExecutor implements Runnable {
    BlockingQueue<Runnable> threadqu;
     
    public TaskExecutor(BlockingQueue<Runnable> queue) {
        this.threadqu = queue;
    }

    public void run() {
        try {
            while (true) {
                String name = Thread.currentThread().getName();
                Runnable task = threadqu.dequeue();
                System.out.println("Task Started by Thread :" + name);
                task.run();
                System.out.println("Task Finished by Thread :" + name);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
 
    }

}