package thread.start;

public class DaemonThreadMain extends Thread {

    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName() + ": main() start");

        DaemonThread daemonThread = new DaemonThread();
        daemonThread.setDaemon(true);   // 데몬 스레드 여부(기본 값: false)
        daemonThread.start();

        System.out.println(Thread.currentThread().getName() + ": main() end");
    }


    static class DaemonThread extends Thread {

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + ": run()");
            try {
                Thread.sleep(10000);    // 10 초간 대기
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            System.out.println(Thread.currentThread().getName() + ": end()");

        }
    }



}
