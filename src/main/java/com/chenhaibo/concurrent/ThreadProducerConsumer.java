package com.chenhaibo.concurrent;

/**
 * @Author: chenhaibo
 * @Description:
 * @Date: Created in 11:30 2018/8/2
 */
public class ThreadProducerConsumer extends Thread {

    private static int MAX_PRODUCT = 3;
    private static int MIN_PRODUCT = 0;

    private int product;

    public int getProduct() {
        return product;
    }

    public void setProduct(int product) {
        this.product = product;
    }

    public ThreadProducerConsumer(int product) {
        this.product = product;
    }

    /**
     * 生产者生产出来的产品交给店员
     */
    public synchronized void producer() {
        if (this.product >= MAX_PRODUCT) {
            try {
                wait();
                System.out.println("产品已满,请稍候再生产");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return;
        }
        this.product++;
        System.out.println("生产者生产第" + this.product + "个产品.");
        notifyAll();   //通知等待区的消费者可以取出产品了
    }

    /**
     * 消费者从店员取产品
     */
    public synchronized void consume() {
        if (this.product <= MIN_PRODUCT) {
            try {
                wait();
                System.out.println("缺货,稍候再取");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return;
        }
        System.out.println("消费者取走了第" + this.product + "个产品.");
        this.product--;
        notifyAll();   //通知等待去的生产者可以生产产品了
    }

    public static void main(String[] args) {
        ThreadProducerConsumer t = new ThreadProducerConsumer(3);
        t.consume();
        t.producer();
    }
}
