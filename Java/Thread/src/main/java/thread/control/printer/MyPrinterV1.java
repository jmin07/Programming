package thread.control.printer;

import java.util.Queue;
import java.util.Scanner;
import java.util.concurrent.ConcurrentLinkedQueue;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

public class MyPrinterV1 {

    public static void main(String[] args) {
        Printer printer = new Printer();
        Thread printerThread = new Thread(printer, "printer");
        printerThread.start();

        Scanner userInput = new Scanner(System.in);
        while (true) {
            log("exit (q) : ");
            String input = userInput.nextLine();
            if("q".equals(input)) {
                printer.work = false;
                break;
            }
            printer.addJob(input);
        }
    }

    static class Printer implements Runnable {

        volatile boolean work = true;

        // 여러 스레드가 동시에 접근하느 경우
        Queue<String> jobQueue = new ConcurrentLinkedQueue<>();

        @Override
        public void run() {
            while(work) {
                if (jobQueue.isEmpty()) {
                    continue;
                }

                String job = jobQueue.poll();
                log("job: " + job + ", jobQueue: " + jobQueue);
                sleep(3000);
                log("print job: " + job);
            }
            log("printer exits");
        }

        public void addJob(String input) {
            jobQueue.add(input);
        }

    }

}
