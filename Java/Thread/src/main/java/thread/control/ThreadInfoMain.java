package thread.control;

import thread.start.HelloRunnable;

import static util.MyLogger.log;

public class ThreadInfoMain {

    public static void main(String[] args) {
        Thread thread = Thread.currentThread();
        log("Thread= " + thread);
        log("Thread.threadId()= " + thread.threadId());
        log("Thread.getName()= " + thread.getName());
        log("Thread.getPriority()= " + thread.getPriority());
        log("Tread.getThreadGroup()= " + thread.getThreadGroup());
        log("Thread.getState()= " + thread.getState()); // RUNNABLE 은 thread 가 실행할 수 있는 상태.


        Thread myThread = new Thread(new HelloRunnable(), "myThread");
        log("myThread= " + myThread); // [#29,myThread,5,main]
        log("myThread.threadId()= " + myThread.threadId());
        log("myThread.getName()= " + myThread.getName());
        log("myThread.getPriority()= " + myThread.getPriority());
        log("myThread.getThreadGroup()= " + myThread.getThreadGroup());
        log("myThread.getState()= " + myThread.getState()); // RUNNABLE 은 thread 가 실행할 수 있는 상태. // NEW
    }
}
