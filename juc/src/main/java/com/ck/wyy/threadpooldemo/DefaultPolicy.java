package com.ck.wyy.threadpooldemo;

import java.util.concurrent.*;

//LinkedBlockingDeque 不会抛出拒绝策略
public class DefaultPolicy {
    public static void main(String[] args) {
        ExecutorService es2 = new ThreadPoolExecutor(2, 10, 0L, TimeUnit.MILLISECONDS, new ArrayBlockingQueue<Runnable>(4) {
        }, new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                Thread t = new Thread(r);
                t.setDaemon(true);
                System.out.println("create" + t);
                return t;
            }

        },
                rejectPolicy()
//                new ThreadPoolExecutor.DiscardOldestPolicy()

        );
        Runnable r = () -> {
            System.out.println(Thread.currentThread().getName() + " 在忙...");
            try{
                Thread.sleep(100);
            } catch(InterruptedException e) {
                e.printStackTrace();
            }
        };

        for(int i = 0; i < 50; i++) {
            es2.submit(r);
        }

    }

    private static RejectedExecutionHandler rejectPolicy() {
        return new RejectedExecutionHandler() {
            @Override
            public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {

                try{
                    System.out.println(new CallablePolicy().call());
                } catch(Exception e) {
                    e.printStackTrace();
                }
            }
        };
    }

    static class CallablePolicy  implements Callable<String>{

        @Override
        public String call() throws Exception {
            return "discourd" + 123;
        }
    }

}
