package thread;

import java.util.concurrent.ArrayBlockingQueue;

public class BolckQuene_Pro_Con
{
    private int queueSize = 10;//队列允许存放的最大数
    private ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(queueSize);//阻塞队列
    
    public static void main(String[] args)  {
        BolckQuene_Pro_Con test = new BolckQuene_Pro_Con();
        Producer producer = test.new Producer();
        Consumer consumer = test.new Consumer();
         
        producer.start();
        consumer.start();
    }
    
    class Consumer extends Thread{
        @Override
        public void run() {
            consume();
        }
        private void consume() {
            while(true){
                
                try {
                    Thread.sleep(300);
                    queue.take();
                    System.out.println("【消费者】从队列取走一个元素，队列剩余"+queue.size()+"个元素");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
     
    class Producer extends Thread{
        @Override
        public void run() {
            produce();
        }
        private void produce() {
            while(true){
                try {
                    Thread.sleep(200);
                    queue.put(1);
                    System.out.println("【生产者】向队列取中插入一个元素，队列中元素："+queue.size());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}