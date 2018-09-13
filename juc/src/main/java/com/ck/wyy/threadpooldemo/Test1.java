package com.ck.wyy.threadpooldemo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test1 {
    public static void main(String[] args) {
        //创建固定大小线程池  LinkedBlockingQueue
        ExecutorService executor = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 10; i++) {
            SendNoticeTask task = new SendNoticeTask();
            task.setCount(i);
            executor.execute(task);
        }
        System.out.println("主线程结束");

        executor.shutdown();
    }
}

//测试类：SendNoticeTask，执行任务类，就是打印一句当前线程名+第几个任务。为了方便观察，每个线程执行完以后睡10s。
class SendNoticeTask implements Runnable {
    private int count;

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " start to" + " send " + count + " ...");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("finish " + Thread.currentThread().getName());
    }
}
