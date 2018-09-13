package com.ck.wyy.jucdemo;


import java.util.ArrayList;
import java.util.concurrent.*;

public class QueueTest {
    static class Operate implements Callable {
        public int count = 0;

        Operate(int i) {
            count = i;
        }

        @Override
        public Object call() throws Exception {
            return "number and sex = " + count;
        }
    }

    public static void main(String[] args) {
        ArrayBlockingQueue<Operate> queue = new ArrayBlockingQueue(10);

        for(int i = 0; i < 20; i++) {
            // 会阻塞
            // queue.put(i);
            queue.offer(new Operate(i));
        }
        ArrayList<Future> list = new ArrayList();
        ExecutorService service = Executors.newCachedThreadPool();
        while(!queue.isEmpty()){
           list.add(service.submit(queue.poll()));
        }

       list.forEach(o -> {
           try{
               System.out.println(o.get(100L, TimeUnit.MILLISECONDS));
           } catch(InterruptedException e) {
               e.printStackTrace();
           } catch(ExecutionException e) {
               e.printStackTrace();
           } catch(TimeoutException e) {
               e.printStackTrace();
           }
       });

        service.shutdown();
    }
}
