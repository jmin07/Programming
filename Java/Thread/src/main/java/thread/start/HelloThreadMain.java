package thread.start;

public class HelloThreadMain {

    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName() + ": main() start");

        HelloThread helloThread = new HelloThread();
        System.out.println(Thread.currentThread().getName() + ": start() before call");

        // main 스레드가 run() 스레드를 실행하는게 아니라, Thread-0 스레드가 run() 메서드를 실행한다.
        // 즉, main 스레드는 start 메서드를 통해 Thread-0 스레드에게 실행을 지시할 뿐이다.
        // main 스레드는 start 메서드 이후 로직을 실행한다.
        helloThread.start();
        System.out.println(Thread.currentThread().getName() + ": start() after call");

        System.out.println(Thread.currentThread().getName() + ": main() end");
    }

}
