package com.chenhaibo.concurrent;

/**
 * @Author: chenhaibo
 * @Description:
 * @Date: Created in 13:57 2018/7/26
 */
abstract class AbstractProducer implements Producer, Runnable {
    @Override
    public void run() {
        while (true) {
            try {
                producer();
            } catch (InterruptedException e) {
                e.printStackTrace();
                break;
            }
        }
    }
}
